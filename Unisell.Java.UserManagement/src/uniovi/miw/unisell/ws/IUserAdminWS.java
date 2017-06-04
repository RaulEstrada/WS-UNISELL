package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserAdminWS {
	@WebMethod
	public EditUserData createAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserData admin) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData editAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditUserData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException;
	
	@WebMethod
	public EditUserData findAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id)  throws ArgumentException;
	
	@WebMethod
	public EditUserData removeAdmin(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ElementNotFoundException, ArgumentException;
}
