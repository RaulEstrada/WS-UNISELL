
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para Order complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Order">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://unisell.net.data/}OrderState"/>
 *         &lt;element name="buyer_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Buyer" type="{http://unisell.net.data/}UserBuyer" minOccurs="0"/>
 *         &lt;element name="Items" type="{http://unisell.net.data/}ArrayOfOrderItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
    "id",
    "version",
    "dateCreated",
    "orderNumber",
    "state",
    "buyerId",
    "buyer",
    "items"
})
public class Order {

    @XmlElement(name = "Id")
    protected long id;
    protected long version;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCreated;
    protected String orderNumber;
    @XmlElement(name = "State", required = true)
    @XmlSchemaType(name = "string")
    protected OrderState state;
    @XmlElement(name = "buyer_id")
    protected long buyerId;
    @XmlElement(name = "Buyer")
    protected UserBuyer buyer;
    @XmlElement(name = "Items")
    protected ArrayOfOrderItem items;

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
     * Obtiene el valor de la propiedad dateCreated.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Define el valor de la propiedad dateCreated.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * Obtiene el valor de la propiedad orderNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Define el valor de la propiedad orderNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad state.
     * 
     * @return
     *     possible object is
     *     {@link OrderState }
     *     
     */
    public OrderState getState() {
        return state;
    }

    /**
     * Define el valor de la propiedad state.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderState }
     *     
     */
    public void setState(OrderState value) {
        this.state = value;
    }

    /**
     * Obtiene el valor de la propiedad buyerId.
     * 
     */
    public long getBuyerId() {
        return buyerId;
    }

    /**
     * Define el valor de la propiedad buyerId.
     * 
     */
    public void setBuyerId(long value) {
        this.buyerId = value;
    }

    /**
     * Obtiene el valor de la propiedad buyer.
     * 
     * @return
     *     possible object is
     *     {@link UserBuyer }
     *     
     */
    public UserBuyer getBuyer() {
        return buyer;
    }

    /**
     * Define el valor de la propiedad buyer.
     * 
     * @param value
     *     allowed object is
     *     {@link UserBuyer }
     *     
     */
    public void setBuyer(UserBuyer value) {
        this.buyer = value;
    }

    /**
     * Obtiene el valor de la propiedad items.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOrderItem }
     *     
     */
    public ArrayOfOrderItem getItems() {
        return items;
    }

    /**
     * Define el valor de la propiedad items.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOrderItem }
     *     
     */
    public void setItems(ArrayOfOrderItem value) {
        this.items = value;
    }

}
