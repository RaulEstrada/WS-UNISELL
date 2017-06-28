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
        public UserSeller[] ListAllSellers(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserSellerDAO().FindAllSellers().ToArray();
            }
        }

        public UserSeller[] FindSellersByCompanyId(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserSellerDAO().FindByCompanyId(id).ToArray();
            }
        }
    }
}