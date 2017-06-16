using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.ServiceModel;
using System.Web.Http;
using System.Web.Services.Protocols;
using System.Xml;
using UniSell.NET.RESTProvider.DataAccessWS;
using UniSell.NET.RESTProvider.IdentityWS;
using UniSell.NET.RESTProvider.Models;

namespace UniSell.NET.RESTProvider.Controllers
{
    public class BuyersController : ApiController
    {
        // GET: api/Buyers
        public IHttpActionResult Get()
        {
            string token = GetAuthToken();
            IHttpActionResult validateToken = ValidateToken(token);
            if (validateToken != null)
            {
                return validateToken;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User[] buyers = ws.FindUsersByFilter(new UserSearchFilter { Roles = new DataAccessWS.UserRole[] { DataAccessWS.UserRole.BUYER  } });
            return Ok(buyers.Select(b => CreateRestUser(b)));
        }

        // GET: api/Buyers/5
        [Route("api/Buyers/{id}", Name = "GetBuyerById")]
        public IHttpActionResult Get(long id)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = Validate(token, id);
            if (validation != null)
            {
                return validation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User user = ws.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            if (user.Role != DataAccessWS.UserRole.BUYER)
            {
                return NotFound();
            }
            return Ok(CreateRestUser(user));
        }

        // POST: api/Buyers
        public IHttpActionResult Post(UserData User)
        {
            if (User == null || !User.IsComplete())
            {
                return BadRequest("Missing user data");
            }
            IHttpActionResult userValidation = ValidateUserData(User);
            if (userValidation != null)
            {
                return userValidation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User NewUser = ws.CreateUser(User.CreateBuyer());
            return Created(Request.RequestUri.GetLeftPart(UriPartial.Authority) + Url.Route("GetBuyerById", new { id = NewUser.Id }),
                CreateRestUser(NewUser));
        }

        // PUT: api/Buyers/5
        [Route("api/Buyers/{id}")]
        public IHttpActionResult Put(long id, [FromBody] UserData userData)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = Validate(token, id);
            if (validation != null)
            {
                return validation;
            }
            if (userData == null)
            {
                return BadRequest("Missing user data");
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User target = ws.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            if (target.Role != DataAccessWS.UserRole.BUYER)
            {
                return NotFound();
            }
            IHttpActionResult userValidation = ValidateUserData(userData, target);
            if (userValidation != null)
            {
                return userValidation;
            }
            User inputUser = userData.CreateBuyer();
            inputUser.Id = id;
            User updated = ws.UpdateUser(new DataAccessWS.Security { BinarySecurityToken = token }, inputUser);
            return Ok(CreateRestUser(updated));
        }

        // DELETE: api/Buyers/5
        [Route("api/Buyers/{id}")]
        public IHttpActionResult Delete(long id)
        {
            string token = GetAuthToken();
            IHttpActionResult validation = Validate(token, id);
            if (validation != null)
            {
                return validation;
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User target = ws.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            if (target.Role != DataAccessWS.UserRole.BUYER)
            {
                return NotFound();
            }
            User removed = ws.RemoveUser(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            RestUser res = CreateRestUser(removed);
            res.href = "";
            return Ok(res);
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

        private RestUser CreateRestUser(User user)
        {
            return new RestUser
            {
                href = Request.RequestUri.GetLeftPart(UriPartial.Authority) + Url.Route("GetBuyerById", new { id = user.Id }),
                id = user.Id,
                name = user.Name,
                surname = user.Surname,
                email = user.Email,
                document = user.IdDocument,
                documentType = user.IdDocumentType,
                username = user.Username
            };
        }

        private IHttpActionResult Validate(string token, long userId)
        {
            try
            {
                if (!ValidateUserExists(token, userId))
                {
                    return NotFound();
                }
                if (string.IsNullOrEmpty(token) || !ValidateClientIdentity(token, userId))
                {
                    return Unauthorized();
                }
                return null;
            } catch (FaultException ex)
            {
                return BadRequest("Invalid security token");
            }
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

        private bool ValidateClientIdentity(string token, long userId)
        {
            IdentityWSSoapClient ws = new IdentityWSSoapClient();
            IdentityData identity = ws.GetIdentity(new IdentityWS.Security { BinarySecurityToken = token });
            DataAccessSoapClient dataWS = new DataAccessSoapClient();
            User target = dataWS.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, userId);
            return identity != null && target != null && 
                identity.Username.Equals(target.Username) && identity.Role.ToString().Equals(target.Role.ToString());
        }

        private bool ValidateUserExists(string token, long id)
        {
            DataAccessSoapClient dataWS = new DataAccessSoapClient();
            User target = dataWS.FindUser(new DataAccessWS.Security { BinarySecurityToken = token }, id);
            return target != null;
        }

        private IHttpActionResult ValidateUserData(UserData User, User currentUser = null)
        {
            DataAccessSoapClient ws = new DataAccessSoapClient();
            User[] users = ws.FindUsersByFilter(new UserSearchFilter { Email = User.email });
            if (!string.IsNullOrEmpty(User.email) && users != null && users.Length > 0 && 
                (currentUser == null || currentUser.Id != users[0].Id))
            {
                return BadRequest("Another user has already registered the email " + User.email);
            }
            users = ws.FindUsersByFilter(new UserSearchFilter { IdDocument = User.document });
            if (!string.IsNullOrEmpty(User.document) && users != null && users.Length > 0 && 
                (currentUser == null || currentUser.Id != users[0].Id))
            {
                return BadRequest("Another user has already registered the document " + User.document);
            }
            users = ws.FindUsersByFilter(new UserSearchFilter { Username = User.username });
            if (!string.IsNullOrEmpty(User.username) && users != null && users.Length > 0 && 
                (currentUser == null || currentUser.Id != users[0].Id))
            {
                return BadRequest("Another user has already registered the username " + User.username);
            }
            return null;
        }
    }
}
