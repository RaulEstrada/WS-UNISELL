package uniovi.miw.unisell.model;

import java.io.Serializable;

public class CategoryData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public CategoryData setName(String name) {
		this.name = name;
		return this;
	}
}
