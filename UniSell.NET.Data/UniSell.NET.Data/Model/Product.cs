using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace UniSell.NET.Data.Model
{

    public class Product : IEquatable<Product>, IComparable<Product>
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
        public double Price { get; set; }
        [Required]
        public int Units { get; set; }
        [Required]
        public byte[] image { get; set; }
        public long seller_id { get; set; }
        [ForeignKey("seller_id")]
        public UserSeller seller { get; set; }
        public long category_id { get; set; }
        [ForeignKey("category_id")]
        public Category category { get; set; }

        public override string ToString()
        {
            return Id + ": " + Name + ": " + Description + " (" + Price + ")";
        }

        public bool Equals(Product other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other.Id.Equals(Id);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof(Product)) return false;
            return Equals((Product)obj);
        }

        public override int GetHashCode()
        {
            return Id.GetHashCode();
        }

        public int CompareTo(Product other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}