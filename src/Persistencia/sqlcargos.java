/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqlcargos {

    public boolean new_Notacargo(factura f, Connection cobranza) {//Rcpt y cpt
        PreparedStatement st;
        try {
            cobranza.setAutoCommit(false);
            String sql;
            String fol = f.getReferencia();
            String fecha = f.getFecha();
            double total = f.getTotal();
            //cliente
            int idcliente = f.getIdcliente();
            //fin cliente
            int plazo = f.getPlazo();
            int agente = f.getAgente();
            String turno = f.getTurno();
            //Esta variable se utilizará para insertar la fecha de vencimiento
            //Por lo tanto en la consulta o asignacion será la misma
            String fechav = f.getFechasolicitado();
            int cuenta = f.getConceptos();
            //Insertar en cargos
            sql = "insert into cargo(id_agente,id_concepto,id_cliente,referencia,fecha,importe,"
                    + "saldo,SIM,saldomx,turno,comision,plazo,parcialidad,estatus,fechavencimiento) "
                    + "values(" + agente + "," + cuenta + "," + idcliente + ",'" + fol + "','"
                    + fecha + "'," + total + "," + total + "," + total + "," + total + "," + turno + ",0," + plazo + ",0,'1','" + fechav + "')";
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

    public String get_Fechavencimiento(Connection c, int folio) {
        String fecha = "";
        try {
            String sql = "select fechavencimiento \n"
                    + "from cargo\n"
                    + "where referencia='" + folio + "'";
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                fecha = rs.getString("fechavencimiento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlcargos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }

    public cargo getcargowith_pedido(Connection cob, factura p) {
        cargo c = new cargo();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cargo,id_agente,id_cliente,importe\n"
                    + "from cargo\n"
                    + "where referencia=? and estatus ='1'";
            st = cob.prepareStatement(sql);
            st.setString(1, p.getPedido());
            rs = st.executeQuery();
            while (rs.next()) {
                c.setId_cargo(rs.getInt("id_cargo"));
                c.setAgente(rs.getInt("id_agente"));
                c.setCliente(rs.getInt("id_cliente"));
                c.setImporte(rs.getDouble("importe"));
                //referencia completa
                c.setReferencia(p.getPedido());
                //numero de pedido
                c.setRef(p.getReferencia());
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
