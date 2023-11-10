/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import DAO.daoAddenda;
import DAO.daoClientes;
import DAO.daocfdi;
import DAO.daoempresa;
import DAO.daofactura;
import DAO.daoxmlE;
import Modelo.Addenda;
import Modelo.Cliente;
import Modelo.Corridaaddenda;
import Modelo.Destinoscoppel;
import Modelo.Dfactura;
import Modelo.Empresas;
import Modelo.Formadepago;
import Modelo.NAddenda;
import Modelo.Sellofiscal;
import Modelo.Setaddenda;
import Modelo.Usuarios;
import Modelo.convertirNumeros;
import Modelo.convertnum;
import Modelo.factura;
import Modelo.metodopago;
import Modelo.usocfdi;
import Server.Serverprod;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.sat.cfd40.timbrarXML;
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

/**
 *
 * @author GATEWAY1-
 */
public class fac1 extends javax.swing.JPanel {

    public String nombre, empresa, empresacob;
    public Connection sqlcfdi, sqlempresa, liteusuario;
    public Connection ACobranza, cpt, rcpt;
    Serverprod prod = new Serverprod();
    public ArrayList<Formadepago> arrfpago = new ArrayList<>();
    public ArrayList<usocfdi> arruso = new ArrayList<>();
    public ArrayList<metodopago> arrmetodo = new ArrayList<>();
    ArrayList<factura> arrfactura = new ArrayList<>();
    ArrayList<factura> arrfacturaxml = new ArrayList<>();
    daocfdi dcfdi = new daocfdi();
    int estado = 0;
    int ciudad = 0;
    int pais = 0;
    public Usuarios u;

