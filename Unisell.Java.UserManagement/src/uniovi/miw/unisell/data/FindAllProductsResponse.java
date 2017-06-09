
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
 *         &lt;element name="FindAllProductsResult" type="{http://unisell.net.data/}ArrayOfProduct" minOccurs="0"/>
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
    "findAllProductsResult"
})
@XmlRootElement(name = "FindAllProductsResponse")
public class FindAllProductsResponse {

    @XmlElement(name = "FindAllProductsResult")
    protected ArrayOfProduct findAllProductsResult;

    /**
     * Obtiene el valor de la propiedad findAllProductsResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProduct }
     *     
     */
    public ArrayOfProduct getFindAllProductsResult() {
        return findAllProductsResult;
    }

    /**
     * Define el valor de la propiedad findAllProductsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProduct }
     *     
     */
    public void setFindAllProductsResult(ArrayOfProduct value) {
        this.findAllProductsResult = value;
    }

}
