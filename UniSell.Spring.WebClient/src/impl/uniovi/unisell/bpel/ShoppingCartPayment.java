
package impl.uniovi.unisell.bpel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ShoppingCartPayment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ShoppingCartPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://tempuri.org/}ArrayOfItemPayment" minOccurs="0"/>
 *         &lt;element name="buyerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="productsAvailable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="successfulPayment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShoppingCartPayment", namespace = "http://tempuri.org/", propOrder = {
    "items",
    "buyerId",
    "amount",
    "username",
    "password",
    "signature",
    "authToken",
    "productsAvailable",
    "successfulPayment"
})
public class ShoppingCartPayment {

    @XmlElement(namespace = "http://tempuri.org/")
    protected ArrayOfItemPayment items;
    @XmlElement(namespace = "http://tempuri.org/")
    protected long buyerId;
    @XmlElement(namespace = "http://tempuri.org/")
    protected double amount;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String username;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String password;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String signature;
    @XmlElement(namespace = "http://tempuri.org/")
    protected String authToken;
    @XmlElement(namespace = "http://tempuri.org/")
    protected boolean productsAvailable;
    @XmlElement(namespace = "http://tempuri.org/")
    protected boolean successfulPayment;

    /**
     * Obtiene el valor de la propiedad items.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItemPayment }
     *     
     */
    public ArrayOfItemPayment getItems() {
        return items;
    }

    /**
     * Define el valor de la propiedad items.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItemPayment }
     *     
     */
    public void setItems(ArrayOfItemPayment value) {
        this.items = value;
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
     * Obtiene el valor de la propiedad amount.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Obtiene el valor de la propiedad username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Define el valor de la propiedad username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Obtiene el valor de la propiedad authToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Define el valor de la propiedad authToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthToken(String value) {
        this.authToken = value;
    }

    /**
     * Obtiene el valor de la propiedad productsAvailable.
     * 
     */
    public boolean isProductsAvailable() {
        return productsAvailable;
    }

    /**
     * Define el valor de la propiedad productsAvailable.
     * 
     */
    public void setProductsAvailable(boolean value) {
        this.productsAvailable = value;
    }

    /**
     * Obtiene el valor de la propiedad successfulPayment.
     * 
     */
    public boolean isSuccessfulPayment() {
        return successfulPayment;
    }

    /**
     * Define el valor de la propiedad successfulPayment.
     * 
     */
    public void setSuccessfulPayment(boolean value) {
        this.successfulPayment = value;
    }

}
