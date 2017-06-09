using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class CategoryDAO : GenericDAO<Category>, ICategoryDAO
    {
        public CategoryDAO(DBContext context) : base(context)
        {
        }
    }
}