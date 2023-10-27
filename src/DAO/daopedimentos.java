/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Dpedimento;
import Modelo.pedimento;
import Persistencia.sqlpedimentos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daopedimentos implements pedimentos {

    /**
     * Obtiene todos los pedimentos
     *
     * @param c
     * @param ped
     * @return
     */
    @Override
    public ArrayList<pedimento> getallpedimento(Connection c, String ped) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getallpepds(c, ped);
    }

    @Override
    public boolean nuevopedimento(Connection cpt, Connection rcpt, pedimento ped) {
        sqlpedimentos rs = new sqlpedimentos();
        return rs.nuevopedimento(cpt, rcpt, ped);
    }

    @Override
    public boolean borrarped(Connection cpt, Connection rcpt, pedimento ped) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<pedimento> getpedimentosimple(Connection cpt, String cob, String cliente) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentosimple(cpt, cob, cliente);
    }

    /**
     * Obtiene el detallado de pedimento usando al referencia del pedimento
     *
     * @param cpt
     * @param referencias
     * @return
     */
    @Override
    public ArrayList<pedimento> getpedimentoaadv(Connection cpt, String referencias) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentoadv(cpt, referencias);
    }

    @Override
    public boolean newmatpedimento(Connection cpt, Dpedimento ped) {
        sqlpedimentos s = new sqlpedimentos();
        return s.newmatpedimento(cpt, ped);
    }

    /**
     * Datos con el detalle del pedimento para uso de inventario
     *
     * @param cpt
     * @return
     */
    @Override
    public ArrayList<pedimento> getpedimentoinv(Connection cpt) {
        sqlpedimentos s = new sqlpedimentos();
        return s.getpedimentoinv(cpt);
    }

}
