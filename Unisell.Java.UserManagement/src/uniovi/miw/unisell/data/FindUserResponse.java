
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
 *         &lt;element name="FindUserResult" type="{http://unisell.net.data/}User" minOccurs="0"/>
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
    "findUserResult"
})
@XmlRootElement(name = "FindUserResponse")
public class FindUserResponse {

    @XmlElement(name = "FindUserResult")
    protected User findUserResult;

    /**
     * Obtiene el valor de la propiedad findUserResult.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getFindUserResult() {
        return findUserResult;
    }

    /**
     * Define el valor de la propiedad findUserResult.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setFindUserResult(User value) {
        this.findUserResult = value;
    }

}
