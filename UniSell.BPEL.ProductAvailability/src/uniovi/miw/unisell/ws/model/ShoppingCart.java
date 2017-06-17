package uniovi.miw.unisell.ws.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long buyerId;
	private Set<Item> items = new HashSet<>();
	
	public Long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	
	public Set<Item> getItems() {
		return items;
	}
	
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
