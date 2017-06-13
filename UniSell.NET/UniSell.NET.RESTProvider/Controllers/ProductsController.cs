using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.ServiceModel;
using System.Web.Http;
using UniSell.NET.RESTProvider.DataAccessWS;
using UniSell.NET.RESTProvider.IdentityWS;
using UniSell.NET.RESTProvider.Models;

namespace UniSell.NET.RESTProvider.Controllers
{
    public class ProductsController : ApiController
    {
        // GET: api/Products
        public IHttpActionResult Get()
        {
            string token = GetAuthToken();
            IHttpActionResult validateToken = ValidateToken(token);
            if (validateToken != null)
            {
                return validateToken;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Product[] prods = ws.FindAllProducts(new DataAccessWS.Security { BinarySecurityToken = token });
            return Ok(prods.Select(p => CreateRestProduct(p)));
        }

        // GET: api/Products/5
        [Route("api/Products/{id}", Name = "GetProductById")]
        public IHttpActionResult Get(int id)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = ValidateToken(token);
            if (validation != null)
            {
                return validation;
            }
            if (!ValidateProductExists(token, id))
            {
                return NotFound();
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Product product = ws.FindProduct(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            return Ok(CreateRestProduct(product));
        }

        // POST: api/Products
        public IHttpActionResult Post([FromBody]ProductData value)
        {
            string token = GetAuthToken();
            IHttpActionResult userValidation = ValidateClientIsSeller(token);
            if (userValidation != null)
            {
                return userValidation;
            }
            IHttpActionResult productValidation = ValidateProductData(value, token, false);
            if (productValidation != null)
            {
                return productValidation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Product product = ws.CreateProduct(new DataAccessWS.Security { BinarySecurityToken = token }, value.CreateProduct());
            return Created(
                Request.RequestUri.GetLeftPart(UriPartial.Authority) + Url.Route("GetProductById", new { id = product.Id }),
                CreateRestProduct(product));
        }

        // PUT: api/Products/5
        [Route("api/Products/{id}")]
        public IHttpActionResult Put(int id, [FromBody]ProductData value)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = ValidateOwnerProduct(token, id);
            if (validation != null)
            {
                return validation;
            }
            validation = ValidateProductData(value, token, true);
            if (validation != null)
            {
                return validation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Product target = ws.FindProduct(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            assignProperties(target, value, token);
            target.Id = id;
            Product updated = ws.UpdateProduct(new DataAccessWS.Security { BinarySecurityToken = token }, target);
            return Ok(CreateRestProduct(updated));
        }

        // DELETE: api/Products/5
        [Route("api/Products/{id}")]
        public IHttpActionResult Delete(int id)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = ValidateOwnerProduct(token, id);
            if (validation != null)
            {
                return validation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Product removed = ws.RemoveProduct(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            RestProduct res = CreateRestProduct(removed);
            res.href = "";
            return Ok(res);
        }

        private void assignProperties(Product product, ProductData data, string token)
        {
            if (!string.IsNullOrEmpty(data.Name))
            {
                product.Name = data.Name;
            }
            if (!string.IsNullOrEmpty(data.Description))
            {
                product.Description = data.Description;
            }
            if (data.Price != null)
            {
                product.Price = data.Price.Value;
            }
            if (data.Units != null)
            {
                product.Units = data.Units.Value;
            }
            if (data.Image != null)
            {
                product.image = data.Image;
            }
            if (data.SellerId != null)
            {
                product.seller_id = data.SellerId.Value;
                DataAccessSoapClient ws = new DataAccessSoapClient();
                dynamic user = ws.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, product.seller_id);
                product.seller = user;
            }
            if (data.CategoryId != null)
            {
                product.category_id = data.CategoryId.Value;
                DataAccessSoapClient ws = new DataAccessSoapClient();
                dynamic category = ws.FindCategory(new DataAccessWS.Security { BinarySecurityToken = token }, product.category_id);
                product.category = category;
            }
        }

        private string GetAuthToken()
        {
            try
            {
                IEnumerable<string> headerValues = Request.Headers.GetValues("token");
                return headerValues.First();
            }
            catch (Exception ex)
            {
                return null;
            }
        }

        private IHttpActionResult ValidateClientIsSeller(string token)
        {
            try
            {
                IdentityWSSoapClient ws = new IdentityWSSoapClient();
                IdentityData identity = ws.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
                if (identity != null && identity.Role != IdentityWS.UserRole.SELLER)
                {
                    return Unauthorized();
                }
            }
            catch (FaultException ex)
            {
                return BadRequest("Invalid security token");
            }
            return null;
        }

        private IHttpActionResult ValidateToken(string token)
        {
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            try
            {
                IdentityWSSoapClient ws = new IdentityWSSoapClient();
                ws.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
            }
            catch (FaultException ex)
            {
                return BadRequest("Invalid security token");
            }
            return null;
        }

        private IHttpActionResult ValidateOwnerProduct(string token, long productId)
        {
            try
            {
                IdentityWSSoapClient ws = new IdentityWSSoapClient();
                IdentityData identity = ws.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
                if (identity == null)
                {
                    return Unauthorized();
                }
                DataAccessSoapClient dataWS = new DataAccessSoapClient();
                Product target = dataWS.FindProduct(new DataAccessWS.Security { BinarySecurityToken = token }, productId);
                if (target == null)
                {
                    return NotFound();
                }
                User owner = dataWS.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, target.seller_id);
                if (!owner.Username.Equals(identity.Username))
                {
                    return Unauthorized();
                }
            }
            catch (FaultException ex)
            {
                return BadRequest("Invalid security token");
            }
            return null;
        }

         private IHttpActionResult ValidateProductData(ProductData product, string token, bool editing)
        {
            if (product == null)
            {
                return BadRequest("Product data is missing");
            }
            if (!editing && !product.IsComplete())
            {
                return BadRequest("Product data missing some required field");
            }
            if (product.Price != null && product.Price <= 0)
            {
                return BadRequest("Product price must be a positive decimal number");
            }
            if (product.Units != null && product.Units < 1)
            {
                return BadRequest("Product units must be a positive integer");
            }
            if (product.SellerId != null)
            {
                DataAccessSoapClient ws = new DataAccessSoapClient();
                User seller = ws.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, product.SellerId.Value);
                if (seller == null || seller.Role != DataAccessWS.UserRole.SELLER)
                {
                    return BadRequest("Seller with id " + product.SellerId.Value + " not found in the system");
                }
            }
            if (product.CategoryId != null)
            {
                DataAccessSoapClient ws = new DataAccessSoapClient();
                Category category = ws.FindCategory(new DataAccessWS.Security { BinarySecurityToken = token }, product.CategoryId.Value);
                if (category == null)
                {
                    return BadRequest("Category with id " + product.CategoryId.Value + " not found in the system");
                }
            }
            return null;
        }

        private RestProduct CreateRestProduct(Product product)
        {
            return new RestProduct
            {
                href = Request.RequestUri.GetLeftPart(UriPartial.Authority) + Url.Route("GetProductById", new { id = product.Id }),
                Id = product.Id,
                Name = product.Name,
                Description = product.Description,
                Price = product.Price,
                Units = product.Units,
                Image = product.image,
                Seller = product.seller_id,
                Category = product.category_id
            };
        }

        private bool ValidateProductExists(string token, long id)
        {
            DataAccessSoapClient dataWS = new DataAccessSoapClient();
            Product target = dataWS.FindProduct(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            return target != null;
        }
    }
}
