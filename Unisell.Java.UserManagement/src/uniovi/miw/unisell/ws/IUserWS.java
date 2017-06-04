package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.UserSearchFilter;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.ws.exceptions.*;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserWS {
	@WebMethod
	public EditUserData createAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserData admin) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData createSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData editUserAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditUserData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData editUserSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditUserData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData findUserAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id);
	
	@WebMethod
	public EditUserData findUserSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id);
	
	@WebMethod
	public EditUserData removeUserAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id);
	
	@WebMethod
	public EditUserData removeUserSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id);
	
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
}
