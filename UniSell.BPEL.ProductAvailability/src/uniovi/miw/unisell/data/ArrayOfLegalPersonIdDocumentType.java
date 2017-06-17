
package uniovi.miw.unisell.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfLegalPersonIdDocumentType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLegalPersonIdDocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LegalPersonIdDocumentType" type="{http://unisell.net.data/}LegalPersonIdDocumentType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLegalPersonIdDocumentType", propOrder = {
    "legalPersonIdDocumentType"
})
public class ArrayOfLegalPersonIdDocumentType {

    @XmlElement(name = "LegalPersonIdDocumentType")
    @XmlSchemaType(name = "string")
    protected List<LegalPersonIdDocumentType> legalPersonIdDocumentType;

    /**
     * Gets the value of the legalPersonIdDocumentType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the legalPersonIdDocumentType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLegalPersonIdDocumentType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LegalPersonIdDocumentType }
     * 
     * 
     */
    public List<LegalPersonIdDocumentType> getLegalPersonIdDocumentType() {
        if (legalPersonIdDocumentType == null) {
            legalPersonIdDocumentType = new ArrayList<LegalPersonIdDocumentType>();
        }
        return this.legalPersonIdDocumentType;
    }

}
