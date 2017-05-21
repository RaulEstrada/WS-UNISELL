using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace UniSell.NET.Data.Model
{
    public class User : IEquatable<User>, IComparable<User>
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
        public string Surname { get; set; }
        [Required]
        [Index(IsUnique = true)]
        [DataType(DataType.EmailAddress)]
        [StringLength(50)]
        public string Email { get; set; }
        [Required]
        [Index(IsUnique = true)]
        [StringLength(50)]
        public string Username { get; set; }
        [Required]
        public string Password { get; set; }

        public User() { }

        public override string ToString()
        {
            return Id + ": " + Name + " " + Surname + " (" + Email + "), " + Username;
        }

        public bool Equals(User other)
        {
            if (ReferenceEquals(null, other)) return false;
            if (ReferenceEquals(this, other)) return true;
            return other.Username == Username;
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != typeof(User)) return false;
            return Equals((User)obj);
        }

        public override int GetHashCode()
        {
            return Username.GetHashCode();
        }

        public int CompareTo(User other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}