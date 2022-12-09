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
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Facturas {

    public int nuevafac(Connection c, factura f, Connection cob);// factura y generar xml

    public ArrayList<factura> getfacs(Connection c, String folio);//despliegue de facturas

    public factura getfac(Connection c, String folio);//despliegue de facturas

    public int getmaxfolio(Connection c);

    public void actualizacadena(Connection c, factura f);

    public int getmaxncr(Connection c);

    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta);

    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd);

    public int nuevancr(Connection c, factura f, Connection cob);// ncr y generar xml
    
    public ArrayList<abono> getabonospago(Connection c, String op, String bd);
    
    public int nuevopago(Connection c, factura f, Connection cob);// pago y generar xml
}
