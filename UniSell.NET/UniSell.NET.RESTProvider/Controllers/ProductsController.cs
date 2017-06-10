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
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Products/5
        public void Delete(int id)
        {
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
                if (identity != null && identity.Role == IdentityWS.UserRole.SELLER)
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
                SellerId = product.seller_id,
                CategoryId = product.category_id
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
