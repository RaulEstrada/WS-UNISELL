
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
 *         &lt;element name="ListAllSellersResult" type="{http://unisell.net.data/}ArrayOfUserSeller" minOccurs="0"/>
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
    "listAllSellersResult"
})
@XmlRootElement(name = "ListAllSellersResponse")
public class ListAllSellersResponse {

    @XmlElement(name = "ListAllSellersResult")
    protected ArrayOfUserSeller listAllSellersResult;

    /**
     * Obtiene el valor de la propiedad listAllSellersResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserSeller }
     *     
     */
    public ArrayOfUserSeller getListAllSellersResult() {
        return listAllSellersResult;
    }

    /**
     * Define el valor de la propiedad listAllSellersResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserSeller }
     *     
     */
    public void setListAllSellersResult(ArrayOfUserSeller value) {
        this.listAllSellersResult = value;
    }

}
