using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml.Schema;
using System.Xml.Serialization;
using UniSell.NET.RESTProvider.DataAccessWS;

namespace UniSell.NET.RESTProvider.Models
{
    public class RestUser
    {
        [XmlAttribute("href")]
        public string href { get; set; }

        public long id { get; set; }
        public string name { get; set; }
        public string surname { get; set; }
        public string email { get; set; }
        public string document { get; set; }
        public PersonIdDocumentType documentType { get; set; }
        public string username { get; set; }
    }
}