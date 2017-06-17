
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
 *         &lt;element name="ListAllBuyersResult" type="{http://unisell.net.data/}ArrayOfUserBuyer" minOccurs="0"/>
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
    "listAllBuyersResult"
})
@XmlRootElement(name = "ListAllBuyersResponse")
public class ListAllBuyersResponse {

    @XmlElement(name = "ListAllBuyersResult")
    protected ArrayOfUserBuyer listAllBuyersResult;

    /**
     * Obtiene el valor de la propiedad listAllBuyersResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserBuyer }
     *     
     */
    public ArrayOfUserBuyer getListAllBuyersResult() {
        return listAllBuyersResult;
    }

    /**
     * Define el valor de la propiedad listAllBuyersResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserBuyer }
     *     
     */
    public void setListAllBuyersResult(ArrayOfUserBuyer value) {
        this.listAllBuyersResult = value;
    }

}
