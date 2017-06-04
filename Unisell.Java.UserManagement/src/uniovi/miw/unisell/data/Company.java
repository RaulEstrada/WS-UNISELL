
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Company complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Company">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdDocument" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdDocumentType" type="{http://unisell.net.data/}LegalPersonIdDocumentType"/>
 *         &lt;element name="LocationInfo" type="{http://unisell.net.data/}LocationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Company", propOrder = {
    "id",
    "version",
    "name",
    "description",
    "idDocument",
    "idDocumentType",
    "locationInfo"
})
public class Company {

    @XmlElement(name = "Id")
    protected long id;
    protected long version;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "IdDocument")
    protected String idDocument;
    @XmlElement(name = "IdDocumentType", required = true)
    @XmlSchemaType(name = "string")
    protected LegalPersonIdDocumentType idDocumentType;
    @XmlElement(name = "LocationInfo")
    protected LocationInfo locationInfo;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     */
    public long getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     */
    public void setVersion(long value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocument.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocument() {
        return idDocument;
    }

    /**
     * Define el valor de la propiedad idDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocument(String value) {
        this.idDocument = value;
    }

    /**
     * Obtiene el valor de la propiedad idDocumentType.
     * 
     * @return
     *     possible object is
     *     {@link LegalPersonIdDocumentType }
     *     
     */
    public LegalPersonIdDocumentType getIdDocumentType() {
        return idDocumentType;
    }

    /**
     * Define el valor de la propiedad idDocumentType.
     * 
     * @param value
     *     allowed object is
     *     {@link LegalPersonIdDocumentType }
     *     
     */
    public void setIdDocumentType(LegalPersonIdDocumentType value) {
        this.idDocumentType = value;
    }

    /**
     * Obtiene el valor de la propiedad locationInfo.
     * 
     * @return
     *     possible object is
     *     {@link LocationInfo }
     *     
     */
    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    /**
     * Define el valor de la propiedad locationInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationInfo }
     *     
     */
    public void setLocationInfo(LocationInfo value) {
        this.locationInfo = value;
    }

}
