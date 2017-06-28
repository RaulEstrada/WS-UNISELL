using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public int CountUsers(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Count();
            }
        }

        public User CreateUser(User user)
        {
            user.Password = getHashedPassword(user.Password);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Create(user);
            }
        }

        public User[] FindAllUsers(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().All().ToArray();
            }
        }

        public User FindUser(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Find(id);
            }
        }

        public User FindUserByUsername(string username)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindByUsername(username);
            }
        }

        public User RemoveUser(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Remove(id);
            }
        }

        public User UpdateUser(User user, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                User dbUser = ds.getUserDAO().Find(user.Id);
                dbUser.Name = (!String.IsNullOrEmpty(user.Name)) ? user.Name : dbUser.Name;
                dbUser.Surname = (!String.IsNullOrEmpty(user.Surname)) ? user.Surname : dbUser.Surname;
                dbUser.Username = (!String.IsNullOrEmpty(user.Username)) ? user.Username : dbUser.Username;
                dbUser.Password = (!String.IsNullOrEmpty(user.Password)) ? getHashedPassword(user.Password) : dbUser.Password;
                dbUser.IdDocument = (!String.IsNullOrEmpty(user.IdDocument)) ? user.IdDocument : dbUser.IdDocument;
                dbUser.IdDocumentType = (user.IdDocumentType != 0) ? user.IdDocumentType : dbUser.IdDocumentType;
                dbUser.Email = (!String.IsNullOrEmpty(user.Email)) ? user.Email : dbUser.Email;
                dbUser.activeAccount = user.activeAccount;
                if (user.Role == Model.Types.UserRole.SELLER)
                {
                    UserSeller seller = user as UserSeller;
                    UserSeller dbSeller = dbUser as UserSeller;
                    dbSeller.company_id = (seller.company_id != 0) ? seller.company_id : dbSeller.company_id;
                }
                return ds.getUserDAO().Update(dbUser);
            }
        }

        public User[] FindUsersByFilter(UserSearchFilter filter)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindUsersByFilter(filter);
            }
        }
    }
}