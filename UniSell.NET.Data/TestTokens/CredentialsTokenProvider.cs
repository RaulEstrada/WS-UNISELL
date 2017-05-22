using System;
using System.Collections.Generic;
using System.IdentityModel.Selectors;
using System.IdentityModel.Tokens;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.TokenGen;

namespace TestTokens
{
    public class CredentialsTokenProvider : SecurityTokenProvider
    {
        private readonly DatClientCredentials _credentials;

        public CredentialsTokenProvider(DatClientCredentials credentials)
        {
            if (credentials == null) throw new ArgumentNullException("credentials");

            _credentials = credentials;
        }

        protected override SecurityToken GetTokenCore(TimeSpan timeout)
        {
            return new CredentialsToken(new Credentials {
                Password = _credentials.Password,
                Username = _credentials.Username
            });
        }
    }
}
