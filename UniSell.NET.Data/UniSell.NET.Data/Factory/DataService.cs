using System;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Persistence;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.Factory
{
    public class DataService : IDisposable
    {
        private DBContext _context;

        public DataService()
        {
            this._context = new DBContext();
        }

        public void Dispose()
        {
            this._context.Dispose();
        }

        public IUserDAO getUserDAO()
        {
            return new UserDAO(_context);
        }

        public IUserAdminDAO getUserAdminDAO()
        {
            return new UserAdminDAO(_context);
        }
    }
}