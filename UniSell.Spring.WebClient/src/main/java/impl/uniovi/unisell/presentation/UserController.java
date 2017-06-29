package impl.uniovi.unisell.presentation;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import impl.uniovi.unisell.model.AuthenticationInfo;
import impl.uniovi.unisell.model.BadRequestResponse;
import impl.uniovi.unisell.model.PersonIdDocumentType;
import impl.uniovi.unisell.model.User;
import impl.uniovi.unisell.model.UserPost;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegister(Model model) {
		model.addAttribute("userData", new UserPost());
		return "account";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String getProfile(@RequestParam(value = "okMessage", required = false) String okMessage,
			HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/Buyers/" + auth.getId());
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response response = builder.get(Response.class);
		if (response.getStatus() == 200) {
			User user = response.readEntity(User.class);
			model.addAttribute("userData", createUserPost(user));
			model.addAttribute("userProfile", "true");
			model.addAttribute("okMessage", okMessage);
		}
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
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String postProfile(@Valid @ModelAttribute(value = "userData") UserPost userData, Model model, HttpSession session) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/buyers/" + auth.getId());
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response response = builder.put(Entity.entity(userData, MediaType.APPLICATION_JSON), Response.class);
		if (response.getStatus() == 400) {
			BadRequestResponse res = response.readEntity(BadRequestResponse.class);
			model.addAttribute("error", "true");
			model.addAttribute("errorMsg", res.getMessage());
			model.addAttribute("userProfile", "true");
			return "account";
		}
		model.addAttribute("okMessage", "true");
		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/removeUser", method = RequestMethod.GET)
	public String removeUser(@Valid @ModelAttribute(value = "userData") UserPost userData, HttpSession session, Model model) {
		AuthenticationInfo auth = (AuthenticationInfo)session.getAttribute(WelcomeController.AUTH_SESSION);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://156.35.98.14:50868/api/buyers/" + auth.getId());
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON).header("token", auth.getToken());
		Response response = builder.delete(Response.class);
		if (response.getStatus() != 200) {
			BadRequestResponse res = response.readEntity(BadRequestResponse.class);
			model.addAttribute("error", "true");
			model.addAttribute("errorMsg", res.getMessage());
			model.addAttribute("userProfile", "true");
			model.addAttribute("userData", userData);
			return "account";
		}
		session.invalidate();
		return "redirect:/index";
	}

	@ModelAttribute(value = "documentTypes")
	public PersonIdDocumentType[] createDocumentTypes() {
		return PersonIdDocumentType.values();
	}
	
	private UserPost createUserPost(User u) {
		UserPost user = new UserPost();
		user.setDocument(u.getDocument());
		user.setDocumentType(u.getDocumentType());
		user.setEmail(u.getEmail());
		user.setName(u.getName());
		user.setSurname(u.getSurname());
		user.setUsername(u.getUsername());
		return user;
	}
}
