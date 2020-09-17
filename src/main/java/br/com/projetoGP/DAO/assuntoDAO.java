package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.assunto;
import br.com.projetoGP.model.livro;

public class assuntoDAO {
	
	private Connection connection;
	
	public assuntoDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
public int cadastrarAssunto(assunto assunto) throws SQLException {
		
		String sql = "insert into assunto (descricao_assunto) values (?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, assunto.getDescricaoAssunto());
	
		
		
		stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
		
		
		
	
		
		
	

	}

}
