/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modelo.Cliente;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface clientes {
    public ArrayList<Cliente> getClientes(Connection c);
    public Cliente getCliente(Connection c, int id);
    
    
}
