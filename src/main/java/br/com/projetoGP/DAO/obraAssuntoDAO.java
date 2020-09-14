package br.com.projetoGP.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.assunto;
import br.com.projetoGP.model.obraAssunto;

public class obraAssuntoDAO {
	
private Connection connection;
	
	public obraAssuntoDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
public void cadastrarObraAssunto(obraAssunto oassunto) throws SQLException {
		
		String sql = "insert into obra_assunto ( codigo_obra , codigo_assunto ) values (?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1,oassunto.getCodigoObra() );
		stmt.setInt(2, oassunto.getCodigoAssunto());
		
		
		stmt.executeUpdate();

	}

}
