package mx.sat.cfd40;

import DAO.daoempresa;
import Modelo.Empresas;
import Modelo.Sellofiscal;
import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDICancelacion;
import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDICertificacion;
import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDIResultadoCancelacion;
import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDIResultadoCertificacion;
import com.solucionfactible.ws.timbrado.client.Timbrado;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class timbrarXML {

//    Connection conexion = Conexion.Conexion.getRCPTPhylon();
    Connection conexion;
//    convertirNumeros numeros = new convertirNumeros();

    String selloSAT = "", cadenaOriginal = "", PAC = "", uuid = "", selloCFD = "", fechaCer = "", noCertificado = "";
    String literal = "";
    String estado = "";
    Sellofiscal s = new Sellofiscal();
    boolean produccion = false;
    String user = "testing@solucionfactible.com";
    String pass = "timbrado.SF.16672";

//    String user = "facturacion.ath.sfb@hotmail.com";
//    String pass = "Y9#w2U&D1j";
    /**
     *
     * @param factura numero de factura en este formato FAC_12345
     * @param total No se usa
     * @param c Conexion a la bd de la empresa de sqlite
     * @param nempresa Empresa a usar, athletic, uptown va referenciado con la
     * llave primaria de los registros de la empresa
     * @return
     */
    public Sellofiscal timbrar(String factura, String total, Connection c, String nempresa) {
        //Bd de empresas y directorios
        daoempresa d = new daoempresa();
        Empresas e = d.getempresarfc(c, nempresa);
        String rutaXML = e.getXml() + "\\" + factura + ".xml";
        if (produccion) {// solo lo tomara 
            user = e.getUsuariopac();
            pass = e.getPasspac();
        }
        System.out.println(e.getNombre() + " user " + user);
        // Fin de carga de datos de la empresa seleccionada
        Timbrado timbrado = new Timbrado();
        try {
            CFDICertificacion cert = timbrado.timbrar(user, pass, rutaXML, produccion);
//            System.out.println("1 WS Producción: " + (produccion ? "Si" : "No"));
//            System.out.println("2 Status:  " + cert.getStatus());// si bien 200
//            System.out.println("3 Mensaje: " + cert.getMensaje());
            CFDIResultadoCertificacion[] resultados = cert.getResultados();

            if (resultados != null) {
                for (CFDIResultadoCertificacion r : resultados) {
                    if (r != null) {
                        int rStatus = r.getStatus();
                        int j = 0;
//                        Se usa el ciclo porque no deja gaurdarse en un string directo
                        for (int i = 0; i < r.getMensaje().length(); i++) {
                            if (j == 80) {
                                estado += r.getMensaje().charAt(i) + "\n";
                                j = 0;
                            } else {
                                estado += r.getMensaje().charAt(i);
                            }
                            j++;
                        }
                        s.setEstado(estado);
                        System.out.println(String.format("estadus [%d] %s", rStatus, r.getMensaje()) + "??");
                        //Operación creada exitosamente o previamente ya creado

                        if (rStatus == 200) {
                            System.out.println(String.format("CFDI timbrado con folio: %s", r.getUuid()));
                            System.out.println(String.format("Certificado SAT: %s", r.getSelloSAT()));
                            System.out.println("Cadena original del Timbre Fiscal digital: " + r.getCadenaOriginal());
                            System.out.println("XML de CFDI con Timbre Fiscal Digital:");
                            //El CFDI con el TimbreFiscalDigital ya incluido
//                            System.out.println(new String(r.getCfdiTimbrado()));
                            //Se usa la libreria de apache commons codec.
//                            String qrCodeB64 = new String(org.apache.commons.codec.binary.Base64.encodeBase64(r.getQrCode()));
//                            System.out.println("QRCode en base64: " + qrCodeB64);
//                            System.out.println(r.getQrCode());
                            //Crear xml con los datos
//                            generarQR(qrCodeB64);
                            cadenaOriginal = r.getCadenaOriginal();
//                            literal = numeros.Convertir(total, true);
                            crearXML(factura, new String(r.getCfdiTimbrado()), e.getXml());
//                            System.out.println("UUID: " + uuid);
                        }
//                        System.out.println();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public Sellofiscal timbrarpago(String factura, Connection c, String nempresa) {
        //Bd de empresas y directorios
        daoempresa d = new daoempresa();
        Empresas e = d.getempresarfc(c, nempresa);
        String rutaXML = e.getXml() + "\\" + factura + ".xml";
        Timbrado timbrado = new Timbrado();
        try {
            CFDICertificacion cert = timbrado.timbrar(user, pass, rutaXML, produccion);
//            System.out.println("1 WS Producción: " + (produccion ? "Si" : "No"));
//            System.out.println("2 Status:  " + cert.getStatus());// si bien 200
//            System.out.println("3 Mensaje: " + cert.getMensaje());
            CFDIResultadoCertificacion[] resultados = cert.getResultados();

            if (resultados != null) {
                for (CFDIResultadoCertificacion r : resultados) {
                    if (r != null) {
                        int rStatus = r.getStatus();
                        int j = 0;
//                        Se usa el ciclo porque no deja gaurdarse en un string directo
                        for (int i = 0; i < r.getMensaje().length(); i++) {
                            if (j == 80) {
                                estado += r.getMensaje().charAt(i) + "\n";
                                j = 0;
                            } else {
                                estado += r.getMensaje().charAt(i);
                            }
                            j++;
                        }
                        s.setEstado(estado);
//                        System.out.println(String.format("estadus [%d] %s", rStatus, r.getMensaje()) + "??");
                        //Operación creada exitosamente o previamente ya creado

                        if (rStatus == 200) {
                            String qrCodeB64 = new String(org.apache.commons.codec.binary.Base64.encodeBase64(r.getQrCode()));;
                            //Crear xml con los datos
                            cadenaOriginal = r.getCadenaOriginal();
                            crearXML(factura, new String(r.getCfdiTimbrado()), e.getXml());
//                            System.out.println("UUID: " + uuid);
                        }
//                        System.out.println();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    private void crearXML(String factura, String xml, String dic) {
        try {
            String ruta = dic + "\\" + factura + ".xml";
//            String ruta = dic+"\\pfa.xml";
            String contenido = xml;
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            leerXML(factura, dic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void leerXML(String factura, String dic) {
        System.out.println("Leeyendo XML");
        try {
            String archivo = dic + "\\" + factura + ".xml";
            Document doc;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();
            NodeList complemento = doc.getElementsByTagName("tfd:TimbreFiscalDigital");
            for (int i = 0; i < complemento.getLength(); i++) {
                Node nNode = complemento.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    selloSAT = element.getAttribute("SelloSAT");
                    noCertificado = element.getAttribute("NoCertificadoSAT");
                    selloCFD = element.getAttribute("SelloCFD");
                    PAC = element.getAttribute("RfcProvCertif");
                    fechaCer = element.getAttribute("FechaTimbrado");
                    uuid = element.getAttribute("UUID");
                    s.setSellosat(selloSAT);
                    s.setNoceertificado(noCertificado);
                    s.setSellocfd(selloCFD);
                    s.setPac(PAC);
                    s.setFechacer(fechaCer);
                    s.setUuid(uuid);
                }
            }
//            cargarPDF(factura,total);
        } catch (IOException | ParserConfigurationException | SAXException e) {
        }
    }

    public boolean getprod() {
        return produccion;
    }

//    private void generarQR(String cadena) throws FileNotFoundException, IOException {
//
//        final int qrAncho = 180;
//        final int qrAlto = 180;
//        final String formato = "png";
//        final String ruta = "C:/CFDI/CFDI40/QR/facturaQR.png";
//
//        BitMatrix matrix = null;
//        Writer wr = new QRCodeWriter();
//        
//        try {
//            matrix = wr.encode(cadena, BarcodeFormat.QR_CODE, qrAlto, qrAncho);
//        } catch (WriterException ex) {
//            ex.printStackTrace();
//        }
//        
//        BufferedImage imagen = new BufferedImage(qrAlto, qrAncho, BufferedImage.TYPE_INT_RGB);
//
//        for (int i = 0; i < qrAlto; i++) {
//            for (int j = 0; j < qrAncho; j++) {
//                int valor = (matrix.get(i, j) ? 0 : 1) & 0xff;
//                imagen.setRGB(i, j, (valor == 0 ? 0 : 0xFFFFFF));
//            }
//        }
//        
//        FileOutputStream codigo = new FileOutputStream(ruta);
//        ImageIO.write(imagen, formato, codigo);
//
//    }
//    private void cargarPDF(String factura, String total) {
//        try {
//            JasperReport reporte;
//            
//            reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream("/RPT/factura.jasper"));
//            try {
//                Map par = new HashMap();
//                par.put("factura", factura);
//                par.put("cadenaOr", cadenaOriginal);
//                par.put("folioFiscal", uuid);
//                par.put("rfcPAC", PAC);
//                par.put("selloDigital", selloCFD);
//                par.put("selloSAT", selloSAT);
//                par.put("fecha", fechaCer);
//                par.put("cer", noCertificado);
//                par.put("letra", literal);
//
//                JasperPrint jprint = JasperFillManager.fillReport(reporte, par, conexion);
//                JasperViewer view = new JasperViewer(jprint, false);
//
//                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                view.setVisible(true);
//                view.setTitle("TOP-SUELAS");
//
//            } catch (JRException ex) {
//            }
//        } catch (JRException ex) {
//            ex.printStackTrace();
//        }
//    }
    /**
     *
     * @param factura factura en este forrmato FAC_123456
     * @param c Conexion empresa
     * @param nempresa Numero de empresa
     * @param uuidd uuid de la factura
     * @return
     */
    public String cancelarfolio(String factura, Connection c, String nempresa, String uuidd) {
        String l = "";
        try {
            //Bd de empresas y directorios
            daoempresa d = new daoempresa();
            Empresas e = d.getempresarfc(c, nempresa);
            Timbrado timbrado = new Timbrado();
            String[] arruuid = {uuidd + "|03|"};
            CFDICancelacion a = timbrado.cancelar(user, pass, arruuid, e.getCertificado(), e.getKey(), e.getPass(), produccion);
            CFDIResultadoCancelacion[] re = a.getResultados();
            if (re != null) {
                for (CFDIResultadoCancelacion cfd : re) {
                    l = cfd.getMensaje() + ", Estatus: " + cfd.getStatus() + ", " + cfd.getStatusUUID();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(timbrarXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
}
