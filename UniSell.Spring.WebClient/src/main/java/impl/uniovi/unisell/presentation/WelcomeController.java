package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.Authentication;
import impl.uniovi.unisell.model.AuthenticationInfo;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Controller
public class WelcomeController {
	
	public static String AUTH_SESSION = "authCredentials";

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String get() {
		return "index";
	}
	
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String getLoginError(Model model) {
		model.addAttribute("error", "true");
		return "index";
	}

	@RequestMapping(value = {"/", "/index", "/loginError"}, method = RequestMethod.POST)
	public String post(@Valid @ModelAttribute(value = "authentication") Authentication authentication, HttpSession session) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://156.35.98.14:50868/api/authentication");
			ClientResponse response = webResource.
					type(MediaType.APPLICATION_JSON).
					post(ClientResponse.class, authentication); 
			if (!response.hasEntity()) {
				return "redirect:/loginError";
			}
			AuthenticationInfo output = response.getEntity(AuthenticationInfo.class);
			session.setAttribute(AUTH_SESSION, output);
			return "redirect:/home";
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "home";
	}
	
	@ModelAttribute(value = "authentication")
	public Authentication generateAuthentication() {
		return new Authentication();
	}

}
