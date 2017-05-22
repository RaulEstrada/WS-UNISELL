
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
 *         &lt;element name="FindAllUsersResult" type="{http://unisell.net.data/}ArrayOfUser" minOccurs="0"/>
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
    "findAllUsersResult"
})
@XmlRootElement(name = "FindAllUsersResponse")
public class FindAllUsersResponse {

    @XmlElement(name = "FindAllUsersResult")
    protected ArrayOfUser findAllUsersResult;

    /**
     * Obtiene el valor de la propiedad findAllUsersResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUser }
     *     
     */
    public ArrayOfUser getFindAllUsersResult() {
        return findAllUsersResult;
    }

    /**
     * Define el valor de la propiedad findAllUsersResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUser }
     *     
     */
    public void setFindAllUsersResult(ArrayOfUser value) {
        this.findAllUsersResult = value;
    }

}
