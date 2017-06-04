package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.ArrayOfUser;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.LocationInfo;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserSearchFilter;
import uniovi.miw.unisell.model.CompanyData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;

public class DataValidator {
	public static boolean validateUser(UserData user) {
		return user != null
				&& user.getName() != null && !user.getName().trim().isEmpty()
				&& user.getSurname() != null && !user.getSurname().trim().isEmpty()
				&& user.getEmail() != null && !user.getEmail().trim().isEmpty()
				&& user.getIdDocument() != null && !user.getIdDocument().trim().isEmpty()
				&& user.getDocumentType() != null
				&& user.getUsername() != null && !user.getUsername().trim().isEmpty()
				&& user.getPassword() != null && !user.getPassword().trim().isEmpty();
	}
	
	public static boolean validateCompany(CompanyData company) {
		LocationInfo location = null;
		if (company != null) {
			location = company.getLocationInfo();
		}
		return company != null
				&& company.getIdDocument() != null && !company.getIdDocument().isEmpty()
				&& company.getIdDocumentType() != null
				&& company.getName() != null && !company.getName().isEmpty()
				&& company.getDescription() != null && !company.getDescription().isEmpty()
				&& location != null
				&& location.getCity() != null && !location.getCity().isEmpty()
				&& location.getRegion() != null && !location.getRegion().isEmpty()
				&& location.getCountry() != null && !location.getCountry().isEmpty()
				&& location.getZipCode() != null && !location.getZipCode().isEmpty();
	}
	
	public static void validateUserData(DataAccessSoap soap, Security security, UserData user, Long id) 
			throws RepeatedEmailException, RepeatedUsernameException, RepeatedDocumentException {
		UserSearchFilter filter = new UserSearchFilter();
		filter.setEmail(user.getEmail());
		ArrayOfUser res = soap.findUsersByFilter(filter, security);
		if ((!res.getUser().isEmpty() && id == null) || 
				(!res.getUser().isEmpty() && res.getUser().get(0).getId() != id)) {
			throw new RepeatedEmailException("Email " + user.getEmail() + " has already been registered");
		}
		filter = new UserSearchFilter();
		filter.setUsername(user.getUsername());
		res = soap.findUsersByFilter(filter, security);
		if ((!res.getUser().isEmpty() && id == null) || 
				(!res.getUser().isEmpty() && res.getUser().get(0).getId() != id)) {
			throw new RepeatedUsernameException("Another user has registered the username " + user.getUsername());
		}
		filter = new UserSearchFilter();
		filter.setIdDocument(user.getIdDocument());
		res = soap.findUsersByFilter(filter, security);
		if ((!res.getUser().isEmpty() && id == null) || 
				(!res.getUser().isEmpty() && res.getUser().get(0).getId() != id)) {
			throw new RepeatedDocumentException(user.getIdDocument() + " has already been registered");
		}
	}
}
