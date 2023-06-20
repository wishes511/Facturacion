/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import Persistencia.sqldevolucion;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoDevolucion implements Devoluciones {

    @Override
    public ArrayList<Devolucion> arr(Connection c, String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Motivosdev> arrmotivos(Connection c) {
        sqldevolucion s = new sqldevolucion();
        return s.getallmomtivos(c);
    }

    @Override
    public ArrayList<Ddevolucion> arr(Connection c, int id_pedido) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidowithpedido(c, id_pedido);
    }

    @Override
    public boolean newdev(Connection c, Devolucion d, Connection cob) {
        sqldevolucion s = new sqldevolucion();
        return s.newdevolucion(c, d, cob);
    }

    @Override
    public ArrayList<Ddevolucion> arrfac(Connection c, int folio) {
        sqldevolucion s = new sqldevolucion();
        return s.getpedidowithpedidofac(c, folio);
    }

    @Override
    public ArrayList<Devolucion> getalldevswithn(Connection c, String serie) {
        sqldevolucion s = new sqldevolucion();
        return s.getalldevs(c,serie);
    }

}
