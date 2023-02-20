/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Kardexrcpt;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface kardexrcpt {

    public boolean nuevokardex(Connection c, Kardexrcpt k);

    public ArrayList<Kardexrcpt> getkardex(Connection c);

    public ArrayList<Kardexrcpt> getkardex(Connection c, Kardexrcpt k);

    public int maxkardex(Connection c);

    public int maxpedido(Connection c);

    public ArrayList<Kardexrcpt> getkardexfac(Connection c, String r, String cob);

    public ArrayList<Kardexrcpt> getkardexfacsimple(Connection c, String r, String cob);

    public ArrayList<Kardexrcpt> getkardexfacMulti(Connection c, String cob, String folios);
}
