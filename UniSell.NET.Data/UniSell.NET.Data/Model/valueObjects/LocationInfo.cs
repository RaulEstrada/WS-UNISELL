using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace UniSell.NET.Data.Model.valueObjects
{
    [ComplexType]
    public class LocationInfo
    {
        [Required]
        [Column("city")]
        public string City { get; set; }
        [Required]
        [Column("region")]
        public string Region { get; set; }
        [Required]
        [Column("country")]
        public string Country { get; set; }
        [Required]
        [Column("zipCode")]
        public string ZipCode { get; set; }

        public override string ToString()
        {
            return Country + ", " + Region + ", " + City + " (" + ZipCode + ")";
        }
    }

}