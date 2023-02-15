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
public class Formateodedatos {

    /**
     * Formateo de fechas al tomarla de la bd
     *
     * @param fecha
     * @return
     */
    public String ffecha(String fecha) {
        String resp = "";
        for (int i = 0; i < fecha.length()-2; i++) {
            if (fecha.charAt(i) == ' ') {
                resp += "T";
            } else {
                resp += fecha.charAt(i) + "";
            }
        }
        return resp;
    }

    /**
     * formateo de cadena del cliente para poliza
     *
     * @param cliente
     * @return
     */
    public String convertcliente(String cliente) {
        String resp = cliente;
        for (int i = 0; i < 14 - cliente.length(); i++) {
            resp += "0";
        }
//        System.out.println(resp);
        return resp;
    }

    /**
     * formateo de cadena de agente
     *
     * @param agente
     * @return
     */
    public String convierteagente(String agente) {
        String resp;
        if (agente.length() == 2) {
            resp = agente;
        } else {
            resp = "0" + agente;
        }

        return resp;
    }

    /**
     * Totales para poliza
     *
     * @param cant
     * @return
     */
    public String ftotal(String cant) {
        String resp = "";
        String respfinal="";
        int a = 0;
        int cont=0;
        boolean band=false;
        String decimal="";
        String entero="";
        for (int i = 0; i < cant.length(); i++) {
            if (cant.charAt(i) == '.' || band) {
                band=true;
                decimal+=cant.charAt(i);
                if (a == 2) {
                    resp = cant;
                    break;
                }
                a++;
            } else {
                entero+=cant.charAt(i);
                cont++;
            }
            
        }
        if(decimal.length()==2){
            decimal=decimal+"0";
        }
//        System.out.println(entero+decimal);
        int ncaracter=entero.length()+decimal.length();
        if(band==false){
             resp = cant + ".00";
        }
        for (int i=0;i<16-ncaracter;i++) {
            respfinal+="0";
        }
        return respfinal+""+entero+""+decimal;
    }
}
