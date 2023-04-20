/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dureza;
import Persistencia.sqldureza;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daodurezas implements Durezas{

    @Override
    public ArrayList<Dureza> getdurezas(Connection c) {
        sqldureza s = new sqldureza();
        return s.getalldurezas(c);
    }

    @Override
    public boolean nuevadureza(Connection c, Dureza d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
