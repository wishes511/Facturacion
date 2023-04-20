/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ProveedorMPrima;
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
public class sqlproveedores {

    public ArrayList<ProveedorMPrima> getallprovs(Connection c, String nombre) {
        ArrayList<ProveedorMPrima> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from proveedores where nombre like '%" + nombre + "%' order by nombre";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ProveedorMPrima p = new ProveedorMPrima();
                p.setNombre(rs.getString("nombre"));
                p.setRfc(rs.getString("rfc"));
                p.setCp(rs.getString("cp"));
                p.setPais(rs.getString("pais"));
                p.setRazons(rs.getString("razonsocial"));
                p.setProveedor(rs.getInt("id_proveedor"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlproveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
