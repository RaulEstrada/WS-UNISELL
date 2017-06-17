
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
 *         &lt;element name="CreateProductResult" type="{http://unisell.net.data/}Product" minOccurs="0"/>
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
    "createProductResult"
})
@XmlRootElement(name = "CreateProductResponse")
public class CreateProductResponse {

    @XmlElement(name = "CreateProductResult")
    protected Product createProductResult;

    /**
     * Obtiene el valor de la propiedad createProductResult.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getCreateProductResult() {
        return createProductResult;
    }

    /**
     * Define el valor de la propiedad createProductResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setCreateProductResult(Product value) {
        this.createProductResult = value;
    }

}
