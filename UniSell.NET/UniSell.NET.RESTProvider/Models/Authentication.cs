using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace UniSell.NET.RESTProvider.Models
{
    public class Authentication
    {
        public string username;
        public string password;

        public bool IsComplete()
        {
            return !string.IsNullOrEmpty(username) && !string.IsNullOrEmpty(password);
        }

        public override string ToString()
        {
            return "Authentication: " + username + "::" + password;
        }
    }
}