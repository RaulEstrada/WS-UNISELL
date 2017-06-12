using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.Persistence
{
    public interface IProductDAO : IGenericDAO<Product>
    {
        Product[] FindProductsByFilter(ProductSearchFilter filter);
    }
}
