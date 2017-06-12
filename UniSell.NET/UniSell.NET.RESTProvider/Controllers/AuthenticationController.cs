using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using UniSell.NET.RESTProvider.DataAccessWS;
using UniSell.NET.RESTProvider.IdentityWS;
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
            string token = ws.Login(AuthData.username, AuthData.password, new DataAccessWS.UserRole[2] { DataAccessWS.UserRole.BUYER, DataAccessWS.UserRole.SELLER});
            if (string.IsNullOrEmpty(token))
            {
                return StatusCode(HttpStatusCode.Unauthorized);
            }
            IdentityWSSoapClient idWS = new IdentityWSSoapClient();
            IdentityData idData = idWS.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
            return Ok(new AuthToken { Token = token, Username = idData.Username, Role = idData.Role.ToString() });
        }
    }
}
