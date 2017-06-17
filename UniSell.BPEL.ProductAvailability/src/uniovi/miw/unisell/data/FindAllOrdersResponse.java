
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
 *         &lt;element name="FindAllOrdersResult" type="{http://unisell.net.data/}ArrayOfOrder" minOccurs="0"/>
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
    "findAllOrdersResult"
})
@XmlRootElement(name = "FindAllOrdersResponse")
public class FindAllOrdersResponse {

    @XmlElement(name = "FindAllOrdersResult")
    protected ArrayOfOrder findAllOrdersResult;

    /**
     * Obtiene el valor de la propiedad findAllOrdersResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOrder }
     *     
     */
    public ArrayOfOrder getFindAllOrdersResult() {
        return findAllOrdersResult;
    }

    /**
     * Define el valor de la propiedad findAllOrdersResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOrder }
     *     
     */
    public void setFindAllOrdersResult(ArrayOfOrder value) {
        this.findAllOrdersResult = value;
    }

}
