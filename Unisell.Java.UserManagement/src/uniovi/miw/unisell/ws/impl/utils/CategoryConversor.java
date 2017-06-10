package uniovi.miw.unisell.ws.impl.utils;

import uniovi.miw.unisell.data.Category;
import uniovi.miw.unisell.model.CategoryData;
import uniovi.miw.unisell.model.EditCategoryData;

public class CategoryConversor {
	public Category createCategory(CategoryData data, Long id) {
		Category category = new Category();
		category.setId(id);
		category.setName(data.getName());
		return category;
	}
	
	public Category createCategory(CategoryData data) {
		return createCategory(data, 0l);
	}
	
	public EditCategoryData createEditCategoryData(Category category) {
		CategoryData data = new CategoryData()
				.setName(category.getName());
		return new EditCategoryData()
				.setId(category.getId())
				.setCategoryData(data);
	}
}
