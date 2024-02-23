/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import DAO.daoConceptos;
import Paneles.*;
import DAO.daocfdi;
import DAO.daokardexrcpt;
import DAO.daopedimentos;
import Modelo.ConceptosES;
import Modelo.Formadepago;
import Modelo.Formateodedatos;
import Modelo.KardexCmp;
import Modelo.Usuarios;
import Modelo.factura;
import Modelo.metodopago;
import Modelo.usocfdi;
import Server.Serverprod;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class Inout1 extends javax.swing.JPanel {

    public String nombre, empresa, empresacob;
    public Connection sqlcfdi, sqlempresa, liteusuario;
    public Connection ACobranza, cpt, rcpt, cobB;
    Serverprod prod = new Serverprod();
    public ArrayList<Formadepago> arrfpago = new ArrayList<>();
    public ArrayList<usocfdi> arruso = new ArrayList<>();
    public ArrayList<metodopago> arrmetodo = new ArrayList<>();
    ArrayList<factura> arrfactura = new ArrayList<>();
    ArrayList<factura> arrfacturaxml = new ArrayList<>();
    ArrayList<KardexCmp> k = new ArrayList<>();
    daocfdi dcfdi = new daocfdi();
    int estado = 0;
    int ciudad = 0;
    int pais = 0;
    public Usuarios u;
    int clic = 0;
    int clic2 = 0;
    int clic3 = 0;
    String serie = "A";
    int cuenta = 1;

    /**
     * Creates new form Cliente1
     */
    public Inout1() {
        initComponents();
        JtCliente.requestFocus();
        JbCancelar.setEnabled(true);
        grupo.add(Be);
        grupo.add(Bs);
        Be.setSelected(true);
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
        JbCancelar = new javax.swing.JMenuItem();
        grupo = new javax.swing.ButtonGroup();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JlSerie = new javax.swing.JLabel();
        Be = new javax.swing.JRadioButton();
        Bs = new javax.swing.JRadioButton();

        JbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JbCancelar.setText("Cancelar salida");
        JbCancelar.setToolTipText("");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });
        Pop.add(JbCancelar);

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

        JlSerie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/sticker_120054A.png"))); // NOI18N
        JlSerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlSerieMousePressed(evt);
            }
        });
        JlSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JlSerieKeyPressed(evt);
            }
        });

        Be.setBackground(new java.awt.Color(255, 255, 255));
        Be.setText("Entrada");
        Be.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeActionPerformed(evt);
            }
        });

        Bs.setBackground(new java.awt.Color(255, 255, 255));
        Bs.setText("Salida");
        Bs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JlSerie)
                .addGap(187, 187, 187)
                .addComponent(Be)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Be)
                            .addComponent(Bs))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(JlSerie))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtClienteActionPerformed
        Buscanotas();
    }//GEN-LAST:event_JtClienteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int row = JtDetalle.getSelectedRow();
        int folio = k.get(row).getId_kardex();
        String ser = k.get(row).getSerie();
        String name = k.get(row).getNombreproveedor();
        setreport(folio, name, ser);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        int row = JtDetalle.getSelectedRow();
        String ped = k.get(row).getPedido();
        if (k.get(row).getStatus().equals("1")) {
//            Es importante la serie y que el pedido sea vacio ya que solo se permite borrar movimientos independientes
//            Tomar en cuenta solo algunas cuentas y no todas, entradas y salidas
            if ((cuenta == 60 || cuenta == 1 || cuenta == 10) && serie.equals("B") && ped.equals("")) {
                JbCancelar.setVisible(true);
            } else {
                JbCancelar.setVisible(false);
            }
        } else {
            JbCancelar.setVisible(false);
        }
        if (evt.getButton() == 3) {// activar con clic derecho
            Pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed

    }//GEN-LAST:event_jLabel6MousePressed

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        int row = JtDetalle.getSelectedRow();
        if (iscancel()) {
            daopedimentos dp = new daopedimentos();
            double stock = dp.getStockwithkardex(cpt, k.get(row).getId_kardex());
            //Verifica que la cantidad de la entrada no se mayor al stock del pedimento
            //ademas de que sea si o si una entrada, que no afecte las salidas
            if (k.get(row).getCantidad() >= stock && Be.isSelected()) {
                JOptionPane.showMessageDialog(null,
                        "NO SE PUEDE CANCELAR ENTRADA YA QUE EXCEDE EL STOCK DEL PEDIMENTO",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                setcancelar(row);
            }
        }

    }//GEN-LAST:event_JbCancelarActionPerformed

    private void JlSerieMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlSerieMousePressed
        if (evt.getButton() == 1) {
            clic++;
        }
        if (evt.getButton() == 3) {
            clic3++;
        }
        if (evt.getButton() == 2) {
            clic2++;
            String combinacion = clic + "" + clic2 + "" + clic3;
//            System.out.println(combinacion);
            if (combinacion.equals("211")) {
                if (serie.equals("A")) {
                    serie = "B";
                    JlSerie.setIcon(new ImageIcon(getClass().getResource("/Recursos/sticker_120054B.png")));// carga de logo
                } else {
                    serie = "A";
                    JlSerie.setIcon(new ImageIcon(getClass().getResource("/Recursos/sticker_120054A.png")));// carga de logo
                }
                clic = 0;
                clic2 = 0;
                clic3 = 0;
            }
        }
        Buscanotas();
    }//GEN-LAST:event_JlSerieMousePressed

    private void JlSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JlSerieKeyPressed

    }//GEN-LAST:event_JlSerieKeyPressed

    private void BeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeActionPerformed
        cuenta = 1;
        Buscanotas();
    }//GEN-LAST:event_BeActionPerformed

    private void BsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsActionPerformed
        cuenta = 60;
        Buscanotas();
    }//GEN-LAST:event_BsActionPerformed

    /**
     * Cuestion antes de ejecutar la cancelacion
     *
     * @return boleano , true si acepta la cancelacion
     */
    private boolean iscancel() {
        int resp = JOptionPane.showConfirmDialog(null, "Estas seguro de cancelar el movimiento?");
        return (resp == 0);
    }

    /**
     * Ejecuta la cancelacion del movimiento
     *
     * @param row linea del arraylist
     */
    private void setcancelar(int row) {
        daokardexrcpt dk = new daokardexrcpt();
        daoConceptos d = new daoConceptos();
        java.util.Date date = new Date();
//        Se obtiene un nuevo folio
        int folio = dk.maxkardexsincuenta(cpt);
//        Se obtiene el id del concepto de cancelacion
        ConceptosES e = d.getConceptos(cpt, 20, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        KardexCmp kar = k.get(row);
        kar.setId_concepto(e.getId_concepto());
        kar.setFolio(folio);
        kar.setFechadoc(sdf.format(date));
        kar.setFechamov(sdf.format(date));
        kar.setNombreusuario(u.getUsuario());
        if (dk.deleterow(cpt, kar)) {
            JOptionPane.showMessageDialog(null, "Proceso completo, REVISA TU REPORTE DE KARDEX");
            Buscanotas();
        }
    }

    /**
     * Despliega reporte del pedido individual
     *
     * @param folio
     * @param regimen
     * @param moneda
     * @param serie
     * @param total
     */
    private void setreport(int folio, String name, String serie) {
        try {
            Map parametros = new HashMap();
//            Agregar parametros al reporte
            parametros.put("idk", folio);
            parametros.put("serie", serie);
            parametros.put("nombre", name);
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportestpu/indexkardex.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Mov " + folio);
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//  Importante ya que es donde se usara la base de datos con clientes fiscales o internos
    private void Buscanotas() {
        Formateodedatos fd = new Formateodedatos();
//        obtiene la bd a usar mediante los datos del usuario y lo que se quiere buscar
        String cob = fd.getB_or_Amovs(u.getTipo_usuario(), u.getTurno(), serie);
//        if (u.getTipo_usuario().equals("2")) {
//            cob = (serie.equals("B")) ? "RACobranzaTpu" : "ACobranzaTpu";
//        } else {
//            cob = (serie.equals("B")) ? "[192.168.90.1\\DATOS620].RACobranzaTpu" : "ACobranzaTpu";
//        }
        String tipo = String.valueOf(cuenta);
        String var = JtCliente.getText();
        daokardexrcpt dk = new daokardexrcpt();
        k = dk.getkardex(cpt, serie, cob, tipo, var);
//        daofactura df = new daofactura();
//        arrfactura = df.getpedidos(cpt, JtCliente.getText(), serie);
        generatabla();
    }

    private void generatabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Folio");
        model.addColumn("Nombre");
        model.addColumn("Serie");
        model.addColumn("Fecha");
        model.addColumn("Cuenta");
        model.addColumn("Concepto");
        model.addColumn("Material");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Importe");
        model.addColumn("Pedido");
        model.addColumn("Estado");
        model.setNumRows(k.size());
        DecimalFormat formateador = new DecimalFormat("####.##");
        for (int i = 0; i < k.size(); i++) {
            String estat = "0";
            switch (k.get(i).getStatus()) {
                case "0":
                    estat = "NO ACTIVA";
                    break;
                case "1":
                    estat = "ACTIVA";
                    break;
                case "2":
                    estat = "CANCELADA";
                    break;
            }
////            System.out.println(arrfactura.get(i).getTotal());
            model.setValueAt(k.get(i).getId_kardex(), i, 0);
            model.setValueAt(k.get(i).getNombreproveedor(), i, 1);
            model.setValueAt(k.get(i).getSerie(), i, 2);
            model.setValueAt(k.get(i).getFechamov(), i, 3);
            model.setValueAt(k.get(i).getCuenta(), i, 4);
            model.setValueAt(k.get(i).getNombrecuenta(), i, 5);
            model.setValueAt(k.get(i).getNombrematerial() + " " + k.get(i).getDureza(), i, 6);
            model.setValueAt(formateador.format(k.get(i).getCantidad()), i, 7);
            model.setValueAt(formateador.format(k.get(i).getCosto()), i, 8);
            model.setValueAt(formateador.format(k.get(i).getImporte()), i, 9);
            model.setValueAt(k.get(i).getPedido(), i, 10);
            model.setValueAt(estat, i, 11);
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
    private javax.swing.JRadioButton Be;
    private javax.swing.JRadioButton Bs;
    private javax.swing.JMenuItem JbCancelar;
    private javax.swing.JLabel JlSerie;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JPopupMenu Pop;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
