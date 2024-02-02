/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Comision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sqlcomisiones {

    public ArrayList<Comision> getcomisiones(Connection c, String fecha, String referencia) {
        ArrayList<Comision> arr = new ArrayList<>();
        try {
            String sql = "select id_cargo,referencia,importe,"
                    + "DATEDIFF(day,convert(date,c.fecha),'" + fecha + "') as dias,saldo,saldomx,c.id_agente,\n"
                    + "comision = case when DATEDIFF(day,convert(date,c.fecha),'" + fecha + "')<=30 then importe*0.03 \n"
                    + "else case when DATEDIFF(day,convert(date,c.fecha),'" + fecha + "')>30 and DATEDIFF(day,convert(date,c.fecha),'" + fecha + "')<=45 then importe*0.02 \n"
                    + "else case when DATEDIFF(day,convert(date,c.fecha),'" + fecha + "')>45 and DATEDIFF(day,convert(date,c.fecha),'" + fecha + "')<=60 then importe*0.01 \n"
                    + "else 0 end end end\n"
                    + "from cargo c\n"
                    + "where (saldo=0 or saldomx =0) and c.estatus='1' and (" + referencia + ")";
            System.out.println("get comision " + sql);
            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Comision s = new Comision();
                s.setId_cargo(rs.getInt("id_cargo"));
                s.setReferencia(rs.getString("referencia"));
                s.setImporte(rs.getDouble("importe"));
                s.setDias(rs.getInt("dias"));
                s.setComision(rs.getDouble("comision"));
                s.setId_agente(rs.getInt("id_agente"));
                arr.add(s);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {

            Logger.getLogger(sqlcomisiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean newcomision(Connection c, ArrayList<Comision> arr) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            for (Comision com : arr) {
                String sql = "insert into comisiones(id_cargo,id_agente,referencia,dias,comision,fecha,usuario,importe,tipocambio,serie,estatus) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                st = c.prepareStatement(sql);
                st.setInt(1, com.getId_cargo());
                st.setInt(2, com.getId_agente());
                st.setString(3, com.getReferencia());
                st.setInt(4, com.getDias());
                st.setDouble(5, com.getComision());
                st.setString(6, com.getFecha());
                st.setString(7, com.getUsuario());
                st.setDouble(8, com.getImporte());
                st.setDouble(9, com.getTipocambio());
                st.setString(10, com.getSerie());
                st.setString(11, "1");
                st.executeUpdate();
            }
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlcomisiones.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlcomisiones.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

}
