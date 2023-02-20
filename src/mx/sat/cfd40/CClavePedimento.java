//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.20 a las 10:15:19 AM CST 
//


package mx.sat.cfd40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para c_ClavePedimento.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="c_ClavePedimento">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="A1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "c_ClavePedimento", namespace = "http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt")
@XmlEnum
public enum CClavePedimento {

    @XmlEnumValue("A1")
    A_1("A1");
    private final String value;

    CClavePedimento(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CClavePedimento fromValue(String v) {
        for (CClavePedimento c: CClavePedimento.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
