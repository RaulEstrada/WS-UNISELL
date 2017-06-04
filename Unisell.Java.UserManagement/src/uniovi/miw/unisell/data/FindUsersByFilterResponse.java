
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
 *         &lt;element name="FindUsersByFilterResult" type="{http://unisell.net.data/}ArrayOfUser" minOccurs="0"/>
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
    "findUsersByFilterResult"
})
@XmlRootElement(name = "FindUsersByFilterResponse")
public class FindUsersByFilterResponse {

    @XmlElement(name = "FindUsersByFilterResult")
    protected ArrayOfUser findUsersByFilterResult;

    /**
     * Obtiene el valor de la propiedad findUsersByFilterResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUser }
     *     
     */
    public ArrayOfUser getFindUsersByFilterResult() {
        return findUsersByFilterResult;
    }

    /**
     * Define el valor de la propiedad findUsersByFilterResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUser }
     *     
     */
    public void setFindUsersByFilterResult(ArrayOfUser value) {
        this.findUsersByFilterResult = value;
    }

}
