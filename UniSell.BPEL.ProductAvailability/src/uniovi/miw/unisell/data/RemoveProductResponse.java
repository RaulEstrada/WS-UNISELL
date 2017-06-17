
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
 *         &lt;element name="RemoveProductResult" type="{http://unisell.net.data/}Product" minOccurs="0"/>
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
    "removeProductResult"
})
@XmlRootElement(name = "RemoveProductResponse")
public class RemoveProductResponse {

    @XmlElement(name = "RemoveProductResult")
    protected Product removeProductResult;

    /**
     * Obtiene el valor de la propiedad removeProductResult.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getRemoveProductResult() {
        return removeProductResult;
    }

    /**
     * Define el valor de la propiedad removeProductResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setRemoveProductResult(Product value) {
        this.removeProductResult = value;
    }

}
