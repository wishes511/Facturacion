/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;

/**
 *
 * @author Michel Araujo 2022
 */
public class Conexiones {
    Connection cpt, rcpt, cobranza;
    String empresa, empresacob, empresarcpt;

    public String getEmpresarcpt() {
        return empresarcpt;
    }

    public void setEmpresarcpt(String empresarcpt) {
        this.empresarcpt = empresarcpt;
    }

    public String getEmpresacob() {
        return empresacob;
    }

    public void setEmpresacob(String empresacob) {
        this.empresacob = empresacob;
    }

    public Connection getCpt() {
        return cpt;
    }

    public void setCpt(Connection cpt) {
        this.cpt = cpt;
    }

    public Connection getRcpt() {
        return rcpt;
    }

    public void setRcpt(Connection rcpt) {
        this.rcpt = rcpt;
    }

    public Connection getCobranza() {
        return cobranza;
    }

    public void setCobranza(Connection cobranza) {
        this.cobranza = cobranza;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
