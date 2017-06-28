package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.EditUserSellerData;
import uniovi.miw.unisell.model.UserSellerData;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserSellerWS {

	@WebMethod
	public EditUserSellerData createSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			UserSellerData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException, UnauthorizedAccessException;
	
	@WebMethod
	public EditUserSellerData editSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditUserSellerData user) throws InvalidEntityException, RepeatedUsernameException, 
			RepeatedEmailException, RepeatedDocumentException, UnauthorizedAccessException;
	
	@WebMethod
	public EditUserSellerData findSeller(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id)  throws ArgumentException, UnauthorizedAccessException;

	@WebMethod
	public EditUserSellerData[] findSellersByCompanyId(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security, 
			Long id) throws ArgumentException, UnauthorizedAccessException;
}
