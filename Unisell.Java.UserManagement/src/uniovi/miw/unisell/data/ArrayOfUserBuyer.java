
package uniovi.miw.unisell.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfUserBuyer complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUserBuyer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserBuyer" type="{http://unisell.net.data/}UserBuyer" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUserBuyer", propOrder = {
    "userBuyer"
})
public class ArrayOfUserBuyer {

    @XmlElement(name = "UserBuyer", nillable = true)
    protected List<UserBuyer> userBuyer;

    /**
     * Gets the value of the userBuyer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userBuyer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserBuyer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserBuyer }
     * 
     * 
     */
    public List<UserBuyer> getUserBuyer() {
        if (userBuyer == null) {
            userBuyer = new ArrayList<UserBuyer>();
        }
        return this.userBuyer;
    }

}
