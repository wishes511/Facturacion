/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Detpagos;
import Modelo.Dfactura;
import Modelo.Formateodedatos;
import Modelo.Kardexrcpt;
import Modelo.Poliza;
import Modelo.Producto;
import Modelo.Sellofiscal;
import Modelo.Seriecpt;
import Modelo.abono;
import Modelo.cargo;
import Modelo.factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GATEWAY1-Michel araujo
 */
public class sqlfactura {

    public String formateafecha(String f) {
        //Solo da formato para que pueda entrar a la bd
        String nuevafecha = "";
        for (int i = 0; i < f.length() - 2; i++) {
            if (f.charAt(i) == ' ') {
                nuevafecha += "T";
            } else {
                nuevafecha += f.charAt(i);
            }
        }
        return nuevafecha;
    }

    /**
     *
     * @param con conexion a series folio de rcpt
     * @param folio
     * @return
     */
    public int buscafolio(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        int f = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select folio from documentos where folio=" + folio + " and serie='fac'";
//            System.out.println("busca folio " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                f = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    /**
     *
     * @param con
     * @param folio
     * @return
     */
    public int buscafolioncr(Connection con, String folio) {//obtiene datos de la factura recien ingresada
        int f = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select folio from documentos where folio=" + folio + " and serie='NCR'";
//            System.out.println("busca folio " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                f = rs.getInt("folio");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

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
                double descuento = rs.getDouble("descuento");
                f.setDescuento(descuento);
                f.setId(rs.getInt("id"));
                f.setSerie(rs.getString("serie"));
                f.setFolio(rs.getInt("folio"));
                f.setFormapago(rs.getString("formadepago"));
                f.setDescmetodop(rs.getString("Metododepago"));//descripcion metodo pago
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setMoneda(rs.getString("Moneda"));
                f.setTotal(rs.getDouble("Total"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setIdcliente(rs.getInt("idcliente"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setBaseimpuesto(rs.getDouble("subtotal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                String sql1 = "select * from documentosdetalle where iddocumento=" + f.getId(); /// Detalle de factura o conceptos
                st1 = con.prepareStatement(sql1);
                rs1 = st1.executeQuery();
                while (rs1.next()) {// setear detalle de conceptos o detallado de factura
                    Dfactura df = new Dfactura();
                    df.setDescuento(rs1.getDouble("descuento"));
                    df.setImporta(rs1.getDouble("Importe"));//iva
                    df.setPrecio(rs1.getDouble("precio"));//valor unitario
                    df.setCantidad(rs1.getInt("cantidad"));//cantidad
                    df.setDescripcion(rs1.getString("descripcion"));
                    df.setCodigo(rs1.getString("codigo"));
                    df.setUmedida(rs1.getString("umedida"));
                    //impuestosx concepto
                    df.setBase(rs1.getDouble("base"));
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

    /**
     *
     * @param con
     * @param folio
     * @param serie
     * @param cob
     * @return
     */
    public ArrayList<factura> getdocs(Connection con, String folio, String serie, String cob) {//obtiene datos de la factura recien ingresada

        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select id,folio,subtotal,impuestos,total,convert(date,fecha) as fecha,d.nombre,formadepago,metododepago, d.estatus, ISNULL(foliofiscal,'') as foliofiscal, d.usocfdi,fax, d.moneda\n"
                    + "from documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.idcliente=c.NumCliente\n"
                    + "where (d.idcliente like '%" + folio + "%' or d.nombre like '%" + folio + "%') and serie='" + serie + "'\n"
                    + "order by id desc";
            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            DecimalFormat formateador = new DecimalFormat("####.##");
            while (rs.next()) {
                factura f = new factura();
                f.setId(rs.getInt("id"));
                f.setFolio(rs.getInt("folio"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setTotal(rs.getDouble("Total"));
                f.setFecha(rs.getString("fecha"));
                f.setNombre(rs.getString("nombre"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setFormapago(rs.getString("formadepago"));
                f.setEstatus(rs.getInt("estatus"));
                f.setFoliofiscal(rs.getString("foliofiscal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                f.setRegimen(rs.getString("fax"));
                f.setMoneda(rs.getString("moneda"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<factura> getdocsxml(Connection con, String folio, String serie, String cob) {//obtiene datos de la factura recien ingresada

        ArrayList<factura> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select d.id,folio,d.descuento,subtotal,impuestos,total,convert(date,fecha) as fecha,d.nombre,d.rfc,formadepago,metododepago,\n"
                    + " d.estatus, ISNULL(foliofiscal,'') as foliofiscal, d.usocfdi,fax,d.cp,serie,d.Observaciones,moneda,iva,tipocambio,\n"
                    + " dd.cantidad,dd.codigo,descripcion, umedida,dd.precio,dd.base,dd.impuesto,dd.descuento as descu,Tipofactor,dd.importe\n"
                    + "from documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.idcliente=c.NumCliente\n"
                    + "join documentosdetalle dd on dd.IdDocumento=d.Id\n"
                    + "where d.id=" + folio + " and serie='" + serie + "'\n"
                    + "order by d.id desc";
            System.out.println("xml " + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                factura f = new factura();
                f.setId(rs.getInt("id"));
                f.setFolio(rs.getInt("folio"));
                f.setDescuento(rs.getDouble("descuento"));
                f.setSubtotal(rs.getDouble("subtotal"));
                f.setImpuestos(rs.getDouble("impuestos"));
                f.setTotal(rs.getDouble("Total"));
                f.setFecha(rs.getString("fecha"));
                f.setNombre(rs.getString("nombre"));
                f.setRfc(rs.getString("rfc"));
                f.setRegimen(rs.getString("fax"));
                f.setCp(rs.getString("cp"));
                f.setObservaciones(rs.getString("observaciones"));
                f.setMetodopago(rs.getString("metododepago"));
                f.setFormapago(rs.getString("formadepago"));
                f.setEstatus(rs.getInt("estatus"));
                f.setFoliofiscal(rs.getString("foliofiscal"));
                f.setUsocfdi(rs.getString("usocfdi"));
                f.setSerie(rs.getString("serie"));
                f.setObservaciones(rs.getString("observaciones"));
                f.setMoneda(rs.getString("moneda"));
                f.setIva(rs.getDouble("iva"));
                f.setTipocambio(rs.getInt("tipocambio"));
                f.setCantidadfloat(rs.getDouble("cantidad"));
                f.setCodigo(rs.getString("codigo"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setUmedida(rs.getString("umedida"));
                f.setPreciodetalle(rs.getDouble("precio"));
                f.setBasedetalle(rs.getDouble("base"));
                f.setImpuestodet(rs.getString("impuesto"));
                f.setDescuentodetalle(rs.getDouble("descu"));
                f.setTipofac(rs.getString("tipofactor"));
                f.setImportedetalle(rs.getDouble("importe"));
                arr.add(f);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int insertfactura(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
            int totalparesf = f.getTotalpares();
            String relacion = f.getTiporelacion();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("rcpt documentos " + sql + "\n");

//            Insercio a tabla facturas
            sql = "insert into facturas(factura,fecha,pedido,numcliente,plazo,totalpares,descuento,subtotal,IDesc,"
                    + "iva,total,cveagente,fechaembarque,estatus,observaciones,NOentrega,serie,Marca,usuario,registro) "
                    + "values ('" + fol + "','" + fecha + "','" + ped + "'," + idcliente + "," + plazo + "," + totalparesf + ",0,"
                    + subtotal + ", " + desc + "," + imp + "," + total + "," + agente + ",'" + fecha + "','F','" + obs + "',1,'A',' " + f.getMarca() + "','" + usuario + "','" + fecha + "')";
            System.out.println("facturas " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //RCPT
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("facturas rcpt " + sql + " \n");
//            Fin tabla facturas

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
//            Inserta en detallado de documentos
            int i = 1;
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();
                int almacen = arr.getAlmacen();
                int cor = arr.getCorrida();
                int lin = arr.getLinea();
                String stoc = arr.getStock();
                int comb = arr.getCombinacion();
                int est = arr.getEstilo();
                int c1 = arr.getC1();
                int c2 = arr.getC2();
                int c3 = arr.getC3();
                int c4 = arr.getC4();
                int c5 = arr.getC5();
                int c6 = arr.getC6();
                int c7 = arr.getC7();
                int c8 = arr.getC8();
                int c9 = arr.getC9();
                int c10 = arr.getC10();
                int c11 = arr.getC11();
                int c12 = arr.getC12();
                int c13 = arr.getC13();
                int c14 = arr.getC14();

                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();

                sql = "insert into dfacturas values('" + fol + "','" + fecha + "'," + i + "," + prod + "," + est + "," + cor + "," + comb + "," + lin + ","
                        + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "," + c7 + "," + c8 + "," + c9 + "," + c10 + "," + c11 + "," + c12 + "," + c13 + "," + c14 + ","
                        + c + "," + precio + "," + precio + "," + almacen + ",'" + stoc + "',0,'')";
                System.out.println("dfacturas " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("rcpt dfacturas " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
                i++;
            }
//             Fin detallado de documento
//              Status de kardex y dpedidos
            for (Dfactura arr : f.getArr()) {
                sql = "update Kardex set statusimpresion='I', factura='" + fol + "' where folio=" + f.getFoliokardex() + " and cuenta>49 and renglon=" + arr.getRenglon();
                System.out.println("kardex " + sql + " \n");
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("rcpt kardex " + sql);
            }
            //Actualizar status del detallado de pedido
            for (Dfactura arr : f.getArr()) {
                sql = "update dpedidos set estatus='30' where pedido='" + f.getPedido() + "' and renglon=" + arr.getRenglon();
                System.out.println("dpedidos " + sql + " \n");
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // Solo rcpt
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
                System.out.println("rcpt dpedidos " + sql);
            }
//            Fin detallado documento
//          Insercion de polizas
            for (int x = 0; x < f.getArrpolizas().size(); x++) {
                int cuenta = f.getArrpolizas().get(x).getCuenta();
                int sub = f.getArrpolizas().get(x).getSub();
                String fechas = f.getArrpolizas().get(x).getFecha();
                int cliente = f.getArrpolizas().get(x).getIdcliente();
                String ident = f.getArrpolizas().get(x).getIdentificacion();
                String cuental = f.getArrpolizas().get(x).getCuentalarga();
                int t = f.getArrpolizas().get(x).getCa();
                String imps = f.getArrpolizas().get(x).getImporte();
                String concep = f.getArrpolizas().get(x).getConcepto();
                String Acum = f.getArrpolizas().get(x).getAcumulativo();
                String ref = f.getArrpolizas().get(x).getReferencia();
                String fo = f.getArrpolizas().get(x).getFolio();
                String mext = f.getArrpolizas().get(x).getMext();
                int ord = f.getArrpolizas().get(x).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
                System.out.println(sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
            System.out.println("rcpt sfolios " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            if (!relacion.equals("")) {
                sql = "update documentos set tiporelacion='" + relacion + "', foliofiscalorig='" + f.getSeriefoliofiscalorig() + "'  where id=" + resp + "";
                System.out.println("rcpt sfolios " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cobranza.rollback();
                rcpt.rollback();
                JOptionPane.showMessageDialog(null, "insertar -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "inertar -" + ex1);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public int insertfacturaE(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
            int totalparesf = f.getTotalpares();
            String relacion = f.getTiporelacion();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,regimen,usocfdi) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + regimen + "','" + uso + "')";
            System.out.println("documentos " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //para rcpt
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("rcpt documentos " + sql + "\n");

            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
//            Inserta en detallado de documentos
            for (Dfactura arr : f.getArr()) {//
                int doc = resp;
                int prod = arr.getProducto();
                double c = arr.getCantidadfloat();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();

                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
                System.out.println("ddocs " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
                // solo rcpt
                System.out.println("rcpt ddocs " + sql);
                st = rcpt.prepareStatement(sql);
                st.executeUpdate();
            }
//            Fin detallado documento
//          
            for (int i = 0; i < f.getArrpolizas().size(); i++) {
                int cuenta = f.getArrpolizas().get(i).getCuenta();
                int sub = f.getArrpolizas().get(i).getSub();
                String fechas = f.getArrpolizas().get(i).getFecha();
                int cliente = f.getArrpolizas().get(i).getIdcliente();
                String ident = f.getArrpolizas().get(i).getIdentificacion();
                String cuental = f.getArrpolizas().get(i).getCuentalarga();
                int t = f.getArrpolizas().get(i).getCa();
                String imps = f.getArrpolizas().get(i).getImporte();
                String concep = f.getArrpolizas().get(i).getConcepto();
                String Acum = f.getArrpolizas().get(i).getAcumulativo();
                String ref = f.getArrpolizas().get(i).getReferencia();
                String fo = f.getArrpolizas().get(i).getFolio();
                String mext = f.getArrpolizas().get(i).getMext();
                int ord = f.getArrpolizas().get(i).getOrden();
                sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fechas + "','" + fo + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imps + "','000','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
                System.out.println(sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            // Actualizacion de los numeros de folio
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("sfolios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            sql = "update seriesfolios set ultimofolio=" + fol + " where serie='" + serie + "'";
//            System.out.println("rcpt sfolios " + sql);
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
//            actualizar relacion y series etq
            if (!relacion.equals("")) {
                sql = "update documentos set tiporelacion='" + relacion + "', foliofiscalorig='" + f.getSeriefoliofiscalorig() + "'  where id=" + resp + "";
                System.out.println("rcpt sfolios " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
//            rcpt.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
                cobranza.rollback();
                rcpt.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "insertar " + ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
                JOptionPane.showMessageDialog(null, "insertar " + ex1);
            }
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param f
     * @param cobranza
     * @param rcpt
     * @return
     */
    public int insertncr(Connection con, factura f, Connection cobranza, Connection rcpt) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
            cobranza.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            String cuentaa = f.getCuentaabono();
            String subc = f.getSubabono();
            String dcuenta = f.getDesccuenta();
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = "NCR " + fol;
            int agente = f.getAgente();
            String relacion = f.getTiporelacion();
            String folioorig = f.getFoliofiscalorig();
            String referenciasfac = f.getRefncredito();
            sql = "insert into Documentos(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,foliofiscalorig,regimen,usocfdi,Tiporelacion) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "','" + folioorig + "','" + regimen + "','" + uso + "','" + relacion + "')";
            System.out.println("factura " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from documentos group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            //Fin obtener ultimo documento
            //Insertar en cargos
//            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
//                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
//                    + "permiso,nuevoagente,fecharegistro) "
//                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
//                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
//            System.out.println("cargos" + sql);
//            st = cobranza.prepareStatement(sql);
//            st.executeUpdate();
            //Fin insertar cargos
            for (Dfactura arr : f.getArr()) {//Inserta en detallado de documentos
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                double precio = arr.getPrecio();
                double b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                double impo = arr.getImporta();
                double descu = arr.getDescuento();
                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
                System.out.println("d factura " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            // Fin detallado de documento
            // actualiza saldo de cargos
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                double descuento = f.getArrcargo().get(i).getDescuento();
                int cuenta = f.getArrcargo().get(i).getCuenta();
                int sub = f.getArrcargo().get(i).getSubcuenta();
                String referencia = f.getArrcargo().get(i).getReferencia();
                int cliente = f.getArrcargo().get(i).getCliente();
                sql = "update cargos set saldo=saldo-" + descuento + " where "
                        + "referencia='" + referencia + "' and cuenta=" + cuenta + " and subcuenta=" + sub + " and numcliente=" + cliente;
                System.out.println("Actualizar cargos" + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }
            //fin actualiza cargos
            //Nuevos abonos
            int sub = 0;
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                double descuento = f.getArrcargo().get(i).getDescuento();
                int cuenta = f.getArrcargo().get(i).getCuenta();
                sub = f.getArrcargo().get(i).getSubcuenta();
                String referencia = f.getArrcargo().get(i).getReferencia();
                int cliente = f.getArrcargo().get(i).getCliente();
                String fechac = f.getArrcargo().get(i).getFecha();
                String fechan = formateafecha(fechac);
                sql = "insert into Abonos(cuenta,subcuenta,referencia,tiempo,fecha,fechapago,fdepdxc,turno,cveagente,cvebanco,"
                        + "totalpago,pago,descuento,comision,saldo,observaciones,cuentac,subcuentac,referenciac,"
                        + "numclientec,fechac,notadecredito,nuevacomision,usuario,permiso,fecharegistro) "
                        + "values (" + cuentaa + "," + subc + ",'" + m + "',NEWID(),'" + fecha + "','" + fecha + "','" + fecha + "',0," + agente + ",0,"
                        + total + "," + descuento + ",0,0,0,'" + dcuenta + "'," + cuenta + "," + sub + ",'" + referencia + "'," + cliente + ",'"
                        + fechan + "','" + m + "',0,'" + usuario + "',1,'" + fecha + "')";
                System.out.println("Nuevo Abono " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }
            //Fin nuevos abonos
            //Nueva nota en bd
            sql = "insert into NotasCredito values ('" + m + "'," + idcliente + "," + subc + ",'" + fecha + "','" + referenciasfac + "','',0,"
                    + subtotal + "," + imp + "," + total + ",'A','" + usuario + "',1,'" + fecha + "',NULL)";
            System.out.println("Nueva nota enca " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                double descuento = f.getArrcargo().get(i).getDescuento();
                int cant = f.getArrcargo().get(i).getCantidad();
                String descnota = f.getArrcargo().get(i).getDescnota();
                sql = "insert into DNCredito values ('" + m + "'," + cant + ",'" + descnota + "'," + descuento + ")";
                System.out.println("Nueva nota detallado " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

            sql = "update seriesfolios set ultimofolio=ultimofolio+1 where serie='NCR'";
            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();

            con.commit();
            cobranza.commit();
            rcpt.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                con.rollback();
                cobranza.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public int insertpagos(Connection con, factura f, String cob) {//Rcpt y cpt
        PreparedStatement st = null;
        ResultSet rs;
        int resp = 0;
        try {
            con.setAutoCommit(false);
//            cobranza.setAutoCommit(false);
            String sql;
            String usuario = f.getClaveusuario();
            String serie = f.getSerie();
            int fol = f.getFolio();
            String fecha = f.getFecha();
            double desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            double subtotal = f.getSubtotal();
            double total = f.getTotal();
            double iva = f.getIva();
            double imp = f.getImpuestos();
            //pagos
            String rfcctaemi = f.getRfcctaemisora();
            String ctaemi = f.getCtaemisora();
            String bcoemi = f.getBancoemisor();
            String rfcctarep = f.getRfcctareceptor();
            String ctarep = f.getCtareceptora();
            String bcorep = f.getBancoreceptor();
            String op = f.getOrdenpago();
            double monto = f.getMonto();
            System.out.println("monto " + monto);
            //cliente
            int idcliente = f.getIdcliente();
            String nombre = f.getNombre();
            String rfc = f.getRfc();
            String calle = f.getCalle();
            String colonia = f.getColonia();
            String mun = f.getMunicipio();
            String estado = f.getEstado();
            String pais = f.getPais();
            String regimen = f.getRegimen();
            String cp = f.getCp();
            String ni = f.getNinterior();
            String ne = f.getNexterior();
            //fin cliente
            String obs = f.getObservaciones();
            int cajas = f.getTotalcajas();
            int cxcaja = f.getCantidadxcaja();
            String tiposerie = f.getTiposerie();
            String mon = f.getMoneda();
            double tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            String relacion = f.getTiporelacion();
            String folioorig = f.getFoliofiscalorig();
            sql = "insert into Doctospago(claveusuario,serie,folio,numeroaprobacion,anoaprobacion,"
                    + "fecha,estatus,descuento,motivodescuento,numpedido,fechasolicitado,condicion,"
                    + "fechaentrega,retenciones,iva,ivaret,ISRret,subtotal,impuestos,"
                    + "total,idcliente,nombre,rfc,calle,numexterior,numinterior,colonia,"
                    + "localidad,referencia,municipio,estado,pais,cp,observaciones,"
                    + "totalcajas,cantidadporcaja,tiposerie,moneda,tipocambio,enviado,"
                    + "formadepago,metododepago,lugarexpedicion,foliofiscalorig,regimen,usocfdi,Tiporelacion"
                    + ",Monto,Rfcctaemisora,ctaemisora,rfcctareceptora,ctareceptora,bancoemisor,bancoreceptor,ordenpago) "
                    + "values ('" + usuario + "','" + serie + "'," + fol + ",903682,2022,'" + fecha + "','1'," + desc
                    + ",'NINGUNO','" + ped + "','" + fechasoli + "','" + cond + "','" + fechaent + "',0," + iva + ",0,0," + subtotal
                    + "," + imp + "," + total + "," + idcliente + ",'" + nombre + "','" + rfc + "','" + calle + "','" + ne + "','" + ni + "','" + colonia + "'"
                    + ",'','','" + mun + "','" + estado + "','" + pais + "','" + cp + "','" + obs + "'," + cajas + "," + cxcaja
                    + ",'" + tiposerie + "','" + mon + "'," + tipoc + ",0,'" + fpago + "','" + mpago + "','" + Lugar + "'"
                    + ",'" + folioorig + "','" + regimen + "','" + uso + "','" + relacion + "'"
                    + "," + monto + ",'" + rfcctaemi + "','" + ctaemi + "','" + rfcctarep + "','" + ctarep + "','" + bcoemi + "','" + bcorep + "','" + op + "')";
            System.out.println("Pago " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();

            st = con.prepareStatement("select top(1)max(id) as id from doctospago group by fecha order by id desc");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id");
            }
            rs.close();
//            resp = f.getFolio();
            for (Detpagos arr : f.getArrpagos()) {
                //Inserta en detallado de detallado pago
                int doc = resp;
                double cant = arr.getCantidad();
                String de = arr.getDescripcion();
                String co = arr.getCodigo();
                String umed = arr.getUmedida();
                double precio = arr.getPrecio();
                String fp = arr.getFormadedpago();
                String moneda = arr.getMoneda();
                double mo = arr.getMonto();
                String rfcce = arr.getRfcctaemisora();
                String rfccr = arr.getRfcctareceptora();
                String ctae = arr.getCtaemisora();
                String ctar = arr.getCtareceptora();
                String uuid = arr.getUuid();
                String fo = arr.getRef();
                String mp = arr.getMetodopago();
                int par = arr.getParcialidad();
                double salant = arr.getImportesaldoant();
                double salpag = arr.getImportepagado();
                double salin = arr.getImpsaldoinsoluto();
                sql = "insert into doctospagodetalle(IdDocumento, Cantidad, Descripcion, Codigo, UMedida,"
                        + " Precio, FormadePago, MonedaPagoP, Monto, RFCCtaEmisora, CtaEmisora, RFCCtaReceptora,"
                        + " CtaReceptora, UUID, folio, Moneda, MetodoPago, \n"
                        + "                         NoParcialidad, ImporteSdoAnt, ImportePagado, ImpSaldoInsoluto) "
                        + "values(" + doc + "," + cant + ",'" + de + "','" + co + "','" + umed + "'," + precio + ",'" + fp + "','" + moneda + "',"
                        + mo + ",'" + rfcce + "','" + ctae + "','" + rfccr + "','" + ctar + "','" + uuid + "','" + fo + "','" + moneda + "','" + mp + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
                System.out.println("d pagos " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            for (Detpagos arr : f.getArrpagos17()) {
                //Inserta en detallado de detallado pago
                int doc = resp;
                double cant = arr.getCantidad();
                String de = arr.getDescripcion();
                String co = arr.getCodigo();
                String umed = arr.getUmedida();
                double precio = arr.getPrecio();
                String fp = arr.getFormadedpago();
                String moneda = arr.getMoneda();
                double mo = arr.getMonto();
                String rfcce = arr.getRfcctaemisora();
                String rfccr = arr.getRfcctareceptora();
                String ctae = arr.getCtaemisora();
                String ctar = arr.getCtareceptora();
                String uuid = arr.getUuid();
                String fo = arr.getRef();
                String mp = arr.getMetodopago();
                int par = arr.getParcialidad();
                double salant = arr.getImportesaldoant();
                double salpag = arr.getImportepagado();
                double salin = arr.getImpsaldoinsoluto();
                sql = "insert into doctospagodetalle(IdDocumento, Cantidad, Descripcion, Codigo, UMedida,"
                        + " Precio, FormadePago, MonedaPagoP, Monto, RFCCtaEmisora, CtaEmisora, RFCCtaReceptora,"
                        + " CtaReceptora, UUID, folio, Moneda, MetodoPago, \n"
                        + "                         NoParcialidad, ImporteSdoAnt, ImportePagado, ImpSaldoInsoluto) "
                        + "values(" + doc + "," + cant + ",'" + de + "','" + co + "','" + umed + "'," + precio + ",'" + fp + "','" + moneda + "',"
                        + mo + ",'" + rfcce + "','" + ctae + "','" + rfccr + "','" + ctar + "','" + uuid + "','" + fo + "','" + moneda + "','" + mp + "'," + par + "," + salant + "," + salpag + "," + salin + ")";
                System.out.println("d pagos17 " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            // Fin detallado de documento

            sql = "update seriesfolios set ultimofolio=ultimofolio+1 where serie='PAG'";
            System.out.println("series folios " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            cobranza.commit();
//            con.rollback();
//            cobranza.rollback();
        } catch (Exception ex) {
            try {
                resp = 0;
                con.rollback();
//                cobranza.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return resp;
    }

    public boolean actualizafactura(Connection con, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            String cert = f.getCertificado();
            String sello = f.getSello();
            String cadena = f.getCadenaorig();
            sql = "update documentos set nodeseriecertificado='" + cert + "', sello='" + sello + "', cadenaoriginal='" + cadena + "' where id=" + f.getId();
            System.out.println("actualizar sello " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            con.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                JOptionPane.showMessageDialog(null, "actualizar fac -" + ex);
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    /**
     *
     * @param con
     * @param f
     * @return
     */
    public boolean actualizapago(Connection con, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql;
            String cert = f.getCertificado();
            String sello = f.getSello();
            String cadena = f.getCadenaorig();
            sql = "update doctospago set nodeseriecertificado='" + cert + "', sello='" + sello + "', cadenaoriginal='" + cadena + "' where id=" + f.getId();
            System.out.println("actualizar pago sello " + sql);
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

    /**
     *
     * @param con: conexion a cpt o rcpt
     * @param s Clase sellofiscal
     * @param id
     * @return
     * @see Actualiza los datos faltantes de la factura que son los datos
     * fiscales de la factura
     */
    public boolean actualizasellos(Connection con, Sellofiscal s, int id) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update documentos set sellosat='" + s.getSellosat() + "',nodeseriecertificado='"
                    + s.getNoceertificado() + "', sellocfdi='" + s.getSellocfd() + "', fechacertificacion='"
                    + s.getFechacer() + "', foliofiscal='" + s.getUuid() + "' where id=" + id;
            System.out.println(sql);
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

    /**
     *
     * @param con
     * @param s
     * @param id
     * @return
     */
    public boolean actualizasellospago(Connection con, Sellofiscal s, int id) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            con.setAutoCommit(false);
            String sql = "update doctospago set sellosat='" + s.getSellosat() + "',nodeseriecertificado='"
                    + s.getNoceertificado() + "', sellocfdi='" + s.getSellocfd() + "', fechacertificacion='"
                    + s.getFechacer() + "', foliofiscal='" + s.getUuid() + "' where id=" + id;
            System.out.println(sql);
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

    public int getmaxfac(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select max(folio) as folio from documentos where serie='fac'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     *
     * @param con
     * @param serie
     * @return folio de seriesfolios
     */
    public int getmaxfac(Connection con, String serie) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select ultimofolio from seriesfolios where serie='" + serie + "'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("ultimofolio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxncr(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select max(folio) as folio from documentos where serie='ncr'");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("folio") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public int getmaxpago(Connection con) {//max folio de documentos
        int resp = 0;
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+20 ),0,20) as fechav from doctospago group by fecha order by id desc");
            rs = st.executeQuery();
            while (rs.next()) {
                resp = rs.getInt("id") + 1;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    public ArrayList<ConceptosES> getcuentas(Connection con, String cuenta) {//max folio de documentos
        ArrayList<ConceptosES> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            st = con.prepareStatement("select * from catcuentas where cuenta=" + cuenta);
            rs = st.executeQuery();
            while (rs.next()) {
                ConceptosES c = new ConceptosES();
                c.setCuenta(rs.getString("Cuenta"));
                c.setSubcuenta(rs.getString("subcuenta"));
                c.setNombre(rs.getString("Descripcion"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<cargo> getfoliotoNCR(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct cuenta, subcuenta,c.referencia,c.fecha,importe,\n"
                    + "saldo,cli.nombre40,convert(date,fechavencimiento) as fechav,sim,c.plazo, c.numcliente,\n"
                    + " SUBSTRING(c.referencia,0,len(c.referencia)-1) as ref, d.FolioFiscal,c.cveagente,d.RFC,d.calle,d.Colonia,\n"
                    + "d.Municipio,d.Estado,d.Pais,d.cp,cli.fax from cargos c\n"
                    + "join clientes cli on c.numcliente=cli.numcliente\n"
                    + "join " + bd + ".dbo.Documentos d on SUBSTRING(c.referencia,0,len(c.referencia)-1) =d.folio\n"
                    + "where (c.numcliente like '%" + nombre + "%' or cli.nombre like '%" + nombre + "%') and c.referencia NOT Like '%NCR%'"
                    + " and saldo!=0 and d.Serie='fac' and estatus='1' order by c.fecha";
            st = con.prepareStatement(sql);
            System.out.println("sql cargos" + sql);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                cargo c = new cargo();
                c.setCuenta(rs.getInt("cuenta"));
                c.setSubcuenta(rs.getInt("subcuenta"));
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(rs.getString("fecha"));
                c.setImporte(rs.getDouble("importe"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setSim(rs.getDouble("sim"));
                c.setNombre(rs.getString("nombre40"));
                c.setCliente(rs.getInt("numcliente"));
                c.setFechav(rs.getString("fechav"));
                c.setPlazo(rs.getInt("plazo"));
                c.setRef(rs.getString("ref"));
                c.setFoliofiscal(rs.getString("foliofiscal"));
                c.setAgente(rs.getInt("cveagente"));
                c.setRfc(rs.getString("rfc"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setMunicipio(rs.getString("municipio"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setRenglon(i);
                arr.add(c);
                i++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con conexion cpt
     * @param nombre Nombre o id del cliente
     * @param bd Nombre de la bd a cobranza
     * @return Arraylist de la clase cargo
     */
    public ArrayList<cargo> getfoliotoFACRel(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<cargo> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct d.folio,c.referencia,convert(date,d.fecha) as fecha,d.nombre, saldo, d.total, isnull(d.foliofiscal,'') as foliofiscal\n"
                    + " from documentos d\n"
                    + "join " + bd + ".dbo.Cargos c on SUBSTRING(c.Referencia,0,LEN(c.Referencia)-1)=convert(varchar,d.folio)\n"
                    + "where idcliente=" + nombre + " and d.serie='fac' and d.estatus='1' and isnull(d.foliofiscal,'')!=''\n"
                    + "order by d.fecha desc";
            st = con.prepareStatement(sql);
            System.out.println("sql cargos fac " + sql);
            rs = st.executeQuery();
            int i = 0;
            while (rs.next()) {
                cargo c = new cargo();
                c.setReferencia(rs.getString("referencia"));
                c.setFecha(rs.getString("fecha"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setNombre(rs.getString("nombre"));
                c.setFoliofiscal(rs.getString("foliofiscal"));
                c.setImporte(rs.getDouble("total"));
                c.setRenglon(i);
                arr.add(c);
                i++;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<abono> getOrdenesp(Connection con, String nombre, String bd, int cuenta) {//cargos para ncr solo cobranza
        ArrayList<abono> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct a.referencia as op,a.totalpago,referenciac,c.numcliente,c.Nombre40, \n"
                    + "SUBSTRING(referenciac,0,len(a.referenciac)-1) as ref, d.FolioFiscal, \n"
                    + "c.rfc,c.CP,c.fax,c.calle,c.colonia,ci.Descripcion as ciudad, \n"
                    + "e.descripcion as estado,p.Descripcion as pais, car.Saldo, \n"
                    + " a.Pago, car.Saldo+a.Pago as anterior, a.cuenta,a.subcuenta,a.parcialidad\n"
                    + "from " + bd + ".dbo.abonos a\n"
                    + "join " + bd + ".dbo.clientes c on a.NumClienteC=c.NumCliente\n"
                    + "join " + bd + ".dbo.Ciudades ci on c.CveCiudad=ci.CveCiudad\n"
                    + "join " + bd + ".dbo.Estados e on ci.CveEstado=e.CveEstado\n"
                    + "join " + bd + ".dbo.Paises p on e.CvePais=p.CvePais\n"
                    + "join Documentos d on SUBSTRING(referenciac,0,len(a.referenciac)-1)=d.folio \n"
                    + "join " + bd + ".dbo.Cargos car on a.referenciac=car.referencia\n"
                    + "where a.referencia like '%" + nombre + "%' and d.serie='FAC' and a.subcuenta=" + cuenta + "\n"
                    + "order by a.referencia";
            System.out.println("sql get abonos" + sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                abono a = new abono();
                Cliente c = new Cliente();
                double ar = rs.getDouble("saldo") + rs.getDouble("pago");
                a.setOrdenpago(rs.getString("op"));
                a.setReferencia(rs.getString("referenciac"));
                a.setRef(rs.getString("ref"));
                a.setFolio(rs.getString("foliofiscal"));
                a.setTotalpago(rs.getDouble("totalpago"));
                a.setTotal(rs.getDouble("totalpago"));
                a.setSaldo(rs.getDouble("saldo"));
                a.setPago(rs.getDouble("Pago"));
                a.setAnterior(ar);
                a.setCuenta(rs.getInt("cuenta"));
                a.setSubcuenta(rs.getInt("subcuenta"));
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre40"));
                c.setRfc(rs.getString("rfc"));
                c.setCp(rs.getString("cp"));
                c.setRegimen(rs.getString("fax"));
                c.setCalle(rs.getString("calle"));
                c.setColonia(rs.getString("colonia"));
                c.setCiudad(rs.getString("ciudad"));
                c.setEstado(rs.getString("estado"));
                c.setPais(rs.getString("pais"));
                a.setParcialidad(rs.getInt("parcialidad"));
                a.setC(c);
                arr.add(a);
            }

            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    /**
     *
     * @param con
     * @param ncliente
     * @return
     */
    public ArrayList<Cliente> getClientesfacs(Connection con, String ncliente) {//cobranza
        ArrayList<Cliente> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select top(15) isnull(Nombre40,'') as nombre, numcliente,c.RFC,c.CP,c.fax,"
                    + "c.calle,c.colonia,ci.Descripcion as ciudad,e.descripcion as estado,"
                    + "p.Descripcion as pais,ISNULL(c.CveMetodoPago,'') as mpago,ISNULL(paginaweb,'') as uso, plazo, agente1, ag.CveCanal\n"
                    + "from Clientes c\n"
                    + "join Ciudades ci on c.CveCiudad=ci.CveCiudad\n"
                    + "join Estados e on ci.CveEstado=e.CveEstado \n"
                    + "join Paises p on e.CvePais=p.CvePais\n"
                    + "join agentes ag on c.Agente1=ag.CveAgente\n"
                    + "where (numcliente like '%" + ncliente + "%' or Nombre40 like '%" + ncliente + "%') and isnull(nombre40,'')!=''\n"
                    + "group by nombre40,numcliente, c.RFC,c.CP,c.fax,c.calle,c.colonia,ci.Descripcion,e.descripcion,p.Descripcion,c.CveMetodoPago,paginaweb,plazo,agente1,ag.CveCanal\n"
                    + "order by nombre40 desc";
            System.out.println(sql);
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCvecliente(rs.getInt("numcliente"));
                c.setNombre(rs.getString("nombre"));
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
                c.setFormapago(rs.getString("mpago"));
                c.setUsocfdi(rs.getString("uso"));
                c.setClave(rs.getString("CveCanal"));
                arr.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean cancelafac(Connection cpt, Connection rcpt, Connection cob, factura f) {//Rcpt y cpt
        PreparedStatement st = null;
        try {
            cpt.setAutoCommit(false);
            rcpt.setAutoCommit(false);
            cob.setAutoCommit(false);
            String sql = "update documentos set estatus='0', fechacancel='" + f.getFechacancel() + "' where folio=" + f.getFolio();
            System.out.println("cancela doc " + sql);
            st = cpt.prepareStatement(sql);
            st.executeUpdate();
            st = rcpt.prepareStatement(sql);
            st.executeUpdate();
            sql = "update cargos set saldo=0 where SUBSTRING(referencia,0,len(referencia)-1)='" + f.getFolio() + "'";
            System.out.println("cancela cargo " + sql);
            st = cob.prepareStatement(sql);
            st.executeUpdate();
            cpt.commit();
            rcpt.commit();
            cob.commit();
//            con.rollback();
            return true;
        } catch (Exception ex) {
            try {
                cpt.rollback();
                rcpt.rollback();
                cob.rollback();
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Procesoserie.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    // solo por que al principio no se especifico esta parte
    public ArrayList<Poliza> getpolizas(Connection con, String cob) {//ult kardex folio
        ArrayList<Poliza> arr = new ArrayList<>();
        Formateodedatos fd = new Formateodedatos();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct '1' as cuentamov,'5' as subctamov,d.fecha,CONVERT(varchar,folio)+' O' folio,IdCliente,'M' m,"
                    + "subtotal,Impuestos,total,asi.Cuenta, asi.SubCuenta, asi.Concepto, asi.Orden, asi.Acumulativa, ag.CveCanal,ca,c.Agente1\n"
                    + "from Documentos d\n"
                    + "join " + cob + ".dbo.Clientes c on d.IdCliente=c.NumCliente\n"
                    + "join " + cob + ".dbo.Agentes ag on ag.CveAgente=c.Agente1\n"
                    + "join " + cob + ".dbo.AsientosContables asi on asi.Asiento='1'\n"
                    + "join " + cob + ".dbo.cargos a on SUBSTRING(a.referencia,0,len(a.referencia)-1)=convert(varchar,d.Folio)\n"
                    + "where d.estatus=1 and year(d.fecha)=2023\n"
                    + "order by d.folio desc";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            int conta = 0;
            while (rs.next()) {
                String c = rs.getString("Cuenta");
                String cuenta = fd.convertcliente(c + rs.getString("idcliente"));
                Poliza p = new Poliza();
                p.setCuenta(1);
                p.setSub(5);
                p.setFecha(fd.ffecha(rs.getString("fecha")));
                p.setFolio(rs.getString("folio"));
                p.setIdcliente(rs.getInt("idcliente"));
                p.setIdentificacion("M");
                p.setCuentalarga(cuenta);
                p.setCa(rs.getInt("ca"));
                p.setOrden(rs.getInt("orden"));
                p.setDiario("000");
                p.setMext("0.00");
                p.setAcumulativo(rs.getString("acumulativa"));
                p.setConcepto(rs.getString("concepto") + " " + rs.getString("folio"));
                if (rs.getString("cuenta").equals("4005")) {
                    p.setReferencia(rs.getString("cvecanal") + "1" + fd.convierteagente(rs.getString("agente1")) + " 4.001");
                } else {
                    p.setReferencia("4.001");
                }
                switch (conta) {
                    case 0:
                        p.setImporte(fd.ftotal(rs.getString("total")));
                        conta++;
                        break;
                    case 1:
                        p.setImporte(fd.ftotal(rs.getString("impuestos")));
                        conta++;
                        break;
                    case 2:
                        p.setImporte(fd.ftotal(rs.getString("subtotal")));
                        conta = 0;
                        break;
                }
                arr.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public void setpoliza(Connection cob, ArrayList<Poliza> arr) {
        try {
            PreparedStatement st = null;
            cob.setAutoCommit(false);
            for (int i = 0; i < arr.size(); i++) {
                int cuenta = arr.get(i).getCuenta();
                int sub = arr.get(i).getSub();
                String fecha = arr.get(i).getFecha();
                int cliente = arr.get(i).getIdcliente();
                String ident = arr.get(i).getIdentificacion();
                String cuental = arr.get(i).getCuentalarga();
                int t = arr.get(i).getCa();
                String imp = arr.get(i).getImporte();
                String concep = arr.get(i).getConcepto();
                String Acum = arr.get(i).getAcumulativo();
                String ref = arr.get(i).getReferencia();
                String fol = arr.get(i).getFolio();
                String mext = arr.get(i).getMext();
                int ord = arr.get(i).getOrden();
                String sql = "insert into dpolizas values(" + cuenta + "," + sub + ",'" + fecha + "','" + fol + "',"
                        + cliente + ",'" + ident + "','" + cuental + "','" + ref + "','" + t + "','" + imp + "','" + arr.get(i).getDiario() + "','" + mext + "','" + concep + "'," + ord + ",'" + Acum + "')";
                System.out.println(sql);
                st = cob.prepareStatement(sql);
                st.executeUpdate();
            }
            cob.commit();
        } catch (SQLException ex) {
            try {
                cob.rollback();
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Obtener los asientos contables
     *
     * @param concob Conexion de cobranza
     * @return La lista de los asientos contalbles
     */
    public ArrayList<Poliza> getAsientoscontables(Connection concob) {
        ArrayList<Poliza> arr = new ArrayList<>();
        try {
            PreparedStatement st = null;
            ResultSet rs = null;
            String sql = "select * from asientoscontables";
            st = concob.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Poliza p = new Poliza();
                p.setCuentalarga(rs.getString("cuenta"));
//                p.setSub(rs.getInt("subcuenta"));
                p.setConcepto(rs.getString("concepto"));
                p.setCa(rs.getInt("ca"));
                p.setImporte(rs.getString("importe"));
                p.setOrden(rs.getInt("Orden"));
                p.setAcumulativo(rs.getString("Acumulativa"));
                arr.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sqlfactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    //metodos externos
}
