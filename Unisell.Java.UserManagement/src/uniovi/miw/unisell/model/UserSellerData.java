package uniovi.miw.unisell.model;

import java.io.Serializable;

public class UserSellerData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long companyId;
	private UserData userData;

	public Long getCompanyId() {
		return companyId;
	}

	public UserSellerData setCompanyId(Long companyId) {
		this.companyId = companyId;
		return this;
	}

	public UserData getUserData() {
		return userData;
	}

	public UserSellerData setUserData(UserData userData) {
		this.userData = userData;
		return this;
	}
	
	
}
