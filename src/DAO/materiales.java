/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Materiales;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface materiales {

    public boolean nuevomat(Connection cpt, Connection rcpt, Materiales m);

    public ArrayList<Materiales> getmateriales(Connection rcpt, String mat);

    public boolean deletemat(int material);

    public boolean modmaterial(Connection cpt, Connection rcpt, Materiales m);
}
