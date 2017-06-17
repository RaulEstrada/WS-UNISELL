
package impl.uniovi.unisell.bpel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfItemPayment complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfItemPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemPayment" type="{http://tempuri.org/}ItemPayment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfItemPayment", namespace = "http://tempuri.org/", propOrder = {
    "itemPayment"
})
public class ArrayOfItemPayment {

    @XmlElement(name = "ItemPayment", namespace = "http://tempuri.org/", nillable = true)
    protected List<ItemPayment> itemPayment;

    /**
     * Gets the value of the itemPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPayment }
     * 
     * 
     */
    public List<ItemPayment> getItemPayment() {
        if (itemPayment == null) {
            itemPayment = new ArrayList<ItemPayment>();
        }
        return this.itemPayment;
    }

}
