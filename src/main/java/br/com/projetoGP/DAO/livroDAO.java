package br.com.projetoGP.DAO;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.projetoGP.connection.ConnectionFactory;
import br.com.projetoGP.model.livro;

public class livroDAO {
	
	private Connection connection;
	
	public livroDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public int cadastrarLivro(livro livro) throws SQLException {
		
		String sql = "insert into obra (titulo, ano_publicacao, tipo_obra, `codigo_editora(FK)`, isbn ) values (?,?,?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, livro.getTitulo());
		stmt.setDate(2, (Date) livro.getAno_publicacao());
		stmt.setString(3, livro.getTipo_obra());
		stmt.setInt(4, livro.getCodigo_editora());
		stmt.setLong(5, livro.getIsbn());
		
		
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
	}
	
	public List<livro> mostrarLivros() throws SQLException{
		
		List<livro> lista = new ArrayList<livro>();
		
		String sql = "select * from obra";
		
		
		
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
