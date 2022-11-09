/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresas;
import Persistencia.sqlempresa;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public class daoempresa implements Empresa {

//    public Empresas getempresa(Connection c) {
    @Override
    public String getdirimag(Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresas getempresa(Connection c) {
        sqlempresa em = new sqlempresa();
        Empresas e = new Empresas();
        e = em.getEmpresa(c);
        return e;
    }

}
