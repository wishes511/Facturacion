//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.12.05 a las 11:21:34 AM CST 
//


package mx.sat.pagos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para c_Estado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="c_Estado"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="collapse"/&gt;
 *     &lt;enumeration value="AGU"/&gt;
 *     &lt;enumeration value="BCN"/&gt;
 *     &lt;enumeration value="BCS"/&gt;
 *     &lt;enumeration value="CAM"/&gt;
 *     &lt;enumeration value="CHP"/&gt;
 *     &lt;enumeration value="CHH"/&gt;
 *     &lt;enumeration value="COA"/&gt;
 *     &lt;enumeration value="COL"/&gt;
 *     &lt;enumeration value="DIF"/&gt;
 *     &lt;enumeration value="CMX"/&gt;
 *     &lt;enumeration value="DUR"/&gt;
 *     &lt;enumeration value="GUA"/&gt;
 *     &lt;enumeration value="GRO"/&gt;
 *     &lt;enumeration value="HID"/&gt;
 *     &lt;enumeration value="JAL"/&gt;
 *     &lt;enumeration value="MEX"/&gt;
 *     &lt;enumeration value="MIC"/&gt;
 *     &lt;enumeration value="MOR"/&gt;
 *     &lt;enumeration value="NAY"/&gt;
 *     &lt;enumeration value="NLE"/&gt;
 *     &lt;enumeration value="OAX"/&gt;
 *     &lt;enumeration value="PUE"/&gt;
 *     &lt;enumeration value="QUE"/&gt;
 *     &lt;enumeration value="ROO"/&gt;
 *     &lt;enumeration value="SLP"/&gt;
 *     &lt;enumeration value="SIN"/&gt;
 *     &lt;enumeration value="SON"/&gt;
 *     &lt;enumeration value="TAB"/&gt;
 *     &lt;enumeration value="TAM"/&gt;
 *     &lt;enumeration value="TLA"/&gt;
 *     &lt;enumeration value="VER"/&gt;
 *     &lt;enumeration value="YUC"/&gt;
 *     &lt;enumeration value="ZAC"/&gt;
 *     &lt;enumeration value="AL"/&gt;
 *     &lt;enumeration value="AK"/&gt;
 *     &lt;enumeration value="AZ"/&gt;
 *     &lt;enumeration value="AR"/&gt;
 *     &lt;enumeration value="CA"/&gt;
 *     &lt;enumeration value="NC"/&gt;
 *     &lt;enumeration value="SC"/&gt;
 *     &lt;enumeration value="CO"/&gt;
 *     &lt;enumeration value="CT"/&gt;
 *     &lt;enumeration value="ND"/&gt;
 *     &lt;enumeration value="SD"/&gt;
 *     &lt;enumeration value="DE"/&gt;
 *     &lt;enumeration value="FL"/&gt;
 *     &lt;enumeration value="GA"/&gt;
 *     &lt;enumeration value="HI"/&gt;
 *     &lt;enumeration value="ID"/&gt;
 *     &lt;enumeration value="IL"/&gt;
 *     &lt;enumeration value="IN"/&gt;
 *     &lt;enumeration value="IA"/&gt;
 *     &lt;enumeration value="KS"/&gt;
 *     &lt;enumeration value="KY"/&gt;
 *     &lt;enumeration value="LA"/&gt;
 *     &lt;enumeration value="ME"/&gt;
 *     &lt;enumeration value="MD"/&gt;
 *     &lt;enumeration value="MA"/&gt;
 *     &lt;enumeration value="MI"/&gt;
 *     &lt;enumeration value="MN"/&gt;
 *     &lt;enumeration value="MS"/&gt;
 *     &lt;enumeration value="MO"/&gt;
 *     &lt;enumeration value="MT"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="NV"/&gt;
 *     &lt;enumeration value="NJ"/&gt;
 *     &lt;enumeration value="NY"/&gt;
 *     &lt;enumeration value="NH"/&gt;
 *     &lt;enumeration value="NM"/&gt;
 *     &lt;enumeration value="OH"/&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="OR"/&gt;
 *     &lt;enumeration value="PA"/&gt;
 *     &lt;enumeration value="RI"/&gt;
 *     &lt;enumeration value="TN"/&gt;
 *     &lt;enumeration value="TX"/&gt;
 *     &lt;enumeration value="UT"/&gt;
 *     &lt;enumeration value="VT"/&gt;
 *     &lt;enumeration value="VA"/&gt;
 *     &lt;enumeration value="WV"/&gt;
 *     &lt;enumeration value="WA"/&gt;
 *     &lt;enumeration value="WI"/&gt;
 *     &lt;enumeration value="WY"/&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="QC"/&gt;
 *     &lt;enumeration value="NS"/&gt;
 *     &lt;enumeration value="NB"/&gt;
 *     &lt;enumeration value="MB"/&gt;
 *     &lt;enumeration value="BC"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="SK"/&gt;
 *     &lt;enumeration value="AB"/&gt;
 *     &lt;enumeration value="NL"/&gt;
 *     &lt;enumeration value="NT"/&gt;
 *     &lt;enumeration value="YT"/&gt;
 *     &lt;enumeration value="UN"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "c_Estado", namespace = "http://www.sat.gob.mx/sitio_internet/cfd/catalogos")
@XmlEnum
public enum CEstado {

    AGU,
    BCN,
    BCS,
    CAM,
    CHP,
    CHH,
    COA,
    COL,
    DIF,
    CMX,
    DUR,
    GUA,
    GRO,
    HID,
    JAL,
    MEX,
    MIC,
    MOR,
    NAY,
    NLE,
    OAX,
    PUE,
    QUE,
    ROO,
    SLP,
    SIN,
    SON,
    TAB,
    TAM,
    TLA,
    VER,
    YUC,
    ZAC,
    AL,
    AK,
    AZ,
    AR,
    CA,
    NC,
    SC,
    CO,
    CT,
    ND,
    SD,
    DE,
    FL,
    GA,
    HI,
    ID,
    IL,
    IN,
    IA,
    KS,
    KY,
    LA,
    ME,
    MD,
    MA,
    MI,
    MN,
    MS,
    MO,
    MT,
    NE,
    NV,
    NJ,
    NY,
    NH,
    NM,
    OH,
    OK,
    OR,
    PA,
    RI,
    TN,
    TX,
    UT,
    VT,
    VA,
    WV,
    WA,
    WI,
    WY,
    ON,
    QC,
    NS,
    NB,
    MB,
    BC,
    PE,
    SK,
    AB,
    NL,
    NT,
    YT,
    UN;

    public String value() {
        return name();
    }

    public static CEstado fromValue(String v) {
        return valueOf(v);
    }

}
