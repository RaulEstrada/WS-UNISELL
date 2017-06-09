using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Model.Types;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.Persistence
{
    public interface IUserDAO : IGenericDAO<User>
    {
        bool ExistsUsernamePassword(string username, string password, UserRole[] rolesAllowed);
        User FindByUsername(string username);
        User[] FindUsersByFilter(UserSearchFilter filter);
    }
}
