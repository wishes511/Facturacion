/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Comision;
import Persistencia.sqlcomisiones;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daocomisiones implements int_Comision {

    /**
     * Obtiene las comisiones si es que existen del pago reciente haciendo como
     * filtro la fecha de creacion del cargo, la fecha de pago y si no tiene
     * saldo
     *
     * @param c
     * @param fecha
     * @param referencia
     * @return
     */
    @Override
    public ArrayList<Comision> getcomisiones(Connection c, String fecha, String referencia) {
        sqlcomisiones s = new sqlcomisiones();
        return s.getcomisiones(c, fecha, referencia);
    }

    /**
     * Crea e inserta en la bd n numero de comisiones de acuerdo al numero de
     * facturas selecionadas y que cumplan con el filtro anterior
     *
     * @param c
     * @param arr
     * @return
     */
    @Override
    public boolean newcomision(Connection c, ArrayList<Comision> arr) {
        sqlcomisiones s = new sqlcomisiones();
        return s.newcomision(c, arr);
    }

}
