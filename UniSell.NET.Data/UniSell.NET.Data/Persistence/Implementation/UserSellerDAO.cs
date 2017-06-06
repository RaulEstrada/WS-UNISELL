using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class UserSellerDAO : GenericDAO<UserSeller>, IUserSellerDAO
    {
        public UserSellerDAO(DBContext context) : base(context)
        {
        }

        public IEnumerable<UserSeller> FindAllSellers()
        {
            return DbSet.ToList();
        }

        public IEnumerable<UserSeller> FindByCompanyId(long id)
        {
            return DbSet.Where(u => u.company_id == id);
        }
    }
}