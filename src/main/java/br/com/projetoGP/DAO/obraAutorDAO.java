package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.obraAssunto;
import br.com.projetoGP.model.obraAutor;

public class obraAutorDAO {
	
private Connection connection;
	
	public obraAutorDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
public void cadastrarObraAssunto(obraAutor oautor) throws SQLException {
		
		String sql = "insert into obra_autor ( codigo_obra , codigo_autor ) values (?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1,oautor.getCodigo_obra() );
		stmt.setInt(2, oautor.getCodigo_autor());
		
		
		stmt.executeUpdate();

	}

}
