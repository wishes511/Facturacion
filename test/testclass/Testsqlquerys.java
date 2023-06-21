/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import DAO.daoDevolucion;
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
public class Testsqlquerys {
    public static void main(String [] args){
        try {
            Testsqlquerys t = new Testsqlquerys();
            t.verificadevs("A",19);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificadevs(String s, int id) throws ClassNotFoundException, IOException, SQLException{
        Serverprod si = new Serverprod();
        Connection c=si.getconexionTPU("Tpucpt");
        daoDevolucion d = new daoDevolucion();
        d.verificadevs(c, s, id);
        c.close();
        
    }
}
