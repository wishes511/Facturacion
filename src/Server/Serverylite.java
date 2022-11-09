/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GATEWAY1-
 */
public class Serverylite {

    private Connection connect, connectlite, connectlite2;
    private final String URL = "jdbc:sqlserver://192.168.6.8\\datos65:9205";
    private final String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    FileWriter fichero = null;
    private final String urlite = "C:\\af\\prod\\compras.db";
    private final File f = new File(urlite);
    //url lite cfdi
    FileWriter fichero1 = null;
    private final String urlitecfdi = "C:\\af\\prod\\cfdi.db";
    private final File f1 = new File(urlitecfdi);

    public Connection getconexionS() throws ClassNotFoundException, IOException, SQLException {
        Class.forName(drive);
        connect = DriverManager.getConnection(URL, "sa", "Prok2001");
        System.out.println("Conectado a server");
        return connect;
    }

    public void cerrar() throws SQLException {
        connect.close();
        System.out.println("Cerrar server");
    }

    public Connection getconexionC() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("org.sqlite.JDBC");
        if (!f.exists()) {
            fichero = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fichero);
            fichero.close();
            connectlite = DriverManager.getConnection("jdbc:sqlite:" + urlite);
//            System.out.println("Conectado");
        } else {
            connectlite = DriverManager.getConnection("jdbc:sqlite:" + urlite);
//            System.out.println("Conectado");
        }
        return connectlite;
    }

    public void cerrarlite() throws SQLException {
        connectlite.close();
    }

    public Connection getconexioncfdi() throws ClassNotFoundException, IOException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connectlite2 = DriverManager.getConnection("jdbc:sqlite:" + urlitecfdi);
        System.out.println("Conectado cfdi");
        return connectlite2;
    }

    public void cerrarcfdi() throws SQLException {
        connectlite2.close();
    }
}
