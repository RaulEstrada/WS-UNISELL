package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RepeatedNameException extends Exception {
	private static final long serialVersionUID = 1L;

	public RepeatedNameException(String message) {
		super(message);
	}
}
