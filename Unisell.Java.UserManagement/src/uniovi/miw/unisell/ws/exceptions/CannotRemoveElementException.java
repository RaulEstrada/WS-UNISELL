package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class CannotRemoveElementException extends Exception {
	private static final long serialVersionUID = 1L;

	public CannotRemoveElementException(String message) {
		super(message);
	}
}
