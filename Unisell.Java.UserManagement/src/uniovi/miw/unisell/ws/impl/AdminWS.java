package uniovi.miw.unisell.ws.impl;

import javax.jws.WebService;

import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserAdmin;
import uniovi.miw.unisell.ws.IAdminWS;
import uniovi.miw.unisell.ws.exceptions.InvalidUserException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;
import uniovi.miw.unisell.ws.impl.utils.UserDataValidator;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IAdminWS")
public class AdminWS implements IAdminWS {

	@Override
	public UserAdmin createAdmin(uniovi.miw.unisell.data.Security security,
			UserAdmin admin) throws InvalidUserException, RepeatedUsernameException {
		if (!UserDataValidator.validateUser(admin)) {
			throw new InvalidUserException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		if (soap.findUserByUsernamePassword(admin.getUsername(), admin.getPassword()) != null) {
			throw new RepeatedUsernameException("Another user has registered the username " + admin.getUsername());
		}
		admin.setActiveAccount(true);
		uniovi.miw.unisell.data.Security soapSecurity = new uniovi.miw.unisell.data.Security();
		soapSecurity.setBinarySecurityToken(security.getBinarySecurityToken());
		return (UserAdmin)soap.createUser(admin, soapSecurity);
	}

	@Override
	public UserAdmin editAdmin(uniovi.miw.unisell.data.Security security, 
			UserAdmin admin) throws InvalidUserException, RepeatedUsernameException {
		if (!UserDataValidator.validateUser(admin)) {
			throw new InvalidUserException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User user = soap.findUserByUsernamePassword(admin.getUsername(), admin.getPassword());
		if (user != null && user.getId() != admin.getId()) {
			throw new RepeatedUsernameException("Another user has registered the username " + admin.getUsername());
		}
		uniovi.miw.unisell.data.Security soapSecurity = new uniovi.miw.unisell.data.Security();
		soapSecurity.setBinarySecurityToken(security.getBinarySecurityToken());
		return (UserAdmin)soap.updateUser(admin, soapSecurity);
	}

}
