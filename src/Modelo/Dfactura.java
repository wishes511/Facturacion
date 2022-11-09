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
public class Dfactura implements java.io.Serializable{
    int id, idoc, producto,talla,cantidad;
    String descripcion, codigo, umedida, descripcionprov,impuesto, tasaocuota,tipofactor;
    float precio, base,  importa, descuento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdoc() {
        return idoc;
    }

    public void setIdoc(int idoc) {
        this.idoc = idoc;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getDescripcionprov() {
        return descripcionprov;
    }

    public void setDescripcionprov(String descripcionprov) {
        this.descripcionprov = descripcionprov;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getTipofactor() {
        return tipofactor;
    }

    public void setTipofactor(String tipofactor) {
        this.tipofactor = tipofactor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public String getTasaocuota() {
        return tasaocuota;
    }

    public void setTasaocuota(String tasaocuota) {
        this.tasaocuota = tasaocuota;
    }

    public float getImporta() {
        return importa;
    }

    public void setImporta(float importa) {
        this.importa = importa;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
}
