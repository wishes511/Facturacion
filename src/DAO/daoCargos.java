/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.factura;
import Persistencia.sqlcargos;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public class daoCargos implements Cargos {

    private final sqlcargos S = new sqlcargos();

    /**
     * Ingresa un nuevo cargo en la bd interna como complemento de una factura
     * la referencia se especifica como "FAC_45682", que es la "serie_folio"
     *
     * @param c conexion cobranza interna
     * @param f
     * @return
     */
    @Override
    public boolean new_Notacargo(Connection c, factura f) {
        return S.new_Notacargo(f, c);
    }

    /**
     * Obtiene la fecha de vencimiento del cargo con el folio de la factura
     *
     * @param c conexion de cobranza
     * @param folio de factura
     * @return String, fecha de vencimiento
     */
    @Override
    public String get_Fechavencimiento(Connection c, int folio) {
        return S.get_Fechavencimiento(c, folio);
    }

}