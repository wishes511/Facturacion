/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panelmaq;

import DAO.daoAgentes;
import DAO.daofactura;
import Modelo.Agentes;
import Modelo.Cliente;
import Modelo.Dfactura;
import Modelo.Formateodedatos;
import Modelo.Sellofiscal;
import Modelo.Usuarios;
import Modelo.factura;
import Server.Serverprod;
import Server.Serverylite;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class Cargos_especial extends javax.swing.JPanel {

    public Connection ACobranza, cobB;
    Serverylite slite = new Serverylite();
    Serverprod prod = new Serverprod();
    public ArrayList<Agentes> arragente = new ArrayList<>();
    public ArrayList<Cliente> arrcliente = new ArrayList<>();
    public Usuarios u;
    int clic = 0;
    int clic2 = 0;
    int clic3 = 0;
    String serie = "A";

    /**
     * Creates new form Cargos_especial
     */
    public Cargos_especial() {
        initComponents();
        JtCliente.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo = new javax.swing.ButtonGroup();
        JtCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JtObs = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        JcAgente = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        JcCliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        JtCargo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        JlSerie = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        JtCliente.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCliente.setBorder(null);
        JtCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtClienteMousePressed(evt);
            }
        });
        JtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Referencia");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ic_send_128_28719.png"))); // NOI18N
        jLabel2.setToolTipText("Procesar factura");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        JtObs.setColumns(20);
        JtObs.setRows(5);
        jScrollPane2.setViewportView(JtObs);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Observaciones");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Agentes");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cliente");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Cargo");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
        });

        JtCargo.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        JtCargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtCargo.setBorder(null);
        JtCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JtCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCargoMousePressed(evt);
            }
        });
        JtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtCargoActionPerformed(evt);
            }
        });

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(362, 362, 362)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel12)))
                        .addGap(0, 367, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(JtCargo)
                                    .addComponent(jSeparator2)
                                    .addComponent(JtCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JcAgente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JcCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                                .addGap(89, 89, 89)
                                .addComponent(JlSerie))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(JtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(JtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JlSerie)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JcAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(JcCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Se obtienen todos los cliente, se cargan y se busca cual es el agente que
     * llega con la salida y da la opcion de elegir cualquier otro
     */
    private void setAgentes() {
        DefaultComboBoxModel ag = new DefaultComboBoxModel();
        daoAgentes da = new daoAgentes();
        arragente = da.getAgentes(ACobranza);
        for (Agentes agent : arragente) {
            ag.addElement(agent.getNombre());
        }
        JcAgente.setModel(ag);
        for (int i = 0; i < arragente.size(); i++) {
            if (arrcliente.get(JcCliente.getSelectedIndex()).getAg().getIdagente() == arragente.get(i).getIdagente()) {
                JcAgente.setSelectedIndex(i);
            }
        }
    }

    private void JtClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtClienteMousePressed
        JtCliente.setText("");
    }//GEN-LAST:event_JtClienteMousePressed

    private void JtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtClienteActionPerformed
        JtCargo.requestFocus();
    }//GEN-LAST:event_JtClienteActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed

    }//GEN-LAST:event_jLabel2MousePressed

    private void setfactura() {
        Formateodedatos fd = new Formateodedatos();
        if (1 == 1) {
        } else {
            factura f = new factura();
            java.util.Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            daofactura dfac = new daofactura();
            ArrayList<Dfactura> arrf = new ArrayList<>();
            // fin setear impuestos
            int rowc = JcCliente.getSelectedIndex();
            f.setExportacion("01");
            f.setFolio(0);
            f.setClaveusuario(u.getUsuario());
//                Obtiene la serie fiscal de acuerdo al turno
            f.setSerie("FAC");
            f.setTurno(u.getTurno());
            f.setConceptos(6);
            f.setFecha(sdf.format(date));
            f.setIdcliente(arrcliente.get(rowc).getCvecliente());
            f.setNombre(arrcliente.get(rowc).getNombre());
            f.setPlazo(arrcliente.get(rowc).getPlazo());
            f.setObservaciones(JtObs.getText().toUpperCase());
//                f.setAgente(k.get(row).getCli().getAgente());
            f.setAgente(arrcliente.get(rowc).getAg().getIdagente());
            f.setEmpresa("1");
            //id del documento recien añadido
            if (arrf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error al realizar factura, intente capturar de nuevo");
                vaciarcampos();
            } else {
                int id =3; //dfac.nuevafactpu(cpt, f, ACobranza);
                Sellofiscal s = new Sellofiscal();
                if (id != 0) {
//                        
                    JOptionPane.showMessageDialog(null, "Proceso terminado: \n " + s.getEstado());
                    vaciarcampos();
                    JtCliente.requestFocus();
                }
            }

        }

    }

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed

    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void JtCargoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCargoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCargoMousePressed

    private void JtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtCargoActionPerformed

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
    }//GEN-LAST:event_JlSerieMousePressed

    private void JlSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JlSerieKeyPressed
        
    }//GEN-LAST:event_JlSerieKeyPressed

    private void vaciarcampos() {
        JtObs.setText("");
        JtCliente.setText("");
        JtCliente.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcAgente;
    private javax.swing.JComboBox<String> JcCliente;
    private javax.swing.JLabel JlSerie;
    public javax.swing.JTextField JtCargo;
    public javax.swing.JTextField JtCliente;
    private javax.swing.JTextArea JtObs;
    private javax.swing.ButtonGroup grupo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
