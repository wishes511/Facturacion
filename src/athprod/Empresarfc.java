/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athprod;

import DAO.daoempresa;
import Modelo.Empresas;
import Server.Serverylite;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GATEWAY1-
 */
public class Empresarfc extends javax.swing.JInternalFrame {

    private JFileChooser filechooser;

    Connection serverlite;
    ArrayList<Empresas> arr = new ArrayList<>();

    /**
     * Creates new form Respaldos
     */
    public Empresarfc() {
        try {
            initComponents();
            Serverylite l = new Serverylite();
            serverlite = l.getconexionC();
            setempresas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Empresarfc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Empresarfc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Empresarfc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPopupMenu();
        JmCert = new javax.swing.JMenuItem();
        JmKey = new javax.swing.JMenuItem();
        JmSalida = new javax.swing.JMenuItem();
        JmCp = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtEmpresa = new javax.swing.JTable();

        JmCert.setText("Actualizar Certificado");
        JmCert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCertActionPerformed(evt);
            }
        });
        Menu.add(JmCert);

        JmKey.setText("Actualizar Key");
        JmKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmKeyActionPerformed(evt);
            }
        });
        Menu.add(JmKey);

        JmSalida.setText("Actualizar archivos de salida");
        JmSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmSalidaActionPerformed(evt);
            }
        });
        Menu.add(JmSalida);

        JmCp.setText("Actualizar codigo postal");
        JmCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmCpActionPerformed(evt);
            }
        });
        Menu.add(JmCp);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Propiedades de archivos de facturacion");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        JtEmpresa.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        JtEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JtEmpresa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JtEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtEmpresaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtEmpresa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

    }//GEN-LAST:event_formInternalFrameClosing

    private void JtEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtEmpresaMousePressed
        if (evt.getButton() == 3) {
            Menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_JtEmpresaMousePressed

    private void JmCertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCertActionPerformed
        actualizadatos("certificado");
    }//GEN-LAST:event_JmCertActionPerformed

    private void JmKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmKeyActionPerformed
        actualizadatos("key");
    }//GEN-LAST:event_JmKeyActionPerformed

    private void JmSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmSalidaActionPerformed
        actualizadatos("salidaxml");
    }//GEN-LAST:event_JmSalidaActionPerformed

    private void JmCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmCpActionPerformed
//        actualizadatos("cp");
        actualizastring("cp");
    }//GEN-LAST:event_JmCpActionPerformed

    /**
     * Funcion para actualizar alguna de las columnas
     *
     * @param columna
     */
    private void actualizadatos(String columna) {
        filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            daoempresa de = new daoempresa();
            int id = Integer.parseInt(arr.get(JtEmpresa.getSelectedRow()).getIp());
            de.actualizadir(serverlite, columna, file.getAbsolutePath(), id);
            setempresas();
        }
    }

    private void actualizastring(String columna) {
        String dato = JOptionPane.showInputDialog(null, "Introduce nuevo dato");
        if (dato == null || dato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El valor esta vacio, intentelo de nuevo");
        } else {
            daoempresa de = new daoempresa();
            int id = Integer.parseInt(arr.get(JtEmpresa.getSelectedRow()).getIp());
            de.actualizadir(serverlite, columna, dato, id);
            JOptionPane.showMessageDialog(null, "Exito al modificar "+columna);
            setempresas();
        }

    }

    private void setempresas() {
        DefaultTableModel model = new DefaultTableModel();
        daoempresa d = new daoempresa();
//        Se buscan todos lo registros acerca de la empresa
        arr = d.getallempresa(serverlite);
        model.addColumn("Nombre");
        model.addColumn("Rfc");
        model.addColumn("Regimen");
        model.addColumn("CP");
        model.addColumn("Certificado");
        model.addColumn("Key");
        model.addColumn("Pass");
        model.addColumn("Xml guardado");
        model.setNumRows(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            model.setValueAt(arr.get(i).getNombre(), i, 0);
            model.setValueAt(arr.get(i).getRfc(), i, 1);
            model.setValueAt(arr.get(i).getRegimen(), i, 2);
            model.setValueAt(arr.get(i).getCp(), i, 3);
            model.setValueAt(arr.get(i).getCertificado(), i, 4);
            model.setValueAt(arr.get(i).getKey(), i, 5);
            model.setValueAt(arr.get(i).getPass(), i, 6);
            model.setValueAt(arr.get(i).getXml(), i, 7);
        }
        JtEmpresa.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JmCert;
    private javax.swing.JMenuItem JmCp;
    private javax.swing.JMenuItem JmKey;
    private javax.swing.JMenuItem JmSalida;
    private javax.swing.JTable JtEmpresa;
    private javax.swing.JPopupMenu Menu;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
