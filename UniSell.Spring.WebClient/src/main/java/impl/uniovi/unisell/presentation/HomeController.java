package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Product;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		if (auth.getRole().equals("SELLER")) {
			return getSeller(auth, model);
		} else {
			return getBuyer();
		}
	}
	
	@SuppressWarnings("unchecked")
	private String getSeller(AuthenticationInfo auth, Model model) {
		try {
			String username = auth.getUsername();
			String token = auth.getToken();
			ClientConfig cfg = new DefaultClientConfig();
			cfg.getClasses().add(JacksonJsonProvider.class);
			Client client = Client.create(cfg);
			WebResource webResource = client.resource("http://156.35.98.14:50868/api/sellers/" + username + "/products");
			Product<String>[] products = webResource
				.type(MediaType.APPLICATION_JSON)
				.header("token", token)
				.get(Product[].class);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "/seller/home";
	}
	
	private String getBuyer() {
		return "/buyer/home";
	}
}
