using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class CompanySearchFilter
    {
        public string IdDocument { get; set; }
        public LegalPersonIdDocumentType IdDocumentType { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string City { get; set; }
        public string Region { get; set; }
        public string Country { get; set; }
        public string ZipCode { get; set; }
    }
}