using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.WebServices;

namespace TestTokens
{
    class Program
    {
        static void Main(string[] args)
        {
            var serviceAddress = new EndpointAddress("http://localhost:9090/WebServices/DataAccessWS.svc");

            var channelFactory = new ChannelFactory<IDataAccessWS>(BindingHelper.CreateDataAccessBinding(), serviceAddress);

            var credentials = new DatClientCredentials("admin","admin");
            credentials.ServiceCertificate.DefaultCertificate = new X509Certificate2(Properties.Resources.cert2, "pass");

            channelFactory.Endpoint.Behaviors.Remove(typeof(ClientCredentials));
            channelFactory.Endpoint.Behaviors.Add(credentials);

            var service = channelFactory.CreateChannel();
            Console.WriteLine("COUNT USERS!: " + service.CountUsers());
        }
    }
}
