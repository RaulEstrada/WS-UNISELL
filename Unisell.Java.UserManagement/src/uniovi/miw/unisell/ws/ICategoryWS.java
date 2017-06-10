package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebParam.Mode;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.CategoryData;
import uniovi.miw.unisell.model.EditCategoryData;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.CannotRemoveElementException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedNameException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizeAccessException;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ICategoryWS {
	@WebMethod
	public EditCategoryData[] listCategoriesByName(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			String name) throws UnauthorizeAccessException;
	
	@WebMethod
	public EditCategoryData createCategory(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			CategoryData category) throws RepeatedNameException, InvalidEntityException;
	
	@WebMethod
	public EditCategoryData editCategory(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			EditCategoryData category) throws RepeatedNameException, InvalidEntityException;
	
	@WebMethod
	public EditCategoryData removeCategory(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ArgumentException, ElementNotFoundException, CannotRemoveElementException;
	
	@WebMethod
	public EditCategoryData findCategory(@WebParam(header = true, mode = Mode.IN, targetNamespace = "http://schemas.xmlsoap.org/ws/2002/04/secext") Security security,
			Long id) throws ArgumentException;
}
