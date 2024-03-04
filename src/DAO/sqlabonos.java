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

    public boolean new_Refacturacion(Connection cobranza, cargo c) {
        PreparedStatement st;
        try {
            cobranza.setAutoCommit(false);
            String sql;
            int cargo = c.getId_cargo();
            int agente = c.getAgente();
            int cliente = c.getCliente();
            int cuenta1 = c.getId_concepto();
            int cuenta2 = c.getId_concepto2();
            String referencia = c.getReferencia();
            String ref = c.getRef();
            String fecha = c.getFecha();
            int turno = c.getTurno();
            double importe = c.getImporte();
            String usuario = c.getUsuario();
            String obs = "Nota de cargo " + referencia;
            String obs2 = "Nota de credito " + referencia;
            //Nota de cargo
            sql = "insert into abono(id_cargo,id_agente,id_concepto,id_cliente,referencia,"
                    + "referenciac,fecha,fechapago,turno,parcialidad,importe,pago,saldo,"
                    + "observaciones,usuario,estatus) "
                    + "values(?,?,?,?,?,?,?,?,?,1,?,?,?,?,?,'1')";
            st = cobranza.prepareStatement(sql);
            st.setInt(1, cargo);
            st.setInt(2, agente);
            st.setInt(3, cliente);
            st.setInt(4, cuenta1);
            st.setString(5, referencia);
            st.setString(6, ref);
            st.setString(7, fecha);
            st.setString(8, fecha);
            st.setInt(9, turno);
            st.setDouble(10, importe);
            st.setDouble(11, importe);
            st.setDouble(12, importe);
            st.setString(13, obs);
            st.setString(14, usuario);
            st.executeUpdate();
            //Nota de credito para regresar el saldo a cero
            sql = "insert into abono(id_cargo,id_agente,id_concepto,id_cliente,referencia,"
                    + "referenciac,fecha,fechapago,turno,parcialidad,importe,pago,saldo,"
                    + "observaciones,usuario,estatus) "
                    + "values(?,?,?,?,?,?,?,?,?,1,?,?,?,?,?,'1')";
            st = cobranza.prepareStatement(sql);
            st.setInt(1, cargo);
            st.setInt(2, agente);
            st.setInt(3, cliente);
            st.setInt(4, cuenta2);
            st.setString(5, referencia);
            st.setString(6, ref);
            st.setString(7, fecha);
            st.setString(8, fecha);
            st.setInt(9, turno);
            st.setDouble(10, importe);
            st.setDouble(11, importe);
            st.setDouble(12, 0);
            st.setString(13, obs2);
            st.setString(14, usuario);
            st.executeUpdate();
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
