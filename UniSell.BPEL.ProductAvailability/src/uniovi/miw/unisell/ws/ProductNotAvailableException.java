package uniovi.miw.unisell.ws;

import javax.xml.ws.WebFault;

@WebFault
public class ProductNotAvailableException extends Exception {
		private static final long serialVersionUID = 1L;

		public ProductNotAvailableException(String message) {
			super(message);
		}
}
