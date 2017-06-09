
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
 *         &lt;element name="RemoveCategoryResult" type="{http://unisell.net.data/}Category" minOccurs="0"/>
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
    "removeCategoryResult"
})
@XmlRootElement(name = "RemoveCategoryResponse")
public class RemoveCategoryResponse {

    @XmlElement(name = "RemoveCategoryResult")
    protected Category removeCategoryResult;

    /**
     * Obtiene el valor de la propiedad removeCategoryResult.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getRemoveCategoryResult() {
        return removeCategoryResult;
    }

    /**
     * Define el valor de la propiedad removeCategoryResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setRemoveCategoryResult(Category value) {
        this.removeCategoryResult = value;
    }

}
