package uniovi.miw.unisell.ws.impl;

import javax.jws.WebService;

import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.ws.IUserWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserWS")
public class UserWS implements IUserWS {

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

}
