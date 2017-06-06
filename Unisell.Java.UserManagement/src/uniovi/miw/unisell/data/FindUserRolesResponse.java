
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
 *         &lt;element name="FindUserRolesResult" type="{http://unisell.net.data/}ArrayOfUserRole" minOccurs="0"/>
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
    "findUserRolesResult"
})
@XmlRootElement(name = "FindUserRolesResponse")
public class FindUserRolesResponse {

    @XmlElement(name = "FindUserRolesResult")
    protected ArrayOfUserRole findUserRolesResult;

    /**
     * Obtiene el valor de la propiedad findUserRolesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserRole }
     *     
     */
    public ArrayOfUserRole getFindUserRolesResult() {
        return findUserRolesResult;
    }

    /**
     * Define el valor de la propiedad findUserRolesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserRole }
     *     
     */
    public void setFindUserRolesResult(ArrayOfUserRole value) {
        this.findUserRolesResult = value;
    }

}
