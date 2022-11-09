/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-Michel araujo
 */
public class sqlclientes {

    public ArrayList<Cliente> getClientes(Connection con) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select numcliente,nombre from clientes order by nombre");
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
        public Cliente getCliente(Connection con, int idcliente) {//cobranza
        Cliente c = new Cliente();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from clientes where numcliente="+idcliente);
            rs = st.executeQuery();
            while (rs.next()) {
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
