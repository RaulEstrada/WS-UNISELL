package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.Company;
import uniovi.miw.unisell.model.CompanyData;
import uniovi.miw.unisell.model.EditCompanyData;

public class CompanyConversor {
	
	public Company createCompany(CompanyData data, Long id) {
		Company company = new Company();
		company.setId(id);
		company.setIdDocument(data.getIdDocument());
		company.setIdDocumentType(data.getIdDocumentType());
		company.setName(data.getName());
		company.setDescription(data.getDescription());
		company.setLocationInfo(data.getLocationInfo());
		return company;
	}
	
	public Company createCompany(CompanyData data) {
		return createCompany(data, 0l);
	}
	
	public EditCompanyData createEditCompanyData(Company company) {
		CompanyData data = new CompanyData()
				.setIdDocument(company.getIdDocument())
				.setIdDocumentType(company.getIdDocumentType())
				.setName(company.getName())
				.setDescription(company.getDescription())
				.setLocationInfo(company.getLocationInfo());
		return new EditCompanyData()
				.setId(company.getId())
				.setCompanyData(data);
	}
}
