package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IProductAvailabilityWS {
	@WebMethod
	public ShoppingCartAvail checkAvailability(ShoppingCartAvail cart) throws ProductNotAvailableException, ArgumentException;
}
