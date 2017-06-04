package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserSeller;
import uniovi.miw.unisell.model.EditUserSellerData;
import uniovi.miw.unisell.model.UserData;
import uniovi.miw.unisell.model.UserSellerData;

public class UserSellerConversor {
	private UserConversor userConversor = new UserConversor();

	public User createUser(UserSellerData data, Long id) {
		UserSeller user = new UserSeller();
		user.setCompanyId(data.getCompanyId());
		return userConversor.assignCommonAttributes(user, data.getUserData(), id);
	}
	
	public User createUser(UserSellerData data) {
		return createUser(data, 0l);
	}
	
	public EditUserSellerData createEditUserData(UserSeller user) {
		UserData data = userConversor.createUserData(user);
		UserSellerData sellerData = new UserSellerData()
				.setCompanyId(user.getCompanyId())
				.setUserData(data);
		return new EditUserSellerData()
				.setId(user.getId())
				.setUserData(sellerData);
	}
}
