package impl.uniovi.unisell.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	@XmlAttribute
	@JsonProperty
	private String href;
	@XmlElement
	@JsonProperty
	private Long id;
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
	
	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
}