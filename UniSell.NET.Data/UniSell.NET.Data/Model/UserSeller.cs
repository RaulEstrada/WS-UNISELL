using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Model
{
    public class UserSeller : User
    {
        public override UserRole Role
        {
            get
            {
                return UserRole.SELLER;
            }
        }
    }
}