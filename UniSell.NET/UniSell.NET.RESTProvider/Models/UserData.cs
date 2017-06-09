using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.RESTProvider.DataAccessWS;

namespace UniSell.NET.RESTProvider.Models
{
    public class UserData
    {
        public string name { get; set; }
        public string surname { get; set; }
        public string email { get; set; }
        public string document { get; set; }
        public PersonIdDocumentType documentType { get; set; }
        public string username { get; set; }
        public string password { get; set; }

        public bool IsComplete()
        {
            return !string.IsNullOrEmpty(name) &&
                !string.IsNullOrEmpty(surname) &&
                !string.IsNullOrEmpty(email) &&
                !string.IsNullOrEmpty(document) &&
                !string.IsNullOrEmpty(username) &&
                !string.IsNullOrEmpty(password) &&
                Enum.GetValues(typeof(PersonIdDocumentType)).Cast<PersonIdDocumentType>().Contains(documentType);
        }

        public UserBuyer CreateBuyer()
        {
            return new UserBuyer
            {
                Name = name,
                Surname = surname,
                Email = email,
                IdDocument = document,
                IdDocumentType = documentType,
                Username = username,
                Password = password,
                activeAccount = true,
                Role = UserRole.BUYER
            };
        }
    }
}