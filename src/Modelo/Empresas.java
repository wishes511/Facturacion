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
public class Empresas implements java.io.Serializable{
    private String nombre, rfc, rsocial, ip, dirimag, dirvideo;

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

    public String getRsocial() {
        return rsocial;
    }

    public void setRsocial(String rsocial) {
        this.rsocial = rsocial;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDirimag() {
        return dirimag;
    }

    public void setDirimag(String dirimag) {
        this.dirimag = dirimag;
    }

    public String getDirvideo() {
        return dirvideo;
    }

    public void setDirvideo(String dirvideo) {
        this.dirvideo = dirvideo;
    }
    
}
