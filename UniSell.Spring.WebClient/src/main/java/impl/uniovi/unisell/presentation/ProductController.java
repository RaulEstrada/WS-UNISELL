package impl.uniovi.unisell.presentation;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Category;
import impl.uniovi.unisell.model.Product;
import impl.uniovi.unisell.model.ProductPost;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class ProductController {

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getNewProduct(Model model) {
		model.addAttribute("product", new Product<Long>());
		return "/product";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public String getEditProduct(@PathVariable(value="productId") String id, @RequestParam(value = "okMessage", required = false) String okMessage,
			HttpSession session, Model model) {
		try {
			AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
			String token = auth.getToken();
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://156.35.98.14:50868/api/products/" + id);
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", token);
			Response response = builder.get(Response.class);
			Product<Long> product = response.readEntity(Product.class);
			model.addAttribute("product", product);
			if (okMessage != null && !okMessage.trim().isEmpty()) {
				model.addAttribute("okMessage", okMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "/product";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String post(@RequestParam("Name") String Name, @RequestParam("Description") String Description,
			@RequestParam("Price") double Price, @RequestParam("Units") int Units, @RequestParam("Category") long Category,
			@RequestParam("Image") CommonsMultipartFile file, HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		ProductPost product = prepareProduct(Name, Description, Price, Units, Category, file, auth);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/products");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response response = builder.post(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);
		Product<Long> resp = response.readEntity(Product.class);
		if (resp != null) {
			model.addAttribute("okMessage", "true");
			return "redirect:/products/" + resp.getId();
		} else {
			model.addAttribute("error", "true");
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
	public String postEditProduct(@PathVariable(value="productId") String id, 
			@RequestParam("Name") String Name, @RequestParam("Description") String Description,
			@RequestParam("Price") double Price, @RequestParam("Units") int Units, @RequestParam("Category") long Category,
			@RequestParam("Image") CommonsMultipartFile file, HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		ProductPost product = prepareProduct(Name, Description, Price, Units, Category, file, auth);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/products/" + id);
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response response = builder.put(Entity.entity(product, MediaType.APPLICATION_JSON), Response.class);
		Product<Long> resp = response.readEntity(Product.class);
		if (resp != null) {
			model.addAttribute("okMessage", "true");
			model.addAttribute("product", resp);
			return "product";
		} else {
			model.addAttribute("error", "true");
			model.addAttribute("product", new Product<Long>());
			return "product";
		}
	}
	
	private ProductPost prepareProduct(String Name, String Description, double Price, int Units, long Category,
			CommonsMultipartFile file, AuthenticationInfo auth) {
		byte data[]=file.getBytes();  
		ProductPost product = new ProductPost();
		product.setName(Name);
		product.setDescription(Description);
		product.setPrice(Price);
		product.setUnits(Units);
		product.setCategoryId(Category);
		product.setImage(data);
		product.setSellerId(auth.getId());
		return product;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/borrarproducto/{productId}", method = RequestMethod.GET)
	public String borrarProducto(@PathVariable(value="productId") String id, HttpSession session) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/products/" + id);
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response resp = builder.delete(Response.class);
		Product<Long> response = resp.readEntity(Product.class);
		if (response != null) {
			return "redirect:/home";
		} else {
			return null;
		}
	}

	@ModelAttribute(value = "categories")
	public Category[] generateAuthentication(HttpSession session) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/categories");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response resp = builder.get(Response.class);
		Category[] categories = resp.readEntity(Category[].class);
		return categories;
	}
}
