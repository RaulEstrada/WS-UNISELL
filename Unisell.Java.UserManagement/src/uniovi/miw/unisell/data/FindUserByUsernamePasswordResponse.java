
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
 *         &lt;element name="FindUserByUsernamePasswordResult" type="{http://unisell.net.data/}User" minOccurs="0"/>
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
    "findUserByUsernamePasswordResult"
})
@XmlRootElement(name = "FindUserByUsernamePasswordResponse")
public class FindUserByUsernamePasswordResponse {

    @XmlElement(name = "FindUserByUsernamePasswordResult")
    protected User findUserByUsernamePasswordResult;

    /**
     * Obtiene el valor de la propiedad findUserByUsernamePasswordResult.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getFindUserByUsernamePasswordResult() {
        return findUserByUsernamePasswordResult;
    }

    /**
     * Define el valor de la propiedad findUserByUsernamePasswordResult.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setFindUserByUsernamePasswordResult(User value) {
        this.findUserByUsernamePasswordResult = value;
    }

}
