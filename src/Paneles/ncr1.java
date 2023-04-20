/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import DAO.daocfdi;
import DAO.daoempresa;
import DAO.daofactura;
import DAO.daoxmlE;
import DAO.daoxmlncr;
import Modelo.Ciudades;
import Modelo.Dfactura;
import Modelo.Empresas;
import Modelo.Estados;
import Modelo.Formadepago;
import Modelo.Paises;
import Modelo.Sellofiscal;
import Modelo.convertnum;
import Modelo.factura;
import Modelo.metodopago;
import Modelo.usocfdi;
import Server.Serverprod;
import Server.Serverylite;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import mx.sat.cfd40.timbrarXML;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GATEWAY1-
 */
public class ncr1 extends javax.swing.JPanel {

    public String empresa, empresacob;
    public Connection sqlcfdi, sqlempresa;
    public Connection cpt, ACobranza;
    Serverylite slite = new Serverylite();
    Serverprod prod = new Serverprod();
    public ArrayList<Formadepago> arrfpago = new ArrayList<>();
    public ArrayList<usocfdi> arruso = new ArrayList<>();
    public ArrayList<metodopago> arrmetodo = new ArrayList<>();
    ArrayList<Paises> arrpais = new ArrayList<>();
    ArrayList<Estados> arrestado = new ArrayList<>();
    ArrayList<Ciudades> arrciudad = new ArrayList<>();
    ArrayList<factura> arrfactura = new ArrayList<>();
    ArrayList<factura> arrfacturaxml = new ArrayList<>();
    daocfdi dcfdi = new daocfdi();
    int estado = 0;
    int ciudad = 0;
    int pais = 0;

    /**
     * Creates new form Cliente1
     */
    public ncr1() {
        initComponents();
        JtCliente.requestFocus();
//        iniciarconexiones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbXml1 = new javax.swing.JButton();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        JbXml1.setBackground(new java.awt.Color(255, 255, 255));
        JbXml1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationvnd_103607.png"))); // NOI18N
        JbXml1.setToolTipText("Verifica XML");
        JbXml1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbXml1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JbXml1MousePressed(evt);
            }
        });

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
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JbXml1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JbXml1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void JbXml1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JbXml1MousePressed
        daofactura dfac = new daofactura();
        int id = arrfactura.get(JtDetalle.getSelectedRow()).getId();
        arrfacturaxml = dfac.getdocxml(cpt, id + "", "NCR", empresacob);

        factura f = new factura();
        String condicion;
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        ArrayList<Dfactura> arrf = new ArrayList<>();
        DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
//        String im = String.valueOf(formateador.format(arrfacturaxml.get(0).getImpuestos()));
        double im=formatdecimal(arrfacturaxml.get(0).getImpuestos());
        String sub = String.valueOf(BigDecimal.valueOf(arrfacturaxml.get(0).getSubtotal()).setScale(2, RoundingMode.FLOOR));
        String desc = String.valueOf(BigDecimal.valueOf(arrfacturaxml.get(0).getDescuento()).setScale(2, RoundingMode.FLOOR));
        double sum = (Double.parseDouble(sub) + im) - Double.parseDouble(desc);
        if (arrfacturaxml.get(0).getTotal() != sum) {
            double partedecimal = sum % 1;
            double d = 0;
            System.out.println(partedecimal);
            if (partedecimal <= 0.50) {
                d = BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
            } else {
                d = BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
            f.setTotal(d);
        } else {
            double partedecimal = arrfacturaxml.get(0).getTotal() % 1;
            double d = 0;
            System.out.println(partedecimal);
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
        ArrayList<String> arruuid = new ArrayList<>();
        arruuid = formateauuid(arruuid, arrfacturaxml.get(0).getFoliofiscalorig());
        f.setId(id);
        f.setExportacion("01");
        f.setIva(arrfacturaxml.get(0).getIva());
        f.setImpuestos(im);
        f.setFolio(arrfacturaxml.get(0).getFolio());
        f.setSerie("NCR");
        f.setFecha(sdf.format(date));
        f.setDescuento(Double.parseDouble(desc));
        f.setSubtotal(Double.parseDouble(sub));
        f.setNombre(arrfacturaxml.get(0).getNombre());
        f.setRfc(arrfacturaxml.get(0).getRfc());
        f.setCp(arrfacturaxml.get(0).getCp());
        f.setRegimen(arrfacturaxml.get(0).getRegimen());
        f.setObservaciones(arrfacturaxml.get(0).getObservaciones());
        f.setTiposerie("NCR");
        f.setMoneda(arrfacturaxml.get(0).getMoneda());
        f.setTipocambio(arrfacturaxml.get(0).getTipocambio());
        f.setFormapago(arrfacturaxml.get(0).getFormapago());
        f.setMetodopago(arrfacturaxml.get(0).getMetodopago());
        f.setUsocfdi(arrfacturaxml.get(0).getUsocfdi());
        condicion = (f.getMetodopago().equals("PUE")) ? "Contado" : "Credito";
        f.setCondicion(condicion);
        f.setLugarexpedicion("36400");
        f.setTiporelacion(arrfacturaxml.get(0).getTiporelacion());
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
//            df.setDescumedida(dcfdi.getdescunidad(sqlcfdi, arrfacturaxml.get(i).getUmedida()));
            df.setUmedida("PR");
            arrf.add(df);
        }
        f.setArruuid(arruuid);
        f.setArr(arrf);
        //Se utiliza el generar factura especial por los decimales
        daoxmlncr dx = new daoxmlncr();
        dx.generarfac(f, cpt, sqlempresa);

        timbrarXML t = new timbrarXML();
        String e = (!empresa.equals("UptownCPT")) ? "1" : "2";
        String fac = String.valueOf(arrfacturaxml.get(0).getFolio());
        Sellofiscal s = t.timbrar("NCR_" + fac, "", sqlempresa, e);
        dfac.Updatesellofiscal(cpt, s, id);
        JOptionPane.showMessageDialog(null, "Proceso terminado: \n " + s.getEstado());
        Buscanotas();
    }//GEN-LAST:event_JbXml1MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
