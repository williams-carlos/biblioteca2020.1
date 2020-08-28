package br.com.projetoGP.model;

import java.sql.Date;

public class livro {


	private String titulo;
	private Date ano_publicacao;
	private String tipo_obra;
	private Integer codigo;
	
	
	
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigo() {
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
	
	

}
