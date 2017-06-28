using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Factory;
using UniSell.NET.Data.JWT;
using UniSell.NET.Data.Model;
using UniSell.NET.Data.Persistence.Implementation;

namespace UniSell.NET.Data.WebServices.impl
{
    public partial class DataAccessImpl
    {
        public int CountCompanies(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Count();
            }
        }

        public Company CreateCompany(Company Company, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Create(Company);
            }
        }

        public Company[] FindAllCompanies(Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().All().ToArray();
            }
        }

        public Company FindCompany(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Find(id);
            }
        }

        public Company RemoveCompany(long id, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().Remove(id);
            }
        }

        public Company UpdateCompany(Company company, Security Security)
        {
            ValidateSecurity(Security);
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

        public Company[] FindCompaniesByFilter(CompanySearchFilter filter, Security Security)
        {
            ValidateSecurity(Security);
            using (var ds = new DataService())
            {
                return ds.getCompanyDAO().FindCompaniesByFilter(filter);
            }
        }
    }
}