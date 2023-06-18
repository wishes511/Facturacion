/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Ddevolucion;
import Modelo.Devolucion;
import Modelo.Motivosdev;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-
 */
public class sqldevolucion {

    public ArrayList<Motivosdev> getallmomtivos(Connection c) {
        ArrayList<Motivosdev> arr = new ArrayList<>();
        try {

            PreparedStatement st;
            ResultSet rs;
            st = c.prepareStatement("select * from motivodev where estatus='1' order by descripcion desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Motivosdev m = new Motivosdev();
                m.setIdmotivo(rs.getInt("id_motivo"));
                m.setDescripcion(rs.getString("descripcion"));
                arr.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<Ddevolucion> getpedidowithpedido(Connection c, int id) {
        ArrayList<Ddevolucion> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select p.id_pedido,id_dpedido,pedido,p.fecha,id_kardex,c.id_cargo,dp.id_dpedimento,dp.cantidad,dp.costo,dp.importe,m.descripcion,dp.dureza,m.id_material,dpp.id_pedimento\n"
                    + "from pedido p\n"
                    + "join Dpedido dp on dp.id_pedido=p.id_pedido\n"
                    + "join Materiales m on dp.id_material=m.id_material\n"
                    + "join DPedimentos dpp on dpp.id_dpedimento=dp.id_dpedimento\n"
                    + "join [192.168.90.1\\DATOS620].RACobranzaTpu.dbo.Cargo c on p.pedido=c.referencia collate SQL_Latin1_General_CP1_CI_AS\n"
                    + "where serie='B' and p.id_pedido=" + id;
            System.out.println("dev ped " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Ddevolucion d = new Ddevolucion();
                d.setId_pedido(rs.getInt("id_pedido"));
                d.setId_dpedido(rs.getInt("id_dpedido"));
                d.setPedido(rs.getString("pedido"));
                d.setFecha(rs.getString("fecha"));
                d.setId_kardex(rs.getInt("id_kardex"));
                d.setId_cargo(rs.getInt("id_cargo"));
                d.setId_dpedimento(rs.getInt("id_dpedimento"));
                d.setId_pedimento(rs.getInt("id_pedimento"));
                d.setCantidad(rs.getDouble("cantidad"));
                d.setPrecio(rs.getDouble("costo"));
                d.setImporte(rs.getDouble("importe"));
                d.setDescripcion(rs.getString("descripcion"));
                d.setDureza(rs.getString("dureza"));
                d.setIdmaterial(rs.getInt("id_material"));
                arr.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean newdevolucion(Connection c, Devolucion d, Connection cob) {
        String sql;
        try {
            c.setAutoCommit(false);
            cob.setAutoCommit(false);
            PreparedStatement st;
            ResultSet rs;
            int respd = 0;
            int cliente = d.getId_cliente();
            int idped = d.getId_pedido();
            int cuenta = d.getId_concepto();
            int kardex = d.getId_kardex();
            int kardexnuevo = d.getId_kardexnuevo();
            int motivo = d.getId_motivo();
            int cargo = d.getId_cargoenc();
            String nombre = d.getNombre();
            String fecha = d.getFecha();
            String obs = d.getDesc();
            String serie = d.getSerie();
            String usuario = d.getUsuario();
            sql = "insert into devoluciones(id_cliente,id_pedido,id_concepto,id_kardex,id_motivo,nombre,total,fecha,descripcion,serie,estatus) "
                    + "values(" + cliente + "," + idped + "," + cuenta + "," + kardex + "," + motivo + ",'" + nombre + "',0,'" + fecha + "','" + obs + "','" + serie + "','1')";
            System.out.println("dev " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            sql = "update pedido set estatus='0' where id_pedido="+idped;
            System.out.println("ped dev " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            sql = "update cargo set saldo=0, saldomx=0,estatus='0' where id_cargo=" + cargo;
            System.out.println("cargo dev " + sql);
            st = cob.prepareStatement(sql);
            st.executeUpdate();
            sql = "select max(id_devolucion) as id from devoluciones";
            System.out.println("ddevolucion " + sql);
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                respd = rs.getInt("id");
            }
            for (int i = 0; i < d.getArr().size(); i++) {
                String dur = d.getArr().get(i).getDureza();
                String desc = d.getArr().get(i).getDescripcion();
                int idmat = d.getArr().get(i).getIdmaterial();
                int ren = i + 1;
                double precio = d.getArr().get(i).getPrecio();
                double cant = d.getArr().get(i).getCantidad();
                double imp = d.getArr().get(i).getImporte();
                int dped = d.getArr().get(i).getId_dpedimento();
                int idpedimento = d.getArr().get(i).getId_pedimento();
                sql = "insert into ddevoluciones(id_devolucion,id_material,dureza,renglon,precio,cantidad,importe,descripcion,estatus) "
                        + "values(" + respd + "," + idmat + ",'" + dur + "'," + ren + "," + precio + "," + cant + "," + imp + ",'" + desc + "','1')";
                System.out.println("d dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();

                sql = "update dpedimentos set cantidadrestante=cantidadrestante+" + cant + " where id_dpedimento=" + dped;
                System.out.println("d dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();

                sql = "insert into kardex "
                        + "values(" + kardexnuevo + "," + cuenta + "," + cliente + "," + idmat + ",0,1," + idpedimento + ",'" + usuario + "','" 
                        + fecha + "'," + precio + "," + precio + "," + cant + "," + ren + ",'B','1','1','" + dur + "','')";
                System.out.println("kar dev " + sql);
                st = c.prepareStatement(sql);
                st.executeUpdate();
            }
            cob.commit();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cob.commit();
                c.rollback();
                JOptionPane.showMessageDialog(null, "Error:"+ex.getMessage());
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqldevolucion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
