/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Persistencia.sqlclientes;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class daoClientes implements clientes {

    @Override
    public ArrayList<Cliente> getClientes(Connection c) {
        sqlclientes s = new sqlclientes();
        return s.getClientes(c);
    }

    @Override
    public Cliente getCliente(Connection c, int id) {
        sqlclientes s = new sqlclientes();
        return s.getCliente(c, id);
    }

    @Override
    public Cliente getClientes(Connection c, int cliente) {
        sqlclientes s = new sqlclientes();
        return s.getClientes(c, cliente);
    }

    @Override
    public boolean importacliente(Connection c, Cliente cli) {
        sqlclientes s = new sqlclientes();
        return s.importacliente(c, cli);
    }

    @Override
    public ArrayList<Cliente> getClientestpu(Connection c) {
        sqlclientes s = new sqlclientes();
        return s.getClientestpu(c);
    }

    @Override
    public ArrayList<Cliente> getClientestpuall(Connection c, String cli) {
        sqlclientes s = new sqlclientes();
        return s.getClientestpuall(c, cli);
    }

    @Override
    public boolean modcliente(Connection cpt, Cliente cli) {
        sqlclientes s = new sqlclientes();
        return s.modcliente(cpt, cli);
    }

}
