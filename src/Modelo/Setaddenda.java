/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author GATEWAY1-
 */
public class Setaddenda {

    String archivo = "";
    factura f;

    public Setaddenda(String archivo, factura f) {
        this.archivo = archivo;
        this.f = f;
    }

    /**
     * Contruye todo el nodo correspondiente a la addenda
     *
     * @return
     */
    public String Construyeaddenda() {
        try {
            Document doc;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();
//            NodeList comp1 = doc.getElementsByTagName("cfdi:Conceptos");

            Node ar = doc.getElementsByTagName("cfdi:Comprobante").item(0);
            Element ad = doc.createElement("cfdi:Addenda");
//            Nodo principal, requestpayment
            Element requestpayment = doc.createElement("requestForPayment");
            requestpayment.setAttribute("DeliveryDate", "2023-02-09");
            requestpayment.setAttribute("documentStatus", "ORIGINAL");
            requestpayment.setAttribute("documentStructureVersion", "CPLR1.0");
            requestpayment.setAttribute("contentVersion", "1.0");
            requestpayment.setAttribute("type", "SimpleInvoiceType");
            ad.appendChild(requestpayment);
            //Nodos extra dentro de requestfor payment
            ad.appendChild(getRequestforpaymentidentification(doc, "FAC14512"));
            ad.appendChild(getOrderIdentification(doc, f));
            ad.appendChild(getSeller(doc, f));
            ad.appendChild(getShipto(doc, "1", "BODEGA COPPEL CULIACAN"));
            ad.appendChild(getcurrency(doc));
            ad.appendChild(getTotallotes(doc, 2));
            ad.appendChild(getlineItem(doc, f));
            ad.appendChild(getTotalamouunt(doc, 0));
            ad.appendChild(getTotalallowance(doc));
            ar.appendChild(ad);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Setaddenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Nodo dee request for paymentident
     *
     * @param doc objeto del xml
     * @param folio ej FAC452654
     * @return
     */
    private Element getRequestforpaymentidentification(Document doc, String folio) {
        Element r = doc.createElement("requestForPaymentIdentification");
        Element entity = doc.createElement("entityType");
        Element unique = doc.createElement("uniqueCreatorIdentification");
        entity.setTextContent(folio);
        unique.setTextContent("INVOICE");
        r.appendChild(entity);
        r.appendChild(unique);
//        r.setAttribute("entityTypr", "INVOICE");
//        r.setAttribute("uniqueCreatorIdentification", folio);
        return r;
    }

    /**
     * Solo es necesario el pedido y la fecha sin el tiempo
     *
     * @param doc
     * @param f factura
     * @return
     */
    private Element getOrderIdentification(Document doc, factura f) {
        Element r = doc.createElement("orderIdentification");
        Element ri = doc.createElement("referenceIdentification");
        Element referenced = doc.createElement("ReferenceDate");
        ri.setAttribute("type", "ON");
        ri.setTextContent("17898");
        referenced.setTextContent("2023-02-09");
        r.appendChild(ri);
        r.appendChild(referenced);
        return r;
    }

    /**
     * selller numero y tipo proveedor
     *
     * @param doc
     * @param f
     * @return
     */
    private Element getSeller(Document doc, factura f) {
        Element seller = doc.createElement("seller");
        Element alterparty = doc.createElement("alternatePartyIdentification");
        Element identipo = doc.createElement("IdentificaTipoProv");
        alterparty.setAttribute("type", "SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY");
        alterparty.setTextContent("55034");
        identipo.setTextContent("2");
        seller.appendChild(alterparty);
        seller.appendChild(identipo);
        return seller;
    }

    /**
     * Nodo ShipTo que contiene nombre, direcion y numero dee bodega
     *
     * @param doc
     * @param nbodega nombre de la bodega
     * @param bodega numero de bodega
     * @return
     */
    private Element getShipto(Document doc, String nbodega, String bodega) {
        Element ship = doc.createElement("shipTo");
        Element nameAdress = doc.createElement("nameAndAddress");
        Element name = doc.createElement("name");
        Element street = doc.createElement("streetAddressOne");
        Element city = doc.createElement("city");
        Element cp = doc.createElement("postalcode");
        Element bod = doc.createElement("bodegaEnt");
        name.setTextContent(nbodega);
        street.setTextContent(" ");
        city.setTextContent(" ");
        cp.setTextContent(" ");
        bod.setTextContent(bodega);
        nameAdress.appendChild(name);
        nameAdress.appendChild(street);
        nameAdress.appendChild(city);
        nameAdress.appendChild(cp);
        nameAdress.appendChild(bod);
        ship.appendChild(nameAdress);
        return ship;
    }

    /**
     * Se obtiene lo que es la moneda
     *
     * @param doc
     * @return
     */
    private Element getcurrency(Document doc) {
        Element curr = doc.createElement("currency");
        Element curfunction = doc.createElement("currencyFunction");
        curr.setAttribute("currencyISOCode", "MXN");
        curfunction.setTextContent("BILLING_CURRENCY");
        curr.appendChild(curfunction);
        return curr;
    }

    /**
     *
     * @param doc
     * @param lotes
     * @return
     */
    private Element getTotallotes(Document doc, int lotes) {
        Element totall = doc.createElement("TotalLotes");
        Element cantidad = doc.createElement("cantidad");
        cantidad.setTextContent(lotes + "");
        totall.appendChild(cantidad);
        return totall;
    }

    /**
     * Devuelve la parte de loos renglones
     *
     * @param doc
     * @param f
     * @return
     */
    private Element getlineItem(Document doc, factura f) {
        Element item = doc.createElement("lineItem");
        item.setAttribute("type", "SimpleInvoiceLineItemType");
        item.setAttribute("number", "1");
        Element tradeitem = doc.createElement("alternateTradeItemIdentification");
        tradeitem.setAttribute("type", "BUYER_ASSIGNED");
        tradeitem.setTextContent("841667");
        Element invq = doc.createElement("invoicedQuantity");
        invq.setAttribute("unitOfMeasure", "PCE");
        invq.setTextContent("13.00");
        Element adq = doc.createElement("aditionalQuantity");
        adq.setAttribute("QuantityType", "NUM_CONSUMER_UNITS");
        adq.setTextContent("13");
//        tradeitemdescripcion
        Element tradeitemdesc = doc.createElement("tradeItemDescriptionInformation");
        Element ltext = doc.createElement("longText");
        ltext.setTextContent("BOTAS PARA ESCALAR MONTAÑAS 5430 25/30 HONTING-AMBAR");
        tradeitemdesc.appendChild(ltext);

//        Codigo talla
        Element codigotalla = doc.createElement("codigoTallaInternoCop");
        Element codigo = doc.createElement("codigo");
        codigo.setTextContent("841667");
        Element talla = doc.createElement("talla");
        talla.setTextContent("280");
        codigotalla.appendChild(codigo);
        codigotalla.appendChild(talla);
//       gross
        Element gross = doc.createElement("grossPrice");
        Element amount = doc.createElement("Amount");
        amount.setTextContent("427.00");
        gross.appendChild(amount);
//        netPrice
        Element netprice = doc.createElement("netPrice");
        Element amountp = doc.createElement("Amount");
        amountp.setTextContent("427.00");
        netprice.appendChild(amountp);
//        pallet informacion
        Element pallet = doc.createElement("palletInformation");
        Element desc = doc.createElement("description");
        desc.setAttribute("type", "BOX");
        desc.setTextContent("EMPAQUETADO");
        Element transport = doc.createElement("transport");
        Element metod = doc.createElement("");
        metod.setTextContent("PAID_BY_BUYER");
        Element prepac = doc.createElement("prepactCant");
        prepac.setTextContent("10");
        transport.appendChild(metod);
        transport.appendChild(prepac);
        pallet.appendChild(desc);
        pallet.appendChild(transport);
//      allowance charge
        Element allowance = doc.createElement("allowanceCharge");
        allowance.setAttribute("allowanceChargeType", " ALLOWANCE_GLOBAL");
        Element specialservice = doc.createElement("PAD");
        Element monetaryamount = doc.createElement("monetaryAmountOrPercentage");
        Element percentunit = doc.createElement("percentagePerUnit");
        percentunit.setTextContent("0");
        Element rate = doc.createElement("ratePerUnit");
        Element amountrate = doc.createElement("amountPerUnit");
        amountrate.setTextContent("0");
        rate.appendChild(amountrate);
        monetaryamount.appendChild(percentunit);
        monetaryamount.appendChild(rate);
        allowance.appendChild(specialservice);
        allowance.appendChild(monetaryamount);
//        Total line
        Element totalline = doc.createElement("totalLineAmount");
        Element grossamount = doc.createElement("grossAmount");
        Element amo = doc.createElement("Amount");
        amo.setTextContent("5551.00");
        grossamount.appendChild(amo);
        Element netamount = doc.createElement("netAmount");
        Element amo1 = doc.createElement("Amount");
        amo1.setTextContent("5551.00");
        netamount.appendChild(amo1);
        totalline.appendChild(grossamount);
        totalline.appendChild(netamount);
//        añadir subnodos al nodo principal
        item.appendChild(tradeitem);
        item.appendChild(invq);
        item.appendChild(adq);
        item.appendChild(codigotalla);
        item.appendChild(tradeitemdesc);
        item.appendChild(gross);
        item.appendChild(netprice);
        item.appendChild(pallet);
        item.appendChild(allowance);
        item.appendChild(totalline);

        return item;
    }
/**
 * Solo crea un nodo de el total de la factura
 * @param doc
 * @param monto
 * Total de la factura
 * @return 
 */
    private Element getTotalamouunt(Document doc, double monto) {
        Element Totalamount = doc.createElement("totalAmount");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent("5551.00");
        Totalamount.appendChild(Amount);
        return Totalamount;
    }
    
    /**
     * Obtener Totalallowance
     * @param doc
     * @return 
     * Elemento de total allowance
     */
    private Element getTotalallowance(Document doc){
        Element Totalallowance=doc.createElement("TotalAllowanceCharge");
        Totalallowance.setAttribute("allowanceOrChargeType", "ALLOWANCE");
        Element sp=doc.createElement("specialServicesType");
        sp.setTextContent("TD");
        Element Amount = doc.createElement("Amount");
        Amount.setTextContent("0");
        Totalallowance.appendChild(sp);
        Totalallowance.appendChild(Amount);

        return Totalallowance;
    }
}
