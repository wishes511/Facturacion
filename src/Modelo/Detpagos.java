/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GATEWAY1-
 */
public class Detpagos implements java.io.Serializable{

    int id, iddocumento, parcialidad;
    float cantidad, precio, monto, importesaldoant, importepagado, impsaldoinsoluto;
    String Descripcion, codigo, umedida, formadedpago, monedapago, rfcctaemisora, ctaemisora,
            rfcctareceptora, ctareceptora, uuid, folio, moneda, metodopago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(int iddocumento) {
        this.iddocumento = iddocumento;
    }

    public int getParcialidad() {
        return parcialidad;
    }

    public void setParcialidad(int parcialidad) {
        this.parcialidad = parcialidad;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getImportesaldoant() {
        return importesaldoant;
    }

    public void setImportesaldoant(float importesaldoant) {
        this.importesaldoant = importesaldoant;
    }

    public float getImportepagado() {
        return importepagado;
    }

    public void setImportepagado(float importepagado) {
        this.importepagado = importepagado;
    }

    public float getImpsaldoinsoluto() {
        return impsaldoinsoluto;
    }

    public void setImpsaldoinsoluto(float impsaldoinsoluto) {
        this.impsaldoinsoluto = impsaldoinsoluto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public String getFormadedpago() {
        return formadedpago;
    }

    public void setFormadedpago(String formadedpago) {
        this.formadedpago = formadedpago;
    }

    public String getMonedapago() {
        return monedapago;
    }

    public void setMonedapago(String monedapago) {
        this.monedapago = monedapago;
    }

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

    public String getRfcctareceptora() {
        return rfcctareceptora;
    }

    public void setRfcctareceptora(String rfcctareceptora) {
        this.rfcctareceptora = rfcctareceptora;
    }

    public String getCtareceptora() {
        return ctareceptora;
    }

    public void setCtareceptora(String ctareceptora) {
        this.ctareceptora = ctareceptora;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }
}
