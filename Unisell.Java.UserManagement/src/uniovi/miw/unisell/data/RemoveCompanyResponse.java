
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
 *         &lt;element name="RemoveCompanyResult" type="{http://unisell.net.data/}Company" minOccurs="0"/>
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
    "removeCompanyResult"
})
@XmlRootElement(name = "RemoveCompanyResponse")
public class RemoveCompanyResponse {

    @XmlElement(name = "RemoveCompanyResult")
    protected Company removeCompanyResult;

    /**
     * Obtiene el valor de la propiedad removeCompanyResult.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getRemoveCompanyResult() {
        return removeCompanyResult;
    }

    /**
     * Define el valor de la propiedad removeCompanyResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setRemoveCompanyResult(Company value) {
        this.removeCompanyResult = value;
    }

}
