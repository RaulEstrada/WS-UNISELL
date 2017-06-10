using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class UserSearchFilter
    {
        public string IdDocument { get; set; }
        public PersonIdDocumentType IdDocumentType { get; set; }
        public string Email { get; set; }
        public string Name { get; set; }
        public string Surname { get; set; }
        public string Username { get; set; }
        public UserRole[] Roles { get; set; }
    }
}