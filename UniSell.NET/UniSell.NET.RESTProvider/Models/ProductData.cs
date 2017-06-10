using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.RESTProvider.DataAccessWS;

namespace UniSell.NET.RESTProvider.Models
{
    public class ProductData
    {
        public string Name { get; set; }
        public string Description { get; set; }
        public double? Price { get; set; }
        public int? Units { get; set; }
        public byte[] Image { get; set; }
        public long? SellerId { get; set; }
        public long? CategoryId { get; set; }

        public bool IsComplete()
        {
            return !string.IsNullOrEmpty(Name) &&
                !string.IsNullOrEmpty(Description) &&
                Price != null &&
                Units != null &&
                Image != null &&
                SellerId != null &&
                CategoryId != null;
        }

        public Product CreateProduct()
        {
            return new Product
            {
                Name = Name,
                Description = Description,
                Price = Price.Value,
                Units = Units.Value,
                image = Image,
                seller_id = SellerId.Value,
                category_id = CategoryId.Value
            };
        }
    }
}