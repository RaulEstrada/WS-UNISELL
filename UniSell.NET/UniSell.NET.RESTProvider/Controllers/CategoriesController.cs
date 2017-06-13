using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using UniSell.NET.RESTProvider.DataAccessWS;

namespace UniSell.NET.RESTProvider.Controllers
{
    public class CategoriesController : ApiController
    {
        // GET: api/Categories
        public IHttpActionResult Get()
        {
            string token = GetAuthToken();
            if (string.IsNullOrEmpty(token))
            {
                return Unauthorized();
            }
            DataAccessSoapClient ws = new DataAccessSoapClient();
            Category[] categories = ws.FindAllCategories(new Security { BinarySecurityToken = token });
            return Ok(categories.Select(c => new { Id = c.Id, Name = c.Name }));
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
    }
}
