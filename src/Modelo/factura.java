/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class factura implements java.io.Serializable{
    int id, folio, naprobacion, estatus, retenciones, idcliente, totalcajas, cantidadxcaja
            , addenda,enviado, cvecliente, cveagente, parcialidad, parcialidad2,foliokardex,agente,plazo;
    String nombrecliente, ncliente, nombreagente, claveusuario, serie, fecha, fechacancel
            , motivodex, pedido, fechasolicitado, condicion, fechaentrega, nombre, rfc
            , calle, nexterior, ninterior,colonia, localidad, referencia, municipio, estado
            , pais, cp, Dnombre, Datencion, Dcalle, Dexterior, Dinterior, Dcolonia, Dlocalidad
            , Dreferencia, Dmunicipio, Destado, Dpais, Dcp, Observaciones, cadenaorig, sello
            , Tiposerie, Moneda, Fechaenvio, Formapago, Metodopago, Lugarexpedicion,Numctapago
            , foliofiscalorig, seriefoliofiscalorig, fechafoliofiscalorig, regimen, foliofiscal
            , nodeseriecert, fechacert, sellosat, sellocfdi, usocfdi, tiporelacion, descmetodop, empresa, certificado,marca,
            cuentaabono,subabono, desccuenta,refncredito,rfcctaemisora,ctaemisora,rfcctareceptor,
            ctareceptora,bancoemisor,bancoreceptor,ordenpago;
    float Descuento, iva, is, subtotal, impuestos, montoiva, montoisr, total, tipocambio, montofoliofiscalorig,
            baseimpuesto,monto;
    Cliente c;
    ArrayList<Dfactura> arr = new ArrayList<>();
    ArrayList<String> arruuid = new ArrayList<>();
    ArrayList<cargo> arrcargo = new ArrayList<>();
    ArrayList<Detpagos> arrpagos = new ArrayList<>();

    public String getRfcctaemisora() {
        return rfcctaemisora;
    }

    public void setRfcctaemisora(String rfcctaemisora) {
        this.rfcctaemisora = rfcctaemisora;
    }

    public String getCtaemisora() {
        return ctaemisora;
    }

    public void setCtaemisora(String ctaemisora) {
        this.ctaemisora = ctaemisora;
    }

    public String getRfcctareceptor() {
        return rfcctareceptor;
    }

    public void setRfcctareceptor(String rfcctareceptor) {
        this.rfcctareceptor = rfcctareceptor;
    }

    public String getCtareceptora() {
        return ctareceptora;
    }

    public void setCtareceptora(String ctareceptora) {
        this.ctareceptora = ctareceptora;
    }

    public String getBancoemisor() {
        return bancoemisor;
    }

    public void setBancoemisor(String bancoemisor) {
        this.bancoemisor = bancoemisor;
    }

    public String getBancoreceptor() {
        return bancoreceptor;
    }

    public void setBancoreceptor(String bancoreceptor) {
        this.bancoreceptor = bancoreceptor;
    }

    public String getOrdenpago() {
        return ordenpago;
    }

    public void setOrdenpago(String ordenpago) {
        this.ordenpago = ordenpago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getRefncredito() {
        return refncredito;
    }

    public void setRefncredito(String refncredito) {
        this.refncredito = refncredito;
    }

    public String getDesccuenta() {
        return desccuenta;
    }

    public void setDesccuenta(String desccuenta) {
        this.desccuenta = desccuenta;
    }

    public String getCuentaabono() {
        return cuentaabono;
    }

    public void setCuentaabono(String cuentaabono) {
        this.cuentaabono = cuentaabono;
    }

    public String getSubabono() {
        return subabono;
    }

    public void setSubabono(String subabono) {
        this.subabono = subabono;
    }

    public ArrayList<cargo> getArrcargo() {
        return arrcargo;
    }

    public void setArrcargo(ArrayList<cargo> arrcargo) {
        this.arrcargo = arrcargo;
    }
    

    public ArrayList<String> getArruuid() {
        return arruuid;
    }

    public void setArruuid(ArrayList<String> arruuid) {
        this.arruuid = arruuid;
    }

    public int getAgente() {
        return agente;
    }

    public void setAgente(int agente) {
        this.agente = agente;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getFoliokardex() {
        return foliokardex;
    }

    public void setFoliokardex(int foliokardex) {
        this.foliokardex = foliokardex;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public float getBaseimpuesto() {
        return baseimpuesto;
    }

    public void setBaseimpuesto(float baseimpuesto) {
        this.baseimpuesto = baseimpuesto;
    }

    public String getDescmetodop() {
        return descmetodop;
    }

    public void setDescmetodop(String descmetodop) {
        this.descmetodop = descmetodop;
    }

    public ArrayList<Dfactura> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Dfactura> arr) {
        this.arr = arr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getNaprobacion() {
        return naprobacion;
    }

    public void setNaprobacion(int naprobacion) {
        this.naprobacion = naprobacion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(int retenciones) {
        this.retenciones = retenciones;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getTotalcajas() {
        return totalcajas;
    }

    public void setTotalcajas(int totalcajas) {
        this.totalcajas = totalcajas;
    }

    public int getCantidadxcaja() {
        return cantidadxcaja;
    }

    public void setCantidadxcaja(int cantidadxcaja) {
        this.cantidadxcaja = cantidadxcaja;
    }

    public int getAddenda() {
        return addenda;
    }

    public void setAddenda(int addenda) {
        this.addenda = addenda;
    }

    public int getEnviado() {
        return enviado;
    }

    public void setEnviado(int enviado) {
        this.enviado = enviado;
    }

    public int getCvecliente() {
        return cvecliente;
    }

    public void setCvecliente(int cvecliente) {
        this.cvecliente = cvecliente;
    }

    public int getCveagente() {
        return cveagente;
    }

    public void setCveagente(int cveagente) {
        this.cveagente = cveagente;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public int getParcialidad2() {
        return parcialidad2;
    }

    public void setParcialidad2(int parcialidad2) {
        this.parcialidad2 = parcialidad2;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNcliente() {
        return ncliente;
    }

    public void setNcliente(String ncliente) {
        this.ncliente = ncliente;
    }

    public String getNombreagente() {
        return nombreagente;
    }

    public void setNombreagente(String nombreagente) {
        this.nombreagente = nombreagente;
    }

    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechacancel() {
        return fechacancel;
    }

    public void setFechacancel(String fechacancel) {
        this.fechacancel = fechacancel;
    }

    public String getMotivodex() {
        return motivodex;
    }

    public void setMotivodex(String motivodex) {
        this.motivodex = motivodex;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getFechasolicitado() {
        return fechasolicitado;
    }

    public void setFechasolicitado(String fechasolicitado) {
        this.fechasolicitado = fechasolicitado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNexterior() {
        return nexterior;
    }

    public void setNexterior(String nexterior) {
        this.nexterior = nexterior;
    }

    public String getNinterior() {
        return ninterior;
    }

    public void setNinterior(String ninterior) {
        this.ninterior = ninterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDnombre() {
        return Dnombre;
    }

    public void setDnombre(String Dnombre) {
        this.Dnombre = Dnombre;
    }

    public String getDatencion() {
        return Datencion;
    }

    public void setDatencion(String Datencion) {
        this.Datencion = Datencion;
    }

    public String getDcalle() {
        return Dcalle;
    }

    public void setDcalle(String Dcalle) {
        this.Dcalle = Dcalle;
    }

    public String getDexterior() {
        return Dexterior;
    }

    public void setDexterior(String Dexterior) {
        this.Dexterior = Dexterior;
    }

    public String getDinterior() {
        return Dinterior;
    }

    public void setDinterior(String Dinterior) {
        this.Dinterior = Dinterior;
    }

    public String getDcolonia() {
        return Dcolonia;
    }

    public void setDcolonia(String Dcolonia) {
        this.Dcolonia = Dcolonia;
    }

    public String getDlocalidad() {
        return Dlocalidad;
    }

    public void setDlocalidad(String Dlocalidad) {
        this.Dlocalidad = Dlocalidad;
    }

    public String getDreferencia() {
        return Dreferencia;
    }

    public void setDreferencia(String Dreferencia) {
        this.Dreferencia = Dreferencia;
    }

    public String getDmunicipio() {
        return Dmunicipio;
    }

    public void setDmunicipio(String Dmunicipio) {
        this.Dmunicipio = Dmunicipio;
    }

    public String getDestado() {
        return Destado;
    }

    public void setDestado(String Destado) {
        this.Destado = Destado;
    }

    public String getDpais() {
        return Dpais;
    }

    public void setDpais(String Dpais) {
        this.Dpais = Dpais;
    }

    public String getDcp() {
        return Dcp;
    }

    public void setDcp(String Dcp) {
        this.Dcp = Dcp;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getCadenaorig() {
        return cadenaorig;
    }

    public void setCadenaorig(String cadenaorig) {
        this.cadenaorig = cadenaorig;
    }

    public String getSello() {
        return sello;
    }

    public void setSello(String sello) {
        this.sello = sello;
    }

    public String getTiposerie() {
        return Tiposerie;
    }

    public void setTiposerie(String Tiposerie) {
        this.Tiposerie = Tiposerie;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public String getFechaenvio() {
        return Fechaenvio;
    }

    public void setFechaenvio(String Fechaenvio) {
        this.Fechaenvio = Fechaenvio;
    }

    public String getFormapago() {
        return Formapago;
    }

    public void setFormapago(String Formapago) {
        this.Formapago = Formapago;
    }

    public String getMetodopago() {
        return Metodopago;
    }

    public void setMetodopago(String Metodopago) {
        this.Metodopago = Metodopago;
    }

    public String getLugarexpedicion() {
        return Lugarexpedicion;
    }

    public void setLugarexpedicion(String Lugarexpedicion) {
        this.Lugarexpedicion = Lugarexpedicion;
    }

    public String getNumctapago() {
        return Numctapago;
    }

    public void setNumctapago(String Numctapago) {
        this.Numctapago = Numctapago;
    }

    public String getFoliofiscalorig() {
        return foliofiscalorig;
    }

    public void setFoliofiscalorig(String foliofiscalorig) {
        this.foliofiscalorig = foliofiscalorig;
    }

    public String getSeriefoliofiscalorig() {
        return seriefoliofiscalorig;
    }

    public void setSeriefoliofiscalorig(String seriefoliofiscalorig) {
        this.seriefoliofiscalorig = seriefoliofiscalorig;
    }

    public String getFechafoliofiscalorig() {
        return fechafoliofiscalorig;
    }

    public void setFechafoliofiscalorig(String fechafoliofiscalorig) {
        this.fechafoliofiscalorig = fechafoliofiscalorig;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getFoliofiscal() {
        return foliofiscal;
    }

    public void setFoliofiscal(String foliofiscal) {
        this.foliofiscal = foliofiscal;
    }

    public String getNodeseriecert() {
        return nodeseriecert;
    }

    public void setNodeseriecert(String nodeseriecert) {
        this.nodeseriecert = nodeseriecert;
    }

    public String getFechacert() {
        return fechacert;
    }

    public void setFechacert(String fechacert) {
        this.fechacert = fechacert;
    }

    public String getSellosat() {
        return sellosat;
    }

    public void setSellosat(String sellosat) {
        this.sellosat = sellosat;
    }

    public String getSellocfdi() {
        return sellocfdi;
    }

    public void setSellocfdi(String sellocfdi) {
        this.sellocfdi = sellocfdi;
    }

    public String getUsocfdi() {
        return usocfdi;
    }

    public void setUsocfdi(String usocfdi) {
        this.usocfdi = usocfdi;
    }

    public String getTiporelacion() {
        return tiporelacion;
    }

    public void setTiporelacion(String tiporelacion) {
        this.tiporelacion = tiporelacion;
    }

    public float getDescuento() {
        return Descuento;
    }

    public void setDescuento(float Descuento) {
        this.Descuento = Descuento;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getIs() {
        return is;
    }

    public void setIs(float is) {
        this.is = is;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public float getMontoiva() {
        return montoiva;
    }

    public void setMontoiva(float montoiva) {
        this.montoiva = montoiva;
    }

    public float getMontoisr() {
        return montoisr;
    }

    public void setMontoisr(float montoisr) {
        this.montoisr = montoisr;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTipocambio() {
        return tipocambio;
    }

    public void setTipocambio(float tipocambio) {
        this.tipocambio = tipocambio;
    }

    public float getMontofoliofiscalorig() {
        return montofoliofiscalorig;
    }

    public void setMontofoliofiscalorig(float montofoliofiscalorig) {
        this.montofoliofiscalorig = montofoliofiscalorig;
    }
    
    
}
