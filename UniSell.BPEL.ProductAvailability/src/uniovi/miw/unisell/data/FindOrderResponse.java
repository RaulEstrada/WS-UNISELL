
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
 *         &lt;element name="FindOrderResult" type="{http://unisell.net.data/}Order" minOccurs="0"/>
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
    "findOrderResult"
})
@XmlRootElement(name = "FindOrderResponse")
public class FindOrderResponse {

    @XmlElement(name = "FindOrderResult")
    protected Order findOrderResult;

    /**
     * Obtiene el valor de la propiedad findOrderResult.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getFindOrderResult() {
        return findOrderResult;
    }

    /**
     * Define el valor de la propiedad findOrderResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setFindOrderResult(Order value) {
        this.findOrderResult = value;
    }

}
