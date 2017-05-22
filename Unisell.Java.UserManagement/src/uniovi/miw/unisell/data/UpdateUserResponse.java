
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
 *         &lt;element name="UpdateUserResult" type="{http://unisell.net.data/}User" minOccurs="0"/>
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
    "updateUserResult"
})
@XmlRootElement(name = "UpdateUserResponse")
public class UpdateUserResponse {

    @XmlElement(name = "UpdateUserResult")
    protected User updateUserResult;

    /**
     * Obtiene el valor de la propiedad updateUserResult.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUpdateUserResult() {
        return updateUserResult;
    }

    /**
     * Define el valor de la propiedad updateUserResult.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUpdateUserResult(User value) {
        this.updateUserResult = value;
    }

}
