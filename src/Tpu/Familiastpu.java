/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daofamilias;
import Modelo.Conexiones;
import Modelo.Familia;
import Modelo.Usuarios;
import Paneltpu.Nuevafamilia;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Familiastpu extends javax.swing.JInternalFrame {

    Connection cpt, rcpt, cobranza;
    Connection litecfdi;
    ArrayList<Familia> arrfam = new ArrayList<>();

    /**
     * Creates new form Materiales
     *
     * @param c
     * @param u
     */
    public Familiastpu(Conexiones c, Usuarios u) {
        initComponents();
        cpt = c.getCpttpu();
        rcpt = c.getRcpttpu();
        cobranza = c.getCobranzatpu();
        litecfdi = c.getLitecfdi();

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
        JmAlta = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtMaterial = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        JmBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        JmBaja.setText("Dar de baja");
        JmBaja.setToolTipText("");
        JmBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmBajaActionPerformed(evt);
            }
        });
        pop.add(JmBaja);

        JmAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tickflat_105962.png"))); // NOI18N
        JmAlta.setText("Activar proveedor");
        JmAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmAltaActionPerformed(evt);
            }
        });
        pop.add(JmAlta);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Familias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/family_pedestrian_icon_216646.png"))); // NOI18N
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/1486485588-add-create-new-math-sign-cross-plus_81186.png"))); // NOI18N
        jLabel1.setToolTipText("Agregar nuevo proveedor");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        JtMaterial.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtMaterial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtMaterial.setBorder(null);
        JtMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtMaterialMousePressed(evt);
            }
        });
        JtMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtMaterialActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JtMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        Nuevafamilia n = new Nuevafamilia(null, true);
        n.cpt = cpt;
        n.setVisible(true);
        JtMaterial.setText("");
        setrows();
    }//GEN-LAST:event_jLabel1MousePressed

    private void JtMaterialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMaterialMousePressed
        JtMaterial.setText("");
    }//GEN-LAST:event_JtMaterialMousePressed

    private void JtMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtMaterialActionPerformed
        setrows();
    }//GEN-LAST:event_JtMaterialActionPerformed

    private void setrows() {
        daofamilias d = new daofamilias();
        arrfam=d.getallfamilia(cpt, JtMaterial.getText());
        settable();
    }

    private void settable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Familia");
        model.addColumn("Estado");
        model.setNumRows(arrfam.size());
        for (int i = 0; i < arrfam.size(); i++) {
            String estado = (arrfam.get(i).getEstatus().equals("1")) ? "Activo" : "Inactivo";
            model.setValueAt(arrfam.get(i).getDescripcion(), i, 0);
            model.setValueAt(estado, i, 1);
        }
        JtDetalle.setModel(model);
    }

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        String estado = arrfam.get(JtDetalle.getSelectedRow()).getEstatus();
        if (estado.equals("1")) {
            JmBaja.setVisible(true);
            JmAlta.setVisible(false);
        } else {
            JmBaja.setVisible(false);
            JmAlta.setVisible(true);
        }

        if (evt.getButton() == 3) {// activar con clic derecho
            pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed

    private void JmBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBajaActionPerformed
        cambiaestado();
        setrows();
    }//GEN-LAST:event_JmBajaActionPerformed

    private void JmAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAltaActionPerformed
        cambiaestado();
        setrows();
    }//GEN-LAST:event_JmAltaActionPerformed

    private void cambiaestado() {
        String estado = (arrfam.get(JtDetalle.getSelectedRow()).getEstatus().equals("1")) ? "0" : "1";
        int id = arrfam.get(JtDetalle.getSelectedRow()).getId_familia();
        daofamilias d = new daofamilias();
        if (d.updateestatus(cpt, id, estado)) {
            JOptionPane.showMessageDialog(null, "Modificacion de estado completo");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmAlta;
    private javax.swing.JMenuItem JmBaja;
    private javax.swing.JTable JtDetalle;
    public javax.swing.JTextField JtMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}
