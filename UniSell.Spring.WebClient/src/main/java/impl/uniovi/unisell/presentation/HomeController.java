package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.Product;

import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	
	private String getBuyer() {
		return "/buyer/home";
	}
}
