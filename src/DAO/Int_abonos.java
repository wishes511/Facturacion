/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.cargo;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface Int_abonos {
    
    public boolean new_Refacturacion(Connection cobranza, cargo c);
}
