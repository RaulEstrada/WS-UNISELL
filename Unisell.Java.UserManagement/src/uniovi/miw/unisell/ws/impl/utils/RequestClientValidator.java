package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.IdentityData;
import uniovi.miw.unisell.data.IdentityWS;
import uniovi.miw.unisell.data.IdentityWSSoap;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;

public class RequestClientValidator {
	public static void validateClientIdentity(Security security) throws UnauthorizedAccessException {
		IdentityWS identityWS = new IdentityWS();
		IdentityWSSoap identitySOAP = identityWS.getIdentityWSSoap12();
		IdentityData loginData = identitySOAP.getIdentity(security);
		if (loginData.getRole() != UserRole.ADMIN) {
			throw new UnauthorizedAccessException("You are not authorized to call this web service");
		}
	}
}
