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
public class Agentes {
    int idagente,idzona,idcanal;
    String Nombre,direccion, ciudad,cp, telefono, rfc;

    public int getIdagente() {
        return idagente;
    }

    public void setIdagente(int idagente) {
        this.idagente = idagente;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public int getIdcanal() {
        return idcanal;
    }

    public void setIdcanal(int idcanal) {
        this.idcanal = idcanal;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
