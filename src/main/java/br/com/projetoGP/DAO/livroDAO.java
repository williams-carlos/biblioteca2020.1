package br.com.projetoGP.DAO;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.livro;

public class livroDAO {
	
	private Connection connection;
	
	public livroDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void cadastrarLivro(livro livro) throws SQLException {
		
		String sql = "insert into Obra (titulo, ano_publicacao, tipo_obra ) values (?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, livro.getTitulo());
		stmt.setDate(2, (Date) livro.getAno_publicacao());
		stmt.setString(3, livro.getTipo_obra());
		
		
		stmt.executeUpdate();

	}
	
	public List<livro> mostrarLivros() throws SQLException{
		
		List<livro> lista = new ArrayList<livro>();
		
		String sql = "select * from Obra";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 Integer cod = rs.getInt("codigo_obra");
			 String titulo = rs.getString("titulo");
			 Date ano_publicacao = rs.getDate("ano_publicacao");
			 String tipo_obra = rs.getNString("tipo_obra");
			 
			 livro l = new livro();
	
			 l.setCodigo(cod);
			 l.setTitulo(titulo);
			 l.setAno_publicacao(ano_publicacao);
			 l.setTipo_obra(tipo_obra);
			 
			 lista.add(l);
			 
		 }
		
		return lista;
		
	}

}
