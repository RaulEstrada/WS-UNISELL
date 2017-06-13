using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace UniSell.NET.RESTProvider.Models
{
    public class AuthToken
    {
        public string Token { get; set; }
        public string Username { get; set; }
        public string Role { get; set; }
        public long Id { get; set; }
    }
}