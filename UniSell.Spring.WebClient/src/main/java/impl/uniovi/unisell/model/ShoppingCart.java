package impl.uniovi.unisell.model;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	private Map<Long, ShoppingCartItem> items = new HashMap<Long, ShoppingCartItem>();

	public ShoppingCartItem[] getItems() {
		return items.values().toArray(new ShoppingCartItem[0]);
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public Map<Long, ShoppingCartItem> getItemsMap() {
		return items;
	}
	
	public double getTotal(){
		double total = 0;
		for (ShoppingCartItem item : getItems()) {
			total += item.getTotal();
		}
		return total;
	}
}
