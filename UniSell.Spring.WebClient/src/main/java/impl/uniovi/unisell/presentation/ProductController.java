package impl.uniovi.unisell.presentation;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Category;
import impl.uniovi.unisell.model.Product;
import impl.uniovi.unisell.model.ProductPost;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

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
			Product<Long> product = prepareWebResource("http://156.35.98.14:50868/api/products/" + id)
					.type(MediaType.APPLICATION_JSON)
					.header("token", token)
					.get(Product.class);
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
		Product<Long> response = prepareWebResource("http://156.35.98.14:50868/api/products")
				.header("token", auth.getToken())
				.type(MediaType.APPLICATION_JSON)
				.post(Product.class, product);
		if (response != null) {
			model.addAttribute("okMessage", "true");
			return "redirect:/products/" + response.getId();
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
		Product<Long> response = prepareWebResource("http://156.35.98.14:50868/api/products/" + id)
				.header("token", auth.getToken())
				.type(MediaType.APPLICATION_JSON)
				.put(Product.class, product);
		if (response != null) {
			model.addAttribute("okMessage", "true");
			model.addAttribute("product", response);
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
	
	private WebResource prepareWebResource(String restURI) {
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);
		return client.resource(restURI);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/borrarproducto/{productId}", method = RequestMethod.GET)
	public String borrarProducto(@PathVariable(value="productId") String id, HttpSession session) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Product<Long> response = prepareWebResource("http://156.35.98.14:50868/api/products/" + id)
				.header("token", auth.getToken())
				.type(MediaType.APPLICATION_JSON)
				.delete(Product.class);
		if (response != null) {
			return "redirect:/home";
		} else {
			return null;
		}
	}

	@ModelAttribute(value = "categories")
	public Category[] generateAuthentication(HttpSession session) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		String token = auth.getToken();
		ClientConfig cfg = new DefaultClientConfig();
		cfg.getClasses().add(JacksonJsonProvider.class);
		Client client = Client.create(cfg);
		WebResource webResource = client.resource("http://156.35.98.14:50868/api/categories");
		Category[] categories = webResource
				.type(MediaType.APPLICATION_JSON)
				.header("token", token)
				.get(Category[].class);
		return categories;
	}
}
