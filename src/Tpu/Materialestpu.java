/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daomateriales;
import Modelo.Conexiones;
import Modelo.Materiales;
import Modelo.Usuarios;
import Paneltpu.Nuevomaterial;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Materialestpu extends javax.swing.JInternalFrame {

    Connection cpt, rcpt, cobranza;
    Connection litecfdi;
    ArrayList<Materiales> arrmat = new ArrayList<>();

    /**
     * Creates new form Materiales
     *
     * @param c
     * @param u
     */
    public Materialestpu(Conexiones c, Usuarios u) {
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
        JmModificar = new javax.swing.JMenuItem();
        JmBorrar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtMaterial = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        JmModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/applicationsgraphicsdrawing_103768.png"))); // NOI18N
        JmModificar.setText("Modificar Material");
        pop.add(JmModificar);

        JmBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/crosscircleregular_106260.png"))); // NOI18N
        JmBorrar.setText("Borrar material");
        pop.add(JmBorrar);

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Materiales");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/material_colors_macos_bigsur_icon_189995.png"))); // NOI18N
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
        jLabel1.setToolTipText("Agregar nuevo material");
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
        Nuevomaterial n = new Nuevomaterial(null, true);
        n.cpt = cpt;
        n.rcpt = rcpt;
        n.litecfdi = litecfdi;
        n.setVisible(true);
    }//GEN-LAST:event_jLabel1MousePressed

    private void JtMaterialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMaterialMousePressed
        JtMaterial.setText("");
    }//GEN-LAST:event_JtMaterialMousePressed

    private void JtMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtMaterialActionPerformed
        setrows();
    }//GEN-LAST:event_JtMaterialActionPerformed

    private void setrows() {
        daomateriales dm = new daomateriales();
        arrmat = dm.getmateriales(cpt, JtMaterial.getText().toUpperCase());
        settable();
    }

    private void settable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Material");
        model.addColumn("precio");
        model.addColumn("unidad");
        model.addColumn("Clavesat");
        model.setNumRows(arrmat.size());
        for (int i = 0; i < arrmat.size(); i++) {
            model.setValueAt(arrmat.get(i).getDescripcion(), i, 0);
            model.setValueAt(arrmat.get(i).getPrecio(), i, 1);
            model.setValueAt(arrmat.get(i).getUnidad(), i, 2);
            model.setValueAt(arrmat.get(i).getCodigosat(), i, 3);
        }
        JtDetalle.setModel(model);
    }

    private void JtDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtDetalleMousePressed
        if (evt.getButton() == 3) {// activar con clic derecho
            pop.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtDetalleMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmBorrar;
    private javax.swing.JMenuItem JmModificar;
    private javax.swing.JTable JtDetalle;
    public javax.swing.JTextField JtMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}