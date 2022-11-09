/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.factura;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Facturas {
    public factura nuevafac(Connection c, factura f);// factura y generar xml
    public ArrayList<factura> getfacs(Connection c, String folio);//despliegue de facturas
    public factura getfac(Connection c, String folio);//despliegue de facturas
}
