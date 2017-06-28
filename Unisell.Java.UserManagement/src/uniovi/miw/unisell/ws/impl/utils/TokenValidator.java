package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.IdentityData;
import uniovi.miw.unisell.data.IdentityWS;
import uniovi.miw.unisell.data.IdentityWSSoap;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;

public class TokenValidator {
	public static void validateAuthToken(Security Security) throws UnauthorizedAccessException {
		IdentityWS ws = new IdentityWS();
		IdentityWSSoap soap = ws.getIdentityWSSoap12();
		IdentityData identity = soap.getIdentity(Security);
		if (identity.getRole() != UserRole.ADMIN) {
			throw new UnauthorizedAccessException("Only admins are authorized to use this SOAP endpoint");
		}
	}
}
