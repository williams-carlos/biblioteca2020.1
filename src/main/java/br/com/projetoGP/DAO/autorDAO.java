package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.assunto;
import br.com.projetoGP.model.autor;

public class autorDAO {

	
private Connection connection;
	
	public autorDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
public int cadastrarAutor(autor autor) throws SQLException {
		
		String sql = "insert into autor (nome_autor) values (?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, autor.getNome_autor() );
	
		
		
		stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
		
		
		
	
		
		
	

	}
}
