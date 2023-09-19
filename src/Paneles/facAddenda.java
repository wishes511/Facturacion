/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import DAO.daofactura;
import Modelo.Addenda;
import Modelo.Almacen;
import Modelo.Combinacion;
import Modelo.Corridas;
import Modelo.Destinoscoppel;
import Modelo.NAddenda;
import Modelo.Producto;
import Modelo.Setaddenda;
import Modelo.cargo;
import Modelo.factura;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 * @author GATEWAY1-
 */
public class facAddenda extends javax.swing.JDialog {

    public ArrayList<Addenda> arraddenda = new ArrayList<>();
    public ArrayList<Destinoscoppel> arrdestinos = new ArrayList<>();
    public String archivoxml;
    public String empresa;
    public factura f;
    public Connection cpt, rcpt;

    /**
     * Creates new form Paresremision
     */
    public facAddenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Recursos/edit-validated_40458.png"));
        setIconImage(icon);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        desplieguecargos();

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
        JlIniciar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtCargo = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JcDestino = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JtCajas = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        JtCant = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 153, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bordeazul16x16.png")))); // NOI18N
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        JlIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        JlIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JlIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlIniciarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JlIniciarMousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Cancel_icon-icons.com_54824.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        JtCargo.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        JtCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtCargo.setSelectionBackground(new java.awt.Color(213, 215, 250));
        JtCargo.setSelectionForeground(new java.awt.Color(0, 0, 0));
        JtCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCargoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtCargo);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Refresh_36729.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Destino");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("# Cajas");

        JtCajas.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtCajas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCajas.setBorder(null);
        JtCajas.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCajasMousePressed(evt);
            }
        });
        JtCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCajasActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Cantidad x caja");

        JtCant.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtCant.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCant.setBorder(null);
        JtCant.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtCant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCantMousePressed(evt);
            }
        });
        JtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCantActionPerformed(evt);
            }
        });

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JtCajas)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(JtCant))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(JtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(JcDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(564, 564, 564)
                        .addComponent(JlIniciar)
                        .addGap(0, 598, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JlIniciar)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void JlIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlIniciarMouseClicked
        
    }//GEN-LAST:event_JlIniciarMouseClicked

    private void JlIniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlIniciarMousePressed
        setaddenda();
//       Setaddenda sa= new Setaddenda(archivoxml,f);
    }//GEN-LAST:event_JlIniciarMousePressed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed

        this.dispose();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        desplieguecargos();
    }//GEN-LAST:event_jLabel3MousePressed

    private void JtCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCargoMousePressed

    }//GEN-LAST:event_JtCargoMousePressed

    private void JtCajasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCajasMousePressed
        JtCajas.setText("");
    }//GEN-LAST:event_JtCajasMousePressed

    private void JtCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCajasActionPerformed
        String r = JtCajas.getText();
        JtCant.requestFocus();
    }//GEN-LAST:event_JtCajasActionPerformed

    private void JtCantMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCantMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCantMousePressed

    private void JtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCantActionPerformed

    private void setaddenda() {
        if (!verificaint(JtCajas.getText())) {
            JtCajas.setText("");
            JtCajas.requestFocus();
            JOptionPane.showMessageDialog(null, "Introduzca un numero valido para las cajas");
        } else {
            boolean band = true;
            String n = (empresa.equals("1")) ? "55034" : "1";
            ArrayList<String> arrcod = new ArrayList<>();
            for (int i = 0; i < arraddenda.size(); i++) {
//                Captura de codigo dee coppel
                String estcod = JtCargo.getValueAt(i, 5).toString();
                if (verificaint(estcod)) {
                    arrcod.add(estcod);
                } else {
                    JOptionPane.showMessageDialog(null, "Un codigo de los estilos esta mal, intentalo de nuevo");
                    band = false;
                    break;
                }
            }
            if (band) {
//                Si todo esta bien inicia con la instancia y darle valor al objeto NAddenda para su funcion posterior
                Destinoscoppel dc = new Destinoscoppel();
                dc.setId_coppel(arrdestinos.get(JcDestino.getSelectedIndex()).getId_coppel());
                dc.setDestino(arrdestinos.get(JcDestino.getSelectedIndex()).getDestino());
                NAddenda na = new NAddenda();
                na.setCantidad(Integer.parseInt(JtCant.getText()));
                na.setProv(n);
                na.setF(f);
                na.setArrad(arraddenda);
                na.setArchivo(archivoxml);
                na.setCajas(Integer.parseInt(JtCajas.getText()));
                na.setArrcod(arrcod);
                na.setDc(dc);
                Setaddenda adenda=new Setaddenda(na);
                adenda.Construyeaddenda();
                daofactura df= new daofactura();
                df.setpaquetefact(rcpt, cpt, Integer.parseInt(JtCajas.getText()), f.getFolio());
                JOptionPane.showMessageDialog(null, "Generacion de adenda completo, revisa la factura #"+f.getFolio());
                this.dispose();
            }
            
        }
        
    }

    private void desplieguecargos() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Descripcion");
        model.addColumn("Cantidad");
        model.addColumn("Punto");
        model.addColumn("Precio");
        model.addColumn("Pedido");
        model.addColumn("Estilo coppel");
        model.setNumRows(arraddenda.size());
        //Carga las facturas registyradas en cargos
        JtCargo.setModel(model);
        for (int i = 0; i < arraddenda.size(); i++) {
            JtCargo.setValueAt(arraddenda.get(i).getDescripcionprod(), i, 0);
            JtCargo.setValueAt(arraddenda.get(i).getCantidad(), i, 1);
            JtCargo.setValueAt(arraddenda.get(i).getPunto(), i, 2);
            JtCargo.setValueAt(arraddenda.get(i).getPrecio(), i, 3);
            JtCargo.setValueAt(arraddenda.get(i).getPedido(), i, 4);
            JtCargo.setValueAt("", i, 5);
        }

        DefaultComboBoxModel dest = new DefaultComboBoxModel();
        for (int i = 0; i < arrdestinos.size(); i++) {
            dest.addElement(arrdestinos.get(i).getDestino());
        }
        JcDestino.setModel(dest);

    }

    private boolean verificaciones(String r) {
        boolean resp = false;
        System.out.println("valida " + r);
        if (!r.equals("") && (verificafloat(r) || verificaint(r))) {
            resp = true;
        }
        return resp;
    }

    private boolean verificafloat(String cad) {
        boolean resp = false;
        String patt = "[0-9]+||[0-9]+.[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
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

    private boolean verificastring(String cad) {
        boolean resp = false;
        String patt = "[azAZ ]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

    private boolean verificap(String cad) {
        boolean resp = false;
        String patt = "[p]||[s]";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
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
            java.util.logging.Logger.getLogger(facAddenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(facAddenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(facAddenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(facAddenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                facAddenda dialog = new facAddenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JcDestino;
    private javax.swing.JLabel JlIniciar;
    public javax.swing.JTextField JtCajas;
    public javax.swing.JTextField JtCant;
    private javax.swing.JTable JtCargo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
