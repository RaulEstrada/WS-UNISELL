
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
 *         &lt;element name="FindCompaniesByFilterResult" type="{http://unisell.net.data/}ArrayOfCompany" minOccurs="0"/>
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
    "findCompaniesByFilterResult"
})
@XmlRootElement(name = "FindCompaniesByFilterResponse")
public class FindCompaniesByFilterResponse {

    @XmlElement(name = "FindCompaniesByFilterResult")
    protected ArrayOfCompany findCompaniesByFilterResult;

    /**
     * Obtiene el valor de la propiedad findCompaniesByFilterResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCompany }
     *     
     */
    public ArrayOfCompany getFindCompaniesByFilterResult() {
        return findCompaniesByFilterResult;
    }

    /**
     * Define el valor de la propiedad findCompaniesByFilterResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCompany }
     *     
     */
    public void setFindCompaniesByFilterResult(ArrayOfCompany value) {
        this.findCompaniesByFilterResult = value;
    }

}
