package mx.sat.cfd40;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.xerces.impl.dv.util.Base64;

public class generarXML40 {


    //String urlCER = mConfig.getCer();
    //String urlKEY = mConfig.getKey();
    String password = "AFO901221IC2";
   
    //String RFC = mConfig.getRFC();
    //String RZ = mConfig.getRZ();
    String RZ = "ATHLETIC FOOTWEAR";
    String RFC = "AFO901221IC2";
    String RF = "601";
    String lugar="36400";
    //String RF = mConfig.getRF();

    public void crearComprobante(xmlDAO encabezado, ArrayList<xmlDAO> data) throws Exception {

        String urlCER = "C:\\ESD\\00001000000505860961.cer";
        String urlKEY = "C:\\ESD\\CSD_PMA_AFO901221IC2_20201130_141544.key";
        XMLGregorianCalendar fecha = null;
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(sdf.format(date));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }

        ObjectFactory of = new ObjectFactory();
        Comprobante xml = of.createComprobante();

        //Datos generales
        xml.setVersion("4.0");
        xml.setExportacion("01");
        xml.setSerie(encabezado.getSerie());
        xml.setFolio(encabezado.getFolio());
        xml.setFecha(fecha);
        xml.setFormaPago(encabezado.getFormaP());
        xml.setCondicionesDePago(encabezado.getDescripcionP());
        xml.setDescuento(encabezado.getDescuentoG());
        

        //Totales, tipo comprobante
        xml.setSubTotal(encabezado.getSubT().setScale(2, RoundingMode.HALF_UP));
        //xml.setDescuento(encabezado.getDescuento().setScale(2, RoundingMode.HALF_UP));
        xml.setMoneda(CMoneda.MXN);
        // xml.setTipoCambio(objDAO.getTipoC());
        xml.setTotal(encabezado.getTotal().setScale(2, RoundingMode.HALF_UP));
        xml.setTipoDeComprobante(CTipoDeComprobante.I);

        switch (encabezado.getMetodoPago()) {
            case "PUE":
                xml.setMetodoPago(CMetodoPago.PUE);
                break;
            case "PPD":
                xml.setMetodoPago(CMetodoPago.PPD);
                break;
            case "PIP":
                xml.setMetodoPago(CMetodoPago.PIP);
                break;
        }

        xml.setLugarExpedicion(lugar);

        //Datos del emisor
        xml.setEmisor(createEmisor(of));

        //Datos del receptor
        xml.setReceptor(createReceptor(of,encabezado));

        //Conceptos
        xml.setConceptos(createConceptos(of, data));

        //Impuestos
        xml.setImpuestos(createImpuestos(of, encabezado));

        //Extraer archivos .cer  .key
        File cer = new File(urlCER);
        File key = new File(urlKEY);

        //Agregar certificado y no. de certificado al comprobante por medio del archivo .cer del contribuyente
        X509Certificate x509Cer = getX509Certificate(cer);// Metodo de sellado
        String certificado = getCertificadoBase64(x509Cer);
        String noCertificado = getNoCertificado(x509Cer);
        xml.setCertificado(certificado);//añadir al comprobante
        xml.setNoCertificado(noCertificado);

        //Despues de asignar los valores al xml, guardar el comprobante y realizar el sellado digital
        String cadenaXML = jaxbObjectToXML(xml);

        String cadenaOriginal = "";
        PrivateKey llavePrivada = null;
        String selloDigital = "";

        try {
            cadenaOriginal = generarCadenaOriginal(cadenaXML);
        } catch (TransformerException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Utilizar el archivo .key del contribuyente, ademas de la contraseña correspondiente
        llavePrivada = getPrivateKey(key, password);

        //Asignar el sello digital como texto
        selloDigital = generarSelloDigital(llavePrivada, cadenaOriginal);

        //Agregar el sello digital al xml
        xml.setSello(selloDigital);

        String COMPROBANTE_XML = "C:\\af\\filesfac\\" + encabezado.getSerie() + "-" + encabezado.getFolio() + ".xml";

        JAXBContext context = JAXBContext.newInstance(Comprobante.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new DeafultNamespacePrefixMapper());
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/4 http://www.sat.gob.mx/sitio_internet/cfd/4/cfdv40.xsd");

        //Compilar
        m.marshal(xml, new File(COMPROBANTE_XML));

    }

