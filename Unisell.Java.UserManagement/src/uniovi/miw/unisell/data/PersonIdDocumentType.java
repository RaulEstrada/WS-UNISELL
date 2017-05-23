
package uniovi.miw.unisell.data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para PersonIdDocumentType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PersonIdDocumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DNIE"/>
 *     &lt;enumeration value="NIF"/>
 *     &lt;enumeration value="NIE"/>
 *     &lt;enumeration value="PASSPORT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PersonIdDocumentType")
@XmlEnum
public enum PersonIdDocumentType {

    DNIE,
    NIF,
    NIE,
    PASSPORT;

    public String value() {
        return name();
    }

    public static PersonIdDocumentType fromValue(String v) {
        return valueOf(v);
    }

}
