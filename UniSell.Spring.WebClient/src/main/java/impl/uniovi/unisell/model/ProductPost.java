package impl.uniovi.unisell.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductPost {
	@XmlElement
	@JsonProperty
	private String Name;
	@XmlElement
	@JsonProperty
	private String Description;
	@XmlElement
	@JsonProperty
	private double Price;
	@XmlElement
	@JsonProperty
	private int Units;
	@XmlElement
	@JsonProperty
	private byte[] Image;
	@XmlElement
	@JsonProperty
	private long SellerId;
	@XmlElement
	@JsonProperty
	private long CategoryId;
	
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
	
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double price) {
		Price = price;
	}
	
	public int getUnits() {
		return Units;
	}
	
	public void setUnits(int units) {
		Units = units;
	}
	
	public byte[] getImage() {
		return Image;
	}
	
	public void setImage(byte[] image) {
		Image = image;
	}
	
	public long getSellerId() {
		return SellerId;
	}
	
	public void setSellerId(long seller) {
		SellerId = seller;
	}
	
	public long getCategoryId() {
		return CategoryId;
	}
	
	public void setCategoryId(long category) {
		CategoryId = category;
	}
}