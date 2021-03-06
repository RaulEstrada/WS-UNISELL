package uniovi.miw.unisell.ws;

import java.io.Serializable;

public class ItemAvail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long productId;
	private Integer units;
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Integer getUnits() {
		return units;
	}
	
	public void setUnits(Integer units) {
		this.units = units;
	}

}
