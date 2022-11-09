/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Kardexrcpt;
import Persistencia.sqlkardex;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daokardexrcpt implements kardexrcpt{

    @Override
    public boolean nuevokardex(Connection c, Kardexrcpt k) {
        sqlkardex s = new sqlkardex();
        return s.insertkardex(c, k);
    }

    @Override
    public ArrayList<Kardexrcpt> getkardex(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Kardexrcpt> getkardex(Connection c, Kardexrcpt k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int maxkardex(Connection c) {
        sqlkardex s = new sqlkardex();
        return s.getmaxkardex(c);
    }

    @Override
    public int maxpedido(Connection c) {
        sqlkardex s = new sqlkardex();
        return s.getmaxped(c);
    }

    @Override
    public ArrayList<Kardexrcpt> getkardexfac(Connection c, String r) {
        sqlkardex s = new sqlkardex();
        return s.getkardexfac(c, r);
    }


    
}
