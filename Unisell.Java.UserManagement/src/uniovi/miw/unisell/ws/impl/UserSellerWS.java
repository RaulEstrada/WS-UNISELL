package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfUserSeller;
import uniovi.miw.unisell.data.Company;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.data.User;
import uniovi.miw.unisell.data.UserRole;
import uniovi.miw.unisell.data.UserSeller;
import uniovi.miw.unisell.model.EditUserSellerData;
import uniovi.miw.unisell.model.UserSellerData;
import uniovi.miw.unisell.ws.IUserSellerWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedDocumentException;
import uniovi.miw.unisell.ws.exceptions.RepeatedEmailException;
import uniovi.miw.unisell.ws.exceptions.RepeatedUsernameException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;
import uniovi.miw.unisell.ws.impl.utils.DataValidator;
import uniovi.miw.unisell.ws.impl.utils.TokenValidator;
import uniovi.miw.unisell.ws.impl.utils.UserSellerConversor;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.IUserSellerWS")
public class UserSellerWS implements IUserSellerWS {
	private UserSellerConversor conversor = new UserSellerConversor();

	@Override
	public EditUserSellerData createSeller(Security security, UserSellerData user) throws InvalidEntityException,
			RepeatedUsernameException, RepeatedEmailException, RepeatedDocumentException, UnauthorizedAccessException {
		if (user.getCompanyId() == null || !DataValidator.validateUser(user.getUserData())) {
			throw new InvalidEntityException("User is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		DataValidator.validateUserData(soap, user.getUserData(), null);
		Company company = soap.findCompany(user.getCompanyId(), security);
		if (company == null) {
			throw new InvalidEntityException("Seller company with id " + user.getCompanyId() + " not found in the system");
		}
		User usr = conversor.createUser(user);
		User serverUser = soap.createUser(usr);
		return conversor.createEditUserData((UserSeller)serverUser);
	}

	@Override
	public EditUserSellerData editSeller(Security security, EditUserSellerData user) throws InvalidEntityException,
			RepeatedUsernameException, RepeatedEmailException, RepeatedDocumentException, UnauthorizedAccessException {
		if (user == null || user.getId() == null || 
				!DataValidator.validateUserEdit(user.getUserData().getUserData()) || 
				user.getUserData().getCompanyId() == null) {
			throw new InvalidEntityException("User is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User dbUser = soap.findUser(user.getId(), security);
		if (dbUser == null || dbUser.getRole() != UserRole.SELLER) {
			throw new InvalidEntityException("No user seller found with id " + user.getId());
		}
		DataValidator.validateUserData(soap, user.getUserData().getUserData(), user.getId());
		Company company = soap.findCompany(user.getUserData().getCompanyId(), security);
		if (company == null) {
			throw new InvalidEntityException("Seller company with id " + user.getUserData().getCompanyId() + " not found in the system");
		}
		User usr = conversor.createUser(user.getUserData(), user.getId());
		User editedServer = soap.updateUser(usr, security);
		return conversor.createEditUserData((UserSeller)editedServer);
	}

	@Override
	public EditUserSellerData findSeller(Security security, Long id) throws ArgumentException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		User user = soap.findUser(id, security);
		if (user == null || user.getRole() != UserRole.SELLER) {
			return null;
		}
		return conversor.createEditUserData((UserSeller)user);
	}

	@Override
	public EditUserSellerData[] findSellersByCompanyId(Security security, Long id) throws ArgumentException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Company id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		ArrayOfUserSeller sellers = soap.findSellersByCompanyId(id, security);
		List<EditUserSellerData> sellersData = new ArrayList<>();
		for (UserSeller seller : sellers.getUserSeller()) {
			sellersData.add(conversor.createEditUserData(seller));
		}
		return sellersData.toArray(new EditUserSellerData[0]);
	}

}
