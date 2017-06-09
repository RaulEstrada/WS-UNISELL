using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using UniSell.NET.RESTProvider.DataAccessWS;
using UniSell.NET.RESTProvider.Models;

namespace UniSell.NET.RESTProvider.Controllers
{
    public class AuthenticationController : ApiController
    {
        // POST: api/Authentication
        public IHttpActionResult Post(Authentication AuthData)
        {
            if (AuthData == null || !AuthData.IsComplete())
            {
                return BadRequest("Authentication data required but not provided");
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            string token = ws.Login(AuthData.username, AuthData.password, new UserRole[2] { UserRole.BUYER, UserRole.SELLER});
            if (string.IsNullOrEmpty(token))
            {
                return StatusCode(HttpStatusCode.Unauthorized);
            }
            return Ok(new AuthToken { Token = token });
        }
    }
}
