package br.com.projetoGP.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
            		//"jdbc:mysql://localhost:3306/bibliotecaWeb", "root", "SUA-SENHA" );
          	"jdbc:mysql://node53905-biblioteca.jelastic.saveincloud.net/mydb2", "root","KOBrtv14318" );  
            		
    // "jdbc:mysql://node53829-env-5354341.jelastic.saveincloud.net/mydb","root","DTRaid38834");
     //   "jdbc:mysql://localhost/mydb2?autoReconnect=true&useSSL=false", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException("ERROR: "+e);
        }
    }

}
