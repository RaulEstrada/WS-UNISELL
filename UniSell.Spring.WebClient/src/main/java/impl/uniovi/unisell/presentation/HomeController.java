package impl.uniovi.unisell.presentation;

import java.util.HashMap;
import java.util.Map;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Category;
import impl.uniovi.unisell.model.Product;
import impl.uniovi.unisell.model.ProductFilter;
import impl.uniovi.unisell.model.ShoppingCart;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute(value = "productFilter") ProductFilter productFilter,
			HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		if (auth.getRole().equals("SELLER")) {
			return getSeller(auth, model);
		} else {
			return getBuyer(productFilter, auth, model, session);
		}
	}
	
	@SuppressWarnings("unchecked")
	private String getSeller(AuthenticationInfo auth, Model model) {
		try {
			String username = auth.getUsername();
			String token = auth.getToken();
			
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://156.35.98.14:50868/api/sellers/" + username + "/products");
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", token);
			Response response = builder.get(Response.class);
			Product<String>[] products = response.readEntity(Product[].class);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "/seller/home";
	}
	
	private String getBuyer(ProductFilter productFilter, AuthenticationInfo auth, Model model, HttpSession session) {
		Category[] categories = getCategories(auth);
		Map<Integer, String> catMap = createCategoryMap(categories);
		Product<String>[] products = getProducts(productFilter, auth.getToken());
		for (Product<String> p : products) {
			p.setCategory(catMap.get(p.getCategory()));
		}
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);
		model.addAttribute("productFilter", productFilter);
		if (session.getAttribute("shoppingCart") == null) {
			session.setAttribute("shoppingCart", new ShoppingCart());
		}
		return "/buyer/home";
	}
	
	@SuppressWarnings("unchecked")
	private Product<String>[] getProducts(ProductFilter productFilter, String authToken) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/products");
		if (productFilter.getName() != null && !productFilter.getName().trim().isEmpty()) {
			target = target.queryParam("Name", productFilter.getName());
		}
		if (productFilter.getDescription() != null && !productFilter.getDescription().trim().isEmpty()) {
			target = target.queryParam("Description", productFilter.getDescription());
		}
		if (productFilter.getPriceFrom() != null) {
			target = target.queryParam("PriceFrom", productFilter.getPriceFrom());
		}
		if (productFilter.getPriceTo() != null) {
			target = target.queryParam("PriceTo", productFilter.getPriceTo());
		}
		if (productFilter.getCategory() != null && !productFilter.getCategory().trim().isEmpty()) {
			target = target.queryParam("Category", productFilter.getCategory());
		}
		Invocation.Builder builder = target.request().header("token", authToken);
		Response resp = builder.get(Response.class);
		Product<String>[] products = resp.readEntity(Product[].class);
		return products;
	}
	
	private Map<Integer, String> createCategoryMap(Category[] categories) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Category category : categories) {
			map.put(category.getId().intValue(), category.getName());
		}
		return map;
	}
	
	private Category[] getCategories(AuthenticationInfo auth) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/categories");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response resp = builder.get(Response.class);
		Category[] categories = resp.readEntity(Category[].class);
		return categories;
	}
}
