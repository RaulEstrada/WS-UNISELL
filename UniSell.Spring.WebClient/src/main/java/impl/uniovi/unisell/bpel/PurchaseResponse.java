
package impl.uniovi.unisell.bpel;

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
 *         &lt;element name="PurchaseResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "purchaseResult"
})
@XmlRootElement(name = "PurchaseResponse")
public class PurchaseResponse {

    @XmlElement(name = "PurchaseResult", namespace = "http://tempuri.org/")
    protected String purchaseResult;

    /**
     * Obtiene el valor de la propiedad purchaseResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseResult() {
        return purchaseResult;
    }

    /**
     * Define el valor de la propiedad purchaseResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseResult(String value) {
        this.purchaseResult = value;
    }

}
