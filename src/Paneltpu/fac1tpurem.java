/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import DAO.daoAgentes;
import DAO.daoCargos;
import DAO.daoConceptos;
import DAO.daoDevolucion;
import Paneles.*;
import DAO.daocfdi;
import DAO.daofactura;
import DAO.daokardexrcpt;
import Modelo.ConceptosES;
import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Formadepago;
import Modelo.Formateodedatos;
import Modelo.KardexCmp;
import Modelo.Usuarios;
import Modelo.cargo;
import Modelo.convertirNumeros;
import Modelo.factura;
import Modelo.metodopago;
import Modelo.usocfdi;
import Panelmaq.Modificaprecio_pedido;
import Server.Serverprod;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class fac1tpurem extends javax.swing.JPanel {

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

    /**
     * Creates new form Cliente1
     */
    public fac1tpurem() {
        initComponents();
        JtCliente.requestFocus();
        JbCancelar1.setEnabled(true);
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
        JbCancelar1 = new javax.swing.JMenuItem();
        Cancelamiento = new javax.swing.JMenuItem();
        JmAddprecios = new javax.swing.JMenuItem();
        JmRefacturacion = new javax.swing.JMenuItem();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JlSerie = new javax.swing.JLabel();

        JbCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Return_icon-icons.com_54801.png"))); // NOI18N
        JbCancelar1.setText("Devolucion salida");
        JbCancelar1.setToolTipText("");
        JbCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelar1ActionPerformed(evt);
            }
        });
        Pop.add(JbCancelar1);

        Cancelamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        Cancelamiento.setText("Cancelacion Pedido");
        Cancelamiento.setToolTipText("");
        Cancelamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelamientoActionPerformed(evt);
            }
        });
        Pop.add(Cancelamiento);

        JmAddprecios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/edit-validated_40458.png"))); // NOI18N
        JmAddprecios.setText("Modificar precios");
        JmAddprecios.setToolTipText("");
        JmAddprecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAddpreciosActionPerformed(evt);
            }
        });
        Pop.add(JmAddprecios);

        JmRefacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/move_23058.png"))); // NOI18N
        JmRefacturacion.setText("Refacturacion");
        JmRefacturacion.setToolTipText("");
        JmRefacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmRefacturacionActionPerformed(evt);
            }
        });
        Pop.add(JmRefacturacion);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtClienteActionPerformed
        Buscanotas();
    }//GEN-LAST:event_JtClienteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
        daoAgentes a = new daoAgentes();

        int row = JtDetalle.getSelectedRow();
        int folio = arrfactura.get(row).getId_pedido();
        String ser = arrfactura.get(row).getSerie();
        double total = Double.parseDouble(formateador.format(arrfactura.get(row).getTotal()));
        String ped = arrfactura.get(row).getPedido();
        if (u.getTurno().equals("6") || u.getTurno().equals("7")) {
            String name = JOptionPane.showInputDialog("Introduzca el nombre del cliente:");
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede mostrar el reporte del cliente ya que no se introdujo ningun valor, intentelo de nuevo");
            } else {
                setreportcliente(folio, "MXN", ser, total, ped, name.toUpperCase());
            }
        }
        setreport(folio, "MXN", ser, total, ped);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed

        int row = JtDetalle.getSelectedRow();
        String estados = arrfactura.get(row).getEstatus() + "";
        if (arrfactura.get(row).getSerie().equals("B") && estados.equals("1")) {
            JbCancelar1.setVisible(true);
            Cancelamiento.setVisible(true);
        } else {
            JbCancelar1.setVisible(false);
            Cancelamiento.setVisible(false);
        }
        //Maquinaria
        if (u.getTurno().equals("6") && arrfactura.get(row).getSerie().equals("B")) {
            JmAddprecios.setVisible(true);
        } else {
            JmAddprecios.setVisible(false);
        }
        //Refacturacion
        if (u.getTurno().equals("7")) {
            JmRefacturacion.setVisible(true);
        } else {
            JmRefacturacion.setVisible(false);
        }
        if (evt.getButton() == 3) {// activar con clic derecho
            Pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed

    }//GEN-LAST:event_jLabel6MousePressed

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
            System.out.println(combinacion);
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
    }//GEN-LAST:event_JlSerieMousePressed

    private void JlSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JlSerieKeyPressed

    }//GEN-LAST:event_JlSerieKeyPressed

    private void JbCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelar1ActionPerformed
        daoDevolucion de = new daoDevolucion();
        int rows = de.verificadevsped(cpt, "B", arrfactura.get(JtDetalle.getSelectedRow()).getId_pedido());
        if (rows != 0) {
            JOptionPane.showMessageDialog(null, "Ya hay una devolucion existente ", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int row = JtDetalle.getSelectedRow();
            Cancelapedidos can = new Cancelapedidos(null, true);
            can.cpt = cpt;
            can.cob = cobB;
            can.u = u;

            can.muestradatos(arrfactura.get(row).getNombrecliente(), arrfactura.get(row).getPedido(), arrfactura.get(row).getId_pedido(), arrfactura.get(row).getIdcliente());
            can.setVisible(true);
            Buscanotas();
        }
    }//GEN-LAST:event_JbCancelar1ActionPerformed

    private void CancelamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelamientoActionPerformed
        String botones[] = {"Aceptar", ""
            + ""
            + "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(this, "¿Estas seguro que deseas realizar la cancelacion?, \nRecuerda que ya no hay retroceso en este proceso", "ATHLETIC",
                0, 0, null, botones, this);
        if (opcion == JOptionPane.YES_OPTION) {
            int row = JtDetalle.getSelectedRow();
//            boolean ncr = getdoccancel(arrfactura.get(row).getId(), "NCR");
//            boolean pag = getdoccancel(arrfactura.get(row).getId(), "PAG");
            ArrayList<Ddevolucion> arrd = new ArrayList<>();
            ArrayList<Ddevolucion> arrdevpedimento = new ArrayList();
            Devolucion dev = new Devolucion();
            Formateodedatos fd = new Formateodedatos();
//            Obtiene la direcion con la bd correcta de acuerdo al turno del usuario
            String bdcob = fd.getBDcob_REMinterna(u.getTurno());
//            if (u.getTurno().equals("5")) {
//                bdcob = "[192.168.90.1\\DATOS620].RACobranzaTpu.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
//            }
//            if (u.getTurno().equals("6")) {
//                bdcob = "[192.168.90.1\\DATOS620].RACobranzamaq.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
//            }
//            if (u.getTurno().equals("6")) {
//                bdcob = "[192.168.90.1\\DATOS620].RACobranzamaq.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS";
//            }
//            bdcob = (u.getTurno().equals("5")) ? "RACobranzaTpu" : "RACobranzamaq";
//            String bdcob = "RACobranzatpu.dbo.Cargo c on p.pedido=c.referencia";
//            if (!ncr && !pag) {
            daoDevolucion d = new daoDevolucion();
            daokardexrcpt dk = new daokardexrcpt();
            int rows = d.verificadevsped(cpt, "B", arrfactura.get(JtDetalle.getSelectedRow()).getId_pedido());
//                Verifica si hay devoluciones o no, si tiene entra sino solo hace el regreso al kardex
            if (rows != 0) {
                arrd = d.getpedscancelrem(cpt, arrfactura.get(row).getId_pedido(), "B", bdcob);
                arrdevpedimento = d.getdevolucion(cpt, arrd.get(0).getId_devolucion());
                dev.setId_kardex(dk.maxkardexsincuenta(cpt));
                dev.setId_kardexnuevo(dev.getId_kardex() + 1);
            } else {
                arrd = d.getpedidocancelsindev(cpt, arrfactura.get(row).getId_pedido(), "B", bdcob);
                dev.setId_kardexnuevo(dk.maxkardexsincuenta(cpt));
            }
//                if (arrd.isEmpty() || arrdevpedimento.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Error al cancelar, contacta a sistemas");
//                } else {

            daoConceptos dc = new daoConceptos();
            java.util.Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            ConceptosES cuentacancel = dc.getConceptos(cpt, 70, 20);
            ConceptosES cuentadevstock = dc.getConceptos(cpt, 20, 1);
            dev.setCuenta1(cuentacancel.getId_concepto());
            dev.setCuenta2(cuentadevstock.getId_concepto());
            dev.setFecha(sdf.format(date));
            dev.setId_pedido(arrd.get(0).getId_pedido());
            dev.setNombre(arrfactura.get(row).getNombre());
            dev.setId_cliente(arrfactura.get(row).getIdcliente());
            dev.setSerie("B");
            dev.setId_cargoenc(arrd.get(0).getId_cargo());
            dev.setId_dev(arrd.get(0).getId_devolucion());
            dev.setUsuario(u.getUsuario());
            dev.setArr(arrd);
            if (d.nuevacancelacion(cpt, cobB, dev, arrdevpedimento)) {
                JOptionPane.showMessageDialog(null, "Proceso completo");
                Buscanotas();
                JtCliente.requestFocus();
            }

//            }
        }
    }//GEN-LAST:event_CancelamientoActionPerformed

    private void JmAddpreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAddpreciosActionPerformed
        cargadpedidos();
    }//GEN-LAST:event_JmAddpreciosActionPerformed

    private void JmRefacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmRefacturacionActionPerformed
        if (u.getTurno().equals("7")) {
            int row=JtDetalle.getSelectedRow();
            daoCargos dc = new daoCargos();
            daoConceptos dconcepto= new daoConceptos();
            cargo car=dc.getCargowith_pedido(cobB, arrfactura.get(row));
            car.setId_concepto(dconcepto.getConceptos_cob(cobB, 10, 25));
            car.setId_concepto2(dconcepto.getConceptos_cob(cobB, 60, 40));
        }
    }//GEN-LAST:event_JmRefacturacionActionPerformed

    private void refacturacion() {

    }

    private void cargadpedidos() {
        int row = JtDetalle.getSelectedRow();
        Modificaprecio_pedido mp = new Modificaprecio_pedido(null, true);
        mp.setconections(cpt, cobB, arrfactura.get(row), u);
        mp.llenatabla();
        mp.setVisible(true);
        Buscanotas();
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
    private void setreport(int folio, String moneda, String serie, double total, String pedido) {
        try {
            String dir = (u.getTurno().equals("5")) ? "Reportestpu" : "ReportesMaq";
//             fin identificar empresa
            Map parametros = new HashMap();
//            Clase que contiene el numero convertido a caracter
            convertirNumeros cnum = new convertirNumeros();
            DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
            String numeros = formateador.format(total);
            String letratotal = cnum.Convertir(numeros, true, moneda);
//            Agregar parametros al reporte
            parametros.put("id", folio);
            parametros.put("totalletra", letratotal);
            parametros.put("serie", serie);
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/" + dir + "/Pedidos.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Pedido " + pedido);
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Exclusivamente para el apartado de el modulo de maquinas de nailea
     *
     * @param folio
     * @param moneda
     * @param serie
     * @param total
     * @param pedido
     * @param ncliente
     */
    private void setreportcliente(int folio, String moneda, String serie, double total, String pedido, String ncliente) {
        try {
//             fin identificar empresa
            Map parametros = new HashMap();
//            Clase que contiene el numero convertido a caracter
            convertirNumeros cnum = new convertirNumeros();
            DecimalFormat formateador = new DecimalFormat("####.##");//para los decimales
            String numeros = formateador.format(total);
            String letratotal = cnum.Convertir(numeros, true, moneda);
//            Agregar parametros al reporte
            parametros.put("id", folio);
            parametros.put("totalletra", letratotal);
            parametros.put("serie", serie);
            parametros.put("ncliente", ncliente);
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/ReportesMaq/Pedidos_cliente.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Pedido cliente " + pedido);
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void Buscanotas() {
        daofactura df = new daofactura();
        arrfactura = df.getpedidos(cpt, JtCliente.getText(), serie);
        generatabla();
    }

    private void generatabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Pedido");
        model.addColumn("Cliente");
        model.addColumn("Kardex");
        model.addColumn("Fecha");
        model.addColumn("Subtotal");
        model.addColumn("Iva");
        model.addColumn("Total");
        model.addColumn("Serie");
        model.addColumn("Concepto");
        model.addColumn("Estado");
        model.setNumRows(arrfactura.size());
        DecimalFormat formateador = new DecimalFormat("####.##");
        for (int i = 0; i < arrfactura.size(); i++) {
            String estat = (arrfactura.get(i).getEstatus() == 1) ? "ACTIVA" : "NO ACTIVA";
//            System.out.println(arrfactura.get(i).getTotal());
            model.setValueAt(arrfactura.get(i).getPedido(), i, 0);
            model.setValueAt(arrfactura.get(i).getNombrecliente(), i, 1);
            model.setValueAt(arrfactura.get(i).getId_kardex(), i, 2);
            model.setValueAt(arrfactura.get(i).getFecha(), i, 3);
            model.setValueAt(formateador.format(arrfactura.get(i).getSubtotal()), i, 4);
            model.setValueAt(formateador.format(arrfactura.get(i).getImpuestos()), i, 5);
            model.setValueAt(formateador.format(arrfactura.get(i).getTotal()), i, 6);
            model.setValueAt(arrfactura.get(i).getSerie(), i, 7);
            model.setValueAt(arrfactura.get(i).getDesccuenta(), i, 8);
            model.setValueAt(estat, i, 9);
        }
        JtDetalle.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Cancelamiento;
    private javax.swing.JMenuItem JbCancelar1;
    private javax.swing.JLabel JlSerie;
    private javax.swing.JMenuItem JmAddprecios;
    private javax.swing.JMenuItem JmRefacturacion;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JPopupMenu Pop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
