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
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Count();
            }
        }

        [WebMethod]
        public User CreateUser(User user)
        {
            user.Password = getHashedPassword(user.Password);
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Create(user);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User[] FindAllUsers()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().All().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User FindUser(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Find(id);
            }
        }

        [WebMethod]
        public string Login(string username, string password, UserRole[] rolesAllowed)
        {
            string hashedPassword = getHashedPassword(password);
            using (var ds = new DataService())
            {
                if (ds.getUserDAO().ExistsUsernamePassword(username, hashedPassword, rolesAllowed))
                {
                    return JWTGenerator.Generate(username);
                }
                return null;
            }
        }

        [WebMethod]
        public User FindUserByUsername(string username)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindByUsername(username);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User RemoveUser(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserDAO().Remove(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public User UpdateUser(User user)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                User dbUser = ds.getUserDAO().Find(user.Id);
                dbUser.Name = (!String.IsNullOrEmpty(user.Name)) ? user.Name : dbUser.Name;
                dbUser.Surname = (!String.IsNullOrEmpty(user.Surname)) ? user.Surname : dbUser.Surname;
                dbUser.Username = (!String.IsNullOrEmpty(user.Username)) ? user.Username : dbUser.Username;
                dbUser.Password = (!String.IsNullOrEmpty(user.Password)) ? getHashedPassword(user.Password) : dbUser.Password;
                dbUser.IdDocument = (!String.IsNullOrEmpty(user.IdDocument)) ? user.IdDocument : dbUser.IdDocument;
                dbUser.IdDocumentType = (user.IdDocumentType != 0) ? user.IdDocumentType : dbUser.IdDocumentType;
                dbUser.Email = (!String.IsNullOrEmpty(user.Email)) ? user.Email : dbUser.Email;
                dbUser.activeAccount = user.activeAccount;
                if (user.Role == Model.Types.UserRole.SELLER)
                {
                    UserSeller seller = user as UserSeller;
                    UserSeller dbSeller = dbUser as UserSeller;
                    dbSeller.company_id = (seller.company_id != 0) ? seller.company_id : dbSeller.company_id;
                }
                return ds.getUserDAO().Update(dbUser);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserAdmin[] ListAllAdmins()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserAdminDAO().FindAllAdmins().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserSeller[] ListAllSellers()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserSellerDAO().FindAllSellers().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserBuyer[] ListAllBuyers()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserBuyerDAO().FindAllBuyers().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public UserSeller[] FindSellersByCompanyId(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getUserSellerDAO().FindByCompanyId(id).ToArray();
            }
        }

        [WebMethod]
        public User[] FindUsersByFilter(UserSearchFilter filter)
        {
            using (var ds = new DataService())
            {
                return ds.getUserDAO().FindUsersByFilter(filter);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountCategories()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Count();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category[] FindAllCategories()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().All().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category CreateCategory(Category Category)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Create(Category);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category FindCategory(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Find(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category RemoveCategory(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Remove(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Category UpdateCategory(Category Category)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().Update(Category);
            }
        }

        [WebMethod]
        public Category[] FindCategoriesByName(string name)
        {
            using (var ds = new DataService())
            {
                return ds.getCategoryDAO().FindByName(name);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountProducts()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Count();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product[] FindAllProducts()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().All().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product CreateProduct(Product Product)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Create(Product);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product FindProduct(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Find(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product[] FindProductsByFilter(ProductSearchFilter filter)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().FindProductsByFilter(filter);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product RemoveProduct(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Remove(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Product UpdateProduct(Product Product)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getProductDAO().Update(Product);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public int CountCompanies()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Count();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company CreateCompany(Company Company)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Create(Company);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company[] FindAllCompanies()
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().All().ToArray();
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company FindCompany(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Find(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company RemoveCompany(long id)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Remove(id);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company UpdateCompany(Company company)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                Company dbCompany = ds.getCompanyDAO().Find(company.Id);
                dbCompany.Name = (!string.IsNullOrEmpty(company.Name)) ? company.Name : dbCompany.Name;
                dbCompany.Description = (!string.IsNullOrEmpty(company.Description)) ? company.Description : dbCompany.Description;
                dbCompany.IdDocument = (!string.IsNullOrEmpty(company.IdDocument)) ? company.IdDocument : dbCompany.IdDocument;
                dbCompany.IdDocumentType = (company.IdDocumentType != 0) ? company.IdDocumentType : dbCompany.IdDocumentType;
                dbCompany.LocationInfo = (company.LocationInfo != null) ? company.LocationInfo : dbCompany.LocationInfo;
                return ds.getCompanyDAO().Update(dbCompany);
            }
        }

        [WebMethod]
        [SoapHeader("Security", Direction = SoapHeaderDirection.In)]
        public Company[] FindCompaniesByFilter(CompanySearchFilter filter)
        {
            ValidateSecurity();
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().FindCompaniesByFilter(filter);
            }
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

        private void ValidateSecurity()
        {
            if (Security == null || String.IsNullOrEmpty(Security.BinarySecurityToken))
            {
                throw new SoapException("Authentication Failure - Auth token required but not received",
                    SoapException.ClientFaultCode);
            }
            try
            {
                bool validToken = JWTAuthenticator.ValidateToken(Security.BinarySecurityToken);
                if (!validToken)
                {
                    throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
                }
            } catch (Exception ex) when (ex is ArgumentException
                || ex is SecurityTokenInvalidSignatureException
                || ex is SecurityTokenExpiredException)
            {
                throw new SoapException("Authentication Failure - Auth token provided is not valid",
                        SoapException.ClientFaultCode);
            }
        }

        private string getHashedPassword(string plainPassword)
        {
            SHA512 sha512 = new SHA512Managed();
            byte[] password = Encoding.UTF8.GetBytes(plainPassword);
            byte[] hashed = sha512.ComputeHash(password);
            return Convert.ToBase64String(hashed);
        }
    }
}
