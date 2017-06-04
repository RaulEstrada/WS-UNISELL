package uniovi.miw.unisell.model;

import java.io.Serializable;

import uniovi.miw.unisell.data.PersonIdDocumentType;

public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name, surname, email, idDocument, username, password;
	private boolean accountEnabled;
	private PersonIdDocumentType documentType;
	
	public String getName() {
		return name;
	}
	
	public UserData setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public UserData setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public UserData setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getIdDocument() {
		return idDocument;
	}
	
	public UserData setIdDocument(String idDocument) {
		this.idDocument = idDocument;
		return this;
	}
	
	public String getUsername() {
		return username;
	}
	
	public UserData setUsername(String username) {
		this.username = username;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public UserData setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public PersonIdDocumentType getDocumentType() {
		return documentType;
	}
	
	public UserData setDocumentType(PersonIdDocumentType documentType) {
		this.documentType = documentType;
		return this;
	}

	public boolean isAccountEnabled() {
		return accountEnabled;
	}

	public UserData setAccountEnabled(boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
		return this;
	}

}