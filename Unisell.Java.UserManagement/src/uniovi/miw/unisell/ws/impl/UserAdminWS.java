package uniovi.miw.unisell.ws.impl;

import javax.jws.WebService;

import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.ws.IUserAdminWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;
import uniovi.miw.unisell.ws.impl.utils.DataValidator;
import uniovi.miw.unisell.ws.impl.utils.UserConversor;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserAdminWS")
public class UserAdminWS implements IUserAdminWS {
	private UserConversor conversor = new UserConversor();

	@Override
	public EditUserData createAdmin(Security security, UserData admin) throws InvalidEntityException,
			RepeatedUsernameException, RepeatedEmailException, RepeatedDocumentException {
		if (!DataValidator.validateUser(admin)) {
			throw new InvalidEntityException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		DataValidator.validateUserData(soap, security, admin, null);
		User user = conversor.createUser(admin);
		User serverUser = soap.createUser(user, security);
		return conversor.createEditUserData(serverUser);
	}

	@Override
	public EditUserData editAdmin(Security security, EditUserData user) throws InvalidEntityException,
			RepeatedUsernameException, RepeatedEmailException, RepeatedDocumentException {
		if (user == null || user.getId() == null || !DataValidator.validateUser(user.getUserData())) {
			throw new InvalidEntityException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User dbUser = soap.findUser(user.getId(), security);
		if (dbUser == null || dbUser.getRole() != UserRole.ADMIN) {
			throw new InvalidEntityException("No user admin found with id " + user.getId());
		}
		DataValidator.validateUserData(soap, security, user.getUserData(), user.getId());
		User usr = conversor.createUser(user.getUserData(), user.getId());
		User editedServer = soap.updateUser(usr, security);
		return conversor.createEditUserData(editedServer);
	}

	@Override
	public EditUserData findAdmin(Security security, Long id) throws ArgumentException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User user = soap.findUser(id, security);
		if (user == null || user.getRole() != UserRole.ADMIN) {
			return null;
		}
		return conversor.createEditUserData(user);
	}

	@Override
	public EditUserData removeAdmin(Security security, Long id) throws ElementNotFoundException, ArgumentException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User target = soap.findUser(id, security);
		if (target == null || target.getRole() != UserRole.ADMIN) {
			throw new ElementNotFoundException("User admin with id " + id + " not found");
		}
		soap.removeUser(id, security);
		return conversor.createEditUserData(target);
	}
	

}
