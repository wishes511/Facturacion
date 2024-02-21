/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maq;

import Modelo.Conexiones;
import Modelo.Usuarios;
import Panelmaq.pagotpucargo1;
import Panelmaq.pagotpucargo2;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public class PagostpuCargos extends javax.swing.JInternalFrame {

    pagotpucargo1 c1;
    pagotpucargo2 c2;
    String var = "0";
    public String name, empresa, empresacob;
    Connection rcpt, litecfdi, liteempresa, cobranza, cpt, cobB;
    public Conexiones conexion;
    public Usuarios u;

    /**
     * Creates new form Clientes Hay que recordar que todos los registros estan
     * almacenados en la tabla fiscal de cargos especiales, por lo tanto no hay
     * que ingresar en el servidor interno para esta cuestion, se maneja por la
     * serie.
     *
     * @param cn
     * @param u
     */
    public PagostpuCargos(Conexiones cn, Usuarios u) {
        initComponents();
        cpt = cn.getCpttpu();
        rcpt = cn.getRcpttpu();
        cobranza = cn.getCobranzatpu();
        empresa = cn.getEmpresa();
        empresacob = cn.getEmpresacob();
        cobB = cn.getCobranzatpuB();
        this.u = u;
        generaciontab();//Tabs de facturacion
        setarraylist();
    }

    private void setarraylist() {
        //tambien conexiones
        c1.empresa = empresa;
        c1.empresacob = empresacob;
        c1.ACobranza = cobranza;
        c1.sqlempresa = liteempresa;
        c1.sqlcfdi = litecfdi;
        c1.cpt = cpt;

        //tambien conexiones
        c2.empresa = empresa;
        c2.ACobranza = cobranza;
        c2.cpt=cpt;
        c2.u = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Tabbed = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pagos Cargos especiales");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/labelprint.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Tabbed.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public final void generaciontab() {//generar tabs
        c1 = new pagotpucargo1();
        c2 = new pagotpucargo2();
        Tabbed.addTab("Ver Pagos especiales", c1);
        Tabbed.addTab("Nuevo pago especial", c2);
        Tabbed.setSelectedComponent(c1);
        c2.JtCliente.requestFocus();
        c1.JtCliente.requestFocus();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tabbed;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}