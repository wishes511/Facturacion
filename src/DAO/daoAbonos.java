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
public class daoAbonos implements Int_abonos {

    private final sqlabonos s = new sqlabonos();

    /**
     * Inserta en la bd una nota de cargo "abonando" el importe al saldo y la
     * nota de credito para restarle ese saldo y quede nuevamente en ceros. Se
     * simplifico y todo el proceso se hizo de una.
     *
     * @param cobranza conexion a cobranza
     * @param c Objeti tipo cargo
     * @return boolean para saber si se lelvo a cabo o no
     */
    @Override
    public boolean new_Refacturacion(Connection cobranza, cargo c) {
        return s.new_Refacturacion(cobranza, c);
    }

}
