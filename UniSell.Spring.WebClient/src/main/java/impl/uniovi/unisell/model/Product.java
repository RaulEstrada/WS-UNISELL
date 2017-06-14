package impl.uniovi.unisell.model;

import java.util.Base64;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product<T> {
	@XmlAttribute
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
	private double Price;
	@XmlElement
	@JsonProperty
	private int Units;
	@XmlElement
	@JsonProperty
	private byte[] Image;
	@XmlElement
	@JsonProperty
	private T Seller;
	@XmlElement
	@JsonProperty
	private T Category;
	
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
	
	public T getSeller() {
		return Seller;
	}
	
	public void setSeller(T seller) {
		Seller = seller;
	}
	
	public T getCategory() {
		return Category;
	}
	
	public void setCategory(T category) {
		Category = category;
	}
	
	public String getImageBase64() {
		return Base64.getEncoder().encodeToString(Image);
	}
	
}
