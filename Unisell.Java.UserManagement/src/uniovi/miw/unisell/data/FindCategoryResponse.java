
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
 *         &lt;element name="FindCategoryResult" type="{http://unisell.net.data/}Category" minOccurs="0"/>
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
    "findCategoryResult"
})
@XmlRootElement(name = "FindCategoryResponse")
public class FindCategoryResponse {

    @XmlElement(name = "FindCategoryResult")
    protected Category findCategoryResult;

    /**
     * Obtiene el valor de la propiedad findCategoryResult.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getFindCategoryResult() {
        return findCategoryResult;
    }

    /**
     * Define el valor de la propiedad findCategoryResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setFindCategoryResult(Category value) {
        this.findCategoryResult = value;
    }

}
