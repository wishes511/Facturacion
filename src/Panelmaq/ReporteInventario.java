/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panelmaq;

import Modelo.Conexiones;
import Modelo.Usuarios;
import Paneles.fac1;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GATEWAY1-
 */
public class ReporteInventario {

    private Conexiones u;

    public void setreport() {
        try {
            Map parametros = new HashMap();
//            Agregar parametros al reporte
            JasperReport jasper = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportesmaq/Indexinv.jasper"));
            JasperPrint print = JasperFillManager.fillReport(jasper, parametros, u.getCpttpu());
            JasperViewer ver = new JasperViewer(print, false); //despliegue de reporte
            ver.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ver.setTitle("Saldos vencidos");
            ver.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(fac1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setvars(Conexiones u) {
        this.u = u;
    }
}
