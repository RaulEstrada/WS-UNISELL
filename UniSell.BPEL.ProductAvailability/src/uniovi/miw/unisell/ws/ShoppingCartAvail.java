package uniovi.miw.unisell.ws;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCartAvail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long buyerId;
	private Set<ItemAvail> items = new HashSet<>();
	private Double amount;
	private String username;
	private String password;
	private String signature;
	private String authToken;
	private boolean productsAvailable = false;
	private boolean successfulPayment = false;
	
	public Long getBuyerId() {
		return buyerId;
	}
	
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	
	public Set<ItemAvail> getItems() {
		return items;
	}
	
	public void setItems(Set<ItemAvail> items) {
		this.items = items;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public boolean isProductsAvailable() {
		return productsAvailable;
	}

	public void setProductsAvailable(boolean productsAvailable) {
		this.productsAvailable = productsAvailable;
	}

	public boolean isSuccessfulPayment() {
		return successfulPayment;
	}

	public void setSuccessfulPayment(boolean successfulPayment) {
		this.successfulPayment = successfulPayment;
	}
	
}