    //Metodos
    private Comprobante.Emisor createEmisor(ObjectFactory of) {//Emisor
        Comprobante.Emisor emisor = of.createComprobanteEmisor();
        emisor.setRegimenFiscal(RF);
        emisor.setNombre(RZ);
        emisor.setRfc(RFC);
        
        return emisor;
    }

    private Comprobante.Receptor createReceptor(ObjectFactory of, xmlDAO obj) {//Receptor
        Comprobante.Receptor receptor = of.createComprobanteReceptor();
        receptor.setNombre(obj.getReceptor());
        receptor.setRfc(obj.getRfcR());
        
        switch(obj.getUsoCfdi()){
            case "G01":
                     receptor.setUsoCFDI(CUsoCFDI.G_01);
            break;
            case "G03":
                     receptor.setUsoCFDI(CUsoCFDI.G_03);
            break;
            case "P01":
                     receptor.setUsoCFDI(CUsoCFDI.P_01);
            break;
            case "G02":
                     receptor.setUsoCFDI(CUsoCFDI.G_02);
            break;
            case "D01":
                     receptor.setUsoCFDI(CUsoCFDI.D_01);
            break;
            case "S01":
                     receptor.setUsoCFDI(CUsoCFDI.S_01);
            break;
            
        }
        receptor.setRegimenFiscalReceptor(obj.getRegimenFR());
        receptor.setDomicilioFiscalReceptor(obj.getDomicilioReceptor());
        return receptor;
    }

    private Comprobante.Conceptos createConceptos(ObjectFactory of, ArrayList<xmlDAO> data) {//conceptos
        Comprobante.Conceptos cps = of.createComprobanteConceptos();
        List<Comprobante.Conceptos.Concepto> list = cps.getConcepto();

        for (int i = 0; i < data.size(); i++) {
            Comprobante.Conceptos.Concepto c = of.createComprobanteConceptosConcepto();
            c.setObjetoImp("02");
            c.setImporte(data.get(i).getImporte().setScale(2, RoundingMode.HALF_UP));
//            c.setDescuento(data.get(i).getDescuento().setScale(2, RoundingMode.HALF_UP));
            c.setValorUnitario(data.get(i).getValorUnitario());
            c.setDescripcion(data.get(i).getDescripcion());
            c.setClaveUnidad(data.get(i).getClaveUn());
            c.setCantidad(data.get(i).getCantidad());
            c.setNoIdentificacion(data.get(i).getNoIdenf());
            c.setClaveProdServ(data.get(i).getClaveProdServ());
            c.setUnidad(data.get(i).getUnidad());
            c.setImpuestos(createImpuestosConcepto(of, data.get(i).getImporteImpuesto(),
                    data.get(i).getBase(), "002", data.get(i).getTasaCuota()));
            list.add(c);
        }

        return cps;
    }

    private Comprobante.Conceptos.Concepto.Impuestos createImpuestosConcepto(ObjectFactory of, BigDecimal importe, BigDecimal base, String imp, BigDecimal TasaC) {

        Comprobante.Conceptos.Concepto.Impuestos imps = of.createComprobanteConceptosConceptoImpuestos();

        //Bloque para impuestos trasladados
        Comprobante.Conceptos.Concepto.Impuestos.Traslados trs = of.createComprobanteConceptosConceptoImpuestosTraslados();
        List<Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado> list = trs.getTraslado();
        Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado t1 = of.createComprobanteConceptosConceptoImpuestosTrasladosTraslado();
        t1.setImporte(importe.setScale(2, RoundingMode.HALF_UP));//Impuesto del renglon
        t1.setBase(base.setScale(2, RoundingMode.HALF_UP));//Total del renglon
        t1.setImpuesto(imp);
        t1.setTipoFactor(CTipoFactor.TASA);
        t1.setTasaOCuota(TasaC);
        

        list.add(t1);

        imps.setTraslados(trs);

        return imps;
    }

