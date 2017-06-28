using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public string Login(string username, string password, UserRole[] rolesAllowed)
        {
            string hashedPassword = getHashedPassword(password);
            using (var ds = new DataService())
            {
                if (ds.getUserDAO().ExistsUsernamePassword(username, hashedPassword, rolesAllowed))
                {
                    return JWTGenerator.Generate(username);
                }
                return null;
            }
        }
    }
}