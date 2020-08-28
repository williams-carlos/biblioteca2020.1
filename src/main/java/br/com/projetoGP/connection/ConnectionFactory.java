package br.com.projetoGP.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/mydb2?autoReconnect=true&useSSL=false", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: "+e);
        }
    }

}
