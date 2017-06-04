package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfUser;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.ws.IUserWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizeAccessException;
import uniovi.miw.unisell.ws.impl.utils.RequestClientValidator;
import uniovi.miw.unisell.ws.impl.utils.UserConversor;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserSearchFilter;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserWS")
public class UserWS implements IUserWS {
	private UserConversor userConversor = new UserConversor();

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
			res.add(userConversor.createEditUserData(u));
		}
		return res.toArray(new EditUserData[0]);
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
		return userConversor.createEditUserData(user);
	}
}
