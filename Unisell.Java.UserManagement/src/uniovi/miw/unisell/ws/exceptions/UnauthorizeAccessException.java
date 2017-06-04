package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class UnauthorizeAccessException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnauthorizeAccessException(String message) {
		super(message);
	}
}
