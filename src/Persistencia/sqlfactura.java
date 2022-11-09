/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.Dfactura;
import Modelo.Kardexrcpt;
import Modelo.Producto;
import Modelo.Seriecpt;
import Modelo.factura;
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
public class sqlfactura {

    public factura getfactura(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        factura f = new factura();
        ArrayList<Dfactura> arr = new ArrayList<>();
        try {
            PreparedStatement st, st1;
            ResultSet rs, rs1;
            String sql = "select * from documentos where estatus =1 and folio=" + folio;
            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                float descuento = rs.getFloat("descuento");
                f.setDescuento(descuento);
                f.setId(rs.getInt("id"));
                f.setSerie(rs.getString("serie"));
                f.setFolio(rs.getInt("folio"));
                f.setFormapago(rs.getString("formadepago"));
                f.setDescmetodop(rs.getString("Metododepago"));//descripcion metodo pago
                f.setSubtotal(rs.getFloat("subtotal"));
                f.setMoneda(rs.getString("Moneda"));
                f.setTotal(rs.getFloat("Total"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setIdcliente(rs.getInt("idcliente"));
                f.setImpuestos(rs.getFloat("impuestos"));
                f.setBaseimpuesto(rs.getFloat("subtotal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                String sql1 = "select * from documentosdetalle where iddocumento=" + f.getId(); /// Detalle de factura o conceptos
                st1 = con.prepareStatement(sql1);
                rs1 = st1.executeQuery();
                while (rs1.next()) {// setear detalle de conceptos o detallado de factura
                    Dfactura df = new Dfactura();
                    df.setDescuento(rs1.getFloat("descuento"));
                    df.setImporta(rs1.getFloat("Importe"));//iva
                    df.setPrecio(rs1.getFloat("precio"));//valor unitario
                    df.setCantidad(rs1.getInt("cantidad"));//cantidad
                    df.setDescripcion(rs1.getString("descripcion"));
                    df.setCodigo(rs1.getString("codigo"));
                    df.setUmedida(rs1.getString("umedida"));
                    //impuestosx concepto
                    df.setBase(rs1.getFloat("base"));
                    df.setImpuesto(rs1.getString("impuesto"));
                    df.setTipofactor(rs1.getString("tipofactor"));
                    df.setTasaocuota(rs1.getString("tasaocuota") + "0000");
                    df.setId(rs.getInt("id"));
                    arr.add(df);
                }
                f.setArr(arr);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public boolean insertfactura(Connection con) {//Rcpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;

            sql = "insert into Kardex "
                    + "values ()";
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

}
