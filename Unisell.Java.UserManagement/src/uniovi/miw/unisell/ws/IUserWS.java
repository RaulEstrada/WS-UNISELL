package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.LegalPersonIdDocumentType;
import uniovi.miw.unisell.data.PersonIdDocumentType;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.data.UserSearchFilter;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.ws.exceptions.*;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserWS {
	
	@WebMethod
	public String login(String username, String password) throws ArgumentException;
	
	@WebMethod
	public EditUserData disableAccount(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws UnauthorizeAccessException, ArgumentException;
	
	@WebMethod
	public EditUserData enableAccount(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws UnauthorizeAccessException, ArgumentException;
	
	@WebMethod
	public EditUserData[] listUsersByFilter(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserSearchFilter filter) throws UnauthorizeAccessException, ArgumentException;
	
	@WebMethod
	public EditUserData removeUser(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ElementNotFoundException, ArgumentException;
	
	@WebMethod
	public UserRole[] findUserRoles();
	
	@WebMethod
	public PersonIdDocumentType[] findPersonDocumentTypes();
	
	@WebMethod
	public LegalPersonIdDocumentType[] findLegalDocumentTypes();
}
