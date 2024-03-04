/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.cargo;
import Persistencia.sqlfactura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqlabonos {

    public boolean new_Refacturacion(Connection cobranza, cargo c) {//Rcpt y cpt
        PreparedStatement st;
        try {
            cobranza.setAutoCommit(false);
            String sql;
            int cargo = c.getId_cargo();
            int agente = c.getAgente();
            int cliente = c.getCliente();
            int cuenta1=c.getId_concepto();
            int cuenta2=c.getId_concepto2();
            String referencia=c.getReferencia();
            String ref= c.getRef();
            String fecha=c.getFecha();
            int turno=c.getTurno();
            double importe=c.getImporte();
            String usuario=c.getUsuario();

            //Insertar en cargos
            sql = "insert into abono(id_cargo,id_agente,id_concepto,id_cliente,referencia,"
                    + "referenciac,fecha,fechapago,turno,parcialidad,importe,pago,saldo,"
                    + "observaciones,usuario,estatus) "
                    + "values()";
//            System.out.println("cargos " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
            cobranza.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cobranza.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "inertar -" + ex1);
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
