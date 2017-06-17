package uniovi.miw.unisell.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IProductAvailabilityWS")
public class ProductAvailabilityWS implements IProductAvailabilityWS {

	@Override
	public ShoppingCart checkAvailability(ShoppingCart cart) throws ProductNotAvailableException, ArgumentException {
		if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
			throw new ArgumentException("Shopping cart or items not found");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		List<String> productsNotAvailable = new ArrayList<>();
		for (Item item : cart.getItems()) {
			int unitsAvailable = soap.findProductAvailability(item.getProductId());
			if (item.getUnits() > unitsAvailable) {
				productsNotAvailable.add(item.getProductId() + "");
			}
		}
		if (!productsNotAvailable.isEmpty()) {
			throw new ProductNotAvailableException("The following products do not have enough units available: " 
					+ String.join(", ", productsNotAvailable));
		}
		cart.setProductsAvailable(true);
		return cart;
	}

}
