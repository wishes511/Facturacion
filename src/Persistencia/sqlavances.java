/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Avance;
import Modelo.metadep;
import Modelo.pantalla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sqlavances {

    public boolean nuevoavancept(Connection a, Avance av) {
        try {
            PreparedStatement st;
            a.setAutoCommit(false);
            int lote = av.getLote();
            int pares = av.getPares();
            String fecha = av.getFecha();
            String punto = av.getPunto();
            String sql = "insert into lotespt(lotes,fecha,punto,pares,estatus) values(" + lote + ",'" + fecha + "','" + punto + "'," + pares + ",'1')";
            System.out.println(sql);
            st = a.prepareStatement(sql);
            st.executeUpdate();
            a.commit();

            return true;
        } catch (SQLException ex) {
            try {
                a.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    /**
     * Vacia la bd de avances de sqlite
     *
     * @param a
     */
    public void Vaciabd(Connection a) {
        try {
            PreparedStatement st;
            a.setAutoCommit(false);
            String sql = "delete from Avancespt";
            System.out.println(sql);
            st = a.prepareStatement(sql);
            st.executeUpdate();
            a.commit();
        } catch (SQLException ex) {
            try {
                a.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Desarrollo para poder realizar el reporte con lo dinamico de los puntos
     *
     * @param av conexion a avances
     * @param lite conexion a sqlite
     * @param rcpt
     * @param cob
     * @param f1 fecha iniciañ
     * @param f2 fecha fianl
     * @return
     */
    public boolean setRowsav(Connection av, Connection lite, String rcpt, String cob, String f1, String f2) {
        try {
            ResultSet rs, rs1, rs2;
            PreparedStatement st, st1, st2, s;
            lite.setAutoCommit(false);
            String sql = "select lotes,p.pedido, nombre40,corridacpt,cor.PuntoInicial, cor.PuntoFinal,p.npares,sum(pares) as in_par\n"
                    + "from lotespt l \n"
                    + "join programa p on l.lotes=p.lote\n"
                    + "join " + rcpt + ".dbo.pedidos ped on ped.pedido=p.pedido\n"
                    + "join " + cob + ".dbo.Clientes c on ped.NumCliente=c.NumCliente\n"
                    + "join " + rcpt + ".dbo.corridas cor on p.corridacpt=cor.Corrida\n"
                    + "where l.fecha between '" + f1 + "' and '" + f2 + "' and years=year(l.fecha)\n"
                    + "group by lotes,p.pedido, nombre40,corridacpt,cor.PuntoInicial, cor.PuntoFinal,p.npares";
            System.out.println(sql);
            st = av.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                int lote = rs.getInt("lotes");
                int parin = rs.getInt("in_par");
                int npar = rs.getInt("npares");
                int pi = rs.getInt("puntoinicial") * 10;
                int pf = (rs.getInt("puntofinal") * 10) + 5;
                String pedido = rs.getString("pedido");
                String cliente = rs.getString("nombre40");
                sql = "select distinct convert(date,fecha) as fecha, lotes\n"
                        + "from lotespt\n"
                        + "where lotes=" + lote + " and fecha between '" + f1 + "' and '" + f2 + "'";
//                System.out.println(sql);
                st1 = av.prepareStatement(sql);
                rs1 = st1.executeQuery();
                while (rs1.next()) {
                    ArrayList<Avance> arrav = new ArrayList<>();
                    String fecha = rs1.getString("fecha");
                    sql = "select distinct sum(pares) as pares,punto\n"
                            + "from lotespt\n"
                            + "where lotes=" + lote + " and convert(date,fecha)='" + fecha + "'\n"
                            + "group by punto\n"
                            + "order by punto";
//                    System.out.println(sql);
                    st2 = av.prepareStatement(sql);
                    rs2 = st2.executeQuery();

                    while (rs2.next()) {
                        Avance a = new Avance();
                        a.setPunto(rs2.getString("punto"));
                        a.setPares(rs2.getInt("pares"));
                        arrav.add(a);
                    }
                    int iarr = 0;
                    int p = pi;
                    int aux = 1;
                    String sqlpar = "";
                    boolean band = true;
//                    bucle solo para crear un string con la consulta para insercion
                    for (int i = 0; i <= 11; i++) {
                        if (band) {
                            if (arrav.get(iarr).getPunto().equals(pi + "")) {
                                sqlpar = "'" + arrav.get(iarr).getPares() + "','" + pi + "'";
                                iarr++;
                            } else {
                                sqlpar = "'0','" + pi + "'";
                            }
                            p += 5;
                            band = false;
                        } else {
                            if (iarr < arrav.size()) {
                                if (arrav.get(iarr).getPunto().equals(p + "")) {
                                    sqlpar += ",'" + arrav.get(iarr).getPares() + "','" + p + "'";
                                    iarr++;
                                } else {
                                    if (p <= pf) {
                                        sqlpar += ",'0','" + p + "'";
                                    } else {
                                        sqlpar += ",'',''";
                                    }

                                }
                            } else {
                                if (p <= pf) {
                                    sqlpar += ",'0','" + p + "'";
                                } else {
                                    sqlpar += ",'',''";
                                }

                            }
                            p += 5;
                        }
                        aux++;
                    }
                    sql = "insert into Avancespt(lote,fecha,pedido,cliente,parinicial,parcap,c1,p1,c2,p2,c3,p3,c4,p4,c5,p5,c6,p6,c7,p7,c8,p8,c9,p9,c10,p10,c11,p11,c12,p12)"
                            + " values(" + lote + ",'" + fecha + "','" + pedido + "','" + cliente + "'," + parin + "," + npar + "," + sqlpar + ")";
//                    System.out.println(sql);
                    s = lite.prepareStatement(sql);
                    s.executeUpdate();
                    lite.commit();
//                    System.out.println(sqlpar);
                    arrav.clear();
                }
            }
            return true;
        } catch (SQLException ex) {
            try {
                lite.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<metadep> getallavance(Connection c) {
        ArrayList<metadep> arr = new ArrayList<>();
        try {
            ResultSet rs;
            PreparedStatement st;
            String sql = "select  * from metaxdep order by nombre";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                metadep m = new metadep();
                m.setNombre(rs.getString("Nombre"));
                m.setCantxhr(rs.getInt("cantxhr"));
                m.setCantxdia(rs.getInt("cantxdia"));
                arr.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     * Cambios en col, de ahora en adelante se utilizara para mandar la
     * multiplicacion de hrs x los pares
     *
     * @param c
     * @param prs
     * @param col
     * @param nombre
     * @return
     */
    public boolean updateprshr(Connection c, int prs, String col, String nombre) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update metaxdep set cantxhr=" + prs + ", cantxdia=" + col + " where nombre='" + nombre + "'";
            System.out.println("actualiza prs avance " + sql);
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public ArrayList<pantalla> getpantalals(Connection c) {
        ArrayList<pantalla> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from pantallas";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                pantalla p = new pantalla();
                p.setPantalla(rs.getInt("pantalla"));
                p.setNombre(rs.getString("nombre"));
                p.setCorte(rs.getString("corte"));
                p.setPrecorte(rs.getString("precorte"));
                p.setPespunte(rs.getString("pespunte"));
                p.setDeshebrado(rs.getString("deshebrado"));
                p.setOjillado(rs.getString("ojillado"));
                p.setInspeccion(rs.getString("inspeccion"));
                p.setPreacabado(rs.getString("preacabado"));
                p.setMontado(rs.getString("montado"));
                p.setMontado2(rs.getString("montado2"));
                p.setPt(rs.getString("pt"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int getmaxpantalla(Connection c) {
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select max(pantalla) as pantalla from pantallas";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("pantalla");
            }
            resp++;
        } catch (SQLException ex) {
            Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public boolean nuevaspantallas(Connection c, pantalla p) {
        try {
            PreparedStatement st;
            c.setAutoCommit(false);
            int pant = p.getPantalla();
            String n = p.getNombre();
            String cor = p.getCorte();
            String prec = p.getPrecorte();
            String pes = p.getPespunte();
            String des = p.getDeshebrado();
            String oji = p.getOjillado();
            String prea = p.getPreacabado();
            String ins = p.getInspeccion();
            String m = p.getMontado();
            String pt = p.getPt();
            String m2 = p.getMontado2();
            String sql = "insert into pantallas "
                    + "values(" + pant + ",'" + n + "','" + cor + "','" + prec + "','" + pes + "','" 
                    + des + "','" + oji + "','" + prea + "','" + ins + "','" + m + "','" + pt + "','" + m2 + "')";
            st = c.prepareStatement(sql);
            st.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlavances.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
