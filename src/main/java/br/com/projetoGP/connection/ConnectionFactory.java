package br.com.projetoGP.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
            //		"jdbc:mysql://node53905-biblioteca.jelastic.saveincloud.net/mydb", "root","KOBrtv14318" ); 
            		
    // "jdbc:mysql://node53829-env-5354341.jelastic.saveincloud.net/mydb","root","DTRaid38834");
        "jdbc:mysql://localhost/testeBD?autoReconnect=true&useSSL=false", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: "+e);
        }
    }

}
