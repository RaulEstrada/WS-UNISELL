
package uniovi.miw.unisell.data;

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
 *         &lt;element name="UpdateOrderResult" type="{http://unisell.net.data/}Order" minOccurs="0"/>
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
    "updateOrderResult"
})
@XmlRootElement(name = "UpdateOrderResponse")
public class UpdateOrderResponse {

    @XmlElement(name = "UpdateOrderResult")
    protected Order updateOrderResult;

    /**
     * Obtiene el valor de la propiedad updateOrderResult.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getUpdateOrderResult() {
        return updateOrderResult;
    }

    /**
     * Define el valor de la propiedad updateOrderResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setUpdateOrderResult(Order value) {
        this.updateOrderResult = value;
    }

}
