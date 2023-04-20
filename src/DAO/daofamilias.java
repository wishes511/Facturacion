/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Familia;
import Persistencia.sqlfamilias;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daofamilias implements familias{

    @Override
    public ArrayList<Familia> getallfamilia(Connection c, String f) {
        sqlfamilias s = new sqlfamilias();
        return s.getallfamilias(c, f);
    }

    @Override
    public boolean newfamilia(Connection c, Familia f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
