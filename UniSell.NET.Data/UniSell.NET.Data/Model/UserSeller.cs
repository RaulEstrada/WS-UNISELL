using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Model
{
    public class UserSeller : User
    {
        public long company_id { get; set; }
        [ForeignKey("company_id")]
        public Company Company { get; set; }

        public UserSeller()
        {
            Role = UserRole.SELLER;
        }
    }
}