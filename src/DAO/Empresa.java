/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresas;
import java.sql.Connection;

/**
 *
 * @author GATEWAY1-
 */
public interface Empresa {
    public Empresas getempresa(Connection c);
    public String getdirimag(Connection c);
}
