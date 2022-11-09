package mx.sat.cfd40;


import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDICertificacion;
import com.solucionfactible.cfdi.ws.timbrado.xsd.CFDIResultadoCertificacion;
import com.solucionfactible.ws.timbrado.client.Timbrado;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class timbrarXML {

//    Connection conexion = Conexion.Conexion.getRCPTPhylon();
    Connection conexion ;
    convertirNumeros numeros = new convertirNumeros();
    
    String selloSAT = "", cadenaOriginal = "", PAC = "", uuid = "", selloCFD = "", fechaCer = "", noCertificado = "";
    String literal = "";

    public void timbrar(String factura, String total) {

        String user = "testing@solucionfactible.com";
        String pass = "timbrado.SF.16672";
        String rutaXML = "C:\\CFDI\\CFDI40\\XML\\" + factura + ".xml";
        boolean produccion = false;

        Timbrado timbrado = new Timbrado();

        try {
            CFDICertificacion cert = timbrado.timbrar(user, pass, rutaXML, produccion);

            System.out.println("WS Producción: " + (produccion ? "Si" : "No"));
            System.out.println("Status:  " + cert.getStatus());// si bien 200
            System.out.println("Mensaje: " + cert.getMensaje());

            CFDIResultadoCertificacion[] resultados = cert.getResultados();

            if (resultados != null) {
                for (CFDIResultadoCertificacion r : resultados) {
                    if (r != null) {
                        int rStatus = r.getStatus();
                        System.out.println(String.format("[%d] %s", rStatus, r.getMensaje()));
                        //Operación creada exitosamente o previamente ya creado

                        if (rStatus == 200) {
                            
                            System.out.println(String.format("CFDI timbrado con folio: %s", r.getUuid()));
                            System.out.println(String.format("Certificado SAT: %s", r.getSelloSAT()));
                            System.out.println("Cadena original del Timbre Fiscal digital: " + r.getCadenaOriginal());
                            System.out.println("XML de CFDI con Timbre Fiscal Digital:");
                            //El CFDI con el TimbreFiscalDigital ya incluido
                            System.out.println(new String(r.getCfdiTimbrado()));
                            //Se usa la libreria de apache commons codec.
                            String qrCodeB64 = new String(org.apache.commons.codec.binary.Base64.encodeBase64(r.getQrCode()));
                            System.out.println("QRCode en base64: " + qrCodeB64);
                            //Crear xml con los datos
//                            generarQR(qrCodeB64);
                            cadenaOriginal = r.getCadenaOriginal();
                            literal = numeros.Convertir(total, true);
                            crearXML(factura, new String(r.getCfdiTimbrado()),total);
                        }
                        System.out.println();
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearXML(String factura, String xml, String total) {
        try {
            String ruta = "C:\\CFDI\\CFDI40\\XML_TIMBRADOS\\" + factura + ".xml";
            String contenido = xml;

            File file = new File(ruta);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            leerXML(factura, total);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void leerXML(String factura,String total) {

        System.out.println("Leeyendo XML");

        try {
            String archivo = "C:\\CFDI\\CFDI40\\XML_TIMBRADOS\\" + factura + ".xml";
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
                }
            }

//            cargarPDF(factura,total);

        } catch (IOException | ParserConfigurationException | SAXException e) {
        }
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

}
