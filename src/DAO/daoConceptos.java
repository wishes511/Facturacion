/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ConceptosES;
import Persistencia.sqlconceptos;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoConceptos implements conceptos{

    @Override
    public ArrayList<ConceptosES> getConceptos(Connection c) {
        sqlconceptos s = new sqlconceptos();
        return s.getConceptosES(c);
    }

    
    
}
