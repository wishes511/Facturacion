/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Dpedimento;
import Modelo.pedimento;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
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
public class sqlpedimentos {

    /**
     * Obtiene todos los pedimentos de acuerrdo al nombre del proveedor
     * ordenados de mayor a menos
     *
     * @param con
     * @param ped
     * @return
     */
    public ArrayList<pedimento> getallpepds(Connection con, String ped) {
        ArrayList<pedimento> arr = new ArrayList<>();
        try {
            ResultSet rs;
            CallableStatement st;
            st = con.prepareCall("{call spgetallpedimentos(?)}");
            st.setString(1, ped);
            rs = st.executeQuery();
            while (rs.next()) {
                pedimento p = new pedimento();
                p.setId_pedimento(rs.getInt("id_pedimento"));
                p.setReferencia(rs.getString("referencia"));
                p.setFecha(rs.getString("fecha"));
                p.setTotal(rs.getDouble("total"));
                p.setTcantidad(rs.getDouble("totalcant"));
                p.setNprov(rs.getString("nombre"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Crea nuevo pedimento
     *
     * @param cpt
     * @param rcpt
     * @param p
     * @return
     */
    public boolean nuevopedimento(Connection cpt, Connection rcpt, pedimento p) {
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql;
            cpt.setAutoCommit(false);
            int kardex = p.getId_kardex();
            int pedimento = 0;
            String fecha = p.getFecha();
            String fechaped = p.getFechapedimento();
            String ref = p.getReferencia();
            String serie = p.getSerie();
            double totalcant = p.getTcantidad();
            double sub = p.getSubtotal();
            double tot = p.getTotal();
            double imp = p.getImpuestos();
            String u = p.getUsuario();
            int cl = p.getId_proveedor();
            String obs = p.getObservaciones();
//            Fin insercion kardex
            sql = "insert into pedimentos(id_proveedor,referencia,fecha,total,impuestos,subtotal,totalcant,serie,estatus,fechapedimento,observaciones)"
                    + " values(" + cl + ",'" + ref + "','" + fecha + "'," + tot + "," + imp + "," + sub + "," + totalcant + ",'A','1','" + fechaped + "','" + obs + "')";
//            System.out.println("pedimento " + sql);
            st = cpt.prepareStatement(sql);
            st.executeUpdate();

            sql = "select max(id_pedimento)as pedimento from pedimentos";
            st = cpt.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pedimento = rs.getInt("pedimento");
            }
            for (int i = 0; i < p.getArr().size(); i++) {
                int mat = p.getArr().get(i).getId_material();
                double precio = p.getArr().get(i).getPrecio();
                double cant = p.getArr().get(i).getCantidad();
                String matped = p.getArr().get(i).getMatped();
                double importe = p.getArr().get(i).getImporte();
                String dureza = p.getArr().get(i).getDureza();
                int alm = p.getArr().get(i).getId_almacen();
                sql = "insert into dpedimentos(id_material,id_pedimento,cantidad,precio,costo,importe,cantidadrestante,estatus,matpedimento,dureza)"
                        + " values(" + mat + "," + pedimento + "," + cant + "," + precio + "," + precio + "," + importe + "," + cant + ",'1','" + matped + "','" + dureza + "')";
//                System.out.println("dped " + sql);
                st = cpt.prepareStatement(sql);
                st.executeUpdate();
                sql = "insert into kardex(id_kardex,id_concepto, id_cliente,id_material,id_prov,id_almacen,id_pedimento,usuario,fecha,costo,precio,cantidad,renglon,serie,estatus,estatusprod,dureza) "
                        + "values(" + kardex + ",1,0," + mat + "," + cl + "," + alm + "," + pedimento + ",'" + u + "','" + fecha + "',"
                        + precio + "," + precio + "," + cant + "," + (i + 1) + ",'A','1','1','" + dureza + "')";
//                System.out.println("kardex " + sql);
                st = cpt.prepareStatement(sql);
                st.executeUpdate();
            }
            cpt.commit();
            return true;
        } catch (SQLException ex) {
            try {
                cpt.rollback();
                Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<pedimento> getpedimentosimple(Connection cpt, String cob, String cliente) {
        ArrayList<pedimento> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id_pedimento,referencia,p.id_proveedor,nombre from pedimentos p\n"
                    + "join proveedores prov on p.id_proveedor=prov.id_proveedor\n"
                    + "where nombre like '%"+cliente+"%' and p.estatus='1'";
//                        String sql = "select id_pedimento,referencia,p.id_proveedor,nombre from pedimentos p\n"
//                    + "join proveedores prov on p.id_proveedor=prov.id_proveedor\n"
//                    + "where nombre like '%"+cliente+"%' and id_pedimento in (select id_pedimento from DPedimentos where cantidadrestante>0)";
            st = cpt.prepareStatement(sql);
            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pedimento p = new pedimento();
                p.setId_pedimento(rs.getInt("id_pedimento"));
                p.setReferencia(rs.getString("referencia"));
                p.setId_proveedor(rs.getInt("id_proveedor"));
                p.setNprov(rs.getString("nombre"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<pedimento> getpedimentoadv(Connection cpt, String referencias) {
        ArrayList<pedimento> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select p.id_pedimento as ped,id_dpedimento,referencia,matpedimento,cantidadrestante,unidad,dp.precio as precio,"
                    + "codigosat,dureza,dp.id_material as mat, convert(date,fechapedimento) as fechaped"
                    + "  from pedimentos p\n"
                    + "join dpedimentos dp on p.id_pedimento=dp.id_pedimento\n"
                    + "join materiales m on dp.id_material=m.id_material\n"
                    + "where (" + referencias + ")";
            System.out.println(sql);
            st = cpt.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pedimento p = new pedimento();
                Dpedimento dp = new Dpedimento();
                p.setId_pedimento(rs.getInt("ped"));
                p.setReferencia(rs.getString("referencia"));
                dp.setId_dpedimento(rs.getInt("id_dpedimento"));
                dp.setMatped(rs.getString("matpedimento"));
                dp.setCantrestante(rs.getDouble("cantidadrestante"));
                dp.setUnidad(rs.getString("unidad"));
                dp.setPrecio(rs.getDouble("precio"));
                dp.setCodigosat(rs.getString("codigosat"));
                dp.setDureza(rs.getString("dureza"));
                dp.setId_material(rs.getInt("mat"));
                p.setFechapedimento(rs.getString("fechaped"));
                p.setDp(dp);
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean newmatpedimento(Connection c, Dpedimento p){
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            int ped=p.getId_pedimento();
            int mat=p.getId_material();
            double cant=p.getCantidad();
            double precio=p.getPrecio();
            double costo=p.getCosto();
            double crestante=p.getCantrestante();
            String nmaterial=p.getMatped();
            String dur=p.getDureza();
            String sql="insert into Dpedimentos(id_material,id_pedimento,cantidad,precio,costo,importe,cantidadrestante,estatus,matpedimento,dureza) "
                    + "values ("+mat+","+ped+","+cant+","+precio+","+costo+",0,"+crestante+",'1','"+nmaterial+"','"+dur+"')";
            System.out.println("new mat "+sql);
            st=c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlpedimentos.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
        
    }
}
