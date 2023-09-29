/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneltpu;

import DAO.daoInventarios;
import DAO.daofactura;
import DAO.daopedimentos;
import Modelo.Formateodedatos;
import Modelo.Inventario;
import Modelo.pedimento;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Nuevacapturainv extends javax.swing.JDialog {

    public Connection cob, cpt;
    public Connection liteusuario;
    ArrayList<pedimento> arr = new ArrayList<>();
    ArrayList<pedimento> arrdet = new ArrayList<>();
    ArrayList<Inventario> arrlite = new ArrayList<>();

    /**
     * Creates new form Modinventarios
     */
    public Nuevacapturainv(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JcPed = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtDetalle = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bordeazul.png")))); // NOI18N

        JcPed.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        JcPed.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcPedItemStateChanged(evt);
            }
        });
        JcPed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JcPedMousePressed(evt);
            }
        });
        JcPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcPedActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jLabel7.setText("Nueva captura de inventario");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/crosscircleregular_106260.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        JtDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JtDetalle);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Pedimento");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JcPed, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JcPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcPedActionPerformed
        buscaregistros();
    }//GEN-LAST:event_JcPedActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        dispose();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        nuevoregistro();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void JcPedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JcPedMousePressed

    }//GEN-LAST:event_JcPedMousePressed

    private void JcPedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcPedItemStateChanged

    }//GEN-LAST:event_JcPedItemStateChanged

    private void buscaregistros() {
        daopedimentos d = new daopedimentos();
        arrdet = d.getpedimentoaadv(cpt, "referencia='" + arr.get(JcPed.getSelectedIndex()).getReferencia() + "'");
        settabla();
    }

    private void limpiarcampos() {
        arr.clear();
        arrlite.clear();
        arrdet.clear();
        setcombo();
        settabla();
    }

    private void nuevoregistro() {
        ArrayList<Inventario> arrnuevo = new ArrayList<>();
        Formateodedatos f = new Formateodedatos();
        boolean band = true;
        for (int i = 0; i < arrdet.size(); i++) {
            Inventario inv = new Inventario();
            String ren = JtDetalle.getValueAt(i, 1).toString();
            if (f.verificafloat(ren)) {
                inv.setId_pedimento(arrdet.get(i).getId_pedimento());
                inv.setId_dpedimento(arrdet.get(i).getDp().getId_dpedimento());
                inv.setId_material(arrdet.get(i).getDp().getId_material());
                inv.setDureza(arrdet.get(i).getDp().getDureza());
                inv.setNombre(arrdet.get(i).getDp().getMatped());
                inv.setCantidad(Double.parseDouble(ren));
            } else {
                band = false;
                i = arrdet.size();
            }
            arrnuevo.add(inv);
        }
        if (band) {
            daoInventarios da = new daoInventarios();
            String resp = (da.nuevoregistroinv(liteusuario, arrnuevo)) ? "Registro completo" : "Error al capturar el pedimento, intentelo de nuevo";
            JOptionPane.showMessageDialog(null, resp);
            limpiarcampos();
        } else {
            JOptionPane.showMessageDialog(null, "Alguno de los valores ingresados en la cantidad es incorrecta, verifica los valores");
        }
    }

    public void setcombo() {
        DefaultComboBoxModel ped = new DefaultComboBoxModel();
        daopedimentos d = new daopedimentos();
        daoInventarios di = new daoInventarios();
        arr = d.getallpedimento(cpt, "");
        arrlite = di.getinventarios(liteusuario);
        organizaarray();
        for (int i = 0; i < arr.size(); i++) {
            ped.addElement(arr.get(i).getReferencia());
        }
        JcPed.setModel(ped);
    }

    public void settabla() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Material");//0  estilo combinacion corrida
        model.addColumn("Cantidad");//0  estilo combinacion corrida
        model.setRowCount(arrdet.size());
        JtDetalle.setModel(model);
        for (int i = 0; i < arrdet.size(); i++) {
            String a = arrdet.get(i).getDp().getMatped() + " " + arrdet.get(i).getDp().getDureza();
            JtDetalle.setValueAt(a, i, 0);
            JtDetalle.setValueAt("0", i, 1);
        }
//        if (JcPed.getSelectedIndex() != 0) {
//        } else {
//            DefaultTableModel model = new DefaultTableModel();
//            JtDetalle.setModel(model);
//        }

    }

    /**
     * Verifica el array principal para elegir solo los pedimentos disponibles,
     * por lo tanto si encuentra el id del pedimento en el array de la bdlite lo
     * elimina del array
     */
    private void organizaarray() {
        for (int i = 0; i < arr.size(); i++) {
            int a1 = arr.get(i).getId_pedimento();
            for (int j = 0; j < arrlite.size(); j++) {
                int a2 = arrlite.get(j).getId_pedimento();
                if (a1 == a2) {
                    arr.remove(i);
                    j = arrlite.size();
                    i--;
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nuevacapturainv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevacapturainv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevacapturainv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevacapturainv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Nuevacapturainv dialog = new Nuevacapturainv(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcPed;
    private javax.swing.JTable JtDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}