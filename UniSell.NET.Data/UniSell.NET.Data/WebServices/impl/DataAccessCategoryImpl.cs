using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public int CountCategories(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Count();
            }
        }

        public Category[] FindAllCategories(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().All().ToArray();
            }
        }

        public Category CreateCategory(Category Category, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Create(Category);
            }
        }

        public Category FindCategory(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Find(id);
            }
        }

        public Category RemoveCategory(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Remove(id);
            }
        }

        public Category UpdateCategory(Category Category, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Update(Category);
            }
        }

        public Category[] FindCategoriesByName(string name)
        {
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().FindByName(name);
            }
        }
    }
}