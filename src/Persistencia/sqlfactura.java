/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cliente;
import Modelo.ConceptosES;
import Modelo.Dfactura;
import Modelo.Kardexrcpt;
import Modelo.Producto;
import Modelo.Seriecpt;
import Modelo.abono;
import Modelo.cargo;
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

    public int insertfactura(Connection con, factura f, Connection cobranza) {//Rcpt y cpt
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
            float desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            float subtotal = f.getSubtotal();
            float total = f.getTotal();
            float iva = f.getIva();
            float imp = f.getImpuestos();
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
            float tipoc = f.getTipocambio();
            String fpago = f.getFormapago();
            String mpago = f.getMetodopago();
            String Lugar = f.getLugarexpedicion();
            String uso = f.getUsocfdi();
            int plazo = f.getPlazo();
            String m = fol + " " + f.getMarca();
            int agente = f.getAgente();
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
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
            for (Dfactura arr : f.getArr()) {//Inserta en detallado de documentos
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                float precio = arr.getPrecio();
                float b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                float impo = arr.getImporta();
                float descu = arr.getDescuento();
                sql = "insert into Documentosdetalle(iddocumento,idproducto,cantidad,descripcion,"
                        + "codigo,UMedida,precio,base,impuesto,tasaocuota,tipofactor,importe,descuento) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
                System.out.println("d factura " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
//            // Fin detallado de documento
//            for(Dfactura arr: f.getArr()){
//                 sql = "update Kardex set statusimpresion='I' where folio="+f.getFoliokardex()+" and cuenta>49 and renglon="+arr.getRenglon();
//                System.out.println("kardex " + sql);
//                st = con.prepareStatement(sql);
//                st.executeUpdate();
//            }
//            //Actualizar status del detallado de pedido
//            for(Dfactura arr: f.getArr()){
//                 sql = "update dpedidos set estatus='30' where pedido='"+f.getPedido()+"' and renglon="+arr.getRenglon();
//                System.out.println("dpedidos " + sql);
//                st = con.prepareStatement(sql);
//                st.executeUpdate();
//            }
            con.commit();
            cobranza.commit();
//            con.rollback();
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

    public int insertncr(Connection con, factura f, Connection cobranza) {//Rcpt y cpt
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
            float desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            float subtotal = f.getSubtotal();
            float total = f.getTotal();
            float iva = f.getIva();
            float imp = f.getImpuestos();
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
            float tipoc = f.getTipocambio();
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
            sql = "insert into Cargos(cuenta,subcuenta,referencia,numcliente,fecha,refacturacion,"
                    + "importe,saldo,comision,turno,cveagente,plazo,fechavencimiento,fdepDxc,SIM,Usuario,"
                    + "permiso,nuevoagente,fecharegistro) "
                    + "values(1,5,'" + m + "'," + idcliente + ",'" + fecha + "',''," + total + "," + total + ",0,0," + agente + ","
                    + plazo + ",'" + fechavencimiento + "','" + fechavencimiento + "'," + total + ",'" + usuario + "',1," + agente + ",'" + fecha + "')";
            System.out.println("cargos" + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            //Fin insertar cargos
            for (Dfactura arr : f.getArr()) {//Inserta en detallado de documentos
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                float precio = arr.getPrecio();
                float b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                float impo = arr.getImporta();
                float descu = arr.getDescuento();
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
                float descuento = f.getArrcargo().get(i).getDescuento();
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
                float descuento = f.getArrcargo().get(i).getDescuento();
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
            sql = "insert into NotasCredito values ('" + m + "'," + idcliente + "," + sub + ",'" + fecha + "','" + referenciasfac + "','',0,"
                    + subtotal + "," + imp + "," + total + ",'A','" + usuario + "',1,'" + fecha + "',NULL)";
            System.out.println("Nueva nota enca " + sql);
            st = cobranza.prepareStatement(sql);
            st.executeUpdate();
            for (int i = 0; i < f.getArrcargo().size(); i++) {
                float descuento = f.getArrcargo().get(i).getDescuento();
                int cant = f.getArrcargo().get(i).getCantidad();
                String descnota = f.getArrcargo().get(i).getDescnota();
                sql = "insert into DNCredito values ('" + m + "'," + cant + ",'" + descnota + "'," + descuento + ")";
                System.out.println("Nueva nota detallado " + sql);
                st = cobranza.prepareStatement(sql);
                st.executeUpdate();
            }

//            //Actualizar status del detallado de pedido
//            for(Dfactura arr: f.getArr()){
//                 sql = "update dpedidos set estatus='30' where pedido='"+f.getPedido()+"' and renglon="+arr.getRenglon();
//                System.out.println("dpedidos " + sql);
//                st = con.prepareStatement(sql);
//                st.executeUpdate();
//            }
//            con.commit();
//            cobranza.commit();
            con.rollback();
            cobranza.rollback();
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
    
        public int insertpagos(Connection con, factura f, Connection cobranza) {//Rcpt y cpt
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
            float desc = f.getDescuento();
            String ped = f.getPedido();
            String fechasoli = f.getFecha();
            String cond = f.getCondicion();
            String fechaent = f.getFecha();
            float subtotal = f.getSubtotal();
            float total = f.getTotal();
            float iva = f.getIva();
            float imp = f.getImpuestos();
            String cuentaa = f.getCuentaabono();
            String subc = f.getSubabono();
            String dcuenta = f.getDesccuenta();
            //pagos
            String rfcctaemi=f.getRfcctaemisora();
            String ctaemi= f.getCtaemisora();
            String bcoemi=f.getBancoemisor();
            String rfcctarep=f.getRfcctareceptor();
            String ctarep=f.getCtareceptora();
            String bcorep=f.getBancoreceptor();
            String op=f.getOrdenpago();
            float monto=f.getMonto();
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
            float tipoc = f.getTipocambio();
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
                    + ","+monto+",'"+rfcctaemi+"','"+ctaemi+"','"+rfcctarep+"','"+ctarep+"','"+bcoemi+"','"+bcorep+"','"+op+"')";
            System.out.println("Pago " + sql);
            st = con.prepareStatement(sql);
            st.executeUpdate();
            //Max ultimo documento
            st = con.prepareStatement("select top(1)max(id) as id, SUBSTRING(convert(varchar,fecha+" + plazo + " ),0,20) as fechav from doctospago group by fecha order by id desc");
            rs = st.executeQuery();
            String fechavencimiento = fecha;
            while (rs.next()) {
                resp = rs.getInt("id");
                fechavencimiento = rs.getString("fechav");
            }
            rs.close();
            for (Dfactura arr : f.getArr()) {//Inserta en detallado de documentos
                int doc = resp;
                int prod = arr.getProducto();
                int c = arr.getCantidad();
                String des = arr.getDescripcion();
                String cod = arr.getCodigo();
                String med = arr.getUmedida();
                float precio = arr.getPrecio();
                float b = arr.getBase();
                String impu = arr.getImpuesto();
                String tas = arr.getTasaocuota();
                String tf = arr.getTipofactor();
                float impo = arr.getImporta();
                float descu = arr.getDescuento();
                sql = "insert into doctospagodetalle(iddocumento,cantidad,descripcion,codigo,umedida,precio,formadepago,"
                        + "monedapagop,monto,rfcctaemisora,ctaemisora,rfcctareceptora,ctareceptora,uuid,folio,moneda,"
                        + "metodopago,noparcialidad,importesdoant,importepagado,ImpSaldoInsoluto) "
                        + "values (" + doc + "," + prod + "," + c + ",'" + des + "','" + cod + "','" + med + "'," + precio + "," + b
                        + ",'" + impu + "','" + tas + "','" + tf + "'," + impo + "," + descu + ")";
                System.out.println("d pagos " + sql);
                st = con.prepareStatement(sql);
                st.executeUpdate();
            }
            // Fin detallado de documento

//            //Actualizar status del detallado de pedido
//            for(Dfactura arr: f.getArr()){
//                 sql = "update dpedidos set estatus='30' where pedido='"+f.getPedido()+"' and renglon="+arr.getRenglon();
//                System.out.println("dpedidos " + sql);
//                st = con.prepareStatement(sql);
//                st.executeUpdate();
//            }
//            con.commit();
//            cobranza.commit();
            con.rollback();
            cobranza.rollback();
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
                c.setImporte(rs.getFloat("importe"));
                c.setSaldo(rs.getFloat("saldo"));
                c.setSim(rs.getFloat("sim"));
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

    public ArrayList<abono> getOrdenesp(Connection con, String nombre, String bd) {//cargos para ncr solo cobranza
        ArrayList<abono> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select distinct a.referencia,totalpago,referenciac,c.numcliente,c.Nombre40,\n"
                    + "SUBSTRING(referenciac,0,len(a.referenciac)-1) as ref, d.FolioFiscal, car.Saldo,\n"
                    + " a.Pago, (car.Saldo + a.Pago) as anterior, a.cuenta,a.subcuenta\n"
                    + "from abonos a\n"
                    + "join clientes c on a.NumClienteC=c.NumCliente\n"
                    + "join " + bd + ".dbo.Documentos d on SUBSTRING(referenciac,0,len(a.referenciac)-1)=d.folio \n"
                    + "join Cargos car on a.referenciac=car.referencia\n"
                    + "where a.referencia='" + nombre + "' and d.serie='FAC' and (a.subcuenta=15)\n"
                    + "order by referenciac";
            System.out.println("sql get abonos" + sql);
            st = con.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                abono a = new abono();
                float ar=rs.getFloat("saldo")+rs.getFloat("pago");
                a.setOrdenpago(rs.getString("referencia"));
                a.setReferencia(rs.getString("referenciac"));
                a.setRef(rs.getString("ref"));
                a.setFolio(rs.getString("foliofiscal"));
                a.setNombre(rs.getString("nombre40"));
                a.setTotalpago(rs.getFloat("totalpago"));
                a.setCliente(rs.getInt("numcliente"));
                a.setSaldo(rs.getFloat("saldo"));
                a.setPago(rs.getFloat("Pago"));
                a.setAnterior(rs.getFloat("anterior"));
                a.setCuenta(rs.getInt("cuenta"));
                a.setSubcuenta(rs.getInt("subcuenta"));
                        
                arr.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcolor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
