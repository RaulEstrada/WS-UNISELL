using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.Services;
using UniSell.NET.BPEL.PayPalPayment.IdentityWS;
using UniSell.NET.BPEL.PayPalPayment.PayPalSOAP;

namespace UniSell.NET.BPEL.PayPalPayment.ws
{
    /// <summary>
    /// Summary description for PaymentWS
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class PaymentWS : System.Web.Services.WebService
    {

        [WebMethod]
        public bool Pay(double Amount, string Username, string Password, string Signature, string AuthToken)
        {
            if (string.IsNullOrEmpty(AuthToken))
            {
                return false;
            }
            if (!CheckUserBuyer(AuthToken))
            {
                return false;
            }
            if (Amount <= 0.01)
            {
                return false;
            }
            PayPalAPIAAInterfaceClient pp = CreatePaypalConnection();
            CustomSecurityHeaderType credentials = CreateHeaderCredentials(Username, Password, Signature);
            SetExpressCheckoutReq request = CreateExpressCheckoutRequest(Amount);
            try
            {
                System.Net.ServicePointManager.SecurityProtocol = System.Net.SecurityProtocolType.Tls12;
                var response = pp.SetExpressCheckout(ref credentials, request);
                if (response.Ack == AckCodeType.Success)
                {
                    return true;
                } else
                {
                    return false;
                }
            }
            catch (Exception ex)
            {
                return false;
            }
        }

        private bool CheckUserBuyer(string AuthToken)
        {
            IdentityWSSoapClient ws = new IdentityWSSoapClient();
            IdentityData Data = ws.GetIdentity(new Security { BinarySecurityToken = AuthToken });
            if (Data == null || Data.Role != UserRole.BUYER)
            {
                return false;
            }
            return true;
        }

        private CustomSecurityHeaderType CreateHeaderCredentials(string Username, string Password, string Signature)
        {
            return new CustomSecurityHeaderType
            {
                Credentials = new UserIdPasswordType
                {
                    Username = Username,
                    Password = Password,
                    Signature = Signature,
                    AppId = WebConfigurationManager.AppSettings["paypalAppID"]
                }
            };
        }

        private SetExpressCheckoutReq CreateExpressCheckoutRequest(double Amount)
        {
            return new SetExpressCheckoutReq
            {
                SetExpressCheckoutRequest = new SetExpressCheckoutRequestType
                {
                    Version = "74.0",
                    SetExpressCheckoutRequestDetails = new SetExpressCheckoutRequestDetailsType
                    {
                        OrderTotal = new BasicAmountType
                        {
                            Value = String.Format("{0:0.00}", Amount),
                            currencyID = CurrencyCodeType.EUR
                        },
                        ReturnURL = "http://unisell.miw",
                        CancelURL = "http://unisell.miw"
                    }
                }
            };
        }

        private PayPalAPIAAInterfaceClient CreatePaypalConnection()
        {
            PayPalAPIAAInterfaceClient api = new PayPalAPIAAInterfaceClient();
            api.Endpoint.Address = new System.ServiceModel.EndpointAddress("https://api-3t.sandbox.paypal.com/nvp");
            return api;
        }
    }
}
