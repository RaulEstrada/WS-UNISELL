using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml;
using UniSell.BPEL.EntryPoint.bpel;

namespace UniSell.BPEL.EntryPoint.ws
{
    /// <summary>
    /// Summary description for PurchaseWS
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class PurchaseWS : System.Web.Services.WebService
    {

        [WebMethod]
        public string Purchase(shoppingCartAvail purchase)
        {
            try
            {
                WS_InvocationClient ws = new WS_InvocationClient();
                var result = ws.process(new WS_InvocationRequest { input = purchase });
                return result.result;
            } catch (FaultException ex)
            {
                if (ex.Message.Contains("ProductNotAvailableException"))
                {
                    throw new SoapException("Producto no disponible",
                    SoapException.ClientFaultCode);
                } else if (ex.Message.Contains("ArgumentExceptionOrder"))
                {
                    throw new SoapException("Faltan datos. Compruebe que tanto las credenciales de la cuenta como el carrito de la compra no están vacíos",
                    SoapException.ClientFaultCode);
                } else if (ex.Message.Contains("PaymentException"))
                {
                    throw new SoapException("No se ha podido realizar el pago. Compruebe las credenciales/saldo de la cuenta",
                    SoapException.ClientFaultCode);
                }
                throw new SoapException("No se ha podido completar el proceso de compra",
                    SoapException.ClientFaultCode);
            }
        }
    }
}
