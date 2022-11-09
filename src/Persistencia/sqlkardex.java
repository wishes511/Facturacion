/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.Kardexrcpt;
import Modelo.Producto;
import Modelo.Seriecpt;
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
public class sqlkardex {

    public ArrayList<Producto> getprodxestilo(Connection con, int estilo) {//cobranza
        ArrayList<Producto> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select distinct producto,estilo, com.combinacion as comb,p.corrida,"
                    + " c.Descripcion dcorrida,c.PuntoInicial,c.PuntoFinal,m.Descripcion as mdes,col.Descripcion as coldes from productos p\n"
                    + "join corridas c on p.Corrida=c.corrida\n"
                    + "join Combinaciones com on p.Combinacion=com.Combinacion\n"
                    + "join materiales m on com.Material1=m.Material\n"
                    + "join colores col on com.Color1=col.Color\n"
                    + "where estilo=" + estilo + " and estatus='A'");
            rs = st.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setProducto(rs.getInt("producto"));
                p.setEstilo(rs.getInt("Estilo"));
                p.setCombinacion(rs.getInt("comb"));
                p.setCorrida(rs.getInt("corrida"));
                p.setCordesc(rs.getString("dcorrida"));
                p.setPi(rs.getInt("puntoinicial"));
                p.setPf(rs.getInt("puntofinal"));
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean insertkardex(Connection con, Kardexrcpt k) {//Rcpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;

            int folio = k.getFolio();
            String pedido = k.getPedido();
            String fecha = k.getFecha();
            String doc = k.getDocref();
            int vale = k.getVale();
            int prv = k.getPrv();
            String cuenta = k.getCuenta();
            String sub = k.getSubcuenta();
            String serie = k.getSerie();
            int agente = k.getAgente();
            int tpares = 0;//para pedidos
            float total = 0;// para pedidos
            String marca = k.getMarca();
            for (int i = 0; i < k.getArr().size(); i++) {
                int almacen = k.getArr().get(i).getAlmacen();
                int prod = k.getArr().get(i).getProducto();
                int paquete = 0;
                int prog = 0;
                int lote = 1;
                int totalpares = k.getArr().get(i).getCantidad();
                float costo = k.getArr().get(i).getCosto();
                float venta = k.getArr().get(i).getPrecio();
                float importe = totalpares * costo;
                int c1 = k.getArr().get(i).getP1();
                int c2 = k.getArr().get(i).getP2();
                int c3 = k.getArr().get(i).getP3();
                int c4 = k.getArr().get(i).getP4();
                int c5 = k.getArr().get(i).getP5();
                int c6 = k.getArr().get(i).getP6();
                int c7 = k.getArr().get(i).getP7();
                int c8 = k.getArr().get(i).getP8();
                int c9 = k.getArr().get(i).getP9();
                int c10 = k.getArr().get(i).getP10();
                int c11 = k.getArr().get(i).getP11();
                int c12 = k.getArr().get(i).getP12();
                String stock = k.getArr().get(i).getTipo();
                tpares += totalpares;
                total += totalpares * venta;
                sql = "insert into Kardex "
                        + "values (" + almacen + "," + prod + "," + folio + ",'" + fecha + "'," + (i + 1) + ",'" + doc + "'," + vale + "," + prv + ",'"
                        + cuenta + "','" + sub + "'," + paquete + "," + prog + "," + lote + "," + totalpares + "," + costo + "," + venta + ","
                        + importe + "," + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + ",0,0,'" + stock + "','"
                        + stock + "','','I','" + pedido + "'," + (i + 1) + ",'',0,0,0,'','" + serie + "','Michel','" + fecha + "')";
                System.out.println("rcpt " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            ///Solo pedidos
            double importes = total + (total * 0.16);
            sql = "insert into Pedidos "
                    + "values ('" + pedido + "','" + fecha + "','" + fecha + "','" + fecha + "','" + fecha + "',''," + prv + ",0,''," + agente + ",23,'P',38,0," + importes + ","
                    + tpares + ",25,'" + fecha + "','',0,'" + fecha + "','','',NULL,'NINGUNA',NULL,NULL,0,0,0,'',0," + tpares + ",0,0,'','N',NULL,NULL,NULL,'"
                    + serie + "','Michel','" + fecha + "','Michel','" + fecha + "','" + marca + "')";
            System.out.println("pedidos " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();

            for (int i = 0; i < k.getArr().size(); i++) {//Dpedidos
                int almacen = k.getArr().get(i).getAlmacen();
                int prod = k.getArr().get(i).getProducto();
                int estilo = k.getArr().get(i).getEstilo();
                int corrida = k.getArr().get(i).getCorrida();
                int comb = k.getArr().get(i).getCombinacion();
                int linea = k.getArr().get(i).getLinea();
                int paquete = 0;
                int prog = 0;
                int lote = 1;
                int totalpares = k.getArr().get(i).getCantidad();
                float costo = k.getArr().get(i).getCosto();
                float venta = k.getArr().get(i).getPrecio();
                int c1 = k.getArr().get(i).getP1();
                int c2 = k.getArr().get(i).getP2();
                int c3 = k.getArr().get(i).getP3();
                int c4 = k.getArr().get(i).getP4();
                int c5 = k.getArr().get(i).getP5();
                int c6 = k.getArr().get(i).getP6();
                int c7 = k.getArr().get(i).getP7();
                int c8 = k.getArr().get(i).getP8();
                int c9 = k.getArr().get(i).getP9();
                int c10 = k.getArr().get(i).getP10();
                int c11 = k.getArr().get(i).getP11();
                int c12 = k.getArr().get(i).getP12();
                String stock = k.getArr().get(i).getTipo();
                sql = "insert into DPedidos "
                        + "values ('" + pedido + "','" + fecha + "'," + (i + 1) + "," + prod + "," + estilo + ",NULL," + corrida + "," + comb + "," + linea + "," + c1 + "," + c2 + "," + c3 + "," + c4 + ","
                        + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + ",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0," + c1 + "," + c2 + "," + c3 + "," + c4 + ","
                        + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + ",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"
                        + "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0," + totalpares + "," + totalpares + ",0," + prog + ",0,0," + costo + "," + venta + ",'"
                        + stock + "',0,NULL,25,'" + fecha + "','N',NULL,NULL,NULL,NULL,NULL,'Michel',NULL)";
                System.out.println("Dpedidos " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }

            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public boolean insertkardex(Connection con) {//Rcpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;

            sql = "insert into Kardex "
                    + "values (11,8856,115470,'2022-3-1T18:00:00',1,'1',1,1,'60','01',1,1,1,2,2.5,3.5,.5,1,0,0,0,0,0,0,0,0,0,0,0,0,0,'P','P','','I','4512323 O',1,'',0,0,0,'','B','Michel','2022-10-20T18:00:00')";
            System.out.println("rcpt " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();

            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    public int getmaxkardex(Connection con) {//ult kardex folio
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("SELECT  max(folio)as folio FROM Kardex WHERE Cuenta BETWEEN '50' AND '99'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxped(Connection con) {//ult pedido folio
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("SELECT MAX(Convert(INT, left(pedido,len(Pedido)-2))) as pedido FROM Pedidos Where Convert(INT, left(pedido,len(Pedido)-2)) < 5000000");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("pedido");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public ArrayList<Kardexrcpt> getkardexfac(Connection con, String p) {//obtener datos para factura
        ArrayList<Kardexrcpt> kardex = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select top(10) folio,c.Nombre,c.rfc from kardex k\n"
                    + "join ACobranza.dbo.Clientes c on k.Cl_Prv=c.NumCliente\n"
                    + "where (folio like '" + p + "' or c.Nombre like '%" + p + "%') and (cuenta>49 and cuenta<100)\n"
                    + "order by folio desc");
            rs = st.executeQuery();
            while (rs.next()) {
                Kardexrcpt k = new Kardexrcpt();//objeto kardex
                Cliente c = new Cliente();      //onjeto cliente
                c.setNombre(rs.getString("nombre"));
                c.setRfc(rs.getString("rfc"));
                k.setFolio(rs.getInt("folio"));
                k.setCli(c);
                kardex.add(k);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kardex;
    }

}
