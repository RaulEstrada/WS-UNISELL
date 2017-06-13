package impl.uniovi.unisell.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserPost {
	@XmlElement
	@JsonProperty
	private String name;
	@XmlElement
	@JsonProperty
	private String surname;
	@XmlElement
	@JsonProperty
	private String email;
	@XmlElement
	@JsonProperty
	private String document;
	@XmlElement
	@JsonProperty
	private PersonIdDocumentType documentType;
	@XmlElement
	@JsonProperty
	private String username;
	@XmlElement
	@JsonProperty
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public PersonIdDocumentType getDocumentType() {
		return documentType;
	}
	
	public void setDocumentType(PersonIdDocumentType documentType) {
		this.documentType = documentType;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}