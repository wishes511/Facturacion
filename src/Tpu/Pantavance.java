/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tpu;

import DAO.daodurezas;
import Modelo.Conexiones;
import Modelo.Dureza;
import Modelo.Usuarios;
import Paneltpu.Nuevadurez;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Pantavance extends javax.swing.JInternalFrame {

    Connection cpt, rcpt, cobranza;
    Connection litecfdi;
    ArrayList<Dureza> arrdureza = new ArrayList<>();

    /**
     * Creates new form Materiales
     *
     * @param c
     * @param u
     */
    public Pantavance() {
        initComponents();
        settable();

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
        JtMaterial = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pane = new javax.swing.JEditorPane();

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
        setMaximizable(true);
        setResizable(true);
        setTitle("Durezas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Data_Meter4_37237.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

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

        jScrollPane1.setViewportView(Pane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1244, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtMaterialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtMaterialMousePressed
        JtMaterial.setText("");
    }//GEN-LAST:event_JtMaterialMousePressed

    private void JtMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtMaterialActionPerformed

    }//GEN-LAST:event_JtMaterialActionPerformed

    private void setrows() {
        daodurezas d = new daodurezas();
        arrdureza=d.getalldurezas(cpt, JtMaterial.getText());
        settable();
    }

    private void settable() {
        try {
            Pane.setEditable(false);
            Pane.setPage("http://192.168.6.8:85/Avances/index.jsp");
            Pane.addHyperlinkListener(new HyperlinkListener(){
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e) {
                    if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                        try {
                            Pane.setPage(e.getURL());
                        } catch (IOException ex) {
                            Logger.getLogger(Pantavance.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            
        } catch (IOException ex) {
            Logger.getLogger(Pantavance.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void JmBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmBajaActionPerformed

    }//GEN-LAST:event_JmBajaActionPerformed

    private void JmAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmAltaActionPerformed

    }//GEN-LAST:event_JmAltaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmAlta;
    private javax.swing.JMenuItem JmBaja;
    public javax.swing.JTextField JtMaterial;
    private javax.swing.JEditorPane Pane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu pop;
    // End of variables declaration//GEN-END:variables
}