    /**
     * Creates new form Cliente1
     */
    public fac1() {
        initComponents();
        JtCliente.requestFocus();
        JbXml.setEnabled(false);
        JbCancelar.setEnabled(false);
        JbAddenda.setEnabled(false);
        JmNombre.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pop = new javax.swing.JPopupMenu();
        JmPedfac = new javax.swing.JMenuItem();
        JmNombre = new javax.swing.JMenuItem();
        JmBorraadenda = new javax.swing.JMenuItem();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JbXml = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();
        JbAddenda = new javax.swing.JButton();

        JmPedfac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationsgraphicsdrawing_103768.png"))); // NOI18N
        JmPedfac.setText("Modificar pedido de factura");
        JmPedfac.setToolTipText("");
        JmPedfac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmPedfacActionPerformed(evt);
            }
        });
        Pop.add(JmPedfac);

        JmNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/floppydiskregular_106322.png"))); // NOI18N
        JmNombre.setText("Corregir nombre en factura");
        JmNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmNombreActionPerformed(evt);
            }
        });
        Pop.add(JmNombre);

        JmBorraadenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eraser_icon-icons.com_60679.png"))); // NOI18N
        JmBorraadenda.setText("Borra adenda");
        JmBorraadenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBorraadendaActionPerformed(evt);
            }
        });
        Pop.add(JmBorraadenda);

        setBackground(new java.awt.Color(255, 255, 255));

        JtCliente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        JtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCliente.setBorder(null);
        JtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("# Cliente");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        JbXml.setBackground(new java.awt.Color(255, 255, 255));
        JbXml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationvnd_103607.png"))); // NOI18N
        JbXml.setToolTipText("Verifica XML");
        JbXml.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbXml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbXmlActionPerformed(evt);
            }
        });

        JbCancelar.setBackground(new java.awt.Color(255, 255, 255));
        JbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCancelar.setToolTipText("Cancela XML");
        JbCancelar.setBorder(null);
        JbCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        JbAddenda.setBackground(new java.awt.Color(255, 255, 255));
        JbAddenda.setForeground(new java.awt.Color(255, 255, 255));
        JbAddenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/package_box_10801.png"))); // NOI18N
        JbAddenda.setToolTipText("Agrega addenda");
        JbAddenda.setBorder(null);
        JbAddenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbAddenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbAddendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JbAddenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JbXml, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(JbXml, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbAddenda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtClienteActionPerformed
        Buscanotas();
    }//GEN-LAST:event_JtClienteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        setreport();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JbXmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbXmlActionPerformed
        daofactura dfac = new daofactura();
        int id = arrfactura.get(JtDetalle.getSelectedRow()).getId();
        arrfacturaxml = dfac.getdocxml(cpt, id + "", "FAC", empresacob);

        factura f = new factura();
        String condicion;
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        ArrayList<Dfactura> arrf = new ArrayList<>();
        DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
        String im = String.valueOf(formateador.format(arrfacturaxml.get(0).getImpuestos()));
        String sub = String.valueOf(BigDecimal.valueOf(arrfacturaxml.get(0).getSubtotal()).setScale(2, RoundingMode.FLOOR));
        String desc = String.valueOf(BigDecimal.valueOf(arrfacturaxml.get(0).getDescuento()).setScale(2, RoundingMode.FLOOR));
        double sum = (Double.parseDouble(sub) + Double.parseDouble(im)) - Double.parseDouble(desc);
        if (arrfacturaxml.get(0).getTotal() != sum) {
            double partedecimal = sum % 1;
            double d = 0;
//            System.out.println(partedecimal);
            if (partedecimal <= 0.50) {
                d = BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
            } else {
                d = BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
            f.setTotal(d);
        } else {
            double partedecimal = arrfacturaxml.get(0).getTotal() % 1;
            double d = 0;
//            System.out.println(partedecimal);
            if (partedecimal <= 0.50) {
                d = BigDecimal.valueOf(arrfacturaxml.get(0).getTotal()).setScale(2, RoundingMode.HALF_UP).doubleValue();
            } else {
                d = BigDecimal.valueOf(arrfacturaxml.get(0).getTotal()).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
            f.setTotal(d);
//            f.setTotal(BigDecimal.valueOf(arrfacturaxml.get(0).getTotal()).setScale(2, RoundingMode.FLOOR).doubleValue());
        }

        switch (arrfacturaxml.get(0).getMetodopago()) {
            case "PPD":
                f.setDescmetodop("PAGO EN PARCIALIDADES O DIFERIDO");
                break;
            case "PUE":
                f.setDescmetodop("PAGO EN UNA SOLA EXHIBICIÓN");
                break;
            case "PIP":
                f.setDescmetodop("PAGO INICIAL Y PARCIALIDADES");
                break;
        }
        f.setId(id);
        f.setExportacion("01");
        f.setIva(arrfacturaxml.get(0).getIva());
        f.setImpuestos(Double.parseDouble(im));
        f.setFolio(arrfacturaxml.get(0).getFolio());
        f.setClaveusuario(u.getUsuario());
        f.setSerie("FAC");
        f.setFecha(sdf.format(date));
        f.setDescuento(Double.parseDouble(desc));
        f.setSubtotal(Double.parseDouble(sub));
        f.setNombre(arrfacturaxml.get(0).getNombre());
        f.setRfc(arrfacturaxml.get(0).getRfc());
        f.setCp(arrfacturaxml.get(0).getCp());
        f.setRegimen(arrfacturaxml.get(0).getRegimen());
        f.setObservaciones(arrfacturaxml.get(0).getObservaciones());
        f.setTiposerie("FACTURA");
        f.setMoneda(arrfacturaxml.get(0).getMoneda());
        f.setTipocambio(arrfacturaxml.get(0).getTipocambio());
        f.setFormapago(arrfacturaxml.get(0).getFormapago());
        f.setMetodopago(arrfacturaxml.get(0).getMetodopago());
        f.setUsocfdi(arrfacturaxml.get(0).getUsocfdi());
        condicion = (f.getMetodopago().equals("PUE")) ? "Contado" : "Credito";
        f.setCondicion(condicion);
        f.setLugarexpedicion("36400");
        f.setTiporelacion("");
        f.setEmpresa(!(empresa.equals("UptownCPT")) ? "1" : "2");
        double iva = arrfacturaxml.get(0).getIva();
        for (int i = 0; i < arrfacturaxml.size(); i++) {
            Dfactura df = new Dfactura();
            df.setRenglon(i + 1);
            df.setCantidadfloat(arrfacturaxml.get(i).getCantidadfloat());
            df.setDescripcion(arrfacturaxml.get(i).getDescripcion());
            df.setCodigo(arrfacturaxml.get(i).getCodigo());
            df.setUmedida(arrfacturaxml.get(i).getUmedida());
            df.setPrecio(arrfacturaxml.get(i).getPreciodetalle());
            df.setBase(arrfacturaxml.get(i).getBasedetalle());
            df.setImpuesto(arrfacturaxml.get(i).getImpuestodet());
            df.setTipofactor(arrfacturaxml.get(i).getTipofac());
            df.setImporta(Double.parseDouble(formateador.format((arrfacturaxml.get(i).getImportedetalle()))));
            df.setDescuento(Double.parseDouble(formateador.format(arrfacturaxml.get(i).getDescuentodetalle())));
            df.setTasaocuota(iva + "");
            df.setDescumedida(dcfdi.getdescunidad(sqlcfdi, arrfacturaxml.get(i).getUmedida()));
            arrf.add(df);
        }
        f.setArr(arrf);
        //Se utiliza el generar factura especial por los decimales
        daoxmlE dx = new daoxmlE();
        dx.generarfac(f, cpt, sqlempresa);

        timbrarXML t = new timbrarXML();
        String e = (!empresa.equals("UptownCPT")) ? "1" : "2";
        String fac = String.valueOf(arrfacturaxml.get(0).getFolio());
        Sellofiscal s = t.timbrar("FAC_" + fac, "", sqlempresa, e);
        dfac.Updatesellofiscal(cpt, s, id);
        JOptionPane.showMessageDialog(null, "Proceso terminado: \n " + s.getEstado());
        Buscanotas();
    }//GEN-LAST:event_JbXmlActionPerformed

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        if (evt.getButton() == 3) {// activar con clic derecho
            Pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
        int row = JtDetalle.getSelectedRow();
        int e = arrfactura.get(row).getEstatus();
        String tim = (arrfactura.get(row).getFoliofiscal().equals("")) ? "N" : "T";
        if (e == 1 && tim.equals("N")) {
            JbXml.setEnabled(true);
            JmNombre.setVisible(true);
//            JbCancelar.setEnabled(false);
        } else {
            JbXml.setEnabled(false);
            JmNombre.setVisible(false);
//            JbCancelar.setEnabled(true);
        }
//        if (arrfactura.get(row).getNombre().equals("COPPEL") && tim.equals("T")) {
//            JbAddenda.setEnabled(true);
//        } else {
//            JbAddenda.setEnabled(false);
//        }
        JbAddenda.setEnabled(true);
    }//GEN-LAST:event_JtDetalleMousePressed

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        if (!arrfactura.isEmpty()) {
            String botones[] = {"Aceptar", ""
                + ""
                + "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(this, "¿Deseas cancelar factura?, recuerda que por ahora solo se cancela la factura del sat, nada del sistema", "ATHLETIC",
                    0, 0, null, botones, this);
            if (opcion == JOptionPane.YES_OPTION) {
                String resp = "";
                int row = JtDetalle.getSelectedRow();
                java.util.Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                factura fac = new factura();
                daofactura df = new daofactura();
//                Asigna valores de folio y fecha de cancelacion
                fac.setFolio(arrfactura.get(row).getFolio());
                fac.setFechacancel(sdf.format(date));
//                MOvimientos en la bd para cancelacion de la factura
                df.cancelafac(cpt, rcpt, ACobranza, fac);
                String tim = (arrfactura.get(row).getFoliofiscal().equals("")) ? "N" : "T";
//                Aplica solo si esta timbrada sino solo se da de baja en la bd
                if (tim.equals("T")) {
                    String n = (empresa.equals("UptownCPT")) ? "2" : "1";
                    timbrarXML t = new timbrarXML();
                    resp = t.cancelarfolio("FAC_" + arrfactura.get(row).getFolio(), sqlempresa, n, arrfactura.get(row).getFoliofiscal());
                }
                Buscanotas();
                JOptionPane.showMessageDialog(null, "Proceso terminado: \n " + resp);
            }
        }
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed

//        System.out.println("Leeyendo XML");
        try {
            DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
            daoempresa d = new daoempresa();
            Empresas e = d.getempresarfc(sqlempresa, "1");
            int row = JtDetalle.getSelectedRow();
            String archivo = e.getXml() + "\\FAC_" + arrfactura.get(row).getFolio() + ".xml";
//            System.out.println(archivo);
            Document doc;
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            doc = builder.parse(archivo);
            doc.getDocumentElement().normalize();
            NodeList complemento = doc.getElementsByTagName("cfdi:Concepto");
//            System.out.println(complemento.getLength());
            double descuento = 0;
            double impuestos = 0;
            double baseimp = 0;
            double total = 0;
            String sdesc = String.valueOf(arrfactura.get(row).getDescuento());
//            Validar descuentos
            if (!sdesc.equals("0.0") || arrfactura.get(row).getDescuento() != 0) {
                for (int i = 0; i < complemento.getLength(); i++) {
                    Node nNode = complemento.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) nNode;
                        String f = element.getAttribute("Descuento");
                        descuento += Double.parseDouble(formateador.format(Double.parseDouble(f)));
////                        System.out.println("descuento " + f);
                    }
                }
            }

            complemento = doc.getElementsByTagName("cfdi:Traslado");
            for (int i = 0; i < complemento.getLength() - 1; i++) {
                Node nNode = complemento.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    String f = element.getAttribute("Importe");
                    impuestos += Double.parseDouble(formateador.format(Double.parseDouble(f)));
////                    System.out.println("imp " + f);
                }
            }
            double partedecimal = impuestos % 1;
