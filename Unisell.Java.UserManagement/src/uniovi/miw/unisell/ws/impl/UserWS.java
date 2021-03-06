package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfProduct;
import uniovi.miw.unisell.data.ArrayOfUser;
import uniovi.miw.unisell.data.ArrayOfUserRole;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.LegalPersonIdDocumentType;
import uniovi.miw.unisell.data.PersonIdDocumentType;
import uniovi.miw.unisell.data.ProductSearchFilter;
import uniovi.miw.unisell.model.EditUserData;
import uniovi.miw.unisell.ws.IUserWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.CannotRemoveElementException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;
import uniovi.miw.unisell.ws.impl.utils.RequestClientValidator;
import uniovi.miw.unisell.ws.impl.utils.TokenValidator;
import uniovi.miw.unisell.ws.impl.utils.UserConversor;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.data.UserSearchFilter;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserWS")
public class UserWS implements IUserWS {
	private UserConversor userConversor = new UserConversor();

	@Override
	public String login(String username, String password) throws ArgumentException {
		if (username == null || username.trim().isEmpty() || password == null || 
				password.trim().isEmpty()) {
			throw new ArgumentException("Username and passwords required but not provided");
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		ArrayOfUserRole rolesAllowed = new ArrayOfUserRole();
		rolesAllowed.getUserRole().add(UserRole.ADMIN);
		return dataAccessSOAP.login(username, password, rolesAllowed);
	}

	@Override
	public EditUserData disableAccount(Security security, Long id) 
			throws UnauthorizedAccessException, ArgumentException {
		return changeUserAccount(security, id, false);
	}

	@Override
	public EditUserData enableAccount(Security security, Long id) 
			throws UnauthorizedAccessException, ArgumentException {
		return changeUserAccount(security, id, true);
	}

	@Override
	public EditUserData[] listUsersByFilter(Security security, UserSearchFilter filter)
			throws UnauthorizedAccessException, ArgumentException {
		if (filter == null) {
			throw new ArgumentException("A filter is required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		filter.getRoles().getUserRole().remove(UserRole.BUYER);
		filter.getRoles().getUserRole().removeIf((x) -> x == null);
		if (filter.getRoles().getUserRole().isEmpty()) {
			filter.getRoles().getUserRole().add(UserRole.ADMIN);
			filter.getRoles().getUserRole().add(UserRole.SELLER);
		}
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		ArrayOfUser users = soap.findUsersByFilter(filter);
		List<EditUserData> res = new ArrayList<>();
		for (User u : users.getUser()) {
			res.add(userConversor.createEditUserData(u));
		}
		return res.toArray(new EditUserData[0]);
	}
	
	private EditUserData changeUserAccount(Security security, Long userId, boolean enabled)
			throws UnauthorizedAccessException, ArgumentException {
		if (userId == null) {
			throw new ArgumentException("User id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		RequestClientValidator.validateClientIdentity(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		User user = dataAccessSOAP.findUser(userId, security);
		if (user == null) {
			throw new ArgumentException("User id not present in the system");
		}
		user.setPassword(null);
		user.setActiveAccount(enabled);
		user = dataAccessSOAP.updateUser(user, security);
		return userConversor.createEditUserData(user);
	}

	@Override
	public UserRole[] findUserRoles() {
		return new UserRole[]{UserRole.ADMIN, UserRole.SELLER};
	}

	@Override
	public PersonIdDocumentType[] findPersonDocumentTypes() {
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		return dataAccessSOAP.findPersonIdDocumentTypes().getPersonIdDocumentType()
				.toArray(new PersonIdDocumentType[0]);
	}

	@Override
	public LegalPersonIdDocumentType[] findLegalDocumentTypes() {
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap dataAccessSOAP = dataAccessWS.getDataAccessSoap();
		return dataAccessSOAP.findLegalIdDocumentTypes().getLegalPersonIdDocumentType()
				.toArray(new LegalPersonIdDocumentType[0]);
	}
	
	@Override
	public EditUserData removeUser(Security security, Long id) 
			throws ElementNotFoundException, ArgumentException, CannotRemoveElementException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User target = soap.findUser(id, security);
		if (target == null) {
			throw new ElementNotFoundException("User admin with id " + id + " not found");
		}
		if (target.getRole() == UserRole.SELLER) {
			validateSellerCanBeDeleted(target, soap, security);
		}
		soap.removeUser(id, security);
		return userConversor.createEditUserData(target);
	}
	
	private void validateSellerCanBeDeleted(User user, DataAccessSoap soap, Security security) throws CannotRemoveElementException {
		ProductSearchFilter filter = new ProductSearchFilter();
		filter.setSeller(user.getUsername());
		ArrayOfProduct products = soap.findProductsByFilter(filter, security);
		if (products != null && products.getProduct() != null && !products.getProduct().isEmpty()) {
			throw new CannotRemoveElementException("Seller " + user.getUsername() + " cannot be removed since it has products assigned to the account");
		}
	}
}
