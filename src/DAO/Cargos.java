/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.factura;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface Cargos {
    
    public boolean new_Notacargo(Connection c, factura f);
    
    public String get_Fechavencimiento(Connection c, int folio);
}
