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
import javax.swing.JOptionPane;

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

    public ArrayList<Kardexrcpt> getkardexfac(Connection con, String p, String cob) {//obtener datos para factura
        ArrayList<Kardexrcpt> kardex = new ArrayList<>();
//        String cob = "ACobranzaFH";//base de datos de cobranza
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select folio,k.Cl_Prv,c.Nombre40,c.RFC,c.CP,c.fax,c.calle,c.colonia,ci.Descripcion as ciudad,\n"
                    + "e.descripcion as estado,p.Descripcion as pais,npedido,serie,totalpares,pventa,renglon,\n"
                    + "prod.producto,estilo,prod.codigo,comb.Combinacion, m.Descripcion as material,\n"
                    + "  col.Descripcion as color,cor.Descripcion as corrida, agente1, plazo,l.Marca as marca,\n"
                    + " prod.linea, k.almacen, k.stockpedidos, prod.corrida as cor,\n"
                    + " cantidad1,cantidad2,cantidad3,cantidad4,cantidad5,cantidad6,cantidad7,cantidad8,cantidad9,\n"
                    + " cantidad10,cantidad11,cantidad12,cantidad13,cantidad14,ISNULL(c.CveMetodoPago,'') as mpago,ISNULL(paginaweb,'') as uso ,ag.CveCanal\n"
                    + "from kardex k \n"
                    + "join " + cob + ".dbo.Clientes c on k.Cl_Prv=c.NumCliente\n"
                    + "join " + cob + ".dbo.Ciudades ci on c.CveCiudad=ci.CveCiudad\n"
                    + "join " + cob + ".dbo.Estados e on ci.CveEstado=e.CveEstado \n"
                    + "join " + cob + ".dbo.Paises p on e.CvePais=p.CvePais\n"
                    + "join " + cob + ".dbo.agentes ag on c.Agente1=ag.CveAgente\n"
                    + "join Productos prod on k.Producto=prod.Producto\n"
                    + "join combinaciones comb on prod.Combinacion=comb.Combinacion\n"
                    + "join Materiales m on comb.Material1=m.material\n"
                    + "join colores col on comb.Color1=col.Color\n"
                    + "join corridas cor on prod.Corrida=cor.Corrida\n"
                    + "join lineas l on prod.Linea=l.Linea\n"
                    + "where (folio ='" + p + "' and statusimpresion='N')\n"
                    + "order by renglon";
            st = con.prepareStatement(sql);
            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Kardexrcpt k = new Kardexrcpt();//objeto kardex
                Cliente c = new Cliente();      //onjeto cliente
                Producto prod = new Producto();
                k.setFolio(rs.getInt("folio"));
                //Cliente
                c.setCvecliente(rs.getInt("cl_prv"));
                c.setNombre(rs.getString("nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                c.setAgente(rs.getInt("agente1"));
                c.setPlazo(rs.getInt("plazo"));
                c.setMarca(rs.getString("marca"));
                c.setClave(rs.getString("CveCanal"));
                //Fin cliente
                prod.setProducto(rs.getInt("Producto"));
                prod.setEstilo(rs.getInt("estilo"));
                prod.setCodigosat(rs.getString("codigo"));
                prod.setCombinacion(rs.getInt("combinacion"));
                prod.setDesccombinacion(rs.getString("material") + " " + rs.getString("color"));
                prod.setCordesc(rs.getString("corrida"));
                prod.setLinea(rs.getInt("linea"));
                prod.setCorrida(rs.getInt("cor"));
                //Kardex
                k.setPedido(rs.getString("npedido"));
                k.setSerie(rs.getString("serie"));
                k.setVenta(rs.getFloat("pventa"));
                k.setRenglon(rs.getInt("renglon"));
                k.setTotalpares(rs.getInt("totalpares"));
                k.setVenta(rs.getFloat("pventa"));
                k.setStock(rs.getString("stockpedidos"));
                k.setAlmacen(rs.getInt("almacen"));
                k.setC1(rs.getInt("Cantidad1"));
                k.setC2(rs.getInt("Cantidad2"));
                k.setC3(rs.getInt("Cantidad3"));
                k.setC4(rs.getInt("Cantidad4"));
                k.setC5(rs.getInt("Cantidad5"));
                k.setC6(rs.getInt("Cantidad6"));
                k.setC7(rs.getInt("Cantidad7"));
                k.setC8(rs.getInt("Cantidad8"));
                k.setC9(rs.getInt("Cantidad9"));
                k.setC10(rs.getInt("Cantidad10"));
                k.setC11(rs.getInt("Cantidad11"));
                k.setC12(rs.getInt("Cantidad12"));
                k.setC13(rs.getInt("Cantidad13"));
                k.setC14(rs.getInt("Cantidad14"));
                k.setUso(rs.getString("uso"));
                k.setFp(rs.getString("mpago"));
                

                //Asignar objetos al kardex y arraylist
                k.setCli(c);
                k.setP(prod);
                kardex.add(k);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kardex;
    }

    public ArrayList<Kardexrcpt> getkardexfacsimple(Connection con, String p, String cob) {//obtener datos para factura solo para la busqueda
        ArrayList<Kardexrcpt> kardex = new ArrayList<>();
//        String cob = "ACobranzaFH";//base de datos de cobranza
        try {
            PreparedStatement st;
            ResultSet rs;
            int nrows = (p.equals("289"))?45:16;
            String sql="select distinct top("+nrows+") folio,k.Cl_Prv,c.Nombre40,c.RFC,c.CP \n"
                    + "from kardex k\n"
                    + "join " + cob + ".dbo.Clientes c on k.Cl_Prv=c.NumCliente\n"
                    + "where (k.Cl_Prv like '%" + p + "%' or c.Nombre40 like '%" + p + "%' or c.Numcliente like '%" + p + "%') and (cuenta>49 and cuenta<100) and statusimpresion='N' \n"
                    + "order by folio desc";
            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Kardexrcpt k = new Kardexrcpt();//objeto kardex
                Cliente c = new Cliente();      //onjeto cliente
                k.setFolio(rs.getInt("folio"));
                c.setCvecliente(rs.getInt("cl_prv"));
                c.setNombre(rs.getString("nombre40"));
                k.setCli(c);
                kardex.add(k);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return kardex;
    }

}
