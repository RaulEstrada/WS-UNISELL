using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class ProductDAO : GenericDAO<Product>, IProductDAO
    {
        public ProductDAO(DBContext context) : base(context)
        {
        }

        public Product[] FindProductsByFilter(ProductSearchFilter filter)
        {
            Product[] products = DbSet.Include("seller").Include("category").ToArray();
            if (!string.IsNullOrEmpty(filter.Name)) { products = products.Where(p => p.Name.Equals(filter.Name)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Description)) { products = products.Where(p => p.Description.Contains(filter.Description)).ToArray(); }
            if (filter.PriceFrom != null) { products = products.Where(p => p.Price >= filter.PriceFrom).ToArray(); }
            if (filter.PriceTo != null) { products = products.Where(p => p.Price <= filter.PriceTo).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Seller)) { products = products.Where(p => p.seller.Username.Equals(filter.Seller)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Category)) { products = products.Where(p => p.category.Name.Equals(filter.Category)).ToArray(); }
            return products;
        }
    }
}