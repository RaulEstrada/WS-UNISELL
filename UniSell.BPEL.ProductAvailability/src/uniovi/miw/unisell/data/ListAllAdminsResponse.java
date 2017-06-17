
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
 *         &lt;element name="ListAllAdminsResult" type="{http://unisell.net.data/}ArrayOfUserAdmin" minOccurs="0"/>
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
    "listAllAdminsResult"
})
@XmlRootElement(name = "ListAllAdminsResponse")
public class ListAllAdminsResponse {

    @XmlElement(name = "ListAllAdminsResult")
    protected ArrayOfUserAdmin listAllAdminsResult;

    /**
     * Obtiene el valor de la propiedad listAllAdminsResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserAdmin }
     *     
     */
    public ArrayOfUserAdmin getListAllAdminsResult() {
        return listAllAdminsResult;
    }

    /**
     * Define el valor de la propiedad listAllAdminsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserAdmin }
     *     
     */
    public void setListAllAdminsResult(ArrayOfUserAdmin value) {
        this.listAllAdminsResult = value;
    }

}
