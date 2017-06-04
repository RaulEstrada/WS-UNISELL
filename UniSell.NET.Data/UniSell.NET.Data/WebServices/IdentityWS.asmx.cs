using Microsoft.IdentityModel.Tokens;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.WebServices
{
    /// <summary>
    /// Summary description for IdentityWS
    /// </summary>
    [WebService(Namespace = "http://unisell.net.data/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class IdentityWS : System.Web.Services.WebService
    {
        public Security Security { set; get; }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public IdentityData GetIdentity()
        {
            string username = null;
            try
            {
                username = JWTAuthenticator.GetTokenIdentity(Security.BinarySecurityToken);
            } catch (Exception ex) when(ex is ArgumentException
                    || ex is SecurityTokenInvalidSignatureException
                    || ex is SecurityTokenExpiredException)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            }
            if (username == null)
            {
                return null;
            }
            using (var ds = new DataService())
            {
                User loggedUser = ds.getUserDAO().FindByUsername(username);
                if (loggedUser == null)
                {
                    return null;
                }
                return new IdentityData
                {
                    Username = username,
                    Role = loggedUser.Role
                };
            }
        }
    }
}
