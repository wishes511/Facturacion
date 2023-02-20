//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.02.20 a las 10:15:19 AM CST 
//


package mx.sat.cfd40;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="Emisor" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Domicilio" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
 *                           &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Colonia" />
 *                           &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Localidad" />
 *                           &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
 *                           &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Municipio" />
 *                           &lt;attribute name="Estado" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Estado" />
 *                           &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *                           &lt;attribute name="CodigoPostal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_CodigoPostal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Curp" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_CURP" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Propietario" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="NumRegIdTrib" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="6"/>
 *                       &lt;maxLength value="40"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="ResidenciaFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Receptor" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Domicilio" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
 *                           &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
 *                           &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Estado" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="30"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,30}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *                           &lt;attribute name="CodigoPostal" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="12"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NumRegIdTrib">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="6"/>
 *                       &lt;maxLength value="40"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Destinatario" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Domicilio" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
 *                           &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
 *                           &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
 *                           &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
 *                           &lt;attribute name="Estado" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="30"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,30}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *                           &lt;attribute name="CodigoPostal" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="12"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NumRegIdTrib">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="6"/>
 *                       &lt;maxLength value="40"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="Nombre">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="300"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,300}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Mercancias" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Mercancia" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DescripcionesEspecificas" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Marca" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="35"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,35}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Modelo">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="80"/>
 *                                           &lt;pattern value="[^|]{1,80}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="SubModelo">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="50"/>
 *                                           &lt;pattern value="[^|]{1,50}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="NumeroSerie">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="40"/>
 *                                           &lt;pattern value="[^|]{1,40}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="NoIdentificacion" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="100"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,100}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="FraccionArancelaria" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_FraccionArancelaria" />
 *                           &lt;attribute name="CantidadAduana">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;minInclusive value="0.001"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[0-9]{1,14}(.([0-9]{1,3}))?"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="UnidadAduana" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_UnidadAduana" />
 *                           &lt;attribute name="ValorUnitarioAduana">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;minInclusive value="0.00"/>
 *                                 &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ValorDolares" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;minInclusive value="0.00"/>
 *                                 &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" use="required" fixed="1.1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MotivoTraslado" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_MotivoTraslado" />
 *       &lt;attribute name="TipoOperacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_TipoOperacion" />
 *       &lt;attribute name="ClaveDePedimento" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_ClavePedimento" />
 *       &lt;attribute name="CertificadoOrigen">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;enumeration value="0"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NumCertificadoOrigen">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="6"/>
 *             &lt;maxLength value="40"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{6,40}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NumeroExportadorConfiable">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *             &lt;pattern value="[^|]{1,50}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Incoterm" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_INCOTERM" />
 *       &lt;attribute name="Subdivision">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;enumeration value="0"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Observaciones">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="300"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{1,300}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TipoCambioUSD" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_TipoCambio" />
 *       &lt;attribute name="TotalUSD" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "emisor",
    "propietario",
    "receptor",
    "destinatario",
    "mercancias"
})
@XmlRootElement(name = "ComercioExterior")
public class ComercioExterior {

    @XmlElement(name = "Emisor")
    protected ComercioExterior.Emisor emisor;
    @XmlElement(name = "Propietario")
    protected List<ComercioExterior.Propietario> propietario;
    @XmlElement(name = "Receptor")
    protected ComercioExterior.Receptor receptor;
    @XmlElement(name = "Destinatario")
    protected List<ComercioExterior.Destinatario> destinatario;
    @XmlElement(name = "Mercancias")
    protected ComercioExterior.Mercancias mercancias;
    @XmlAttribute(name = "Version", required = true)
    protected String version;
    @XmlAttribute(name = "MotivoTraslado")
    protected String motivoTraslado;
    @XmlAttribute(name = "TipoOperacion", required = true)
    protected String tipoOperacion;
    @XmlAttribute(name = "ClaveDePedimento")
    protected CClavePedimento claveDePedimento;
    @XmlAttribute(name = "CertificadoOrigen")
    protected Integer certificadoOrigen;
    @XmlAttribute(name = "NumCertificadoOrigen")
    protected String numCertificadoOrigen;
    @XmlAttribute(name = "NumeroExportadorConfiable")
    protected String numeroExportadorConfiable;
    @XmlAttribute(name = "Incoterm")
    protected CINCOTERM incoterm;
    @XmlAttribute(name = "Subdivision")
    protected Integer subdivision;
    @XmlAttribute(name = "Observaciones")
    protected String observaciones;
    @XmlAttribute(name = "TipoCambioUSD")
    protected BigDecimal tipoCambioUSD;
    @XmlAttribute(name = "TotalUSD")
    protected BigDecimal totalUSD;

