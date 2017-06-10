using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Model.Types;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class UserDAO : GenericDAO<User>, IUserDAO
    {
        public UserDAO(DBContext context) : base(context)
        {
        }

        public bool ExistsUsernamePassword(string username, string password, UserRole[] rolesAllowed)
        {
            User[] users = DbSet.Where(u => u.Username.Equals(username) && 
            u.Password.Equals(password) && u.activeAccount && 
            rolesAllowed.Contains(u.Role))
                .ToArray();
            return users != null && users.Length > 0;
        }

        public User FindByUsername(string username)
        {
            User[] users = DbSet.Where(u => u.Username.Equals(username))
                .ToArray();
            return (users != null && users.Length > 0) ? users[0] : null;
        }

        public User[] FindUsersByFilter(UserSearchFilter filter)
        {
            User[] users = DbSet.ToArray();
            if (!string.IsNullOrEmpty(filter.IdDocument)) { users = users.Where(u => u.IdDocument.Equals(filter.IdDocument)).ToArray(); }
            if (filter.IdDocumentType != 0) { users = users.Where(u => u.IdDocumentType == filter.IdDocumentType).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Email)) { users = users.Where(u => u.Email.Equals(filter.Email)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Name)) { users = users.Where(u => u.Name.Equals(filter.Name)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Surname)) { users = users.Where(u => u.Surname.Equals(filter.Surname)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Username)) { users = users.Where(u => u.Username.Equals(filter.Username)).ToArray(); }
            if (filter.Roles != null && filter.Roles.Length > 0) { users = users.Where(u => filter.Roles.Contains(u.Role)).ToArray(); }
            return users;
        }
    }
}