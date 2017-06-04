package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class InvalidEntityException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidEntityException(String message) {
		super(message);
	}
}
