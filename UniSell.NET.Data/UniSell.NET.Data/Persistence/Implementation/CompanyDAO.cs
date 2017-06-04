using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using UniSell.NET.Data.Context;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class CompanyDAO : GenericDAO<Company>, ICompanyDAO
    {
        public CompanyDAO(DBContext context) : base(context)
        {
        }

        public Company[] FindCompaniesByFilter(CompanySearchFilter filter)
        {
            Company[] companies = DbSet.ToArray();
            if (!string.IsNullOrEmpty(filter.IdDocument)) { companies = companies.Where(c => c.IdDocument.Equals(filter.IdDocument)).ToArray(); }
            if (filter.IdDocumentType != 0) { companies = companies.Where(c => c.IdDocumentType == filter.IdDocumentType).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Name)) { companies = companies.Where(c => c.Name.Equals(filter.Name)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Description)) { companies = companies.Where(c => c.Description.Contains(filter.Description)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.City)) { companies = companies.Where(c => c.LocationInfo.City.Equals(filter.City)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Region)) { companies = companies.Where(c => c.LocationInfo.Region.Equals(filter.Region)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.Country)) { companies = companies.Where(c => c.LocationInfo.Country.Equals(filter.Country)).ToArray(); }
            if (!string.IsNullOrEmpty(filter.ZipCode)) { companies = companies.Where(c => c.LocationInfo.ZipCode.Equals(filter.ZipCode)).ToArray(); }
            return companies;
        }
    }
}