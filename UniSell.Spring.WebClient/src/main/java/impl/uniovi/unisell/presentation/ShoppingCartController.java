package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Product;
import impl.uniovi.unisell.model.ShoppingCart;
import impl.uniovi.unisell.model.ShoppingCartItem;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartController {

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/additem/{productId}", method = RequestMethod.GET)
	public String addItem(@PathVariable(value="productId") Long id, HttpSession session) {
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		ShoppingCartItem item = cart.getItemsMap().get(id);
		if (item == null) {
			AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://156.35.98.14:50868/api/products/" + id);
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
			Response response = builder.get(Response.class);
			Product<Long> product = response.readEntity(Product.class);
			item = new ShoppingCartItem();
			item.setQuantity(1);
			item.setProduct(product);
		} else {
			item.setQuantity(item.getQuantity() + 1);
		}
		cart.getItemsMap().put(id, item);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/removeitem/{productId}", method = RequestMethod.GET)
	public String removeItem(@PathVariable(value="productId") Long id, HttpSession session) {
		ShoppingCart cart = (ShoppingCart)session.getAttribute("shoppingCart");
		cart.getItemsMap().remove(id);
		return "redirect:/home";
	}
}
