using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UniSell.NET.Data.Persistence
{
    public interface IGenericDAO<T> where T:class
    {
        T Create(T t);
        T Update(T t);
        T Remove(long id);
        T Find(long id);
        IEnumerable<T> All();
        int Count();
    }
}
