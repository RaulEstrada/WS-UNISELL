using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class OrderDAO : GenericDAO<Order>, IOrderDAO
    {
        public OrderDAO(DBContext context) : base(context)
        {
        }
    }
}