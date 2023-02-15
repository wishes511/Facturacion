/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuarios;
import Persistencia.sqlficha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class daoPrincipal implements principal {

    @Override
    public Usuarios getUsers(Connection c, String u, String pass, String columna) {
        Usuarios us = new Usuarios();
        try {
            PreparedStatement st;
            ResultSet rs;
            u = "";
            String grado = "";
            String query = "select *  from usuarios  where  contrase" + columna + "a='" + pass + "' and permiso!=0";
            System.out.println(query);
            st = c.prepareStatement(query);
            rs = st.executeQuery();
            us.setGrado(grado);
            us.setUsuario("");
            while (rs.next()) {
                u = rs.getString("usuario");
                us.setUsuario(u);
                us.setContraseña(pass);
                if (columna.equals("ñ")) {
                    us.setFacturacion(rs.getInt("facturacion"));
                    grado = rs.getString("admin");
                    us.setGrado(grado);
                } else {
                    us.setFacturacion(1);
                    grado = "1";
                    us.setGrado(grado);
                }
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

}
