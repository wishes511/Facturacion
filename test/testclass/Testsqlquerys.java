/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclass;

import DAO.daoDevolucion;
import Modelo.Kardexrcpt;
import Persistencia.sqlfactura;
import Server.Serverprod;
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
public class Testsqlquerys {

    public static void main(String[] args) {
//        try {
            Testsqlquerys t = new Testsqlquerys();
//            t.verificadevs("A", 19);
            t.modificacaostodfactura();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void verificadevs(String s, int id) throws ClassNotFoundException, IOException, SQLException {
        Serverprod si = new Serverprod();
        Connection c = si.getconexionTPU("Tpucpt");
        daoDevolucion d = new daoDevolucion();
        d.verificadevs(c, s, id);
        c.close();
    }

    /**
     * Actualiza y modifica los costos de dfacturas
     */
    public void modificacaostodfactura() {
        try {
            Serverprod s = new Serverprod();
            Connection concpt = s.getconexionserver8("CPT");
            Connection conrcpt = s.getconexionserver8("RCPT");
            sqlfactura sql = new sqlfactura();
            ArrayList<Kardexrcpt> arr = sql.modcostodfac(conrcpt);
            if(sql.setmodificaciondfactura(conrcpt, arr) || sql.setmodificaciondfactura(concpt, arr)){
                System.out.println("Completo");
            }
//            for (Kardexrcpt arr1 : arr) {
//                System.out.println(arr1.getFactura()+" "+arr1.getId_prod()+" "+arr1.getCosto()+" "+arr1.getVenta()+"");
//            }
            concpt.close();
            conrcpt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Testsqlquerys.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
