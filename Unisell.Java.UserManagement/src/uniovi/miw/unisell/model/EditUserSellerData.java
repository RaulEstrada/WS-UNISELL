package uniovi.miw.unisell.model;

import java.io.Serializable;

public class EditUserSellerData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private UserSellerData userData = new UserSellerData();
	
	public Long getId() {
		return id;
	}
	
	public EditUserSellerData setId(Long id) {
		this.id = id;
		return this;
	}
	
	public UserSellerData getUserData() {
		return userData;
	}
	
	public EditUserSellerData setUserData(UserSellerData userData) {
		this.userData = userData;
		return this;
	}
	
	
}
