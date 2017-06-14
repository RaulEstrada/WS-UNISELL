package impl.uniovi.unisell.model;

public class ProductFilter {
	private String Name, Description, Category;
	private Double PriceFrom, PriceTo;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getCategory() {
		return Category;
	}
	
	public void setCategory(String category) {
		Category = category;
	}
	
	public Double getPriceFrom() {
		return PriceFrom;
	}
	
	public void setPriceFrom(Double priceFrom) {
		PriceFrom = priceFrom;
	}
	
	public Double getPriceTo() {
		return PriceTo;
	}
	
	public void setPriceTo(Double priceTo) {
		PriceTo = priceTo;
	}
}
