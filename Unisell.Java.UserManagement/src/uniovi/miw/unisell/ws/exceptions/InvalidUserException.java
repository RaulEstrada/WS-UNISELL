package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class InvalidUserException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {
		super(message);
	}
}
