using Microsoft.IdentityModel.Tokens;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;
using System.Security.Cryptography;
using System.Text;
using UniSell.NET.Data.Persistence.Implementation;
using UniSell.NET.Data.Model.Types;
using UniSell.NET.Data.WebServices.impl;

namespace UniSell.NET.Data.WebServices
{
    /// <summary>
    /// Summary description for DataAccess
    /// </summary>
    [WebService(Namespace = "http://unisell.net.data/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    public partial class DataAccess : System.Web.Services.WebService
    {
        public Security Security { set; get; }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountUsers()
        {
            return new DataAccessImpl().CountUsers(Security);
        }

        [WebMethod]
        public User CreateUser(User user)
        {
            return new DataAccessImpl().CreateUser(user);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User[] FindAllUsers()
        {
            return new DataAccessImpl().FindAllUsers(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User FindUser(long id)
        {
            return new DataAccessImpl().FindUser(id, Security);
        }

        [WebMethod]
        public string Login(string username, string password, UserRole[] rolesAllowed)
        {
            return new DataAccessImpl().Login(username, password, rolesAllowed);
        }

        [WebMethod]
        public User FindUserByUsername(string username)
        {
            return new DataAccessImpl().FindUserByUsername(username);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User RemoveUser(long id)
        {
            return new DataAccessImpl().RemoveUser(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User UpdateUser(User user)
        {
            return new DataAccessImpl().UpdateUser(user, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserAdmin[] ListAllAdmins()
        {
            return new DataAccessImpl().ListAllAdmins(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserSeller[] ListAllSellers()
        {
            return new DataAccessImpl().ListAllSellers(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserBuyer[] ListAllBuyers()
        {
            return new DataAccessImpl().ListAllBuyers(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserSeller[] FindSellersByCompanyId(long id)
        {
            return new DataAccessImpl().FindSellersByCompanyId(id, Security);
        }

        [WebMethod]
        public User[] FindUsersByFilter(UserSearchFilter filter)
        {
            return new DataAccessImpl().FindUsersByFilter(filter);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountCategories()
        {
            return new DataAccessImpl().CountCategories(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category[] FindAllCategories()
        {
            return new DataAccessImpl().FindAllCategories(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category CreateCategory(Category Category)
        {
            return new DataAccessImpl().CreateCategory(Category, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category FindCategory(long id)
        {
            return new DataAccessImpl().FindCategory(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category RemoveCategory(long id)
        {
            return new DataAccessImpl().RemoveCategory(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category UpdateCategory(Category Category)
        {
            return new DataAccessImpl().UpdateCategory(Category, Security);
        }

        [WebMethod]
        public Category[] FindCategoriesByName(string name)
        {
            return new DataAccessImpl().FindCategoriesByName(name);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountProducts()
        {
            return new DataAccessImpl().CountProducts(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product[] FindAllProducts()
        {
            return new DataAccessImpl().FindAllProducts(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product CreateProduct(Product Product)
        {
            return new DataAccessImpl().CreateProduct(Product, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product FindProduct(long id)
        {
            return new DataAccessImpl().FindProduct(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product[] FindProductsByFilter(ProductSearchFilter filter)
        {
            return new DataAccessImpl().FindProductsByFilter(filter, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product RemoveProduct(long id)
        {
            return new DataAccessImpl().RemoveProduct(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product UpdateProduct(Product Product)
        {
            return new DataAccessImpl().UpdateProduct(Product, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountOrders()
        {
            return new DataAccessImpl().CountOrders(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Order[] FindAllOrders()
        {
            return new DataAccessImpl().FindAllOrders(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public OrderData[] FindOrdersByUsername(string username)
        {
            return new DataAccessImpl().FindOrdersByUsername(username, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public bool CreateOrder(Order Order)
        {
            return new DataAccessImpl().CreateOrder(Order, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Order FindOrder(long id)
        {
            return new DataAccessImpl().FindOrder(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Order RemoveOrder(long id)
        {
            return new DataAccessImpl().RemoveOrder(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Order UpdateOrder(Order Order)
        {
            return new DataAccessImpl().UpdateOrder(Order, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountCompanies()
        {
            return new DataAccessImpl().CountCompanies(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company CreateCompany(Company Company)
        {
            return new DataAccessImpl().CreateCompany(Company, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company[] FindAllCompanies()
        {
            return new DataAccessImpl().FindAllCompanies(Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company FindCompany(long id)
        {
            return new DataAccessImpl().FindCompany(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company RemoveCompany(long id)
        {
            return new DataAccessImpl().RemoveCompany(id, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company UpdateCompany(Company company)
        {
            return new DataAccessImpl().UpdateCompany(company, Security);
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company[] FindCompaniesByFilter(CompanySearchFilter filter)
        {
            return new DataAccessImpl().FindCompaniesByFilter(filter, Security);
        }

        [WebMethod]
        public UserRole[] FindUserRoles()
        {
            return Enum.GetValues(typeof(UserRole)).Cast<UserRole>().ToArray();
        }

        [WebMethod]
        public PersonIdDocumentType[] FindPersonIdDocumentTypes()
        {
            return Enum.GetValues(typeof(PersonIdDocumentType)).Cast<PersonIdDocumentType>().ToArray();
        }

        [WebMethod]
        public LegalPersonIdDocumentType[] FindLegalIdDocumentTypes()
        {
            return Enum.GetValues(typeof(LegalPersonIdDocumentType)).Cast<LegalPersonIdDocumentType>().ToArray();
        }

        [WebMethod]
        public int FindProductAvailability(long productId)
        {
            return new DataAccessImpl().FindProductAvailability(productId);
        }
    }
}
