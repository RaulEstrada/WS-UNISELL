using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Xml;
using UniSell.NET.RESTProvider.DataAccessWS;
using UniSell.NET.RESTProvider.Models;

namespace UniSell.NET.RESTProvider.Controllers
{
    public class BuyersController : ApiController
    {
        private string GetAuthToken()
        {
            try
            {
                IEnumerable<string> headerValues = Request.Headers.GetValues("token");
                return headerValues.First();
            } catch (Exception ex)
            {
                return null;
            }
        }

        // GET: api/Buyers
        public IHttpActionResult Get()
        {
            string token = GetAuthToken();
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User[] buyers = ws.FindUsersByFilter(new Security { BinarySecurityToken = token }, 
                new UserSearchFilter { Role = UserRole.BUYER });
            return Ok(buyers.Select(b => new RestUser {
                href = Request.RequestUri.GetLeftPart(UriPartial.Authority) + Url.Route("GetBuyerById", new { id = b.Id }),
                id = b.Id,
                name = b.Name,
                surname = b.Surname,
                email = b.Email,
                document = b.IdDocument,
                documentType = b.IdDocumentType,
                username = b.Username
            }));
        }

        // GET: api/Buyers/5
        [Route("api/Buyers/{id}", Name = "GetBuyerById")]
        public IHttpActionResult Get(int id)
        {
            string token = GetAuthToken();
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            return null;
        }

        // POST: api/Buyers
        public IHttpActionResult Post(UserData User)
        {
            if (User == null || !User.IsComplete())
            {
                return BadRequest("Missing user data");
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User NewUser = ws.CreateUser(User.CreateBuyer());
            return Ok(NewUser);
        }

        // PUT: api/Buyers/5
        public IHttpActionResult Put(int id, [FromBody]string value)
        {
            string token = GetAuthToken();
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            return null;
        }

        // DELETE: api/Buyers/5
        public IHttpActionResult Delete(int id)
        {
            string token = GetAuthToken();
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            return null;
        }
    }
}
