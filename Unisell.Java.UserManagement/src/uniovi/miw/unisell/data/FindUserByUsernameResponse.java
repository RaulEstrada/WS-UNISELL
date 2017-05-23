
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
 *         &lt;element name="FindUserByUsernameResult" type="{http://unisell.net.data/}User" minOccurs="0"/>
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
    "findUserByUsernameResult"
})
@XmlRootElement(name = "FindUserByUsernameResponse")
public class FindUserByUsernameResponse {

    @XmlElement(name = "FindUserByUsernameResult")
    protected User findUserByUsernameResult;

    /**
     * Obtiene el valor de la propiedad findUserByUsernameResult.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getFindUserByUsernameResult() {
        return findUserByUsernameResult;
    }

    /**
     * Define el valor de la propiedad findUserByUsernameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setFindUserByUsernameResult(User value) {
        this.findUserByUsernameResult = value;
    }

}