    private Comprobante.Impuestos createImpuestos(ObjectFactory of, xmlDAO obj) {// impuestos trasladados
        Comprobante.Impuestos impus = of.createComprobanteImpuestos();
        impus.setTotalImpuestosTrasladados(obj.getTotalImpuesto());

        //Bloque para los impuestos trasladados
        Comprobante.Impuestos.Traslados tras = of.createComprobanteImpuestosTraslados();
        List<Comprobante.Impuestos.Traslados.Traslado> list = tras.getTraslado();
        Comprobante.Impuestos.Traslados.Traslado t1 = of.createComprobanteImpuestosTrasladosTraslado();
        t1.setImporte(obj.getTotalImpuesto().setScale(2, RoundingMode.HALF_UP));
        t1.setBase(obj.getBaseImpuesto().setScale(2, RoundingMode.HALF_UP));
        t1.setTasaOCuota(obj.getTasaCuota());
        t1.setTipoFactor(CTipoFactor.TASA);
        t1.setImpuesto(obj.getImpuesto());
        list.add(t1);
        impus.setTraslados(tras);
        return impus;
    }

    //Metodos de sellado
    private X509Certificate getX509Certificate(final File certificateFile) throws CertificateException, IOException {
        FileInputStream is = null;

        try {
            is = new FileInputStream(certificateFile);
            CertificateFactory of = CertificateFactory.getInstance("X.509");
            return (X509Certificate) of.generateCertificate(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private String getCertificadoBase64(final X509Certificate cert) throws CertificateEncodingException {
        return new String(Base64.encode(cert.getEncoded()));
    }

    private String getNoCertificado(final X509Certificate cert) {
        BigInteger serial = cert.getSerialNumber();
        byte[] sArr = serial.toByteArray();
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < sArr.length; i++) {
            buffer.append((char) sArr[i]);
        }

        return buffer.toString();
    }

    private String jaxbObjectToXML(Comprobante xml) {
        String xmlString = "";

        try {
            JAXBContext context = JAXBContext.newInstance(Comprobante.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(xml, sw);
            xmlString = sw.toString();

        } catch (JAXBException ex) {
            System.out.println(ex.getMessage());
        }
        return xmlString;
    }

    private String generarCadenaOriginal(final String xml) throws TransformerException {
        StreamSource streamS = new StreamSource("C:/af/filesfac/cadenaoriginal_4_0.xslt");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer xlsTransformer = transformerFactory.newTransformer(streamS);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        xlsTransformer.transform(new StreamSource(new StringReader(xml)), new StreamResult(output));

        String resultado = "";

        try {
            resultado = output.toString("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    private PrivateKey getPrivateKey(final File keyFile, final String password) throws GeneralSecurityException, IOException {

        FileInputStream in = new FileInputStream(keyFile);
        org.apache.commons.ssl.PKCS8Key pkcs8 = new org.apache.commons.ssl.PKCS8Key(in, password.toCharArray());

        byte[] decrypted = pkcs8.getDecryptedBytes();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decrypted);
        PrivateKey pk;

        if (pkcs8.isDSA()) {
            pk = KeyFactory.getInstance("DSA").generatePrivate(spec);
        } else if (pkcs8.isRSA()) {
            pk = KeyFactory.getInstance("RSA").generatePrivate(spec);
        }

        pk = pkcs8.getPrivateKey();
        return pk;
    }

    private String generarSelloDigital(final PrivateKey key, final String cadenaOriginal)
            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {

        Signature sing = Signature.getInstance("SHA256withRSA");
        sing.initSign(key, new SecureRandom());

        try {
            sing.update(cadenaOriginal.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(generarXML40.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] signature = sing.sign();
        return new String(Base64.encode(signature));
    }
}
