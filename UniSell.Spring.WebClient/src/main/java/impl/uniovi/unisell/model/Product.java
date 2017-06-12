package impl.uniovi.unisell.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	@XmlAnyAttribute
	@JsonProperty
	private String href;
	@XmlElement
	@JsonProperty
	private Long Id;
	@XmlElement
	@JsonProperty
	private String Name;
	@XmlElement
	@JsonProperty
	private String Description;
	@XmlElement
	@JsonProperty
	private Double Price;
	@XmlElement
	@JsonProperty
	private Integer Units;
	@XmlElement
	@JsonProperty
	private byte[] Image;
	@XmlElement
	@JsonProperty
	private String Seller;
	@XmlElement
	@JsonProperty
	private String Category;
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
	
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
	
	public String getSeller() {
		return Seller;
	}
	
	public void setSeller(String seller) {
		Seller = seller;
	}
	
	public String getCategory() {
		return Category;
	}
	
	public void setCategory(String category) {
		Category = category;
	}
	
}
