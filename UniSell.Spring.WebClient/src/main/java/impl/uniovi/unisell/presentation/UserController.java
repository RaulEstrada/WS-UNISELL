package impl.uniovi.unisell.presentation;

import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import impl.uniovi.unisell.model.BadRequestResponse;
import impl.uniovi.unisell.model.PersonIdDocumentType;
import impl.uniovi.unisell.model.UserPost;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute("userData", new UserPost());
		return "account";
	}

	@RequestMapping(value ="/registration", method = RequestMethod.POST)
	public String postRegister(@Valid @ModelAttribute(value = "userData") UserPost userData, Model model) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/buyers");
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		Response response = builder.post(Entity.entity(userData, MediaType.APPLICATION_JSON), Response.class);
		if (response.getStatus() == 400) {
			BadRequestResponse res = response.readEntity(BadRequestResponse.class);
			model.addAttribute("error", "true");
			model.addAttribute("errorMsg", res.getMessage());
			return "account";
		}
		model.addAttribute("okMessage", "true");
		return "redirect:/index"; 
	}

	@ModelAttribute(value = "documentTypes")
	public PersonIdDocumentType[] createDocumentTypes() {
		return PersonIdDocumentType.values();
	}
}
