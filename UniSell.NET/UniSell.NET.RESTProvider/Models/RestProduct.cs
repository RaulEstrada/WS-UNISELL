using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml.Serialization;

namespace UniSell.NET.RESTProvider.Models
{
    public class RestProduct
    {
        [XmlAttribute("href")]
        public string href { get; set; }

        public long Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public double Price { get; set; }
        public int Units { get; set; }
        public byte[] Image { get; set; }
        public string Seller { get; set; }
        public string Category { get; set; }
    }
}