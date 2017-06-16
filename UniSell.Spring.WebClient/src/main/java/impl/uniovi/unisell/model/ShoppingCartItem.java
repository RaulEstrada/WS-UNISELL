package impl.uniovi.unisell.model;

public class ShoppingCartItem {
	private int quantity;
	private Product<Long> product;
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Product<Long> getProduct() {
		return product;
	}
	
	public void setProduct(Product<Long> product) {
		this.product = product;
	}
	
	
}