//        ArrayList<String> a = new ArrayList<>();
//        a = formateauuid(a, "23D958AB-76, 3C0139A5-7E884C6597, 53998945-6842-4BAC-9895-7985A22BE2E6");
//        System.out.println(a.size());
//        for (String a1 : a) {
//            System.out.println(a1);
//        }
    }//GEN-LAST:event_jLabel6MousePressed

    private void setreport() {
        try {
            String moneda = arrfactura.get(JtDetalle.getSelectedRow()).getMoneda();
            String conformidad = (!moneda.equals("MXN")) ? "De conformidad con el Art. 20 del C.F.F., informamos que "
                    + "para convertir moneda extranjera a su equivalente en moneda nacional, el tipo de cambio a "
                    + "utilizar para efectos de pagos será el que publique el Banco de México en el Diario Oficial "
                    + "de la Federación el día habil anterior al día de pago. Para su consulta: www.banxico.org.mx "
                    + "(sección: Mercado cambiario/Tipos de cambio para solventar obligaciones denominadas en dólares de los Ee.Uu:A., pagaderas en la República Mexicana)" : " ";
            daoempresa d = new daoempresa();
            String n = (empresa.equals("UptownCPT")) ? "2" : "1";
            String logo = (empresa.equals("UptownCPT")) ? "Uptown.jpg" : "AF.png";

            Empresas e = d.getempresarfc(sqlempresa, n);
            Map parametros = new HashMap();
            convertnum conv = new convertnum();
            int folio = arrfactura.get(JtDetalle.getSelectedRow()).getFolio();
            parametros.put("folio", folio);
            parametros.put("totalletra", conv.controlconversion(arrfactura.get(JtDetalle.getSelectedRow()).getTotal()).toUpperCase());
            parametros.put("nombre", e.getNombre());
            parametros.put("rfc", e.getRfc());
            parametros.put("regimen", e.getRegimen());
            parametros.put("lugar", e.getCp());
            parametros.put("comprobante", e.getNumcertificado());
            parametros.put("logo", "C:\\af\\bin\\" + logo);
            parametros.put("metodo", getnmetodo(arrfactura.get(JtDetalle.getSelectedRow()).getMetodopago()));
            parametros.put("uso", getnuso(arrfactura.get(JtDetalle.getSelectedRow()).getUsocfdi()));
            parametros.put("serie", "NCR");
            parametros.put("regimencliente", arrfactura.get(JtDetalle.getSelectedRow()).getRegimen());
            parametros.put("confo", conformidad);
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/indexncr.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("NCR " + folio);
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
        arrfactura = df.getdoc(cpt, JtCliente.getText(), "NCR", empresacob);
        generatabla();
    }

        private double formatdecimal(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(cant);
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
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
    
    /**
     * Formatea los folios fiscales a usar
     *
     * @param arr
     * @param folios
     * @return
     */
    private ArrayList<String> formateauuid(ArrayList<String> arr, String folios) {
        String cadena = "";
        for (int i = 0; i < folios.length(); i++) {
            String car = folios.charAt(i) + "";
            if (!car.equals(" ")) {
                if (car.equals(",")) {
                    arr.add(cadena);
                    cadena = "";
                } else {
                    cadena += car;
                }
            }

        }
        if (!cadena.isEmpty()) {
            arr.add(cadena);
        }
        return arr;
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
        for (int i = 0; i < arrfactura.size(); i++) {
            String estat = (arrfactura.get(i).getEstatus() == 1) ? "ACTIVA" : "CANCELADO";
            String estatfac = (arrfactura.get(i).getFoliofiscal().equals("")) ? "NO TIMBRADO" : "TIMBRADO";
            model.setValueAt(arrfactura.get(i).getFolio(), i, 0);
            model.setValueAt(arrfactura.get(i).getNombre(), i, 1);
            model.setValueAt(arrfactura.get(i).getSubtotal(), i, 2);
            model.setValueAt(arrfactura.get(i).getImpuestos(), i, 3);
            model.setValueAt(arrfactura.get(i).getTotal(), i, 4);
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
    private javax.swing.JButton JbXml1;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
