using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Model
{
    public class OrderData
    {
        public string OrderNumber { get; set; }
        public DateTime DateCreated { get; set; }
        public OrderState State { get; set; }
    }
}