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
        public UserAdmin[] ListAllAdmins(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserAdminDAO().FindAllAdmins().ToArray();
            }
        }
    }
}