using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class OrderItemDAO : GenericDAO<OrderItem>, IOrderItemDAO
    {
        public OrderItemDAO(DBContext context) : base(context)
        {
        }

        public int FindActiveProductOrderCount(long id)
        {
            OrderItem[] orders = DbSet
                .Include("Order")
                .Where(i => i.Order.State == Model.Types.OrderState.ACTIVE && i.product_id == id)
                .ToArray();
            if (orders == null)
            {
                return 0;
            }
            int totalSum = orders.Sum(o => o.quantity);
            return totalSum;
        }
    }
}