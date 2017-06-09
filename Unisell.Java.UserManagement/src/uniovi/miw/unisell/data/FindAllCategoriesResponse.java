
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
 *         &lt;element name="FindAllCategoriesResult" type="{http://unisell.net.data/}ArrayOfCategory" minOccurs="0"/>
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
    "findAllCategoriesResult"
})
@XmlRootElement(name = "FindAllCategoriesResponse")
public class FindAllCategoriesResponse {

    @XmlElement(name = "FindAllCategoriesResult")
    protected ArrayOfCategory findAllCategoriesResult;

    /**
     * Obtiene el valor de la propiedad findAllCategoriesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCategory }
     *     
     */
    public ArrayOfCategory getFindAllCategoriesResult() {
        return findAllCategoriesResult;
    }

    /**
     * Define el valor de la propiedad findAllCategoriesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCategory }
     *     
     */
    public void setFindAllCategoriesResult(ArrayOfCategory value) {
        this.findAllCategoriesResult = value;
    }

}
