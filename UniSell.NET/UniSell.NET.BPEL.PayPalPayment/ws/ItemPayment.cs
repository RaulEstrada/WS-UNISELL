using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UniSell.NET.BPEL.PayPalPayment.ws
{
    public class ItemPayment
    {
        public long productId { get; set; }
        public int units { get; set; }
    }
}