using Microsoft.IdentityModel.Tokens;
using System;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Security.Claims;
using System.Web;

namespace UniSell.NET.Data.JWT
{
    public class JWTGenerator
    {
        private static byte[] SECRET = Guid.NewGuid().ToByteArray();
        public const int EXPIRATION = 45;

        public static string Generate(string username)
        {
            var handler = new JwtSecurityTokenHandler();
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                    Subject = new ClaimsIdentity(new[] { new Claim(ClaimTypes.Name, username) }),
                    Expires = DateTime.UtcNow.AddMinutes(EXPIRATION),
                    SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(SECRET), SecurityAlgorithms.HmacSha256Signature)
            };
            var stoken = handler.CreateToken(tokenDescriptor);
            var token = handler.WriteToken(stoken);
            return token;
        }

        public static ClaimsPrincipal GetPrincipal(string token)
        {
            var handler = new JwtSecurityTokenHandler();
            var jwtToken = handler.ReadToken(token) as JwtSecurityToken;
            if (jwtToken == null)
            {
                return null;
            }
            var validationParameters = new TokenValidationParameters()
            {
                RequireExpirationTime = true,
                ValidateIssuer = false,
                ValidateAudience = false,
                IssuerSigningKey = new SymmetricSecurityKey(SECRET)
            };
            SecurityToken securityToken;
            return handler.ValidateToken(token, validationParameters, out securityToken);
        }
    }
}