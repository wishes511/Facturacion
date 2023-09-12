/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Avance;
import Modelo.metadep;
import Modelo.pantalla;
import Persistencia.sqlavances;
import Server.Serverylite;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoAvances implements Avances {

    /**
     * Crea una linea de avance sobre el objeto de avance
     *
     * @param a La conexion para prueba es en lite
     * @param av
     * @return
     */
    @Override
    public boolean NuevoAvance(Connection a, Avance av) {
        sqlavances s = new sqlavances();
        return s.nuevoavancept(a, av);
    }

    @Override
    public ArrayList<Avance> getavances(Connection a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Para pruebas usar la bd de lite y no la de produccion(6.8)
     *
     * @return
     */
    @Override
    public Connection getconAvance() {
        return null;
    }

    @Override
    public Connection getconAvance8() {
        return null;
    }

    /**
     *
     * @param av conexion a server avcances
     * @param liteav conexion a serverlite para reporte
     * @param rcpt nombre bd rcpt
     * @param cob nombre bd cobranza
     * @param f1 fecha inicial
     * @param f2 fecha final
     * @return
     */
    @Override
    public boolean setrowsav(Connection av, Connection liteav, String rcpt, String cob, String f1, String f2) {
        sqlavances s = new sqlavances();
        return s.setRowsav(av, liteav, rcpt, cob, f1, f2);
    }

    /**
     * Vacia la tabla de los avances en sqlite
     * @param av 
     */
    @Override
    public void vaciabd(Connection av) {
        sqlavances s = new sqlavances();
        s.Vaciabd(av);
    }

    @Override
    public ArrayList<metadep> arrdepp(Connection c) {
        sqlavances sa = new sqlavances();
        return sa.getallavance(c);
    }

    /**
     * Cambios en col, de ahora en adelante se utilizara para mandar la multiplicacion de hrs x los par
     * @param c
     * @param hrs
     * @param columna
     * @param nombre
     * @return 
     */
    @Override
    public boolean actualizahrs(Connection c, int hrs, String columna, String nombre) {
        sqlavances sa = new sqlavances();
        return sa.updateprshr(c, hrs, columna, nombre);
    }

    @Override
    public ArrayList<pantalla> getpantallas(Connection c) {
        sqlavances a = new sqlavances();
        return a.getpantalals(c);
    }

    @Override
    public boolean nuevaspantallas(Connection c, pantalla p) {
        sqlavances a = new sqlavances();
        return a.nuevaspantallas(c, p);
    }

    @Override
    public int getmaxpantalla(Connection c) {
        sqlavances a = new sqlavances();
        return a.getmaxpantalla(c);
    }

}
