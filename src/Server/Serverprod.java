/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GATEWAY1-
 */
public class Serverprod {

    Connection connect;
    private final String URL = "jdbc:sqlserver://192.168.6.75\\SQLEXPRESS:9205;databaseName=Produccionath";
    String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection getconexionS() throws ClassNotFoundException, IOException, SQLException {
        
        Class.forName(drive);
        connect = DriverManager.getConnection(URL, "mich", "mich");
        System.out.println("Conectado a server");
        return connect;
    }
    public void cerrar() throws SQLException{
        connect.close();
    }
}
