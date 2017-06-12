using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class ProductSearchFilter
    {
        public string Name { get; set; }
        public string Description { get; set; }
        public double? PriceFrom { get; set; }
        public double? PriceTo { get; set; }
        public string Seller { get; set; }
        public string Category { get; set; }
    }
}