package uniovi.miw.unisell.model;

import java.io.Serializable;

public class EditCategoryData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CategoryData categoryData;
	
	public Long getId() {
		return id;
	}
	
	public EditCategoryData setId(Long id) {
		this.id = id;
		return this;
	}
	
	public CategoryData getCategoryData() {
		return categoryData;
	}
	
	public EditCategoryData setCategoryData(CategoryData categoryData) {
		this.categoryData = categoryData;
		return this;
	}
	
	
}
