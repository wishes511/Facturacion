/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Empresas;
import Modelo.Fichas;
import java.io.IOException;
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
public class sqlempresa {

    public boolean AddEmpresa(Connection con, Empresas e) {
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into empresa(nombre,ip,dirimagenes,dirvideos,rfc,rsocial) "
                    + "values('"+e.getNombre()+"','"+e.getIp()+"','"+e.getDirimag()+"','"
                    +e.getDirvideo()+"','"+e.getRfc()+"','"+e.getRsocial()+"')";
            System.out.println(sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Empresas getEmpresa(Connection con) {
        Empresas e=null;
        try {
            PreparedStatement st;
            ResultSet rs;

            st = con.prepareStatement("select nombre,ip,dirimagenes,dirvideos,rfc,rsocial from empresa");
            rs = st.executeQuery();
            while (rs.next()) {
                e = new Empresas();
                e.setNombre(rs.getString("nombre"));
                e.setIp(rs.getString("ip"));
                e.setDirimag(rs.getString("dirimagenes"));
                e.setDirvideo(rs.getString("dirvideos"));
                e.setRfc(rs.getString("rfc"));
                e.setRsocial(rs.getString("rsocial"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlempresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

}
