
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
 *         &lt;element name="FindAllCompaniesResult" type="{http://unisell.net.data/}ArrayOfCompany" minOccurs="0"/>
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
    "findAllCompaniesResult"
})
@XmlRootElement(name = "FindAllCompaniesResponse")
public class FindAllCompaniesResponse {

    @XmlElement(name = "FindAllCompaniesResult")
    protected ArrayOfCompany findAllCompaniesResult;

    /**
     * Obtiene el valor de la propiedad findAllCompaniesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCompany }
     *     
     */
    public ArrayOfCompany getFindAllCompaniesResult() {
        return findAllCompaniesResult;
    }

    /**
     * Define el valor de la propiedad findAllCompaniesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCompany }
     *     
     */
    public void setFindAllCompaniesResult(ArrayOfCompany value) {
        this.findAllCompaniesResult = value;
    }

}
