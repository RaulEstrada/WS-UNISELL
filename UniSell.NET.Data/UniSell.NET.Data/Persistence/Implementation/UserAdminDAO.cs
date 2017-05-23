using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class UserAdminDAO : GenericDAO<UserAdmin>, IUserAdminDAO
    {
        public UserAdminDAO(DBContext context) : base(context)
        {
        }

        public IEnumerable<UserAdmin> FindAllAdmins()
        {
            return DbSet.ToList();
        }
    }
}