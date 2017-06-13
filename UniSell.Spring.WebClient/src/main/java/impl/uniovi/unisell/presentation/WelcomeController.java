package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.Authentication;
import impl.uniovi.unisell.model.AuthenticationInfo;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	
	public static String AUTH_SESSION = "authCredentials";

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String get(@RequestParam(value = "okMessage", required = false) String okMessage, Model model) {
		if (okMessage != null && !okMessage.trim().isEmpty()) {
			model.addAttribute("okMessage", okMessage);
		}
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
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://156.35.98.14:50868/api/authentication");
			Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
			Response response = builder.post(Entity.entity(authentication, MediaType.APPLICATION_JSON), Response.class);
			if (!response.hasEntity()) {
				return "redirect:/loginError";
			}
			AuthenticationInfo output = response.readEntity(AuthenticationInfo.class);
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
