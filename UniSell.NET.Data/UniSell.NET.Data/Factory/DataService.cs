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

        public IUserSellerDAO getUserSellerDAO()
        {
            return new UserSellerDAO(_context);
        }

        public IUserBuyerDAO getUserBuyerDAO()
        {
            return new UserBuyerDAO(_context);
        }

        public ICompanyDAO getCompanyDAO()
        {
            return new CompanyDAO(_context);
        }

        public ICategoryDAO getCategoryDAO()
        {
            return new CategoryDAO(_context);
        }

        public IProductDAO getProductDAO()
        {
            return new ProductDAO(_context);
        }

        public IOrderDAO getOrderDAO()
        {
            return new OrderDAO(_context);
        }
    }
}