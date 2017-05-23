package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.User;

public class UserDataValidator {
	public static boolean validateUser(User user) {
		return user != null
				&& user.getName() != null && !user.getName().trim().isEmpty()
				&& user.getSurname() != null && !user.getSurname().trim().isEmpty()
				&& user.getEmail() != null && !user.getEmail().trim().isEmpty()
				&& user.getIdDocument() != null && !user.getIdDocument().trim().isEmpty()
				&& user.getIdDocumentType() != null
				&& user.getUsername() != null && !user.getUsername().trim().isEmpty()
				&& user.getPassword() != null && !user.getPassword().trim().isEmpty();
	}
}
