//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.12.05 a las 11:21:34 AM CST 
//


package mx.sat.pagos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para c_UsoCFDI.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="c_UsoCFDI"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="G01"/&gt;
 *     &lt;enumeration value="G02"/&gt;
 *     &lt;enumeration value="G03"/&gt;
 *     &lt;enumeration value="I01"/&gt;
 *     &lt;enumeration value="I02"/&gt;
 *     &lt;enumeration value="I03"/&gt;
 *     &lt;enumeration value="I04"/&gt;
 *     &lt;enumeration value="I05"/&gt;
 *     &lt;enumeration value="I06"/&gt;
 *     &lt;enumeration value="I07"/&gt;
 *     &lt;enumeration value="I08"/&gt;
 *     &lt;enumeration value="D01"/&gt;
 *     &lt;enumeration value="D02"/&gt;
 *     &lt;enumeration value="D03"/&gt;
 *     &lt;enumeration value="D04"/&gt;
 *     &lt;enumeration value="D05"/&gt;
 *     &lt;enumeration value="D06"/&gt;
 *     &lt;enumeration value="D07"/&gt;
 *     &lt;enumeration value="D08"/&gt;
 *     &lt;enumeration value="D09"/&gt;
 *     &lt;enumeration value="D10"/&gt;
 *     &lt;enumeration value="P01"/&gt;
 *     &lt;enumeration value="S01"/&gt;
 *     &lt;enumeration value="CP01"/&gt;
 *     &lt;enumeration value="CN01"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "c_UsoCFDI", namespace = "http://www.sat.gob.mx/sitio_internet/cfd/catalogos")
@XmlEnum
public enum CUsoCFDI {

    @XmlEnumValue("G01")
    G_01("G01"),
    @XmlEnumValue("G02")
    G_02("G02"),
    @XmlEnumValue("G03")
    G_03("G03"),
    @XmlEnumValue("I01")
    I_01("I01"),
    @XmlEnumValue("I02")
    I_02("I02"),
    @XmlEnumValue("I03")
    I_03("I03"),
    @XmlEnumValue("I04")
    I_04("I04"),
    @XmlEnumValue("I05")
    I_05("I05"),
    @XmlEnumValue("I06")
    I_06("I06"),
    @XmlEnumValue("I07")
    I_07("I07"),
    @XmlEnumValue("I08")
    I_08("I08"),
    @XmlEnumValue("D01")
    D_01("D01"),
    @XmlEnumValue("D02")
    D_02("D02"),
    @XmlEnumValue("D03")
    D_03("D03"),
    @XmlEnumValue("D04")
    D_04("D04"),
    @XmlEnumValue("D05")
    D_05("D05"),
    @XmlEnumValue("D06")
    D_06("D06"),
    @XmlEnumValue("D07")
    D_07("D07"),
    @XmlEnumValue("D08")
    D_08("D08"),
    @XmlEnumValue("D09")
    D_09("D09"),
    @XmlEnumValue("D10")
    D_10("D10"),
    @XmlEnumValue("P01")
    P_01("P01"),
    @XmlEnumValue("S01")
    S_01("S01"),
    @XmlEnumValue("CP01")
    CP_01("CP01"),
    @XmlEnumValue("CN01")
    CN_01("CN01");
    private final String value;

    CUsoCFDI(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CUsoCFDI fromValue(String v) {
        for (CUsoCFDI c: CUsoCFDI.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
