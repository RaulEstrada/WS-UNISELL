using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
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
            WS_InvocationClient ws = new WS_InvocationClient();
            var result = ws.process(new WS_InvocationRequest { input = purchase });
            return result.result;
        }
    }
}
