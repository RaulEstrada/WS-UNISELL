package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.ProductNotAvailableException;
import uniovi.miw.unisell.ws.model.ShoppingCart;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IProductAvailabilityWS {
	@WebMethod
	public boolean checkAvailability(ShoppingCart cart) throws ProductNotAvailableException, ArgumentException;
}