    /**
     * Obtiene el valor de la propiedad emisor.
     * 
     * @return
     *     possible object is
     *     {@link ComercioExterior.Emisor }
     *     
     */
    public ComercioExterior.Emisor getEmisor() {
        return emisor;
    }

    /**
     * Define el valor de la propiedad emisor.
     * 
     * @param value
     *     allowed object is
     *     {@link ComercioExterior.Emisor }
     *     
     */
    public void setEmisor(ComercioExterior.Emisor value) {
        this.emisor = value;
    }

    /**
     * Gets the value of the propietario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propietario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropietario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComercioExterior.Propietario }
     * 
     * 
     */
    public List<ComercioExterior.Propietario> getPropietario() {
        if (propietario == null) {
            propietario = new ArrayList<ComercioExterior.Propietario>();
        }
        return this.propietario;
    }

    /**
     * Obtiene el valor de la propiedad receptor.
     * 
     * @return
     *     possible object is
     *     {@link ComercioExterior.Receptor }
     *     
     */
    public ComercioExterior.Receptor getReceptor() {
        return receptor;
    }

    /**
     * Define el valor de la propiedad receptor.
     * 
     * @param value
     *     allowed object is
     *     {@link ComercioExterior.Receptor }
     *     
     */
    public void setReceptor(ComercioExterior.Receptor value) {
        this.receptor = value;
    }

    /**
     * Gets the value of the destinatario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the destinatario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDestinatario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComercioExterior.Destinatario }
     * 
     * 
     */
    public List<ComercioExterior.Destinatario> getDestinatario() {
        if (destinatario == null) {
            destinatario = new ArrayList<ComercioExterior.Destinatario>();
        }
        return this.destinatario;
    }

    /**
     * Obtiene el valor de la propiedad mercancias.
     * 
     * @return
     *     possible object is
     *     {@link ComercioExterior.Mercancias }
     *     
     */
    public ComercioExterior.Mercancias getMercancias() {
        return mercancias;
    }

