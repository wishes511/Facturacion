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

    /**
     *
     * @param c
     * @return
     */
    @Override
    public int getmaxncr(Connection c) {//folio maximo de las notas de ncr
        sqlfactura s = new sqlfactura();
        return s.getmaxncr(c);
    }

    /**
     *
     * @param c
     * @param cuenta
     * @return
     */
    @Override
    public ArrayList<ConceptosES> getalcuentas(Connection c, String cuenta) {
        sqlfactura s = new sqlfactura();
        return s.getcuentas(c, cuenta);
    }

    /**
     *
     * @param c
     * @param r
     * @param bd
     * @return
     */
    @Override
    public ArrayList<cargo> getfactstoncr(Connection c, String r, String bd) {
        sqlfactura s = new sqlfactura();
        return s.getfoliotoNCR(c, r, bd);
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public int getmaxPago(Connection c) {
        sqlfactura s = new sqlfactura();
        return s.getmaxpago(c);
    }

    /**
     *
     * @param c
     * @param f
     * @param cob
     * @return
     */
    @Override
    public int nuevopago(Connection c, factura f, String cob) {
        sqlfactura s = new sqlfactura();
        return s.insertpagos(c, f, cob);
    }

    /**
     *
     * @param cpt La conexion a cpt para actualizacion, no usar como principal
     * rcpt
     * @param s S es la clase de modelo/Sello ofiscal
     * @param id Es el id del encabezado para actualizar los campos del timbrado
     * @return Regresa Un booleano
     * @see Se utiliza para actualizar los campos faltantes
     */
    @Override
    public boolean Updatesellofiscal(Connection cpt, Sellofiscal s, int id) {
        sqlfactura f = new sqlfactura();
        return f.actualizasellos(cpt, s, id);
    }

    /**
     *
     * @param c
     * @param f
     * @param cob
     * @param rcpt
     * @return
     */
    @Override
    public int nuevafac(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertfactura(c, f, cob, rcpt);
    }

    /**
     *
     * @param c
     * @param serie
     * @return folios de series folios
     */
    @Override
    public int getmaxfolio(Connection c, String serie) {
        sqlfactura s = new sqlfactura();
        return s.getmaxfac(c, serie);
    }

    /**
     *
     * @param c
     * @param f
     * @param cob
     * @param rcpt
     * @return
     */
    @Override
    public int nuevancr(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertncr(c, f, cob, rcpt);
    }

    /**
     *
     * @param cpt
     * @param fol
     *
     * @param serie
     * @param empcobranza Nombre de la base de datos de cobranza
     * @return
     */
    @Override
    public ArrayList<factura> getdoc(Connection cpt, String fol, String serie, String empcobranza) {
        sqlfactura s = new sqlfactura();
        return s.getdocs(cpt, fol, serie, empcobranza);
    }

    /**
     * +
     *
     * @param cob Conexion de cobranza
     * @param ncliente ncliente o nombre de cliente
     * @return
     */
    @Override
    public ArrayList<Cliente> getClienteface(Connection cob, String ncliente) {
        sqlfactura s = new sqlfactura();
        return s.getClientesfacs(cob, ncliente);
    }

    /**
     *
     * @param c Conexxion cpt
     * @param f Objeto factura
     * @param cob Conexion a cobranza
     * @param rcpt conexion rcpt
     * @return Regresa el numero de folio
     */
    @Override
    public int nuevafacE(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertfacturaE(c, f, cob, rcpt);
    }

    /**
     *
     * @param c conexion rcpt
     * @param serie numero de folio
     * @return
     */
    @Override
    public int getbuscafolio(Connection c, String serie) {
        sqlfactura s = new sqlfactura();
        return s.buscafolio(c, serie);
    }

    /**
     *
     * @param c
     * @param serie serie es el folio
     * @return
     */
    @Override
    public int getbuscafolioncr(Connection c, String serie) {
        sqlfactura s = new sqlfactura();
        return s.buscafolioncr(c, serie);
    }

    /**
     *
     * @param c
     * @param f
     */
    @Override
    public void actualizacadenapago(Connection c, factura f) {
        sqlfactura s = new sqlfactura();
        s.actualizapago(c, f);
    }

    /**
     *
     * @param cpt
     * @param s
     * @param id
     * @return
     */
    @Override
    public boolean Updatesellofiscalpago(Connection cpt, Sellofiscal s, int id) {
        sqlfactura f = new sqlfactura();
        return f.actualizasellospago(cpt, s, id);
    }

    /**
     *
     * @param cpt
     * @param fol
     * @param serie
     * @param empcobranza
     * @return
     */
    @Override
    public ArrayList<factura> getdocxml(Connection cpt, String fol, String serie, String empcobranza) {
        sqlfactura f = new sqlfactura();
        return f.getdocsxml(cpt, fol, serie, empcobranza);
    }

    /**
     *
     * @param c conexioncpt
     * @param r nombre, id cliente
     * @param bd Nombre bd cobranza
     * @return
     */
    @Override
    public ArrayList<cargo> getfactstoFACRel(Connection c, String r, String bd) {
        sqlfactura f = new sqlfactura();
        return f.getfoliotoFACRel(c, r, bd);
    }

    /**
     * Cancela en bd la factura y el saldo del cargo a cero
     *
     * @param cpt
     * @param rcpt
     * @param cobranza
     * @param f
     */
    @Override
    public void cancelafac(Connection cpt, Connection rcpt, Connection cobranza, factura f) {
        sqlfactura fac = new sqlfactura();
        fac.cancelafac(cpt, rcpt, cobranza, f);
    }
/**
 * Retorna las lineas de la orden de pago de cuerdo a la subcuenta
 * @param c
 * @param op
 * @param bd
 * @param cuenta
 * @return 
 */
    @Override
    public ArrayList<abono> getabonospago(Connection c, String op, String bd, int cuenta) {
        sqlfactura s = new sqlfactura();
        return s.getOrdenesp(c, op, bd,cuenta);
    }

    @Override
    public ArrayList<Poliza> getasientoscontable(Connection concob) {
        sqlfactura s = new sqlfactura();
        return s.getAsientoscontables(concob);
    }

}
