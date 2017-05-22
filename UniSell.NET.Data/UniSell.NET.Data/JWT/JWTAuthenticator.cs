﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Security.Principal;
using System.Threading.Tasks;
using System.Web;

namespace UniSell.NET.Data.JWT
{
    public class JWTAuthenticator
    {
        public static bool ValidateToken(string token)
        {
            var principal = JWTGenerator.GetPrincipal(token);
            var identity = principal.Identity as ClaimsIdentity;
            if (identity == null || !identity.IsAuthenticated)
            {
                return false;
            }
            var usernameClaim = identity.FindFirst(ClaimTypes.Name);
            return !(string.IsNullOrEmpty(usernameClaim?.Value));
        }
    }
}