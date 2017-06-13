package impl.uniovi.unisell.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class BadRequestResponse {
	private String Message;

	@XmlElement(name = "Message")
	@JsonProperty("Message")
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}
}
