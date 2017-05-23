using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;
using UniSell.NET.Data.Model.valueObjects;

namespace UniSell.NET.Data.Model
{
    public class Company : IEquatable<Company>, IComparable<Company>
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }
        [ConcurrencyCheck]
        [DatabaseGenerated(DatabaseGeneratedOption.Computed)]
        public long version { get; set; }
        [Required]
        public string Name { get; set; }
        [Required]
        public string Description { get; set; }
        [Required]
        [Index(IsUnique = true)]
        [StringLength(10)]
        public string IdDocument { get; set; }
        [Required]
        public LegalPersonIdDocumentType IdDocumentType { get; set; }
        [Required]
        public LocationInfo LocationInfo { get; set; } = new LocationInfo();

        public override string ToString()
        {
            return Id + ": " + Name + ": " + Description + " (" + LocationInfo.ToString() + ")";
        }

        public bool Equals(Company other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other.IdDocument.Equals(IdDocument);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof(Company)) return false;
            return Equals((Company)obj);
        }

        public override int GetHashCode()
        {
            return IdDocument.GetHashCode();
        }

        public int CompareTo(Company other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}