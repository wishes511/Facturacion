/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.factura;
import Persistencia.sqlfactura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daofactura implements Facturas{

    @Override
    public factura nuevafac(Connection c, factura f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<factura> getfacs(Connection c, String folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public factura getfac(Connection c, String folio) {
        sqlfactura f = new sqlfactura();
        return f.getfactura(c, folio);
    }
    
}
