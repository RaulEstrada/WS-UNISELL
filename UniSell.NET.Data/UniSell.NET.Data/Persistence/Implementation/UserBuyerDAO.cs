using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class UserBuyerDAO : GenericDAO<UserBuyer>, IUserBuyerDAO
    {
        public UserBuyerDAO(DBContext context) : base(context)
        {
        }

        public IEnumerable<UserBuyer> FindAllBuyers()
        {
            return DbSet.ToList();
        }
    }
}