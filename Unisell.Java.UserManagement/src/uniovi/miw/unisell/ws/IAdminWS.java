package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserAdmin;
import uniovi.miw.unisell.ws.exceptions.InvalidUserException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IAdminWS {
	
	@WebMethod
	public UserAdmin createAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserAdmin admin) throws InvalidUserException, RepeatedUsernameException;
	@WebMethod
	public UserAdmin editAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserAdmin admin) throws InvalidUserException, RepeatedUsernameException;
	
}
