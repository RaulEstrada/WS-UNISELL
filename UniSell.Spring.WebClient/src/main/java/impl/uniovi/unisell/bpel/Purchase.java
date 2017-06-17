
package impl.uniovi.unisell.bpel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="purchase" type="{http://ws.unisell.miw.uniovi/}shoppingCartAvail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "purchase"
})
@XmlRootElement(name = "Purchase")
public class Purchase {

    @XmlElement(namespace = "http://tempuri.org/")
    protected ShoppingCartAvail purchase;

    /**
     * Obtiene el valor de la propiedad purchase.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingCartAvail }
     *     
     */
    public ShoppingCartAvail getPurchase() {
        return purchase;
    }

    /**
     * Define el valor de la propiedad purchase.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingCartAvail }
     *     
     */
    public void setPurchase(ShoppingCartAvail value) {
        this.purchase = value;
    }

}
