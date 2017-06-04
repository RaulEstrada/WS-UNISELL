package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserAdmin;
import uniovi.miw.unisell.data.UserSeller;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.model.UserData;

public class UserConversor {
	
	public User createUserAdmin(UserData data, Long id) {
		UserAdmin user = new UserAdmin();
		return assignCommonAttributes(user, data, id);
	}
	
	public User createUserSeller(UserData data, Long id) {
		UserSeller user = new UserSeller();
		return assignCommonAttributes(user, data, id);
	}
	
	public User assignCommonAttributes(User user, UserData data, Long id) {
		user.setId(id);
		user.setActiveAccount(true);
		user.setName(data.getName());
		user.setSurname(data.getSurname());
		user.setEmail(data.getEmail());
		user.setUsername(data.getUsername());
		user.setPassword(data.getPassword());
		user.setIdDocument(data.getIdDocument());
		user.setIdDocumentType(data.getDocumentType());
		return user;
	}
	
	public User createUserAdmin(UserData data) {
		return createUserAdmin(data, 0l);
	}
	
	public User createUserSeller(UserData data) {
		return createUserSeller(data, 0l);
	}
	
	public EditUserData createEditUserData(User user) {
		UserData data = new UserData()
			.setName(user.getName())
			.setSurname(user.getSurname())
			.setEmail(user.getEmail())
			.setUsername(user.getUsername())
			.setDocumentType(user.getIdDocumentType())
			.setIdDocument(user.getIdDocument())
			.setAccountEnabled(user.isActiveAccount());
		return new EditUserData()
			.setId(user.getId())
			.setUserData(data);
	}
}