
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
 *         &lt;element name="FindProductAvailabilityResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "findProductAvailabilityResult"
})
@XmlRootElement(name = "FindProductAvailabilityResponse")
public class FindProductAvailabilityResponse {

    @XmlElement(name = "FindProductAvailabilityResult")
    protected int findProductAvailabilityResult;

    /**
     * Obtiene el valor de la propiedad findProductAvailabilityResult.
     * 
     */
    public int getFindProductAvailabilityResult() {
        return findProductAvailabilityResult;
    }

    /**
     * Define el valor de la propiedad findProductAvailabilityResult.
     * 
     */
    public void setFindProductAvailabilityResult(int value) {
        this.findProductAvailabilityResult = value;
    }

}
