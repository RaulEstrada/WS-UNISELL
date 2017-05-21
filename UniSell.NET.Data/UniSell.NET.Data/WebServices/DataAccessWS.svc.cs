using System.Collections.Generic;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.WebServices
{
    public class DataAccessWS : IDataAccessWS
    {
        public int CountUsers()
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Count();
            }
        }

        public User CreateUser(User user)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Create(user);
            }
        }

        public IEnumerable<User> FindAllUsers()
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().All();
            }
        }

        public User FindUser(long id)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Find(id);
            }
        }

        public User RemoveUser(long id)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Remove(id);
            }
        }

        public User UpdateUser(User user)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Update(user);
            }
        }
    }
}
