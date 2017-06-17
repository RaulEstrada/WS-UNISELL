using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UniSell.NET.Data.Persistence
{
    public interface IOrderItemDAO
    {
        int FindActiveProductOrderCount(long id);
    }
}
