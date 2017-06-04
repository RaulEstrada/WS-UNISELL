
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
 *         &lt;element name="GetIdentityResult" type="{http://unisell.net.data/}IdentityData" minOccurs="0"/>
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
    "getIdentityResult"
})
@XmlRootElement(name = "GetIdentityResponse")
public class GetIdentityResponse {

    @XmlElement(name = "GetIdentityResult")
    protected IdentityData getIdentityResult;

    /**
     * Obtiene el valor de la propiedad getIdentityResult.
     * 
     * @return
     *     possible object is
     *     {@link IdentityData }
     *     
     */
    public IdentityData getGetIdentityResult() {
        return getIdentityResult;
    }

    /**
     * Define el valor de la propiedad getIdentityResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentityData }
     *     
     */
    public void setGetIdentityResult(IdentityData value) {
        this.getIdentityResult = value;
    }

}
