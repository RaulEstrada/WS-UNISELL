package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class ElementNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(String message) {
		super(message);
	}
}
