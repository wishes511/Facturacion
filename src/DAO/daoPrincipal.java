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
    public Usuarios getUsers(Connection c, String u, String pass) {
        Usuarios us = new Usuarios();
        us.setUsuario("NO");
        try {
            PreparedStatement st;
            ResultSet rs;
            String query = "select id_usuario,nombre,usuario,tu.descripcion as tipo,grado,d.descripcion as depa\n"
                    + " from usuarios u \n"
                    + "join Tipo_usuario tu on u.id_tipo=tu.id_tipo\n"
                    + "join Departamento d on u.id_departamento=d.id_departamento\n"
                    + "where usuario='"+u+"' and contraseña='"+pass+"' and u.estatus='1'";
            //System.out.println(query);
            st = c.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                us.setUsuario(rs.getString("usuario"));
                us.setNombre(rs.getString("nombre"));
                us.setId_usuario(rs.getInt("id_usuario"));
                us.setTipo_usuario(rs.getString("tipo"));
                us.setGrado(rs.getString("grado"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlficha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

}
