package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.LocationInfo;
import uniovi.miw.unisell.model.CompanyData;
import uniovi.miw.unisell.model.UserData;

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
}
