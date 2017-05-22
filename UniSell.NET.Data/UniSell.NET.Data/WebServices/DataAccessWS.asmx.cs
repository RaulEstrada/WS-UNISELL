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
    /// Summary description for DataAccess
    /// </summary>
    [WebService(Namespace = "http://unisell.net.data/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    public class DataAccess : System.Web.Services.WebService
    {
        public Security Security { set; get; }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountUsers()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Count();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User CreateUser(User user)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Create(user);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User[] FindAllUsers()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().All().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User FindUser(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Find(id);
            }
        }

        [WebMethod]
        public string Login(string username, string password)
        {
            using (var ds = new DataService())
            {
                if (ds.getUserDAO().ExistsUsernamePassword(username, password))
                {
                    return JWTGenerator.Generate(username);
                }
                return null;
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User RemoveUser(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Remove(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User UpdateUser(User user)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Update(user);
            }
        }

        private void ValidateSecurity()
        {
            if (Security == null || String.IsNullOrEmpty(Security.BinarySecurityToken))
            {
                throw new SoapException("Authentication Failure - Auth token required but not received",
                    SoapException.ClientFaultCode);
            }
            try
            {
                bool validToken = JWTAuthenticator.ValidateToken(Security.BinarySecurityToken);
                if (!validToken)
                {
                    throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
                }
            } catch (ArgumentException ex)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            } catch (SecurityTokenInvalidSignatureException ex)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            } catch (SecurityTokenExpiredException ex)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            }
            
        }
    }
}
