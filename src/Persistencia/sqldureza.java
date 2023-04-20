/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Dureza;
import java.sql.CallableStatement;
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
public class sqldureza {

    /**
     * obtener todos las durezas
     * @param c
     * @return 
     */
    public ArrayList<Dureza> getalldurezas(Connection c) {
        ArrayList<Dureza> arr = new ArrayList<>();
        try {
            ResultSet rs;
            CallableStatement st;
            st = c.prepareCall("{call spgetalldureza}");
            rs = st.executeQuery();
            while (rs.next()) {
                Dureza d = new Dureza();
                d.setDureza(rs.getString("dureza"));
                d.setDescripcion(rs.getString("descripcion"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldureza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