//            System.out.println(partedecimal);

            double tot = arrfactura.get(row).getSubtotal() + impuestos - descuento;
//            System.out.println(descuento + " - " + impuestos + " " + tot);
//            System.out.println(formatdecimal(tot));//            cargarPDF(factura,total);
//            System.out.println(formatdecimal(impuestos));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jLabel6MousePressed

    private void JbAddendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbAddendaActionPerformed
        generaradenda();
    }//GEN-LAST:event_JbAddendaActionPerformed

    private void JmPedfacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmPedfacActionPerformed
        Modpedidos mped = new Modpedidos(null, true);
        mped.rcpt = rcpt;
        mped.cpt = cpt;
        mped.setVisible(true);
    }//GEN-LAST:event_JmPedfacActionPerformed

    private void JmNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmNombreActionPerformed
        setmod();
    }//GEN-LAST:event_JmNombreActionPerformed

    private void JmBorraadendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBorraadendaActionPerformed
        if (!arrfactura.isEmpty()) {
            String e = (!empresa.equals("UptownCPT")) ? "1" : "2";
            int row = JtDetalle.getSelectedRow();
            String archivo = getempresa(sqlempresa, e) + "\\FAC_" + arrfactura.get(row).getFolio() + ".xml";
////            System.out.println("arch "+archivo);
            NAddenda na = new NAddenda();
            na.setArchivo(archivo);
            Setaddenda adenda = new Setaddenda(na);
            adenda.deladenda();
        }
    }//GEN-LAST:event_JmBorraadendaActionPerformed

    private void setmod() {
        int row = JtDetalle.getSelectedRow();
        daofactura df = new daofactura();
        daoClientes dc = new daoClientes();
        Cliente c = dc.getCliente(ACobranza, arrfactura.get(row).getIdcliente());
        if (df.updateclientefacv2(cpt, c, arrfactura.get(row).getId())) {
            JOptionPane.showMessageDialog(null, "Modificacion completa  ");
            Buscanotas();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo modificar, avisa a sistemas");
        }
    }

    private void generaradenda() {
        if (!arrfactura.isEmpty()) {
            String e = (!empresa.equals("UptownCPT")) ? "1" : "2";
            int row = JtDetalle.getSelectedRow();
            String archivo = getempresa(sqlempresa, e) + "\\FAC_" + arrfactura.get(row).getFolio() + ".xml";
//            System.out.println(archivo);
            daoAddenda dadenda = new daoAddenda();
            ArrayList<Corridaaddenda> arrcorend = dadenda.getCoraddenda(liteusuario);
//            Se obtienen los productos para generar en automatico la addenda
            ArrayList<Addenda> arradenda = dadenda.getAddenda(cpt, arrfactura.get(row), arrcorend);
            ArrayList<Destinoscoppel> arrdestinos = dadenda.getDestinos(rcpt);
            facAddenda faddenda = new facAddenda(null, true);
            faddenda.f = arrfactura.get(row);
            faddenda.empresa = e;
            faddenda.arraddenda = arradenda;
            faddenda.arrdestinos = arrdestinos;
            faddenda.archivoxml = archivo;
            faddenda.rcpt = rcpt;
            faddenda.cpt = cpt;
            faddenda.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            faddenda.setVisible(true);
        }
    }

    private String getempresa(Connection c, String n) {
        daoempresa d = new daoempresa();
        Empresas e = d.getempresarfc(c, n);
        return e.getXml();
    }

    /**
     *
     * @param tipo
     * @param cant
     *
     * @return
     */
    private double formatdecimal(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp = 0;
        String c = String.valueOf(cant);
        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato <= 5)) {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    private void setreport() {
        String moneda = arrfactura.get(JtDetalle.getSelectedRow()).getMoneda();
        String conformidad = (!moneda.equals("MXN")) ? "De conformidad con el Art. 20 del C.F.F., informamos que "
                + "para convertir moneda extranjera a su equivalente en moneda nacional, el tipo de cambio a "
                + "utilizar para efectos de pagos será el que publique el Banco de México en el Diario Oficial "
                + "de la Federación el día habil anterior al día de pago. Para su consulta: www.banxico.org.mx "
                + "(sección: Mercado cambiario/Tipos de cambio para solventar obligaciones denominadas en dólares de los Ee.Uu:A., pagaderas en la República Mexicana)" : " ";
        try {
            daoempresa d = new daoempresa();
            String n = (empresa.equals("UptownCPT")) ? "2" : "1";
            String logo = (empresa.equals("UptownCPT")) ? "Uptown.jpg" : "AF.png";
            Empresas e = d.getempresarfc(sqlempresa, n);
            String lugar = (empresa.equals("UptownCPT")) ? e.getCp() : "BLVD LAS TORRES 516 DEL VALLE SAN FRANCISCO DEL RINCON GUANAJUATO " + e.getCp();
            Map parametros = new HashMap();
            convertnum conv = new convertnum();
            convertirNumeros cnum = new convertirNumeros();
            int folio = arrfactura.get(JtDetalle.getSelectedRow()).getFolio();

            DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
            String numeros = formateador.format(arrfactura.get(JtDetalle.getSelectedRow()).getTotal());
            parametros.put("folio", folio);
//            parametros.put("totalletra", conv.controlconversion(arrfactura.get(JtDetalle.getSelectedRow()).getTotal()).toUpperCase());
            parametros.put("totalletra", cnum.Convertir(numeros, true, moneda));
            parametros.put("nombre", e.getNombre());
            parametros.put("rfc", e.getRfc());
            parametros.put("regimen", e.getRegimen());
            parametros.put("lugar", lugar);
            parametros.put("comprobante", e.getNumcertificado());
            parametros.put("logo", "C:\\af\\bin\\" + logo);
            parametros.put("metodo", getnmetodo(arrfactura.get(JtDetalle.getSelectedRow()).getMetodopago()));
            parametros.put("uso", getnuso(arrfactura.get(JtDetalle.getSelectedRow()).getUsocfdi()));
            parametros.put("serie", "FAC");
            parametros.put("regimencliente", arrfactura.get(JtDetalle.getSelectedRow()).getRegimen());
            parametros.put("confo", conformidad);

            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/index.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("FAC " + folio);
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getnmetodo(String m) {
        String r = "";
        for (int i = 0; i < arrmetodo.size(); i++) {
            if (m.equals(arrmetodo.get(i).getMetodopago())) {
                r = arrmetodo.get(i).getDescripcion();
                break;
            }
        }
        return r;
    }

    private String getnuso(String m) {
        String r = "";
        for (int i = 0; i < arruso.size(); i++) {
            if (m.equals(arruso.get(i).getusocfdi())) {
                r = arruso.get(i).getDescripcion();
                break;
            }
        }
        return r;
    }

    private void Buscanotas() {
        daofactura df = new daofactura();
        arrfactura = df.getdoc(cpt, JtCliente.getText(), "FAC", empresacob);
        generatabla();
    }

    private void generatabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Folio");
        model.addColumn("Cliente");
        model.addColumn("Subtotal");
        model.addColumn("Impuestos");
        model.addColumn("Total");
        model.addColumn("Fecha");
        model.addColumn("Forma Pago");
        model.addColumn("Metodo Pago");
        model.addColumn("Estado");
        model.addColumn("Timbrado");
        model.addColumn("Uso cfdi");
        model.setNumRows(arrfactura.size());
        DecimalFormat formateador = new DecimalFormat("####.##");
        for (int i = 0; i < arrfactura.size(); i++) {
            String estat = (arrfactura.get(i).getEstatus() == 1) ? "ACTIVA" : "CANCELADO";
            String estatfac = (arrfactura.get(i).getFoliofiscal().equals("")) ? "NO TIMBRADO" : "TIMBRADO";
////            System.out.println(arrfactura.get(i).getTotal());
            model.setValueAt(arrfactura.get(i).getFolio(), i, 0);
            model.setValueAt(arrfactura.get(i).getNombre(), i, 1);
            model.setValueAt(formateador.format(arrfactura.get(i).getSubtotal()), i, 2);
            model.setValueAt(formateador.format(arrfactura.get(i).getImpuestos()), i, 3);
            model.setValueAt(formateador.format(arrfactura.get(i).getTotal()), i, 4);
            model.setValueAt(arrfactura.get(i).getFecha(), i, 5);
            model.setValueAt(arrfactura.get(i).getFormapago(), i, 6);
            model.setValueAt(arrfactura.get(i).getMetodopago(), i, 7);
            model.setValueAt(estat, i, 8);
            model.setValueAt(estatfac, i, 9);
            model.setValueAt(arrfactura.get(i).getUsocfdi(), i, 10);
        }
        JtDetalle.setModel(model);
    }

    private boolean verificaint(String cad) {
        boolean resp = false;
        String patt = "[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbAddenda;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JButton JbXml;
    private javax.swing.JMenuItem JmBorraadenda;
    private javax.swing.JMenuItem JmNombre;
    private javax.swing.JMenuItem JmPedfac;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JPopupMenu Pop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
