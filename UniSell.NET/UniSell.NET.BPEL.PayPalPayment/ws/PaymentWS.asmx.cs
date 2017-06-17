using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Configuration;
using System.Web.Services;
using System.Web.Services.Protocols;
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
        public ShoppingCartPayment Pay(ShoppingCartPayment orderDetails)
        {
            if (string.IsNullOrEmpty(orderDetails.authToken))
            {
                return orderDetails;
            }
            if (!CheckUserBuyer(orderDetails.authToken))
            {
                return orderDetails;
            }
            if (orderDetails.amount <= 0.01)
            {
                return orderDetails;
            }
            PayPalAPIAAInterfaceClient pp = CreatePaypalConnection();
            CustomSecurityHeaderType credentials = CreateHeaderCredentials(orderDetails.username,
                orderDetails.password, orderDetails.signature);
            SetExpressCheckoutReq request = CreateExpressCheckoutRequest(orderDetails.amount);
            try
            {
                System.Net.ServicePointManager.SecurityProtocol = System.Net.SecurityProtocolType.Tls12;
                var response = pp.SetExpressCheckout(ref credentials, request);
                if (response.Ack == AckCodeType.Success)
                {
                    orderDetails.successfulPayment = true;
                    return orderDetails;
                } else
                {
                    return orderDetails;
                }
            }
            catch (Exception ex)
            {
                return orderDetails;
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
                            Value = String.Format("{0:0.00}", Amount).Replace(",", "."),
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
