package uniovi.miw.unisell.ws.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import uniovi.miw.unisell.data.ArrayOfCategory;
import uniovi.miw.unisell.data.ArrayOfProduct;
import uniovi.miw.unisell.data.Category;
import uniovi.miw.unisell.data.DataAccess;
import uniovi.miw.unisell.data.DataAccessSoap;
import uniovi.miw.unisell.data.ProductSearchFilter;
import uniovi.miw.unisell.data.Security;
import uniovi.miw.unisell.model.CategoryData;
import uniovi.miw.unisell.model.EditCategoryData;
import uniovi.miw.unisell.ws.ICategoryWS;
import uniovi.miw.unisell.ws.exceptions.ArgumentException;
import uniovi.miw.unisell.ws.exceptions.CannotRemoveElementException;
import uniovi.miw.unisell.ws.exceptions.ElementNotFoundException;
import uniovi.miw.unisell.ws.exceptions.InvalidEntityException;
import uniovi.miw.unisell.ws.exceptions.RepeatedNameException;
import uniovi.miw.unisell.ws.exceptions.UnauthorizedAccessException;
import uniovi.miw.unisell.ws.impl.utils.CategoryConversor;
import uniovi.miw.unisell.ws.impl.utils.TokenValidator;

@WebService(endpointInterface = "uniovi.miw.unisell.ws.ICategoryWS")
public class CategoryWS implements ICategoryWS {
	private CategoryConversor conversor = new CategoryConversor();

	@Override
	public EditCategoryData[] listCategoriesByName(Security security, String name) throws UnauthorizedAccessException {
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		ArrayOfCategory categories = soap.findCategoriesByName(name);
		List<EditCategoryData> finalCategories = new ArrayList<>();
		for (Category category : categories.getCategory()) {
			finalCategories.add(conversor.createEditCategoryData(category));
		}
		return finalCategories.toArray(new EditCategoryData[0]);
	}

	@Override
	public EditCategoryData createCategory(Security security, CategoryData categoryData)
			throws RepeatedNameException, InvalidEntityException, UnauthorizedAccessException {
		if (categoryData == null || categoryData.getName() == null || categoryData.getName().trim().isEmpty()) {
			throw new InvalidEntityException("Category is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateName(categoryData.getName(), soap, null);
		Category category = conversor.createCategory(categoryData);
		Category serverCategory = soap.createCategory(category, security);
		return conversor.createEditCategoryData(serverCategory);
	}

	@Override
	public EditCategoryData editCategory(Security security, EditCategoryData categoryData)
			throws RepeatedNameException, InvalidEntityException, UnauthorizedAccessException {
		if (categoryData == null || categoryData.getId() == null || 
				categoryData.getCategoryData() == null || categoryData.getCategoryData().getName() == null
				|| categoryData.getCategoryData().getName().trim().isEmpty()) {
			throw new InvalidEntityException("Category is missing some required field");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		validateName(categoryData.getCategoryData().getName(), soap, categoryData.getId());
		Category edited = conversor.createCategory(categoryData.getCategoryData(), categoryData.getId());
		Category editedServer = soap.updateCategory(edited, security);
		return conversor.createEditCategoryData(editedServer);
	}

	@Override
	public EditCategoryData removeCategory(Security security, Long id)
			throws ArgumentException, ElementNotFoundException, CannotRemoveElementException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		Category target = soap.findCategory(id, security);
		if (target == null) {
			throw new ElementNotFoundException("Category with id " + id + " not found");
		}
		validateCategoryRemovable(target, soap, security);
		Category deleted = soap.removeCategory(id, security);
		return conversor.createEditCategoryData(deleted);
	}

	@Override
	public EditCategoryData findCategory(Security security, Long id) throws ArgumentException, UnauthorizedAccessException {
		if (id == null) {
			throw new ArgumentException("Id required but not provided");
		}
		if (security == null) {
			throw new UnauthorizedAccessException("Security token needed");
		}
		TokenValidator.validateAuthToken(security);
		DataAccess dataAccessWS = new DataAccess();
		DataAccessSoap soap = dataAccessWS.getDataAccessSoap12();
		Category category = soap.findCategory(id, security);
		if (category == null) {
			return null;
		}
		return conversor.createEditCategoryData(category);
	}
	
	private void validateName(String name, DataAccessSoap soap, Long currentId) throws RepeatedNameException {
		ArrayOfCategory categories = soap.findCategoriesByName(name);
		if (!categories.getCategory().isEmpty() && 
				(currentId == null || categories.getCategory().get(0).getId() != currentId)){
			throw new RepeatedNameException("Another category has the same name: " + name);
		}
	}
	
	private void validateCategoryRemovable(Category category, DataAccessSoap soap, Security security) 
			throws CannotRemoveElementException {
		ProductSearchFilter filter = new ProductSearchFilter();
		filter.setCategory(category.getName());
		ArrayOfProduct products = soap.findProductsByFilter(filter, security);
		if (products != null && products.getProduct() != null && !products.getProduct().isEmpty()) {
			throw new CannotRemoveElementException("Category " + category.getName() + " contains products. Cannot be removed");
		}
	}
}
