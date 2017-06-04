using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Model
{

    public class UserBuyer : User
    {
        public UserBuyer()
        {
            Role = UserRole.BUYER;
        }
    }
}