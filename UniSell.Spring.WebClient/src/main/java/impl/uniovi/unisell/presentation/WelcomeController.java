package impl.uniovi.unisell.presentation;

import impl.uniovi.unisell.model.Authentication;
import impl.uniovi.unisell.model.AuthenticationInfo;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping(value = {"/", "/index"})
public class WelcomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String post(@Valid @ModelAttribute(value = "authentication") Authentication authentication) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://156.35.98.14:50868/api/authentication");
			ClientResponse response = webResource.
					type(MediaType.APPLICATION_JSON).
					post(ClientResponse.class, authentication); 
			AuthenticationInfo output = response.getEntity(AuthenticationInfo.class);
			System.out.println(output);
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