    /**
     * Define el valor de la propiedad mercancias.
     * 
     * @param value
     *     allowed object is
     *     {@link ComercioExterior.Mercancias }
     *     
     */
    public void setMercancias(ComercioExterior.Mercancias value) {
        this.mercancias = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.1";
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoTraslado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoTraslado() {
        return motivoTraslado;
    }

    /**
     * Define el valor de la propiedad motivoTraslado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoTraslado(String value) {
        this.motivoTraslado = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoOperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Define el valor de la propiedad tipoOperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOperacion(String value) {
        this.tipoOperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad claveDePedimento.
     * 
     * @return
     *     possible object is
     *     {@link CClavePedimento }
     *     
     */
    public CClavePedimento getClaveDePedimento() {
        return claveDePedimento;
    }

    /**
     * Define el valor de la propiedad claveDePedimento.
     * 
     * @param value
     *     allowed object is
     *     {@link CClavePedimento }
     *     
     */
    public void setClaveDePedimento(CClavePedimento value) {
        this.claveDePedimento = value;
    }

    /**
     * Obtiene el valor de la propiedad certificadoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCertificadoOrigen() {
        return certificadoOrigen;
    }

    /**
     * Define el valor de la propiedad certificadoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCertificadoOrigen(Integer value) {
        this.certificadoOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad numCertificadoOrigen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCertificadoOrigen() {
        return numCertificadoOrigen;
    }

    /**
     * Define el valor de la propiedad numCertificadoOrigen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCertificadoOrigen(String value) {
        this.numCertificadoOrigen = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroExportadorConfiable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroExportadorConfiable() {
        return numeroExportadorConfiable;
    }

    /**
     * Define el valor de la propiedad numeroExportadorConfiable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroExportadorConfiable(String value) {
        this.numeroExportadorConfiable = value;
    }

    /**
     * Obtiene el valor de la propiedad incoterm.
     * 
     * @return
     *     possible object is
     *     {@link CINCOTERM }
     *     
     */
    public CINCOTERM getIncoterm() {
        return incoterm;
    }

    /**
     * Define el valor de la propiedad incoterm.
     * 
     * @param value
     *     allowed object is
     *     {@link CINCOTERM }
     *     
     */
    public void setIncoterm(CINCOTERM value) {
        this.incoterm = value;
    }

    /**
     * Obtiene el valor de la propiedad subdivision.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubdivision() {
        return subdivision;
    }

    /**
     * Define el valor de la propiedad subdivision.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubdivision(Integer value) {
        this.subdivision = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCambioUSD.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTipoCambioUSD() {
        return tipoCambioUSD;
    }

    /**
     * Define el valor de la propiedad tipoCambioUSD.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTipoCambioUSD(BigDecimal value) {
        this.tipoCambioUSD = value;
    }

    /**
     * Obtiene el valor de la propiedad totalUSD.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalUSD() {
        return totalUSD;
    }

    /**
     * Define el valor de la propiedad totalUSD.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalUSD(BigDecimal value) {
        this.totalUSD = value;
    }


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
     *         &lt;element name="Domicilio" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
     *                 &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
     *                 &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Estado" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="30"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,30}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *                 &lt;attribute name="CodigoPostal" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="12"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="NumRegIdTrib">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="6"/>
     *             &lt;maxLength value="40"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="Nombre">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="300"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,300}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "domicilio"
    })
    public static class Destinatario {

        @XmlElement(name = "Domicilio", required = true)
        protected List<ComercioExterior.Destinatario.Domicilio> domicilio;
        @XmlAttribute(name = "NumRegIdTrib")
        protected String numRegIdTrib;
        @XmlAttribute(name = "Nombre")
        protected String nombre;

        /**
         * Gets the value of the domicilio property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the domicilio property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDomicilio().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComercioExterior.Destinatario.Domicilio }
         * 
         * 
         */
        public List<ComercioExterior.Destinatario.Domicilio> getDomicilio() {
            if (domicilio == null) {
                domicilio = new ArrayList<ComercioExterior.Destinatario.Domicilio>();
            }
            return this.domicilio;
        }

        /**
         * Obtiene el valor de la propiedad numRegIdTrib.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumRegIdTrib() {
            return numRegIdTrib;
        }

        /**
         * Define el valor de la propiedad numRegIdTrib.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumRegIdTrib(String value) {
            this.numRegIdTrib = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombre(String value) {
            this.nombre = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
         *       &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
         *       &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Estado" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="30"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,30}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
         *       &lt;attribute name="CodigoPostal" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="12"/>
         *             &lt;whiteSpace value="collapse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Domicilio {

            @XmlAttribute(name = "Calle", required = true)
            protected String calle;
            @XmlAttribute(name = "NumeroExterior")
            protected String numeroExterior;
            @XmlAttribute(name = "NumeroInterior")
            protected String numeroInterior;
            @XmlAttribute(name = "Colonia")
            protected String colonia;
            @XmlAttribute(name = "Localidad")
            protected String localidad;
            @XmlAttribute(name = "Referencia")
            protected String referencia;
            @XmlAttribute(name = "Municipio")
            protected String municipio;
            @XmlAttribute(name = "Estado", required = true)
            protected String estado;
            @XmlAttribute(name = "Pais", required = true)
            protected CPais pais;
            @XmlAttribute(name = "CodigoPostal", required = true)
            protected String codigoPostal;

            /**
             * Obtiene el valor de la propiedad calle.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCalle() {
                return calle;
            }

            /**
             * Define el valor de la propiedad calle.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCalle(String value) {
                this.calle = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroExterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroExterior() {
                return numeroExterior;
            }

            /**
             * Define el valor de la propiedad numeroExterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroExterior(String value) {
                this.numeroExterior = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroInterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroInterior() {
                return numeroInterior;
            }

            /**
             * Define el valor de la propiedad numeroInterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroInterior(String value) {
                this.numeroInterior = value;
            }

            /**
             * Obtiene el valor de la propiedad colonia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getColonia() {
                return colonia;
            }

            /**
             * Define el valor de la propiedad colonia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setColonia(String value) {
                this.colonia = value;
            }

            /**
             * Obtiene el valor de la propiedad localidad.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocalidad() {
                return localidad;
            }

            /**
             * Define el valor de la propiedad localidad.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocalidad(String value) {
                this.localidad = value;
            }

            /**
             * Obtiene el valor de la propiedad referencia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReferencia() {
                return referencia;
            }

            /**
             * Define el valor de la propiedad referencia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReferencia(String value) {
                this.referencia = value;
            }

            /**
             * Obtiene el valor de la propiedad municipio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMunicipio() {
                return municipio;
            }

            /**
             * Define el valor de la propiedad municipio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMunicipio(String value) {
                this.municipio = value;
            }

            /**
             * Obtiene el valor de la propiedad estado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEstado() {
                return estado;
            }

            /**
             * Define el valor de la propiedad estado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEstado(String value) {
                this.estado = value;
            }

            /**
             * Obtiene el valor de la propiedad pais.
             * 
             * @return
             *     possible object is
             *     {@link CPais }
             *     
             */
            public CPais getPais() {
                return pais;
            }

            /**
             * Define el valor de la propiedad pais.
             * 
             * @param value
             *     allowed object is
             *     {@link CPais }
             *     
             */
            public void setPais(CPais value) {
                this.pais = value;
            }

            /**
             * Obtiene el valor de la propiedad codigoPostal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPostal() {
                return codigoPostal;
            }

            /**
             * Define el valor de la propiedad codigoPostal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPostal(String value) {
                this.codigoPostal = value;
            }

        }

    }


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
     *         &lt;element name="Domicilio" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
     *                 &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Colonia" />
     *                 &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Localidad" />
     *                 &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
     *                 &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Municipio" />
     *                 &lt;attribute name="Estado" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Estado" />
     *                 &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *                 &lt;attribute name="CodigoPostal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_CodigoPostal" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Curp" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_CURP" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "domicilio"
    })
    public static class Emisor {

        @XmlElement(name = "Domicilio")
        protected ComercioExterior.Emisor.Domicilio domicilio;
        @XmlAttribute(name = "Curp")
        protected String curp;

        /**
         * Obtiene el valor de la propiedad domicilio.
         * 
         * @return
         *     possible object is
         *     {@link ComercioExterior.Emisor.Domicilio }
         *     
         */
        public ComercioExterior.Emisor.Domicilio getDomicilio() {
            return domicilio;
        }

        /**
         * Define el valor de la propiedad domicilio.
         * 
         * @param value
         *     allowed object is
         *     {@link ComercioExterior.Emisor.Domicilio }
         *     
         */
        public void setDomicilio(ComercioExterior.Emisor.Domicilio value) {
            this.domicilio = value;
        }

        /**
         * Obtiene el valor de la propiedad curp.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurp() {
            return curp;
        }

        /**
         * Define el valor de la propiedad curp.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurp(String value) {
            this.curp = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
         *       &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Colonia" />
         *       &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Localidad" />
         *       &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
         *       &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Municipio" />
         *       &lt;attribute name="Estado" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Estado" />
         *       &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
         *       &lt;attribute name="CodigoPostal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_CodigoPostal" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Domicilio {

            @XmlAttribute(name = "Calle", required = true)
            protected String calle;
            @XmlAttribute(name = "NumeroExterior")
            protected String numeroExterior;
            @XmlAttribute(name = "NumeroInterior")
            protected String numeroInterior;
            @XmlAttribute(name = "Colonia")
            protected String colonia;
            @XmlAttribute(name = "Localidad")
            protected String localidad;
            @XmlAttribute(name = "Referencia")
            protected String referencia;
            @XmlAttribute(name = "Municipio")
            protected String municipio;
            @XmlAttribute(name = "Estado", required = true)
            protected CEstado estado;
            @XmlAttribute(name = "Pais", required = true)
            protected CPais pais;
            @XmlAttribute(name = "CodigoPostal", required = true)
            protected String codigoPostal;

            /**
             * Obtiene el valor de la propiedad calle.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCalle() {
                return calle;
            }

            /**
             * Define el valor de la propiedad calle.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCalle(String value) {
                this.calle = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroExterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroExterior() {
                return numeroExterior;
            }

            /**
             * Define el valor de la propiedad numeroExterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroExterior(String value) {
                this.numeroExterior = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroInterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroInterior() {
                return numeroInterior;
            }

            /**
             * Define el valor de la propiedad numeroInterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroInterior(String value) {
                this.numeroInterior = value;
            }

            /**
             * Obtiene el valor de la propiedad colonia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getColonia() {
                return colonia;
            }

            /**
             * Define el valor de la propiedad colonia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setColonia(String value) {
                this.colonia = value;
            }

            /**
             * Obtiene el valor de la propiedad localidad.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocalidad() {
                return localidad;
            }

            /**
             * Define el valor de la propiedad localidad.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocalidad(String value) {
                this.localidad = value;
            }

            /**
             * Obtiene el valor de la propiedad referencia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReferencia() {
                return referencia;
            }

            /**
             * Define el valor de la propiedad referencia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReferencia(String value) {
                this.referencia = value;
            }

            /**
             * Obtiene el valor de la propiedad municipio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMunicipio() {
                return municipio;
            }

            /**
             * Define el valor de la propiedad municipio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMunicipio(String value) {
                this.municipio = value;
            }

            /**
             * Obtiene el valor de la propiedad estado.
             * 
             * @return
             *     possible object is
             *     {@link CEstado }
             *     
             */
            public CEstado getEstado() {
                return estado;
            }

            /**
             * Define el valor de la propiedad estado.
             * 
             * @param value
             *     allowed object is
             *     {@link CEstado }
             *     
             */
            public void setEstado(CEstado value) {
                this.estado = value;
            }

            /**
             * Obtiene el valor de la propiedad pais.
             * 
             * @return
             *     possible object is
             *     {@link CPais }
             *     
             */
            public CPais getPais() {
                return pais;
            }

            /**
             * Define el valor de la propiedad pais.
             * 
             * @param value
             *     allowed object is
             *     {@link CPais }
             *     
             */
            public void setPais(CPais value) {
                this.pais = value;
            }

            /**
             * Obtiene el valor de la propiedad codigoPostal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPostal() {
                return codigoPostal;
            }

            /**
             * Define el valor de la propiedad codigoPostal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPostal(String value) {
                this.codigoPostal = value;
            }

        }

    }


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
     *         &lt;element name="Mercancia" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DescripcionesEspecificas" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Marca" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="35"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,35}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Modelo">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="80"/>
     *                                 &lt;pattern value="[^|]{1,80}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="SubModelo">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="50"/>
     *                                 &lt;pattern value="[^|]{1,50}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="NumeroSerie">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="40"/>
     *                                 &lt;pattern value="[^|]{1,40}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="NoIdentificacion" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="100"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,100}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="FraccionArancelaria" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_FraccionArancelaria" />
     *                 &lt;attribute name="CantidadAduana">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;minInclusive value="0.001"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[0-9]{1,14}(.([0-9]{1,3}))?"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="UnidadAduana" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_UnidadAduana" />
     *                 &lt;attribute name="ValorUnitarioAduana">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;minInclusive value="0.00"/>
     *                       &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ValorDolares" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;minInclusive value="0.00"/>
     *                       &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "mercancia"
    })
    public static class Mercancias {

        @XmlElement(name = "Mercancia", required = true)
        protected List<ComercioExterior.Mercancias.Mercancia> mercancia;

        /**
         * Gets the value of the mercancia property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mercancia property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMercancia().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComercioExterior.Mercancias.Mercancia }
         * 
         * 
         */
        public List<ComercioExterior.Mercancias.Mercancia> getMercancia() {
            if (mercancia == null) {
                mercancia = new ArrayList<ComercioExterior.Mercancias.Mercancia>();
            }
            return this.mercancia;
        }


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
         *         &lt;element name="DescripcionesEspecificas" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Marca" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="35"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,35}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Modelo">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="80"/>
         *                       &lt;pattern value="[^|]{1,80}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="SubModelo">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="50"/>
         *                       &lt;pattern value="[^|]{1,50}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="NumeroSerie">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="40"/>
         *                       &lt;pattern value="[^|]{1,40}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="NoIdentificacion" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="100"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,100}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="FraccionArancelaria" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_FraccionArancelaria" />
         *       &lt;attribute name="CantidadAduana">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;minInclusive value="0.001"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[0-9]{1,14}(.([0-9]{1,3}))?"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="UnidadAduana" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos/ComExt}c_UnidadAduana" />
         *       &lt;attribute name="ValorUnitarioAduana">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;minInclusive value="0.00"/>
         *             &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ValorDolares" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;minInclusive value="0.00"/>
         *             &lt;pattern value="[0-9]{1,16}(.([0-9]{1,2}))?"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "descripcionesEspecificas"
        })
        public static class Mercancia {

            @XmlElement(name = "DescripcionesEspecificas")
            protected List<ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas> descripcionesEspecificas;
            @XmlAttribute(name = "NoIdentificacion", required = true)
            protected String noIdentificacion;
            @XmlAttribute(name = "FraccionArancelaria")
            protected String fraccionArancelaria;
            @XmlAttribute(name = "CantidadAduana")
            protected BigDecimal cantidadAduana;
            @XmlAttribute(name = "UnidadAduana")
            protected String unidadAduana;
            @XmlAttribute(name = "ValorUnitarioAduana")
            protected BigDecimal valorUnitarioAduana;
            @XmlAttribute(name = "ValorDolares", required = true)
            protected BigDecimal valorDolares;

            /**
             * Gets the value of the descripcionesEspecificas property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the descripcionesEspecificas property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDescripcionesEspecificas().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas }
             * 
             * 
             */
            public List<ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas> getDescripcionesEspecificas() {
                if (descripcionesEspecificas == null) {
                    descripcionesEspecificas = new ArrayList<ComercioExterior.Mercancias.Mercancia.DescripcionesEspecificas>();
                }
                return this.descripcionesEspecificas;
            }

            /**
             * Obtiene el valor de la propiedad noIdentificacion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNoIdentificacion() {
                return noIdentificacion;
            }

            /**
             * Define el valor de la propiedad noIdentificacion.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNoIdentificacion(String value) {
                this.noIdentificacion = value;
            }

            /**
             * Obtiene el valor de la propiedad fraccionArancelaria.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFraccionArancelaria() {
                return fraccionArancelaria;
            }

            /**
             * Define el valor de la propiedad fraccionArancelaria.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFraccionArancelaria(String value) {
                this.fraccionArancelaria = value;
            }

            /**
             * Obtiene el valor de la propiedad cantidadAduana.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getCantidadAduana() {
                return cantidadAduana;
            }

            /**
             * Define el valor de la propiedad cantidadAduana.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setCantidadAduana(BigDecimal value) {
                this.cantidadAduana = value;
            }

            /**
             * Obtiene el valor de la propiedad unidadAduana.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnidadAduana() {
                return unidadAduana;
            }

            /**
             * Define el valor de la propiedad unidadAduana.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnidadAduana(String value) {
                this.unidadAduana = value;
            }

            /**
             * Obtiene el valor de la propiedad valorUnitarioAduana.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValorUnitarioAduana() {
                return valorUnitarioAduana;
            }

            /**
             * Define el valor de la propiedad valorUnitarioAduana.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValorUnitarioAduana(BigDecimal value) {
                this.valorUnitarioAduana = value;
            }

            /**
             * Obtiene el valor de la propiedad valorDolares.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValorDolares() {
                return valorDolares;
            }

            /**
             * Define el valor de la propiedad valorDolares.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValorDolares(BigDecimal value) {
                this.valorDolares = value;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Marca" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="35"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,35}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Modelo">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="80"/>
             *             &lt;pattern value="[^|]{1,80}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="SubModelo">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="50"/>
             *             &lt;pattern value="[^|]{1,50}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="NumeroSerie">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="40"/>
             *             &lt;pattern value="[^|]{1,40}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class DescripcionesEspecificas {

                @XmlAttribute(name = "Marca", required = true)
                protected String marca;
                @XmlAttribute(name = "Modelo")
                protected String modelo;
                @XmlAttribute(name = "SubModelo")
                protected String subModelo;
                @XmlAttribute(name = "NumeroSerie")
                protected String numeroSerie;

                /**
                 * Obtiene el valor de la propiedad marca.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMarca() {
                    return marca;
                }

                /**
                 * Define el valor de la propiedad marca.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMarca(String value) {
                    this.marca = value;
                }

                /**
                 * Obtiene el valor de la propiedad modelo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getModelo() {
                    return modelo;
                }

                /**
                 * Define el valor de la propiedad modelo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setModelo(String value) {
                    this.modelo = value;
                }

                /**
                 * Obtiene el valor de la propiedad subModelo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSubModelo() {
                    return subModelo;
                }

                /**
                 * Define el valor de la propiedad subModelo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSubModelo(String value) {
                    this.subModelo = value;
                }

                /**
                 * Obtiene el valor de la propiedad numeroSerie.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumeroSerie() {
                    return numeroSerie;
                }

                /**
                 * Define el valor de la propiedad numeroSerie.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumeroSerie(String value) {
                    this.numeroSerie = value;
                }

            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="NumRegIdTrib" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="6"/>
     *             &lt;maxLength value="40"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="ResidenciaFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Propietario {

        @XmlAttribute(name = "NumRegIdTrib", required = true)
        protected String numRegIdTrib;
        @XmlAttribute(name = "ResidenciaFiscal", required = true)
        protected CPais residenciaFiscal;

        /**
         * Obtiene el valor de la propiedad numRegIdTrib.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumRegIdTrib() {
            return numRegIdTrib;
        }

        /**
         * Define el valor de la propiedad numRegIdTrib.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumRegIdTrib(String value) {
            this.numRegIdTrib = value;
        }

        /**
         * Obtiene el valor de la propiedad residenciaFiscal.
         * 
         * @return
         *     possible object is
         *     {@link CPais }
         *     
         */
        public CPais getResidenciaFiscal() {
            return residenciaFiscal;
        }

        /**
         * Define el valor de la propiedad residenciaFiscal.
         * 
         * @param value
         *     allowed object is
         *     {@link CPais }
         *     
         */
        public void setResidenciaFiscal(CPais value) {
            this.residenciaFiscal = value;
        }

    }


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
     *         &lt;element name="Domicilio" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
     *                 &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
     *                 &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
     *                 &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
     *                 &lt;attribute name="Estado" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="30"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,30}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *                 &lt;attribute name="CodigoPostal" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="12"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="NumRegIdTrib">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="6"/>
     *             &lt;maxLength value="40"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "domicilio"
    })
    public static class Receptor {

        @XmlElement(name = "Domicilio")
        protected ComercioExterior.Receptor.Domicilio domicilio;
        @XmlAttribute(name = "NumRegIdTrib")
        protected String numRegIdTrib;

        /**
         * Obtiene el valor de la propiedad domicilio.
         * 
         * @return
         *     possible object is
         *     {@link ComercioExterior.Receptor.Domicilio }
         *     
         */
        public ComercioExterior.Receptor.Domicilio getDomicilio() {
            return domicilio;
        }

        /**
         * Define el valor de la propiedad domicilio.
         * 
         * @param value
         *     allowed object is
         *     {@link ComercioExterior.Receptor.Domicilio }
         *     
         */
        public void setDomicilio(ComercioExterior.Receptor.Domicilio value) {
            this.domicilio = value;
        }

        /**
         * Obtiene el valor de la propiedad numRegIdTrib.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumRegIdTrib() {
            return numRegIdTrib;
        }

        /**
         * Define el valor de la propiedad numRegIdTrib.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumRegIdTrib(String value) {
            this.numRegIdTrib = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="Calle" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip100" />
         *       &lt;attribute name="NumeroExterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="NumeroInterior" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_NumeroDomicilio" />
         *       &lt;attribute name="Colonia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Localidad" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Referencia" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Referencia" />
         *       &lt;attribute name="Municipio" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Descrip120" />
         *       &lt;attribute name="Estado" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="30"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,30}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Pais" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
         *       &lt;attribute name="CodigoPostal" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="12"/>
         *             &lt;whiteSpace value="collapse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Domicilio {

            @XmlAttribute(name = "Calle", required = true)
            protected String calle;
            @XmlAttribute(name = "NumeroExterior")
            protected String numeroExterior;
            @XmlAttribute(name = "NumeroInterior")
            protected String numeroInterior;
            @XmlAttribute(name = "Colonia")
            protected String colonia;
            @XmlAttribute(name = "Localidad")
            protected String localidad;
            @XmlAttribute(name = "Referencia")
            protected String referencia;
            @XmlAttribute(name = "Municipio")
            protected String municipio;
            @XmlAttribute(name = "Estado", required = true)
            protected String estado;
            @XmlAttribute(name = "Pais", required = true)
            protected CPais pais;
            @XmlAttribute(name = "CodigoPostal", required = true)
            protected String codigoPostal;

            /**
             * Obtiene el valor de la propiedad calle.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCalle() {
                return calle;
            }

            /**
             * Define el valor de la propiedad calle.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCalle(String value) {
                this.calle = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroExterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroExterior() {
                return numeroExterior;
            }

            /**
             * Define el valor de la propiedad numeroExterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroExterior(String value) {
                this.numeroExterior = value;
            }

            /**
             * Obtiene el valor de la propiedad numeroInterior.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroInterior() {
                return numeroInterior;
            }

            /**
             * Define el valor de la propiedad numeroInterior.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroInterior(String value) {
                this.numeroInterior = value;
            }

            /**
             * Obtiene el valor de la propiedad colonia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getColonia() {
                return colonia;
            }

            /**
             * Define el valor de la propiedad colonia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setColonia(String value) {
                this.colonia = value;
            }

            /**
             * Obtiene el valor de la propiedad localidad.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLocalidad() {
                return localidad;
            }

            /**
             * Define el valor de la propiedad localidad.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLocalidad(String value) {
                this.localidad = value;
            }

            /**
             * Obtiene el valor de la propiedad referencia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReferencia() {
                return referencia;
            }

            /**
             * Define el valor de la propiedad referencia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReferencia(String value) {
                this.referencia = value;
            }

            /**
             * Obtiene el valor de la propiedad municipio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMunicipio() {
                return municipio;
            }

            /**
             * Define el valor de la propiedad municipio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMunicipio(String value) {
                this.municipio = value;
            }

            /**
             * Obtiene el valor de la propiedad estado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEstado() {
                return estado;
            }

            /**
             * Define el valor de la propiedad estado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEstado(String value) {
                this.estado = value;
            }

            /**
             * Obtiene el valor de la propiedad pais.
             * 
             * @return
             *     possible object is
             *     {@link CPais }
             *     
             */
            public CPais getPais() {
                return pais;
            }

            /**
             * Define el valor de la propiedad pais.
             * 
             * @param value
             *     allowed object is
             *     {@link CPais }
             *     
             */
            public void setPais(CPais value) {
                this.pais = value;
            }

            /**
             * Obtiene el valor de la propiedad codigoPostal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoPostal() {
                return codigoPostal;
            }

            /**
             * Define el valor de la propiedad codigoPostal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoPostal(String value) {
                this.codigoPostal = value;
            }

        }

    }

}
