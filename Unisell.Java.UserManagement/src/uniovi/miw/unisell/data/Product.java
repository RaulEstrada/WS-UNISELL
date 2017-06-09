
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Product complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Units" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="image" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="seller_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="seller" type="{http://unisell.net.data/}UserSeller" minOccurs="0"/>
 *         &lt;element name="category_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="category" type="{http://unisell.net.data/}Category" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "id",
    "version",
    "name",
    "description",
    "price",
    "units",
    "image",
    "sellerId",
    "seller",
    "categoryId",
    "category"
})
public class Product {

    @XmlElement(name = "Id")
    protected long id;
    protected long version;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Price")
    protected double price;
    @XmlElement(name = "Units")
    protected int units;
    protected byte[] image;
    @XmlElement(name = "seller_id")
    protected long sellerId;
    protected UserSeller seller;
    @XmlElement(name = "category_id")
    protected long categoryId;
    protected Category category;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     */
    public long getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     */
    public void setVersion(long value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad price.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad units.
     * 
     */
    public int getUnits() {
        return units;
    }

    /**
     * Define el valor de la propiedad units.
     * 
     */
    public void setUnits(int value) {
        this.units = value;
    }

    /**
     * Obtiene el valor de la propiedad image.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Define el valor de la propiedad image.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setImage(byte[] value) {
        this.image = value;
    }

    /**
     * Obtiene el valor de la propiedad sellerId.
     * 
     */
    public long getSellerId() {
        return sellerId;
    }

    /**
     * Define el valor de la propiedad sellerId.
     * 
     */
    public void setSellerId(long value) {
        this.sellerId = value;
    }

    /**
     * Obtiene el valor de la propiedad seller.
     * 
     * @return
     *     possible object is
     *     {@link UserSeller }
     *     
     */
    public UserSeller getSeller() {
        return seller;
    }

    /**
     * Define el valor de la propiedad seller.
     * 
     * @param value
     *     allowed object is
     *     {@link UserSeller }
     *     
     */
    public void setSeller(UserSeller value) {
        this.seller = value;
    }

    /**
     * Obtiene el valor de la propiedad categoryId.
     * 
     */
    public long getCategoryId() {
        return categoryId;
    }

    /**
     * Define el valor de la propiedad categoryId.
     * 
     */
    public void setCategoryId(long value) {
        this.categoryId = value;
    }

    /**
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
        this.category = value;
    }

}
