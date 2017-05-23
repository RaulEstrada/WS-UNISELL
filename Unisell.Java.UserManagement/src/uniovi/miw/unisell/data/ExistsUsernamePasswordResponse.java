
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
 *         &lt;element name="ExistsUsernamePasswordResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "existsUsernamePasswordResult"
})
@XmlRootElement(name = "ExistsUsernamePasswordResponse")
public class ExistsUsernamePasswordResponse {

    @XmlElement(name = "ExistsUsernamePasswordResult")
    protected boolean existsUsernamePasswordResult;

    /**
     * Obtiene el valor de la propiedad existsUsernamePasswordResult.
     * 
     */
    public boolean isExistsUsernamePasswordResult() {
        return existsUsernamePasswordResult;
    }

    /**
     * Define el valor de la propiedad existsUsernamePasswordResult.
     * 
     */
    public void setExistsUsernamePasswordResult(boolean value) {
        this.existsUsernamePasswordResult = value;
    }

}
