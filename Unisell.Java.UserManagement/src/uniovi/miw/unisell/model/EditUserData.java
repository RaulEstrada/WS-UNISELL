package uniovi.miw.unisell.model;

import java.io.Serializable;

public class EditUserData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private UserData userData = new UserData();
	
	public Long getId() {
		return id;
	}
	
	public EditUserData setId(Long id) {
		this.id = id;
		return this;
	}
	
	public UserData getUserData() {
		return userData;
	}
	
	public EditUserData setUserData(UserData userData) {
		this.userData = userData;
		return this;
	}
	
	public String getUsername() {
		return this.userData.getUsername();
	}
	
	public String getPassword() {
		return this.userData.getPassword();
	}
	
}
