using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public int CountOrders(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().Count();
            }
        }

        public Order[] FindAllOrders(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().All().ToArray();
            }
        }

        public OrderData[] FindOrdersByUsername(string username, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().FindOrdersByUser(username);
            }
        }

        public bool CreateOrder(Order Order, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                Order.dateCreated = DateTime.Now;
                Order newOrder = ds.getOrderDAO().Create(Order);
                return true;
            }
        }

        public Order FindOrder(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().Find(id);
            }
        }

        public Order RemoveOrder(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().Remove(id);
            }
        }

        public Order UpdateOrder(Order Order, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getOrderDAO().Update(Order);
            }
        }

        public int CountOrdersByProduct(long id)
        {
            using (var ds = new DataService())
            {
                return ds.getOrderItemDAO().FindActiveProductOrderCount(id);
            }
        }
    }
}