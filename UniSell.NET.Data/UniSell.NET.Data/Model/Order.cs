using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Model
{
    public class Order : IEquatable<Order>, IComparable<Order>
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }
        [ConcurrencyCheck]
        [DatabaseGenerated(DatabaseGeneratedOption.Computed)]
        public long version { get; set; }
        [Required]
        public DateTime dateCreated { get; set; }
        [Required]
        public string orderNumber { get; set; }
        [Required]
        public OrderState State { get; set; }
        public long buyer_id { get; set; }
        [ForeignKey("buyer_id")]
        public UserBuyer Buyer { get; set; }
        public virtual List<OrderItem> Items { get; set; }

        public Order()
        {
            State = OrderState.ACTIVE;
            Items = new List<OrderItem>();
        }

        public override string ToString()
        {
            return Id + ": " + orderNumber + ": " + dateCreated.ToShortDateString() + ": " + buyer_id;
        }

        public bool Equals(Order other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other.Id.Equals(Id);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof(Order)) return false;
            return Equals((Order)obj);
        }

        public override int GetHashCode()
        {
            return Id.GetHashCode();
        }

        public int CompareTo(Order other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}