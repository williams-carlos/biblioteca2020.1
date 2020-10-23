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
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	
	public int cadastrarLivro(livro livro) throws SQLException {
		
		String sql = "insert into obra (titulo, ano_publicacao, tipo_obra, `codigo_editora(FK)`, isbn, visibilidade ) values (?,?,?,?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, livro.getTitulo());
		stmt.setDate(2, (Date) livro.getAno_publicacao());
		stmt.setString(3, livro.getTipo_obra());
		stmt.setInt(4, livro.getCodigo_editora());
		stmt.setLong(5, livro.getIsbn());
		stmt.setBoolean(6, livro.isVisibilidade());
		
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
		 
		 	}
		 }
	
	return lista;
	
}
public livro editaLivro(int cod_livro) throws SQLException {
	//List<livro> lista = new ArrayList<livro>();
	livro l = new livro();
	String sql ="SELECT DISTINCT o.codigo_obra, o.titulo, o.ano_publicacao, o.tipo_obra, o.isbn, o.visibilidade, a.nome_autor,"+
" ass.descricao_assunto, ed.nome_editora, ed.cidade FROM obra o, autor a, obra_autor oa, assunto ass,"+ 
" obra_assunto oass, editora ed WHERE o.codigo_obra = oa.codigo_obra AND oa.codigo_autor = a.idAutor and"+ 
" o.codigo_obra = oass.codigo_obra and oass.codigo_assunto = ass.codigo_assunto AND" + 
" ed.codigo_editora = (SELECT `codigo_editora(FK)` FROM `obra` where `codigo_obra` = ?) AND"+ 
" o.codigo_obra = ?" ;

	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setInt(1, cod_livro);
	stmt.setInt(2, cod_livro);
	 
	ResultSet rs = stmt.executeQuery();
	 
	 while (rs.next()) {
		 Integer cod = rs.getInt("codigo_obra"); 
		 String titulo = rs.getString("titulo");
		 Date ano_publicacao = rs.getDate("ano_publicacao");
		 String tipo_obra = rs.getString("tipo_obra");
		 long isbn	= rs.getLong("isbn");
		 Boolean visibilidade = rs.getBoolean("visibilidade");
		 String nome_autor = rs.getString("nome_autor");
		 String assunto = rs.getString("descricao_assunto");
		 String editora = rs.getString("nome_editora");
		 String cidade_editora = rs.getNString("cidade");
		 
		 

		 l.setCodigo(cod);
		 l.setTitulo(titulo);
		 l.setIsbn(isbn);
		 l.setAno_publicacao(ano_publicacao);
		 l.setTipo_obra(tipo_obra);
		 l.setVisibilidade(visibilidade);
		 l.getAutor().setNome_autor(nome_autor);
		 l.getAssunto().setDescricaoAssunto(assunto);
		 l.getEditora().setNome_editora(editora);
		 l.getEditora().setCidade(cidade_editora);
		 
	 	}
	
	return l;
	}

	public void upDateLivro (int codigo, livro livro) throws SQLException {
	
		String sql= "update obra o, autor a, obra_autor oa, assunto ass, obra_assunto oass set o.titulo = ?, "+
				 "o.ano_publicacao = ?, o.tipo_obra = ?, o.isbn = ?, o.visibilidade = ?, a.nome_autor = ?," + 
				" ass.descricao_assunto = ? where o.codigo_obra = oa.codigo_obra and " +
				"oa.codigo_autor = a.idAutor and o.codigo_obra = oass.codigo_obra and " +
				"oass.codigo_assunto = ass.codigo_assunto and o.codigo_obra = ?";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, livro.getTitulo());
		stmt.setDate(2, (Date) livro.getAno_publicacao());
		stmt.setString(3, livro.getTipo_obra());
		stmt.setLong(4, livro.getIsbn());
		stmt.setBoolean(5, livro.isVisibilidade());
		stmt.setString(6, livro.getAutor().getNome_autor());
		stmt.setString(7, livro.getAssunto().getDescricaoAssunto());
		stmt.setInt(8, codigo);
		stmt.executeUpdate();
		
		String sql2 = "update editora set nome_editora = ?, cidade = ? where codigo_editora = "+
		"(select `codigo_editora(FK)` from obra where codigo_obra = ?)";
	
		PreparedStatement stmt2 = connection.prepareStatement(sql2);
		stmt2.setString(1, livro.getEditora().getNome_editora());
		stmt2.setString(2, livro.getEditora().getCidade());
		stmt2.setInt(3, codigo);
		stmt2.executeUpdate();
	}

}