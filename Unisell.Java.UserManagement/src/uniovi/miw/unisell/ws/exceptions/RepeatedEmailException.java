package uniovi.miw.unisell.ws.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class RepeatedEmailException  extends Exception {
	private static final long serialVersionUID = 1L;

	public RepeatedEmailException(String message) {
		super(message);
	}
}
