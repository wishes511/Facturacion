/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Familia;
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
public class sqlfamilias {

    public ArrayList<Familia> getallfamilias(Connection c, String fam) {
        ArrayList<Familia> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from familias order by descripcion";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Familia f = new Familia();
                f.setId_familia(rs.getInt("id_familia"));
                f.setDescripcion(rs.getString("descripcion"));
                arr.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlfamilias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
