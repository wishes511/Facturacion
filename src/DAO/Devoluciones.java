/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Devoluciones {

    public ArrayList<Motivosdev> arrmotivos(Connection c);
    
    public ArrayList<Devolucion> arr(Connection c, String s);
    
    public ArrayList<Ddevolucion> arr(Connection c, int id_pedido);
    
    public ArrayList<Ddevolucion> arrfac(Connection c, int folio);

    public boolean newdev(Connection c, Devolucion d, Connection cob);
    
    public ArrayList<Devolucion> getalldevswithn(Connection c,String serie);
}
