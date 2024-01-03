/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Agentes;
import Modelo.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-Michel araujo
 */
public class sqlclientes {

    public ArrayList<Cliente> getClientes(Connection con) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
//            String sql="select * from clientes \n"
//                    + "where ISNULL(nombre40,'')!=''\n"
//                    + "order by nombre40";
            String sql = "select numcliente,nombre40,c.rfc,calle,colonia,c.cp,fax,agente1,plazo,CveCanal\n"
                    + "from clientes c\n"
                    + "join Agentes a on c.Agente1=a.CveAgente\n"
                    + "where ISNULL(nombre40,'')!=''\n"
                    + "order by nombre40";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                Agentes a = new Agentes();
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setAgente(rs.getInt("agente1"));
                c.setPlazo(rs.getInt("Plazo"));
                a.setIdcanal(rs.getInt("cvecanal"));
                c.setAg(a);
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getClientestpu(Connection con) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cliente,c.nombre as cliente,rfc,cp,calle,usocfdi,regimen,c.id_agente as agente,a.canal,plazo from cliente c\n"
                    + "join Agente a on  c.id_agente=a.id_agente\n"
                    + "where c.estatus='1'\n"
                    + "order by c.nombre";
            st = con.prepareStatement(sql);
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                Agentes ag = new Agentes();
                c.setCvecliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("cliente"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setCalle(rs.getString("calle"));
                c.setUsocfdi(rs.getString("usocfdi"));
                c.setRegimen(rs.getString("regimen"));
                ag.setIdagente(rs.getInt("agente"));
                ag.setIdcanal(rs.getInt("canal"));
                c.setPlazo(rs.getInt("plazo"));
                c.setAg(ag);
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Cliente> getClientestpuall(Connection cob, String cli) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_cliente, id_agente, nombre, rfc, cp, razonsocial, usocfdi, calle, colonia, pais, Estado, regimen, estatus, ciudad,correo,cuenta,telefono \n"
                    + "from cliente c\n"
                    + "where nombre like ? \n"
                    + "order by nombre desc";
            st = cob.prepareStatement(sql);
            st.setString(1, "%"+cli+"%");
//            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCvecliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setCalle(rs.getString("calle"));
                c.setUsocfdi(rs.getString("usocfdi"));
                c.setRegimen(rs.getString("regimen"));
                c.setColonia(rs.getString("colonia"));
                c.setPais(rs.getString("pais"));
                c.setEstado(rs.getString("estado"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstatus(rs.getString("estatus"));
                c.setCorreo(rs.getString("correo"));
                c.setCuenta(rs.getString("cuenta"));
                c.setTelefono(rs.getString("telefono"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public Cliente getClientes(Connection con, int cli) {//cobranza
        Cliente c = new Cliente();
        try {
            CallableStatement st;
            st = con.prepareCall("{call spclonacliente(?)}");
            st.setInt(1, cli);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {

                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre40"));
                c.setAgente(rs.getInt("agente1"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setUsocfdi(rs.getString("paginaweb"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setRegimen(rs.getString("fax"));
                c.setNombreagente(rs.getString("nombre"));
                c.setCanal(rs.getInt("CveCanal"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public Cliente getCliente(Connection con, int idcliente) {//cobranza
        Cliente c = new Cliente();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from clientes where numcliente=" + idcliente);
            rs = st.executeQuery();
            while (rs.next()) {
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("Nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public boolean importacliente(Connection c, Cliente cli) {
        int ag = 0;
        try {
            c.setAutoCommit(false);
            ResultSet rs;
            PreparedStatement st;
            String sql = "select * from Agente where id_agente=" + cli.getAgente();
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                ag = rs.getInt("id_agente");
            }
            if (ag == 0) {
                sql = "insert into Agente(id_agente,nombre,canal,comision,estatus) values(" + cli.getAgente() + ",'" + cli.getNombreagente() + "'," + cli.getCanal() + ",0,'1')";
//                System.out.println(sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            sql = "insert into Cliente(id_cliente,id_agente,nombre,rfc,cp,razonsocial,usocfdi,calle,colonia,pais,estado,regimen,estatus,ciudad) "
                    + "values(" + cli.getCvecliente() + "," + cli.getAgente() + ",'" + cli.getNombre() + "','" + cli.getRfc() + "','"
                    + cli.getCp() + "','" + cli.getNombre() + "','" + cli.getUsocfdi() + "','" + cli.getCalle() + "','" + cli.getColonia() + "','"
                    + cli.getPais() + "','" + cli.getEstado() + "','" + cli.getRegimen() + "','1','" + cli.getCiudad() + "')";
//            System.out.println(sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean modcliente(Connection cpt, Cliente c) {
        try {
            cpt.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update cliente set nombre=?,rfc=?,cp=?,usocfdi=?,calle=?,colonia=?,pais=?,"
                    + "estado=?,regimen=?,ciudad=?,correo=?,cuenta=?,telefono=?  where id_cliente=?";
            st = cpt.prepareStatement(sql);
            st.setString(0, c.getNombre());
            st.setString(1, c.getRfc());
            st.setString(2, c.getCp());
            st.setString(3, c.getUsocfdi());
            st.setString(4, c.getCalle());
            st.setString(5, c.getColonia());
            st.setString(6, c.getPais());
            st.setString(7, c.getEstado());
            st.setString(8, c.getRegimen());
            st.setString(9, c.getCiudad());
            st.setString(10, c.getCorreo());
            st.setString(11, c.getCuenta());
            st.setString(12, c.getTelefono());
            st.setInt(13, c.getCvecliente());
            st.executeUpdate();
//            System.out.println("mod cliente " + i);
            cpt.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlclientes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

}
