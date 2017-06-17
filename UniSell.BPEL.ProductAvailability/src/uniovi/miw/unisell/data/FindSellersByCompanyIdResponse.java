
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
 *         &lt;element name="FindSellersByCompanyIdResult" type="{http://unisell.net.data/}ArrayOfUserSeller" minOccurs="0"/>
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
    "findSellersByCompanyIdResult"
})
@XmlRootElement(name = "FindSellersByCompanyIdResponse")
public class FindSellersByCompanyIdResponse {

    @XmlElement(name = "FindSellersByCompanyIdResult")
    protected ArrayOfUserSeller findSellersByCompanyIdResult;

    /**
     * Obtiene el valor de la propiedad findSellersByCompanyIdResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserSeller }
     *     
     */
    public ArrayOfUserSeller getFindSellersByCompanyIdResult() {
        return findSellersByCompanyIdResult;
    }

    /**
     * Define el valor de la propiedad findSellersByCompanyIdResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserSeller }
     *     
     */
    public void setFindSellersByCompanyIdResult(ArrayOfUserSeller value) {
        this.findSellersByCompanyIdResult = value;
    }

}
