
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
 *         &lt;element name="CountCompaniesResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "countCompaniesResult"
})
@XmlRootElement(name = "CountCompaniesResponse")
public class CountCompaniesResponse {

    @XmlElement(name = "CountCompaniesResult")
    protected int countCompaniesResult;

    /**
     * Obtiene el valor de la propiedad countCompaniesResult.
     * 
     */
    public int getCountCompaniesResult() {
        return countCompaniesResult;
    }

    /**
     * Define el valor de la propiedad countCompaniesResult.
     * 
     */
    public void setCountCompaniesResult(int value) {
        this.countCompaniesResult = value;
    }

}
