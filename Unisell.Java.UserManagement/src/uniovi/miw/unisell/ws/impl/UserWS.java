package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfUser;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.ws.IUserWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.InvalidUserException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizeAccessException;
import uniovi.miw.unisell.ws.impl.utils.RequestClientValidator;
import uniovi.miw.unisell.ws.impl.utils.UserConversor;
import uniovi.miw.unisell.ws.impl.utils.UserDataValidator;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserAdmin;
import uniovi.miw.unisell.data.UserSearchFilter;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserWS")
public class UserWS implements IUserWS {
	private UserConversor userCreator = new UserConversor();

	@Override
	public String login(String username, String password) throws ArgumentException {
		if (username == null || username.trim().isEmpty() || password == null || 
				password.trim().isEmpty()) {
			throw new ArgumentException("Username and passwords required but not provided");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		return dataAccessSOAP.login(username, password);
	}

	@Override
	public EditUserData disableAccount(Security security, Long id) 
			throws UnauthorizeAccessException, ArgumentException {
		return changeUserAccount(security, id, false);
	}

	@Override
	public EditUserData enableAccount(Security security, Long id) 
			throws UnauthorizeAccessException, ArgumentException {
		return changeUserAccount(security, id, true);
	}

	private EditUserData changeUserAccount(Security security, Long userId, boolean enabled)
			throws UnauthorizeAccessException, ArgumentException {
		if (userId == null) {
			throw new ArgumentException("User id required but not provided");
		}
		RequestClientValidator.validateClientIdentity(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		User user = dataAccessSOAP.findUser(userId, security);
		if (user == null) {
			throw new ArgumentException("User id not present in the system");
		}
		user.setPassword(null);
		user.setActiveAccount(enabled);
		user = dataAccessSOAP.updateUser(user, security);
		return userCreator.createEditUserData(user);
	}
	
	@Override
	public EditUserData createAdmin(uniovi.miw.unisell.data.Security security,
			UserData admin) throws InvalidUserException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException {
		if (!UserDataValidator.validateUser(admin)) {
			throw new InvalidUserException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateUsernameIdEmail(soap, security, admin, null);
		UserAdmin user = userCreator.createUserAdmin(admin);
		User serverUser = soap.createUser(user, security);
		return userCreator.createEditUserData(serverUser);
	}

	@Override
	public EditUserData editUser(uniovi.miw.unisell.data.Security security, 
			EditUserData user) throws InvalidUserException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException {
		if (user == null || user.getId() == null || !UserDataValidator.validateUser(user.getUserData())) {
			throw new InvalidUserException("User is missing some required field");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateUsernameIdEmail(soap, security, user.getUserData(), user.getId());
		UserAdmin edited = userCreator.createUserAdmin(user.getUserData(), user.getId());
		User editedServer = soap.updateUser(edited, security);
		return userCreator.createEditUserData(editedServer);
	}
	
	@Override
	public EditUserData[] listUsersByFilter(Security security, UserSearchFilter filter)
			throws UnauthorizeAccessException, ArgumentException {
		if (filter == null) {
			throw new ArgumentException("A filter is required but not provided");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		ArrayOfUser users = soap.findUsersByFilter(filter, security);
		List<EditUserData> res = new ArrayList<>();
		for (User u : users.getUser()) {
			res.add(userCreator.createEditUserData(u));
		}
		return res.toArray(new EditUserData[0]);
	}
	
	private void validateUsernameIdEmail(DataAccessSoap soap, Security security, UserData user, Long id) 
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
		filter.setIdDocumentType(user.getDocumentType());
		res = soap.findUsersByFilter(filter, security);
		if ((!res.getUser().isEmpty() && id == null) || 
				(!res.getUser().isEmpty() && res.getUser().get(0).getId() != id)) {
			throw new RepeatedDocumentException(user.getDocumentType() + " " + user.getIdDocument() + " has already been registered");
		}
	}
}
