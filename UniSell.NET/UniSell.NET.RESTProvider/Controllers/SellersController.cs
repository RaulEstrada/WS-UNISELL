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
    public class SellersController : ApiController
    {
        // GET: api/Sellers/5
        [Route("api/Sellers/{username}/Products")]
        public IHttpActionResult Get(string username)
        {
            DataAccessSoapClient dataWS = new DataAccessSoapClient();
            var binding = dataWS.ChannelFactory.Endpoint.Binding as BasicHttpBinding;
            binding.MaxReceivedMessageSize = int.MaxValue;
            string token = GetAuthToken();
            IHttpActionResult validation = ValidateSeller(token, username);
            if (validation != null)
            {
                return validation;
            }
            Product[] products = dataWS.FindProductsByFilter(new DataAccessWS.Security { BinarySecurityToken = token },
                new ProductSearchFilter { Seller = username });
            return Ok(products.Select(p => CreateRestProduct(p)));
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

        private IHttpActionResult ValidateSeller(string token, string username)
        {
            try
            {
                IdentityWSSoapClient ws = new IdentityWSSoapClient();
                IdentityData identity = ws.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
                if (identity == null)
                {
                    return Unauthorized();
                }
                if (!identity.Username.Equals(username))
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
                Seller = product.seller.Username,
                Category = product.category.Name
            };
        }
    }
}
