//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.20 a las 10:15:19 AM CST 
//


package mx.sat.cfd40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para c_INCOTERM.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="c_INCOTERM">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="CFR"/>
 *     &lt;enumeration value="CIF"/>
 *     &lt;enumeration value="CPT"/>
 *     &lt;enumeration value="CIP"/>
 *     &lt;enumeration value="DAF"/>
 *     &lt;enumeration value="DAP"/>
 *     &lt;enumeration value="DAT"/>
 *     &lt;enumeration value="DES"/>
 *     &lt;enumeration value="DEQ"/>
 *     &lt;enumeration value="DDU"/>
 *     &lt;enumeration value="DDP"/>
 *     &lt;enumeration value="EXW"/>
 *     &lt;enumeration value="FCA"/>
 *     &lt;enumeration value="FAS"/>
 *     &lt;enumeration value="FOB"/>
 *     &lt;enumeration value="DPU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "c_INCOTERM", namespace = "http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt")
@XmlEnum
public enum CINCOTERM {

    CFR,
    CIF,
    CPT,
    CIP,
    DAF,
    DAP,
    DAT,
    DES,
    DEQ,
    DDU,
    DDP,
    EXW,
    FCA,
    FAS,
    FOB,
    DPU;

    public String value() {
        return name();
    }

    public static CINCOTERM fromValue(String v) {
        return valueOf(v);
    }

}
