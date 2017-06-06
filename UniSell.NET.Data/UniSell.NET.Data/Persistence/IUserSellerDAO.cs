using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence
{
    public interface IUserSellerDAO
    {
        IEnumerable<UserSeller> FindAllSellers();
        IEnumerable<UserSeller> FindByCompanyId(long id);
    }
}