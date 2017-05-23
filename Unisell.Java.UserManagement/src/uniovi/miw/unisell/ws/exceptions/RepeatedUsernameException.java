package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RepeatedUsernameException extends Exception {
	private static final long serialVersionUID = 1L;

	public RepeatedUsernameException(String message) {
		super(message);
	}
}
