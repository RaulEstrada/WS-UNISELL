
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UserSeller complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UserSeller">
 *   &lt;complexContent>
 *     &lt;extension base="{http://unisell.net.data/}User">
 *       &lt;sequence>
 *         &lt;element name="company_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Company" type="{http://unisell.net.data/}Company" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserSeller", propOrder = {
    "companyId",
    "company"
})
public class UserSeller
    extends User
{

    @XmlElement(name = "company_id")
    protected long companyId;
    @XmlElement(name = "Company")
    protected Company company;

    /**
     * Obtiene el valor de la propiedad companyId.
     * 
     */
    public long getCompanyId() {
        return companyId;
    }

    /**
     * Define el valor de la propiedad companyId.
     * 
     */
    public void setCompanyId(long value) {
        this.companyId = value;
    }

    /**
     * Obtiene el valor de la propiedad company.
     * 
     * @return
     *     possible object is
     *     {@link Company }
     *     
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Define el valor de la propiedad company.
     * 
     * @param value
     *     allowed object is
     *     {@link Company }
     *     
     */
    public void setCompany(Company value) {
        this.company = value;
    }

}
