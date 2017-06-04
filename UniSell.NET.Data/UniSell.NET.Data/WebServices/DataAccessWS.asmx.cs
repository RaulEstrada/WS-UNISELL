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
using System.Security.Cryptography;
using System.Text;
using UniSell.NET.Data.Persistence.Implementation;

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
            if (user.Role != Model.Types.UserRole.BUYER)
            {
                ValidateSecurity();
            }
            user.Password = getHashedPassword(user.Password);
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
            string hashedPassword = getHashedPassword(password);
            using (var ds = new DataService())
            {
                if (ds.getUserDAO().ExistsUsernamePassword(username, hashedPassword))
                {
                    return JWTGenerator.Generate(username);
                }
                return null;
            }
        }

        [WebMethod]
        public User FindUserByUsername(string username)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindByUsername(username);
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
                User dbUser = ds.getUserDAO().Find(user.Id);
                dbUser.Name = (!String.IsNullOrEmpty(user.Name)) ? user.Name : dbUser.Name;
                dbUser.Surname = (!String.IsNullOrEmpty(user.Surname)) ? user.Surname : dbUser.Surname;
                dbUser.Username = (!String.IsNullOrEmpty(user.Username)) ? user.Username : dbUser.Username;
                dbUser.Password = (!String.IsNullOrEmpty(user.Password)) ? getHashedPassword(user.Password) : dbUser.Password;
                dbUser.IdDocument = (!String.IsNullOrEmpty(user.IdDocument)) ? user.IdDocument : dbUser.IdDocument;
                dbUser.IdDocumentType = (user.IdDocumentType != 0) ? user.IdDocumentType : dbUser.IdDocumentType;
                dbUser.Email = (!String.IsNullOrEmpty(user.Email)) ? user.Email : dbUser.Email;
                dbUser.activeAccount = user.activeAccount;
                return ds.getUserDAO().Update(dbUser);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserAdmin[] ListAllAdmins()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserAdminDAO().FindAllAdmins().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User[] FindUsersByFilter(UserSearchFilter filter)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindUsersByFilter(filter);
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
            } catch (Exception ex) when (ex is ArgumentException
                || ex is SecurityTokenInvalidSignatureException
                || ex is SecurityTokenExpiredException)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            }
        }

        private string getHashedPassword(string plainPassword)
        {
            SHA512 sha512 = new SHA512Managed();
            byte[] password = Encoding.UTF8.GetBytes(plainPassword);
            byte[] hashed = sha512.ComputeHash(password);
            return Convert.ToBase64String(hashed);
        }
    }
}
