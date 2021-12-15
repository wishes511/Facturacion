/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Server.Serverprod;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class daoserver implements Server{
    Connection c=null;
    @Override
    public Connection Getconexion() {
        try {
            Serverprod s= new Serverprod();
            s.getconexionS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(daoserver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(daoserver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(daoserver.class.getName()).log(Level.SEVERE, null, ex);
        }
      return c;   
    }

    @Override
    public void cerrarConexion() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(daoserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
