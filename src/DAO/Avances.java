/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Avance;
import Modelo.metadep;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface Avances {

    public Connection getconAvance();
    
    public boolean NuevoAvance(Connection a, Avance av);

    public ArrayList<Avance> getavances(Connection a);
    
    public Connection getconAvance8();
    
    public boolean setrowsav(Connection av,Connection liteav,String rcpt, String cob, String f1, String f2);
    
    public void vaciabd(Connection av);
    
    public ArrayList<metadep> arrdepp(Connection c);
    
    /**
     * Actualiza las hrs de acuerdo a la columna ingresada
     * @param c
     * @param hrs
     * @param columna
     * @param nombre
     * @return 
     */
    public boolean actualizahrs(Connection c, int hrs, String columna, String nombre);
    
}
