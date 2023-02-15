/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Poliza;
import Modelo.Sellofiscal;
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

    public int nuevafac(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    /**
     *
     * @param c Conexion cpt
     * @param f Objeto de factura con lo necesario para insertar y generar xml
     * @param cob
     * @param rcpt
     * @return
     */
    public int nuevafacE(Connection c, factura f, Connection cob, Connection rcpt);// factura y generar xml

    public ArrayList<factura> getfacs(Connection c, String folio);//despliegue de facturas

    public factura getfac(Connection c, String folio);//despliegue de facturas

    public int getmaxfolio(Connection c);

    /**
     *
     * @param c
     * @param serie
     * @return
     */
    public int getmaxfolio(Connection c, String serie);

    public int getbuscafolio(Connection c, String serie);

    public int getbuscafolioncr(Connection c, String serie);

    public void actualizacadena(Connection c, factura f);
    
    public void actualizacadenapago(Connection c, factura f);

    public int getmaxncr(Connection c);

    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta);

    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd);

    /**
     *
     * @param c
     * @param f
     * @param cob
     * @param rcpt
     * @return
     */
    public int nuevancr(Connection c, factura f, Connection cob, Connection rcpt);// ncr y generar xml

    public ArrayList<abono> getabonospago(Connection c, String op, String bd, int cuenta);

    public int nuevopago(Connection c, factura f, String cob);// pago y generar xml

    public int getmaxPago(Connection c);

    public ArrayList<factura> getdoc(Connection cpt, String fol, String serie, String empcobranza);
    
    public ArrayList<factura> getdocxml(Connection cpt, String fol, String serie, String empcobranza);

    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id);
    
    public boolean Updatesellofiscalpago(Connection cpt, Sellofiscal s, int id);

    public ArrayList<Cliente> getClienteface(Connection cob, String ncliente);
    
    /**
     * 
     * @param c
     * conexion a cpt
     * @param r
     * Id o nombre del cliente
     * @param bd
     * Nombre de bd a cobranza
     * @return 
     */
    public ArrayList<cargo> getfactstoFACRel(Connection c, String r, String bd);
    
    /**
     * 
     * @param cpt
     * @param rcpt
     * @param cobranza
     * @param f 
     */
    public void cancelafac(Connection cpt, Connection rcpt, Connection cobranza, factura f);
    public ArrayList<Poliza> getasientoscontable(Connection concob);
}
