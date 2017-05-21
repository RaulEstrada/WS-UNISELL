using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.WebServices
{
    [ServiceContract(Namespace = "http://unisell.net.data/")]
    public interface IDataAccessWS
    {
        [OperationContract]
        IEnumerable<User> FindAllUsers();
        [OperationContract]
        User FindUser(long id);
        [OperationContract]
        int CountUsers();
        [OperationContract]
        User CreateUser(User user);
        [OperationContract]
        User UpdateUser(User user);
        [OperationContract]
        User RemoveUser(long id);
    }
}
