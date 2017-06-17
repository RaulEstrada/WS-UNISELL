
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
 *         &lt;element name="input" type="{http://ws.unisell.miw.uniovi/}shoppingCartAvail"/>
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
    "input"
})
@XmlRootElement(name = "WS_InvocationRequest", namespace = "http://ws.Invocation.tps")
public class WSInvocationRequest {

    @XmlElement(namespace = "http://ws.Invocation.tps", required = true)
    protected ShoppingCartAvail input;

    /**
     * Obtiene el valor de la propiedad input.
     * 
     * @return
     *     possible object is
     *     {@link ShoppingCartAvail }
     *     
     */
    public ShoppingCartAvail getInput() {
        return input;
    }

    /**
     * Define el valor de la propiedad input.
     * 
     * @param value
     *     allowed object is
     *     {@link ShoppingCartAvail }
     *     
     */
    public void setInput(ShoppingCartAvail value) {
        this.input = value;
    }

}
