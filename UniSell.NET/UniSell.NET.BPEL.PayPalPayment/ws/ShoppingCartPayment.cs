using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UniSell.NET.BPEL.PayPalPayment.ws
{
    public class ShoppingCartPayment
    {
        public long buyerId { get; set; }
        public HashSet<ItemPayment> items = new HashSet<ItemPayment>();
        public double amount { get; set; }
        public string username { get; set; }
        public string password { get; set; }
        public string signature { get; set; }
        public string authToken { get; set; }
        public bool productsAvailable { get; set; }
        public bool successfulPayment { get; set; }
    }
}