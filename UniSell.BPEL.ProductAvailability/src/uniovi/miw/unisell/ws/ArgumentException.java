package uniovi.miw.unisell.ws;

import javax.xml.ws.WebFault;

@WebFault
public class ArgumentException extends Exception {
	private static final long serialVersionUID = 1L;

	public ArgumentException(String message) {
		super(message);
	}
}
