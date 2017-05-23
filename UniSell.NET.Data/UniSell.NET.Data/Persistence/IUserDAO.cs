using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence
{
    public interface IUserDAO : IGenericDAO<User>
    {
        bool ExistsUsernamePassword(string username, string password);
        User FindByUsernamePassword(string username, string password);
        User FindByUsername(string username);
    }
}
