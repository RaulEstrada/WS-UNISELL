using Microsoft.IdentityModel.Tokens;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;
using System.Web.Services.Protocols;
using UniSell.NET.Data.JWT;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        private void ValidateSecurity(Security Security)
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
            }
            catch (Exception ex) when (ex is ArgumentException
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