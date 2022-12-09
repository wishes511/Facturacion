/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import DAO.daocfdi;
import Modelo.Procserie;
import Persistencia.sqlfactura;
import Persistencia.sqlkardex;
import Server.Serverprod;
import Server.Serverylite;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class testproc {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//            ArrayList<Connection> arr= new ArrayList<>();
//            Procserie p= new Procserie();
//            p.setConnecxiones(arr);
//            p.start();

        Connection c;
        Serverylite s = new Serverylite();
//        kardex();
        sqlfactura f = new sqlfactura();
        String fechan=f.formateafecha("2022-11-22 13:29:56.0");
        System.out.println(fechan);
    }

    private static void kardex() {
        try {
            Connection c;
            Serverprod s = new Serverprod();
            c = s.getconexionpruebarcpt();
            sqlkardex k= new sqlkardex();
            k.insertkardex(c);
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testproc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
