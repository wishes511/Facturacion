/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daoControlinventarios;
import DAO.daoInventarios;
import DAO.daopedimentos;
import Modelo.Conexiones;
import Modelo.Controlinventario;
import Modelo.Formateodedatos;
import Modelo.Inventario;
import Modelo.Usuarios;
import Modelo.pedimento;
import Paneltpu.Nuevacapturainv;
import Paneltpu.VerInventarios;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author GATEWAY1- 25/09/2023
 */
public class Inventarios extends javax.swing.JInternalFrame {

    Connection cpt, rcpt, cobranza;
    Connection litecfdi, liteusuario;
    ArrayList<Inventario> arrinv = new ArrayList<>();
    ArrayList<pedimento> arr = new ArrayList<>();
    Controlinventario inv = new Controlinventario();
    double diferencias;
    private Usuarios u;

    /**
     * Creates new form Materiales
     *
     * @param c
     * @param u
     */
    public Inventarios(Conexiones c, Usuarios u) {
        initComponents();
        cpt = c.getCpttpu();
        rcpt = c.getRcpttpu();
        cobranza = c.getCobranzatpu();
        litecfdi = c.getLitecfdi();
        liteusuario = c.getLiteusuario();
        this.u=u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop = new javax.swing.JPopupMenu();
        JmBaja = new javax.swing.JMenuItem();
        Pop_reporte = new javax.swing.JPopupMenu();
        JmReporte = new javax.swing.JMenuItem();
        JmReporte_pedimento = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JlFecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JlRespalldo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        JmBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JmBaja.setText("Eliminar pedimento");
        JmBaja.setToolTipText("");
        JmBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBajaActionPerformed(evt);
            }
        });
        pop.add(JmBaja);

        JmReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_table_order_report_history_2332.png"))); // NOI18N
        JmReporte.setText("Reporte Inventarios");
        JmReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmReporteActionPerformed(evt);
            }
        });
        Pop_reporte.add(JmReporte);

        JmReporte_pedimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/documenttextregular_106258.png"))); // NOI18N
        JmReporte_pedimento.setText("Reporte Material sin pedimento");
        JmReporte_pedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmReporte_pedimentoActionPerformed(evt);
            }
        });
        Pop_reporte.add(JmReporte_pedimento);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Inventarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_inventory_maintenance_product_box_boxes_2326.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JtDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtDetalle);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add_plus_interface_icon_181584.png"))); // NOI18N
        jLabel1.setToolTipText("Agregar nuevo proveedor");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Inventario :");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        JlFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        JlFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlFechaMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file_pdf_download_icon-icons.com_68954.png"))); // NOI18N
        jLabel2.setToolTipText("Imprimir reporte para captura de inventario");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/business_package_box_accept_productorpackagetoaccept_negocio_paquet_2334.png"))); // NOI18N
        jLabel3.setToolTipText("Realizar cierre de mes");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        JlRespalldo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JlRespalldo.setForeground(new java.awt.Color(255, 102, 102));
        JlRespalldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlRespalldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlRespalldoMousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/books_21813.png"))); // NOI18N
        jLabel4.setToolTipText("Reporte de inventarios anteriores");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/file-expand_Pdf_icon-icons.com_68956.png"))); // NOI18N
        jLabel5.setToolTipText("Imprimir diferencias de sistema y captura");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JlRespalldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(JlFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JlRespalldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        Nuevacapturainv n = new Nuevacapturainv(null, true);
        n.cpt = cpt;
        n.cargausuario(u);
        n.liteusuario = liteusuario;
        n.setcombo();
        n.setVisible(true);
        setrows();
    }//GEN-LAST:event_jLabel1MousePressed

    private void setrows() {
        daopedimentos d = new daopedimentos();
        daoInventarios di = new daoInventarios();
//        Obtiene los registros de el stock de sistemas y los registros del inventario 
        arr = d.getpedimentoinv(cpt);
        arrinv = di.getinventariostocheck(liteusuario);
        settable();
    }

    private void settable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Pedimento");
        model.addColumn("Material");
        model.addColumn("Stock sistema");
        model.addColumn("Captura inventario");
        model.addColumn("Diferencia");
        model.setNumRows(arrinv.size());
        JtDetalle.setModel(model);
        setarraywithinv();
        for (int i = 0; i < arrinv.size(); i++) {
            JtDetalle.setValueAt(arrinv.get(i).getReferencia(), i, 0);
            JtDetalle.setValueAt(arrinv.get(i).getNombre(), i, 1);
            JtDetalle.setValueAt(arrinv.get(i).getCantidadpedimento(), i, 2);
            JtDetalle.setValueAt(arrinv.get(i).getCantidad(), i, 3);
            JtDetalle.setValueAt(arrinv.get(i).getDiferencias(), i, 4);
        }
    }

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        if (evt.getButton() == 3) {// activar con clic derecho
            pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed

    private void JmBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBajaActionPerformed
        daoInventarios di = new daoInventarios();
//        Elimina el pedimento completo de la captura de inventario
        if (di.deletepedimento(liteusuario, arrinv.get(JtDetalle.getSelectedRow()).getId_pedimento())) {
            JOptionPane.showMessageDialog(null, "Eliminacion completa!");
            setrows();
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar el pedimento de la captura de inv.");
        }
    }//GEN-LAST:event_JmBajaActionPerformed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void JlFechaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlFechaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JlFechaMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        setreporte("Pedimento_inventario");
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
//        Realiza la validacion de el total de las lineas del sistema con lo capturado, ademas muestra las diferencias
        if (arr.size() != arrinv.size()) {
            JOptionPane.showMessageDialog(null, "No se puede realizar inventario debido a diferencia en captura "
                    + "de inventario y stock de sistema\nTienes " + diferencias + " diferencias y numero de "
                    + "materiales con pedimentos " + arr.size() + "/" + arrinv.size(), "Error en inventarios", JOptionPane.ERROR_MESSAGE);
        } else {
            String botones[] = {"Aceptar", ""
                + ""
                + "Cancelar"};
            int opcion = JOptionPane.showOptionDialog(this, "Estas seguro de generar cierre?, recuerda que ya no hay cambios despues del proceso.", "TPU",
                    0, 0, null, botones, this);
            if (opcion == JOptionPane.YES_OPTION) {
                generarcierre();
            }

        }
    }//GEN-LAST:event_jLabel3MousePressed

    private void JlRespalldoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlRespalldoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JlRespalldoMousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        Pop_reporte.show(evt.getComponent(), evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        setreporte("Invsiscap");
    }//GEN-LAST:event_jLabel5MousePressed

    private void JmReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmReporteActionPerformed
        verinventarios();
    }//GEN-LAST:event_JmReporteActionPerformed

    private void JmReporte_pedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmReporte_pedimentoActionPerformed
        vermat_sinpedimento();
    }//GEN-LAST:event_JmReporte_pedimentoActionPerformed

    private void verinventarios() {
        VerInventarios v = new VerInventarios(null, true);
//        Manda el valor de la conexion ademas verifica que haya registros anteriores para el despliegue del reporte
//        Ahi mismo despliega una interfaz si es que hay registros
        v.cpt = cpt;
        if (v.setcombo()) {
            JOptionPane.showMessageDialog(null, "No se ha hecho ningun inventario, por lo tanto no puedes imprimir algun reporte",
                    "No hay Inventarios", JOptionPane.ERROR_MESSAGE);
        } else {
            v.llenacombo();
            v.setVisible(true);
        }
    }

    private void vermat_sinpedimento() {
        try {
            Formateodedatos fd = new Formateodedatos();
            Map parametros = new HashMap();
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource(fd.getReporte_inv(u.getTurno())+".jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, cpt);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Despliegue de Materiales sin pedimento");
            ver.setVisible(true);
//            Exportacion al archivo pdf
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede desplegar reporte " + ex.getMessage(), "Error en reporte", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Despliega el reporte de acuerdo a el inv. capturado y las diferencias
     *
     * @param reporte
     */
    private void setreporte(String reporte) {
        try {
//            Se selecciona el tipo de conexion
            Connection con = (reporte.equals("Invsiscap")) ? liteusuario : cpt;
            Map parametros = new HashMap();
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportestpu/" + reporte + ".jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, con);
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Despliegue de inventarios");
            ver.setVisible(true);
//            Exportacion al archivo pdf
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se puede desplegar reporte " + ex.getMessage(), "Error en reporte", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generarcierre() {
        daoInventarios di = new daoInventarios();
//        Reliza la insercion de los registros en la tabla del inventariado,
//        borra los registros de las tablas de sqlite, ademas de que actualiza 
//        los registros de control de inventario
        if (di.nuevoinventario(cpt, liteusuario, arrinv, inv.getMes(), inv.getYears())) {
            JlRespalldo.setText("GENERANDO RESPALDO, PORFAVOR NO CERRAR");
//        Realiza respaldo de la bd    
            di.ejecutarespcierre(cpt, inv.getMes(), inv.getYears());
            getfecha();
            JlRespalldo.setText("");
            JOptionPane.showMessageDialog(null, "Completo");
        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio algun error al generar el cierre de mes.");
        }

    }

    /**
     * Obtiene el periodo actual de inventarios desde el server ya que ahi esta
     * la informacion alojada
     */
    public void getfecha() {
        daoControlinventarios co = new daoControlinventarios();
        inv = co.getarrinv(cpt);
        JlFecha.setText(inv.getMes() + "-" + inv.getYears());
        setrows();
    }

    private void setarraywithinv() {
        diferencias = 0;
//        Se utiliza primero el inv. capturado y asi se limita el numero de renglones para no causar un
//        Overflow por diferencias de posibles renglones
        for (int i = 0; i < arrinv.size(); i++) {
            int idinv = arrinv.get(i).getId_dpedimento();
//            Ahora se recorre el segundo array para buscar el dpedimento
            for (int j = 0; j < arr.size(); j++) {
                int idarr = arr.get(j).getDp().getId_dpedimento();
//          Si lo encuentra se crea un nuevo objeto de tipo inventario para obtener y hacer una modificacion en
//          la parte de cantidades, referencia y las diferencias, si es que existen
                if (idinv == idarr) {
                    daoInventarios d = new daoInventarios();
                    double cantinv = arrinv.get(i).getCantidad();
                    double cantarr = arr.get(j).getDp().getCantrestante();
                    double dif = BigDecimal.valueOf(cantarr - cantinv).setScale(2, RoundingMode.FLOOR).doubleValue();
                    Inventario invent = arrinv.get(i);
                    invent.setCantidadpedimento(arr.get(j).getDp().getCantrestante());
                    invent.setReferencia(arr.get(j).getReferencia());
                    invent.setDiferencias(dif);
                    diferencias += dif;
                    arrinv.set(i, invent);
//                    Actualizar referencia y cantidad de sistema en sqlite
                    d.updatecantin_inv(liteusuario, invent);
                    j = arr.size();
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlFecha;
    private javax.swing.JLabel JlRespalldo;
    private javax.swing.JMenuItem JmBaja;
    private javax.swing.JMenuItem JmReporte;
    private javax.swing.JMenuItem JmReporte_pedimento;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JPopupMenu Pop_reporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}
