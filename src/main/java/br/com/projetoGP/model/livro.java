package br.com.projetoGP.model;

import java.sql.Date;

public class livro {


	private String titulo;
	private Date ano_publicacao;
	private String tipo_obra;
	private int codigo;
	private int codigo_editora;
	private long isbn;
	private boolean visibilidade;
	private autor autor;
	
	public livro() {
		autor = new autor();
	}
	
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public int getCodigo_editora() {
		return codigo_editora;
	}
	public void setCodigo_editora(int codigo_editora) {
		this.codigo_editora = codigo_editora;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getAno_publicacao() {
		return ano_publicacao;
	}
	public void setAno_publicacao(Date ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}
	public String getTipo_obra() {
		return tipo_obra;
	}
	public void setTipo_obra(String tipo_obra) {
		this.tipo_obra = tipo_obra;
	}

	public autor getAutor() {
		return autor;
	}

	public void setAutor(autor autor) {
		this.autor = autor;
	}
	
	

}
