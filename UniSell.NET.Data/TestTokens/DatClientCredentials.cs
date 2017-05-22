using System;
using System.Collections.Generic;
using System.IdentityModel.Selectors;
using System.Linq;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.TokenGen;

namespace TestTokens
{
    public class DatClientCredentials : ClientCredentials
    {
        public string Username { get; private set; }
        public string Password { get; private set; }

        public DatClientCredentials(string u, string p)
        {
            this.Username =u;
            Password = p;
        }

        protected override ClientCredentials CloneCore()
        {
            return new DatClientCredentials(this.Username, this.Password);
        }

        public override SecurityTokenManager CreateSecurityTokenManager()
        {
            return new DatCredentialsSecurityTokenManager(this);
        }
    }
}
