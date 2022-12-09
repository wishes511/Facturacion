/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ConceptosES;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import Persistencia.sqlfactura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daofactura implements Facturas {

    @Override
    public ArrayList<factura> getfacs(Connection c, String folio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public factura getfac(Connection c, String folio) {
        sqlfactura f = new sqlfactura();
        return f.getfactura(c, folio);
    }

    @Override
    public int getmaxfolio(Connection c) {
        sqlfactura s = new sqlfactura();
        return s.getmaxfac(c);
    }

    @Override
    public void actualizacadena(Connection c, factura f) {
        sqlfactura s = new sqlfactura();
        s.actualizafactura(c, f);
    }

    @Override
    public int nuevafac(Connection c, factura f, Connection cob) {
        sqlfactura s = new sqlfactura();
        return s.insertfactura(c, f, cob);
    }

    @Override
    public int getmaxncr(Connection c) {//folio maximo de las notas de ncr
        sqlfactura s = new sqlfactura();
        return s.getmaxncr(c);
    }

    @Override
    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta) {
        sqlfactura s = new sqlfactura();
        return s.getcuentas(c, cuenta);
    }

    @Override
    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd) {
                sqlfactura s = new sqlfactura();
        return s.getfoliotoNCR(c, r, bd);
    }

    @Override
    public int nuevancr(Connection c, factura f, Connection cob) {
        sqlfactura s = new sqlfactura();
        return s.insertncr(c, f, cob);
    }

    @Override
    public ArrayList<abono> getabonospago(Connection c, String op, String bd) {
        sqlfactura s = new sqlfactura();
        return s.getOrdenesp(c, op, bd);
    }

    @Override
    public int nuevopago(Connection c, factura f, Connection cob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
