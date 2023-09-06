/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        for (int i = 0; i < fecha.length() - 2; i++) {
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
        String respfinal = "";
        int a = 0;
        int cont = 0;
        boolean band = false;
        String decimal = "";
        String entero = "";
        for (int i = 0; i < cant.length(); i++) {
            if (cant.charAt(i) == '.' || band) {
                band = true;
                decimal += cant.charAt(i);
                if (a == 2) {
                    resp = cant;
                    break;
                }
                a++;
            } else {
                entero += cant.charAt(i);
                cont++;
            }

        }
        if (decimal.length() == 2) {
            decimal = decimal + "0";
        }
//        System.out.println(entero+decimal);
        int ncaracter = entero.length() + decimal.length();
        if (band == false) {
            resp = cant + ".00";
        }
        for (int i = 0; i < 16 - ncaracter; i++) {
            respfinal += "0";
        }
        return respfinal + "" + entero + "" + decimal;
    }

    /**
     * Formatea las cantidades a 2 digitos y revisa si se redondea o se trunca.
     * * por revisar mas a fondo
     *
     * @param cant
     * @return
     */
    public double formatdecimal(double cant) {
        int dato = 0;
        int punto = 0;
        boolean band = false;
        double resp;
        String c = String.valueOf(cant);
//        String cadena = "";
        for (int i = 0; i < c.length(); i++) {
//            Empieza a tomar datos despues del punto
            if (c.charAt(i) == '.') {
                band = true;
            }
            if (band) {
//                3 digitos de decimal para saber qe hacer con los decimales
                if (punto == 3) {
                    dato = Integer.parseInt(c.charAt(i) + "");
                    i = c.length();
                    break;
                }
//                cadena += c.charAt(i);
                punto++;
            }
        }
        if ((dato <= 5)) {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.FLOOR).doubleValue();
        } else {
            resp = BigDecimal.valueOf(cant).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return resp;
    }

    public String formatclientedigito(String cliente) {
        String resp = "";
        if (cliente.length() != 4) {
            for (int i = cliente.length(); i < 4; i++) {
                resp += "0";
            }
        }
        resp = resp + cliente;
        System.out.println(resp);
        return resp;
    }

    /**
     * Verifica que en la variable solo haya numero enteros del 0 al 9
     * @param cad
     * @return 
     */
    public boolean verificaint(String cad) {
        boolean resp = false;
        String patt = "[0-9]+";
        Pattern pat = Pattern.compile(patt);
        Matcher match = pat.matcher(cad);
        if (match.matches()) {
            resp = true;
        }
        return resp;
    }

}
