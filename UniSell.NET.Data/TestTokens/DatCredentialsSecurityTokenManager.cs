using System;
using System.Collections.Generic;
using System.IdentityModel.Selectors;
using System.IdentityModel.Tokens;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Security.Tokens;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.TokenGen;

namespace TestTokens
{
    class DatCredentialsSecurityTokenManager : ClientCredentialsSecurityTokenManager
    {
        DatClientCredentials creditCardClientCredentials;

        public DatCredentialsSecurityTokenManager(DatClientCredentials creditCardClientCredentials)
            : base(creditCardClientCredentials)
        {
            this.creditCardClientCredentials = creditCardClientCredentials;
        }

        public override SecurityTokenProvider CreateSecurityTokenProvider(SecurityTokenRequirement tokenRequirement)
        {
            if (tokenRequirement.TokenType == Constants.TOKEN_TYPE)
            {
                // Handle this token for Custom.
                return new CredentialsTokenProvider(this.creditCardClientCredentials);
            }
            else if (tokenRequirement is InitiatorServiceModelSecurityTokenRequirement)
            {
                // Return server certificate.
                if (tokenRequirement.TokenType == SecurityTokenTypes.X509Certificate)
                {
                    return new X509SecurityTokenProvider(creditCardClientCredentials.ServiceCertificate.DefaultCertificate);
                }
            }
            return base.CreateSecurityTokenProvider(tokenRequirement);
        }

        public override SecurityTokenSerializer CreateSecurityTokenSerializer(SecurityTokenVersion version)
        {
            return new CredentialsTokenSerializer(version);
        }
    }
}
