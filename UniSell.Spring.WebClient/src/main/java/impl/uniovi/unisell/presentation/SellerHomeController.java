package impl.uniovi.unisell.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/seller")
public class SellerHomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpSession session) {
		return "/seller/home";
	}
}
