package uniovi.miw.unisell.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import uniovi.miw.unisell.ws.exceptions.*;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserWS {
	@WebMethod
	public String login(String username, String password) throws ArgumentException;
}
