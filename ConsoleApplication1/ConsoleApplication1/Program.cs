using ConsoleApplication1.paypal;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {


            SetExpressCheckoutReq req = new SetExpressCheckoutReq
            {
                SetExpressCheckoutRequest = new SetExpressCheckoutRequestType
                {
                    Version = "74.0",
                    SetExpressCheckoutRequestDetails = new SetExpressCheckoutRequestDetailsType
                    {
                        OrderTotal = new BasicAmountType
                        {
                            Value = "10.00",
                            currencyID = CurrencyCodeType.EUR
                        },
                        ReturnURL = "http://www.google.com",
                        CancelURL = "http://www.google.com"
                    }
                }
            };
            CustomSecurityHeaderType cred = new CustomSecurityHeaderType
            {
                Credentials = new UserIdPasswordType
                {
                    Username = "uo225271_merchant_api2.uniovi.es",
                    Password = "TN4KB6QRPSRDE9G5",
                    Signature = "AFcWxV21C7fd0v3bYYYRCpSSRl31AhzL0GoBgvn-TKnJd6oSO-B8Lqz6",
                    AppId = "APP-80W284485P519543T"
                }
            };

            PayPalAPIAAInterfaceClient pp = new PayPalAPIAAInterfaceClient();
            pp.Endpoint.Address = new System.ServiceModel.EndpointAddress("https://api-3t.sandbox.paypal.com/nvp");
            try
            {
                System.Net.ServicePointManager.SecurityProtocol = System.Net.SecurityProtocolType.Tls12;
                var resp = pp.SetExpressCheckout(ref cred, req);
                Console.Out.WriteLine(resp.CorrelationID);
                Console.Out.WriteLine(resp.Ack.ToString());
                foreach (ErrorType msg in resp.Errors)
                {
                    Console.Out.WriteLine(msg.LongMessage);
                }
            }
            catch (Exception ex)
            {
                Console.Out.WriteLine(ex.Message);

            }

        }
    }
}
