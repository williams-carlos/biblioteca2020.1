package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.autor;
import br.com.projetoGP.model.editora;

public class editoraDAO {
	
	
private Connection connection;
	
	public editoraDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
public int cadastrarEditorar(editora editora) throws SQLException {
		
		String sql = "insert into editora (nome_editora, cidade) values (?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1,editora.getNome_editora());
		stmt.setNString(2, editora.getCidade());
	
		
		
		stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
		
		
		
	
		
		
	

	}

}
