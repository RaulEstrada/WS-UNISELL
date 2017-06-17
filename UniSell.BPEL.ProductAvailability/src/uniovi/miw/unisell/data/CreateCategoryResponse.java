
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
 *         &lt;element name="CreateCategoryResult" type="{http://unisell.net.data/}Category" minOccurs="0"/>
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
    "createCategoryResult"
})
@XmlRootElement(name = "CreateCategoryResponse")
public class CreateCategoryResponse {

    @XmlElement(name = "CreateCategoryResult")
    protected Category createCategoryResult;

    /**
     * Obtiene el valor de la propiedad createCategoryResult.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCreateCategoryResult() {
        return createCategoryResult;
    }

    /**
     * Define el valor de la propiedad createCategoryResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCreateCategoryResult(Category value) {
        this.createCategoryResult = value;
    }

}
