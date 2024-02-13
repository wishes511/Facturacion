/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Conexiones;
import Modelo.Dfactura;
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
     *
     * @param c
     * @param op
     * @param bd
     * @param cuenta
     * @return
     */
    @Override
    public ArrayList<abono> getabonospago(Connection c, String op, String bd, int cuenta) {
        sqlfactura s = new sqlfactura();
        return s.getOrdenesp(c, op, bd, cuenta);
    }

    @Override
    public ArrayList<Poliza> getasientoscontable(Connection concob) {
        sqlfactura s = new sqlfactura();
        return s.getAsientoscontables(concob);
    }

    /**
     *
     * @param rcpt
     * @param cpt
     * @param folio
     * @param foliof
     * @param pedido
     * @return
     */
    @Override
    public boolean actualizapedidos(Connection rcpt, Connection cpt, int folio, int foliof, String pedido) {
        sqlfactura s = new sqlfactura();
        return s.modpedido(rcpt, cpt, folio, foliof, pedido);
    }

    /**
     * modifica el numero de cajas en la factura
     *
     * @param rcpt
     * @param cpt
     * @param paquete
     * @param folio
     * @return
     */
    @Override
    public boolean setpaquetefact(Connection rcpt, Connection cpt, int paquete, int folio) {
        sqlfactura s = new sqlfactura();
        return s.modcajas(rcpt, cpt, paquete, folio);
    }

    /**
     *
     * @param c
     * @return
     */
    @Override
    public int getmaxtraslado(Connection c) {
        sqlfactura s = new sqlfactura();
        return s.getmaxtraslado(c);
    }

    /**
     * Nueva factura de traslado
     *
     * @param cpt
     * @param rcpt
     * @param f
     * @return
     */
    @Override
    public int nuevafacTraslado(Connection cpt, Connection rcpt, factura f) {
        sqlfactura s = new sqlfactura();
        return s.insertfacturatraslado(cpt, rcpt, f);
    }

    @Override
    public Conexiones nuevafacEconex(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertfacturaEcon(c, f, cob, rcpt);
    }

    /**
     * Obtiene el maximmo folio de acuerdo a la serie
     *
     * @param c
     * @param serie
     * @return
     */
    @Override
    public int getmaxfoliotpu(Connection c, String serie) {
        sqlfactura s = new sqlfactura();
        return s.getmaxfactpu(c, serie);
    }

    @Override
    public int getbuscafoliotpu(Connection c, String serie, String folio) {
        sqlfactura s = new sqlfactura();
        return s.buscafoliotpu(c, serie, folio);
    }

    @Override
    public int nuevafactpu(Connection cpt, factura f, Connection cob) {
        sqlfactura s = new sqlfactura();
        return s.insertfacturatpu(cpt, f, cob);
    }

    @Override
    public boolean actualizacadenatpu(Connection c, factura f) {
        sqlfactura s = new sqlfactura();
        return s.actualizafacturatpu(c, f);
    }

    @Override
    public boolean Updatesellofiscaltpu(Connection cpt, Sellofiscal s, int id) {
        sqlfactura f = new sqlfactura();
        return f.actualizasellostpu(cpt, s, id);
    }

    @Override
    public ArrayList<cargo> getfactstoFACReltpu(Connection c, String r, String bd) {
        sqlfactura f = new sqlfactura();
        return f.getfoliotoFACReltpu(c, r, bd);
    }

    @Override
    public int nuevaremtpu(Connection cpt, factura f, Connection cob) {
        sqlfactura s = new sqlfactura();
        return s.insertremtpu(cpt, f, cob);
    }

    @Override
    public ArrayList<factura> getpedidos(Connection cpt, String folio, String serie) {
        sqlfactura s = new sqlfactura();
        return s.getpedidos(cpt, folio, serie);
    }

    @Override
    public ArrayList<factura> getdocstpu(Connection cpt, String folio, String serie, String bd) {
        sqlfactura s = new sqlfactura();
        return s.getdocstpu(cpt, folio, serie, bd);
    }

    @Override
    public ArrayList<cargo> getfactsoncrtpu(Connection c, String r, String bd) {
        sqlfactura s = new sqlfactura();
        return s.getfoliotoNCRtpu(c, r, bd);
    }

    @Override
    public ArrayList<ConceptosES> getalcuentastpu(Connection c, String cuenta) {
        sqlfactura s = new sqlfactura();
        return s.getcuentastpu(c, cuenta);
    }

    @Override
    public int nuevancrtpu(Connection c, factura f, Connection cob, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertncrtpu(c, f, cob, rcpt);
    }

    @Override
    public ArrayList<factura> getdocvspago(Connection cpt, String folio) {
        sqlfactura s = new sqlfactura();
        return s.getfoliovspago(cpt, Integer.parseInt(folio));
    }

    @Override
    public ArrayList<factura> getdocvspagoall(Connection cpt, int id) {
        sqlfactura s = new sqlfactura();
        return s.getfoliovspagoall(cpt, id);
    }

    @Override
    public boolean Cancelancr(Connection cpt, Connection cob, ArrayList<factura> f, String fecha, String usuario) {
        sqlfactura s = new sqlfactura();
        return s.deletencr(cpt, cob, f, fecha, usuario);
    }

    @Override
    public int insertpagotpu(Connection cpt, Connection cob, factura f) {
        sqlfactura s = new sqlfactura();
        return s.insertpagostpu(cpt, f, cob);
    }

    @Override
    public ArrayList<factura> getfactwithserie(Connection rcpt, String ncobranza, String serie) {
        sqlfactura s = new sqlfactura();
        return s.getfactwithserie(rcpt, ncobranza, serie);
    }

    @Override
    public ArrayList<Dfactura> getfactwithseriedetallado(Connection rcpt, String factura, int año) {
        sqlfactura s = new sqlfactura();
        return s.getfactwithseriedetallado(rcpt, factura, año);
    }

    @Override
    public void actualizacadenapagotpu(Connection c, factura f) {
        sqlfactura s = new sqlfactura();
        s.actualizapagotpu(c, f);
    }

    @Override
    public boolean Updatesellofiscalpagotpu(Connection cpt, Sellofiscal s, int id) {
        sqlfactura sw = new sqlfactura();
        return sw.actualizasellotpupago(cpt, s, id);
    }

    @Override
    public boolean updateclientefacv2(Connection con, Cliente c, int id_documento) {
        sqlfactura s = new sqlfactura();
        return s.updateclientedoc(con, c, id_documento);
    }

    @Override
    public ArrayList<factura> getdocpagos(Connection cpt, String fol, String serie, String empcobranza) {
        sqlfactura s = new sqlfactura();
        return s.getdocspagos(cpt, fol, serie, empcobranza);
    }

    @Override
    public ArrayList<factura> getdocpagostpu(Connection cpt, String fol, String serie) {
        sqlfactura s = new sqlfactura();
        return s.getdocspagostpu(cpt, fol, serie);
    }

    /**
     * Busca una nota de credito o pago de acuerdo al id de la factura
     *
     * @param c
     * @param iddoc
     * @param serie
     * @param bd
     * @return
     */
    @Override
    public ArrayList<factura> searchPagncrtofac(Connection c, int iddoc, String serie, String bd) {
        sqlfactura s = new sqlfactura();
        return s.searchPagncrtofac(c, iddoc, serie, bd);
    }

    @Override
    public ArrayList<cargo> getfactrem(Connection cobB, String var, String ncob) {
        sqlfactura s = new sqlfactura();
        return s.getcargosrem(cobB, var, ncob);
    }

    @Override
    public ArrayList<factura> getdocspagosremi(Connection con, String folio) {
        sqlfactura s = new sqlfactura();
        return s.getdocspagosremi(con, folio);
    }

    @Override
    public int nuevafactpuATH(Connection cpt, factura f, Connection cob, Connection cpttpu, Connection rcpt) {
        sqlfactura s = new sqlfactura();
        return s.insertfacturatpuATH(cpt, f, cob, cpttpu, rcpt);
    }

    @Override
    public ArrayList<factura> getdocxmltpu(Connection cpt, String fol, String serie) {
        sqlfactura f = new sqlfactura();
        return f.getdocsxmltpu(cpt, fol, serie);
    }

    @Override
    public ArrayList<cargo> getfactopagotpu(Connection c, String r, String bd) {
        sqlfactura s = new sqlfactura();
        return s.getfoliotopagotpu(c, r, bd);
    }

    @Override
    public int insertpagotpuPUE(Connection cpt, Connection cob, factura f) {
        sqlfactura s = new sqlfactura();
        return s.insertpagostpu(cpt, f, cob);
    }

    /**
     * Obtiene registros del pago de acuerdo al id del documento de pago
     *
     * @param c
     * @param id
     * @return
     */
    @Override
    public ArrayList<factura> getregspcancelpagotpu(Connection c, int id) {
        sqlfactura s = new sqlfactura();
        return s.getcancelapago(c, id);
    }

    /**
     * Ejecuta modificacion de registros para cancelacion de un pago en tpu
     *
     * @param c
     * @param cob
     * @param arr
     * @return
     */
    @Override
    public boolean execcancelacionPago(Connection c, Connection cob, ArrayList<factura> arr) {
        sqlfactura s = new sqlfactura();
        return s.execcancelPago(c, cob, arr);
    }

}
