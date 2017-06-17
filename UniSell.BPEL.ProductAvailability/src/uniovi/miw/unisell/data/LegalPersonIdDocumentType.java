
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LegalPersonIdDocumentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="LegalPersonIdDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CIF"/>
 *     &lt;enumeration value="CIE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LegalPersonIdDocumentType")
@XmlEnum
public enum LegalPersonIdDocumentType {

    CIF,
    CIE;

    public String value() {
        return name();
    }

    public static LegalPersonIdDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
