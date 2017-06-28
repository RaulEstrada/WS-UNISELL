package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfCompany;
import uniovi.miw.unisell.data.ArrayOfUserSeller;
import uniovi.miw.unisell.data.Company;
import uniovi.miw.unisell.data.CompanySearchFilter;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.CompanyData;
import uniovi.miw.unisell.model.EditCompanyData;
import uniovi.miw.unisell.ws.ICompanyWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.CannotRemoveElementException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;
import uniovi.miw.unisell.ws.impl.utils.CompanyConversor;
import uniovi.miw.unisell.ws.impl.utils.DataValidator;
import uniovi.miw.unisell.ws.impl.utils.TokenValidator;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.ICompanyWS")
public class CompanyWS implements ICompanyWS {
	private CompanyConversor companyCreator = new CompanyConversor();

	@Override
	public EditCompanyData[] listCompaniesByFilter(Security security, CompanySearchFilter filter)
			throws UnauthorizedAccessException, ArgumentException {
		if (filter == null) {
			throw new ArgumentException("A filter is required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		ArrayOfCompany companies = soap.findCompaniesByFilter(filter, security);
		List<EditCompanyData> res = new ArrayList<>();
		for (Company c : companies.getCompany()) {
			res.add(companyCreator.createEditCompanyData(c));
		}
		return res.toArray(new EditCompanyData[0]);
	}

	@Override
	public EditCompanyData createCompany(Security security, CompanyData companyData) 
			throws RepeatedDocumentException, InvalidEntityException, UnauthorizedAccessException {
		if (!DataValidator.validateCompany(companyData)) {
			throw new InvalidEntityException("Company is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateDocument(soap, security, companyData, null);
		Company company = companyCreator.createCompany(companyData);
		Company serverCompany = soap.createCompany(company, security);
		return companyCreator.createEditCompanyData(serverCompany);
	}

	@Override
	public EditCompanyData editCompany(Security security, EditCompanyData company) 
			throws RepeatedDocumentException, InvalidEntityException, UnauthorizedAccessException {
		if (company == null || company.getId() == null || !DataValidator.validateCompany(company.getCompanyData())) {
			throw new InvalidEntityException("Company is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateDocument(soap, security, company.getCompanyData(), company.getId());
		Company edited = companyCreator.createCompany(company.getCompanyData(), company.getId());
		Company editedServer = soap.updateCompany(edited, security);
		return companyCreator.createEditCompanyData(editedServer);
	}

	@Override
	public EditCompanyData removeCompany(Security security, Long id) 
			throws ArgumentException, ElementNotFoundException, CannotRemoveElementException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		Company target = soap.findCompany(id, security);
		if (target == null) {
			throw new ElementNotFoundException("Company with id " + id + " not found");
		}
		if (!canRemoveCompany(target, soap, security)) {
			throw new CannotRemoveElementException("Company with id " + target.getId() + " has sellers assigned and cannot be removed");
		}
		Company deleted = soap.removeCompany(id, security);
		return companyCreator.createEditCompanyData(deleted);
	}

	@Override
	public EditCompanyData findCompany(Security security, Long id) throws ArgumentException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		Company company = soap.findCompany(id, security);
		if (company == null) {
			return null;
		}
		return companyCreator.createEditCompanyData(company);
	}
	
	private void validateDocument(DataAccessSoap soap, Security security, CompanyData company, Long id) throws RepeatedDocumentException {
		CompanySearchFilter filter = new CompanySearchFilter();
		filter.setIdDocument(company.getIdDocument());
		ArrayOfCompany res = soap.findCompaniesByFilter(filter, security);
		if ((!res.getCompany().isEmpty() && id == null) ||
				(!res.getCompany().isEmpty() && res.getCompany().get(0).getId() != id)) {
			throw new RepeatedDocumentException(company.getIdDocument() + " has already been registered");
		}
	}
	
	private boolean canRemoveCompany(Company company, DataAccessSoap soap, Security security) {
		ArrayOfUserSeller sellers = soap.findSellersByCompanyId(company.getId(), security);
		return sellers == null || sellers.getUserSeller() == null || sellers.getUserSeller().isEmpty();
	}

}
