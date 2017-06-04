package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RepeatedDocumentException extends Exception {
	private static final long serialVersionUID = 1L;

	public RepeatedDocumentException(String message) {
		super(message);
	}
}
