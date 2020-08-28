package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoGP.connection.ConnectionFactory;

public class funcionarioDAO {
	
private Connection connection;
	
	public funcionarioDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public boolean existeFuncionario(String login, String senha) throws SQLException {
		
		String sql = "select * from funcionario where login= ? and senha= ?";
		
		
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 return true;
		 }
		
        
		
		
		
		
		
		return false;
		
		
	}

}
