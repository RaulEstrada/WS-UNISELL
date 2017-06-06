package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.CompanySearchFilter;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.CompanyData;
import uniovi.miw.unisell.model.EditCompanyData;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.CannotRemoveElementException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizeAccessException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ICompanyWS {

	@WebMethod
	public EditCompanyData[] listCompaniesByFilter(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			CompanySearchFilter filter) throws UnauthorizeAccessException, ArgumentException;
	
	@WebMethod
	public EditCompanyData createCompany(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			CompanyData company) throws RepeatedDocumentException, InvalidEntityException;
	
	@WebMethod
	public EditCompanyData editCompany(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditCompanyData company) throws RepeatedDocumentException, InvalidEntityException;
	
	@WebMethod
	public EditCompanyData removeCompany(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ArgumentException, ElementNotFoundException, CannotRemoveElementException;
	
	@WebMethod
	public EditCompanyData findCompany(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ArgumentException;
}
