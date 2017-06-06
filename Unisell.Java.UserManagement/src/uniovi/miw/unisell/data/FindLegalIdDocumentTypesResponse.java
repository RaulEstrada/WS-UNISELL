
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
 *         &lt;element name="FindLegalIdDocumentTypesResult" type="{http://unisell.net.data/}ArrayOfLegalPersonIdDocumentType" minOccurs="0"/>
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
    "findLegalIdDocumentTypesResult"
})
@XmlRootElement(name = "FindLegalIdDocumentTypesResponse")
public class FindLegalIdDocumentTypesResponse {

    @XmlElement(name = "FindLegalIdDocumentTypesResult")
    protected ArrayOfLegalPersonIdDocumentType findLegalIdDocumentTypesResult;

    /**
     * Obtiene el valor de la propiedad findLegalIdDocumentTypesResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLegalPersonIdDocumentType }
     *     
     */
    public ArrayOfLegalPersonIdDocumentType getFindLegalIdDocumentTypesResult() {
        return findLegalIdDocumentTypesResult;
    }

    /**
     * Define el valor de la propiedad findLegalIdDocumentTypesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLegalPersonIdDocumentType }
     *     
     */
    public void setFindLegalIdDocumentTypesResult(ArrayOfLegalPersonIdDocumentType value) {
        this.findLegalIdDocumentTypesResult = value;
    }

}
