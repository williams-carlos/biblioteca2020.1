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
		
		String sql = "insert into obra (titulo, ano_publicacao, tipo_obra, `codigo_editora(FK)`, isbn, visibilidade ) values (?,?,?,?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, livro.getTitulo());
		stmt.setDate(2, (Date) livro.getAno_publicacao());
		stmt.setString(3, livro.getTipo_obra());
		stmt.setInt(4, livro.getCodigo_editora());
		stmt.setLong(5, livro.getIsbn());
		stmt.setBoolean(6, true);
		
		
		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
	}
	
	public List<livro> mostrarLivros() throws SQLException{
		
		List<livro> lista = new ArrayList<livro>();
		
		String sql = "SELECT * FROM obra o, autor a, obra_autor oa WHERE o.codigo_obra = oa.codigo_obra AND "  + 
							                                                      "oa.codigo_autor = a.idAutor";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 Integer cod = rs.getInt("codigo_obra");
			 String titulo = rs.getString("titulo");
			 long isbn	= rs.getLong("isbn");
			 Date ano_publicacao = rs.getDate("ano_publicacao");
			 String tipo_obra = rs.getString("tipo_obra");
			 Boolean visibilidade = rs.getBoolean("visibilidade");
			 String nome_autor = rs.getString("nome_autor");
			 if(visibilidade) {
			 
			 livro l = new livro();
	
			 l.setCodigo(cod);
			 l.setTitulo(titulo);
			 l.setIsbn(isbn);
			 l.setAno_publicacao(ano_publicacao);
			 l.setTipo_obra(tipo_obra);
			 l.getAutor().setNome_autor(nome_autor);
			 lista.add(l);
			 
		 }}
		
		return lista;
		
	}

	
	public void removerLivro(int codigo) throws SQLException {
		
		String sql = "update obra set visibilidade = ? where codigo_obra = ?";
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setBoolean(1, false);
		stmt.setInt(2, codigo);
		
		stmt.executeUpdate();
		
		
		
	}
	
public List<livro> buscarIsbn(long isbnl) throws SQLException{
		
		List<livro> lista = new ArrayList<livro>();
		
		String sql = "SELECT * FROM obra o, autor a, obra_autor oa WHERE o.codigo_obra = oa.codigo_obra AND " + 
							                                              "oa.codigo_autor = a.idAutor AND isbn like ?";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, isbnl+"%");
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 Integer cod = rs.getInt("codigo_obra");
			 String titulo = rs.getString("titulo");
			 long isbn	= rs.getLong("isbn");
			 Date ano_publicacao = rs.getDate("ano_publicacao");
			 String tipo_obra = rs.getString("tipo_obra");
			 Boolean visibilidade = rs.getBoolean("visibilidade");
			 String nome_autor = rs.getString("nome_autor");
			 if(visibilidade) {
			 
			 livro l = new livro();
	
			 l.setCodigo(cod);
			 l.setTitulo(titulo);
			 l.setIsbn(isbn);
			 l.setAno_publicacao(ano_publicacao);
			 l.setTipo_obra(tipo_obra);
			 l.getAutor().setNome_autor(nome_autor);
			 lista.add(l);
			 
		 }}
		
		return lista;
		
	}


public List<livro> buscarAutor(String autor) throws SQLException {
	List<livro> lista = new ArrayList<livro>();
	
	String sql = "SELECT * FROM obra o, autor a, obra_autor oa WHERE o.codigo_obra = oa.codigo_obra AND " + 
			                                                        "oa.codigo_autor = a.idAutor AND "
			                                                     +  "a.nome_autor  like ?";
	
	
	
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setString(1, "%"+autor+"%");
	
	 ResultSet rs = stmt.executeQuery();
	 
	 while (rs.next()) {
		 Integer cod = rs.getInt("codigo_obra");
		 String titulo = rs.getString("titulo");
		 long isbn	= rs.getLong("isbn");
		 Date ano_publicacao = rs.getDate("ano_publicacao");
		 String tipo_obra = rs.getString("tipo_obra");
		 Boolean visibilidade = rs.getBoolean("visibilidade");
		 String nome_autor = rs.getString("nome_autor");
		 
		 if(visibilidade) {
		 
		 livro l = new livro();

		 l.setCodigo(cod);
		 l.setTitulo(titulo);
		 l.setIsbn(isbn);
		 l.setAno_publicacao(ano_publicacao);
		 l.setTipo_obra(tipo_obra);
		 l.getAutor().setNome_autor(nome_autor);
		 lista.add(l);
		 
	 }}
	
	return lista;
	
}
public List<livro> buscarTitulo(String tituloB) throws SQLException {
	List<livro> lista = new ArrayList<livro>();
	
	String sql = "SELECT * FROM obra o, autor a, obra_autor oa WHERE o.codigo_obra = oa.codigo_obra AND " + 
						                                                 "oa.codigo_autor = a.idAutor AND titulo like ?";
	
	
	
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setString(1, "%"+tituloB+"%");
	
	 ResultSet rs = stmt.executeQuery();
	 
	 while (rs.next()) {
		 Integer cod = rs.getInt("codigo_obra");
		 String titulo = rs.getString("titulo");
		 long isbn	= rs.getLong("isbn");
		 Date ano_publicacao = rs.getDate("ano_publicacao");
		 String tipo_obra = rs.getString("tipo_obra");
		 Boolean visibilidade = rs.getBoolean("visibilidade");
		 String nome_autor = rs.getString("nome_autor");
		 if(visibilidade) {
		 
		 livro l = new livro();

		 l.setCodigo(cod);
		 l.setTitulo(titulo);
		 l.setIsbn(isbn);
		 l.setAno_publicacao(ano_publicacao);
		 l.setTipo_obra(tipo_obra);
		 l.getAutor().setNome_autor(nome_autor);
		 lista.add(l);
		 
	 }}
	
	return lista;
	
}
	
}
