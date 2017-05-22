using System.ServiceModel.Channels;
using System.ServiceModel.Security.Tokens;
using UniSell.NET.Data.TokenGen;

namespace TestTokens
{
    public class BindingHelper
    {
        public static Binding CreateDataAccessBinding()
        {
            HttpTransportBindingElement httpTransport = new HttpTransportBindingElement();

            SymmetricSecurityBindingElement messageSecurity = new SymmetricSecurityBindingElement();
            messageSecurity.EndpointSupportingTokenParameters.SignedEncrypted.Add(new CredentialsTokenParameters());
            X509SecurityTokenParameters x509ProtectionParameters = new X509SecurityTokenParameters();
            x509ProtectionParameters.InclusionMode = SecurityTokenInclusionMode.Never;
            messageSecurity.ProtectionTokenParameters = x509ProtectionParameters;
            return new CustomBinding(messageSecurity, httpTransport);
        }
    }
}
