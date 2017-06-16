using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace UniSell.NET.Data.Model
{
    public class OrderItem : IEquatable<OrderItem>, IComparable<OrderItem>
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }
        [ConcurrencyCheck]
        [DatabaseGenerated(DatabaseGeneratedOption.Computed)]
        public long version { get; set; }
        [Required]
        public int quantity { get; set; }
        public long product_id { get; set; }
        [ForeignKey("product_id")]
        public Product Product { get; set; }
        public long order_id { get; set; }
        [ForeignKey("order_id")]
        public Order Order { get; set; }

        public override string ToString()
        {
            return Id + ": " + quantity + ": " + Product.ToString();
        }

        public bool Equals(OrderItem other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other.Id.Equals(Id);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof(OrderItem)) return false;
            return Equals((OrderItem)obj);
        }

        public override int GetHashCode()
        {
            return Id.GetHashCode();
        }

        public int CompareTo(OrderItem other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}