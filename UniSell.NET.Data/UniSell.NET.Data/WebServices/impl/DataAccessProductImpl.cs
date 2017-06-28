using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public int CountProducts(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Count();
            }
        }

        public Product[] FindAllProducts(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().All().ToArray();
            }
        }

        public Product CreateProduct(Product Product, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Create(Product);
            }
        }

        public Product FindProduct(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Find(id);
            }
        }

        public Product[] FindProductsByFilter(ProductSearchFilter filter, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().FindProductsByFilter(filter);
            }
        }

        public Product RemoveProduct(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Remove(id);
            }
        }

        public Product UpdateProduct(Product Product, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Update(Product);
            }
        }

        public int FindProductAvailability(long productId)
        {
            using (var ds = new DataService())
            {
                Product product = ds.getProductDAO().Find(productId);
                if (product == null)
                {
                    return 0;
                }
                int productUnits = product.Units;
                int activeOrders = ds.getOrderItemDAO().FindActiveProductOrderCount(productId);
                return productUnits - activeOrders;
            }
        }
    }
}