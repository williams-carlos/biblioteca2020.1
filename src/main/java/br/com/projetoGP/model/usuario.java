package br.com.projetoGP.model;

import java.sql.Date;

public class usuario {
	
	private int codigo;
	private String nome_usuario;
	private long telefone;
	private long cpf;
	private String login;
	private String senha;
	private Date dataNascimento;
	
	private String endereco_logradouro;
	private int endereco_numero;
	private String endereco_complemento;
	private String endereco_bairro;
	private String endereco_cidade;
	private String endereco_UF;
	private long endereco_CEP;
	
	private boolean visibilidade;
	
	
	
	
	private String tipo;
	
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getEndereco_logradouro() {
		return endereco_logradouro;
	}
	public void setEndereco_logradouro(String endereco_logradouro) {
		this.endereco_logradouro = endereco_logradouro;
	}
	public int getEndereco_numero() {
		return endereco_numero;
	}
	public void setEndereco_numero(int endereco_numero) {
		this.endereco_numero = endereco_numero;
	}
	public String getEndereco_complemento() {
		return endereco_complemento;
	}
	public void setEndereco_complemento(String endereco_complemento) {
		this.endereco_complemento = endereco_complemento;
	}
	public String getEndereco_bairro() {
		return endereco_bairro;
	}
	public void setEndereco_bairro(String endereco_bairro) {
		this.endereco_bairro = endereco_bairro;
	}
	public String getEndereco_cidade() {
		return endereco_cidade;
	}
	public void setEndereco_cidade(String endereco_cidade) {
		this.endereco_cidade = endereco_cidade;
	}
	public String getEndereco_UF() {
		return endereco_UF;
	}
	public void setEndereco_UF(String endereco_UF) {
		this.endereco_UF = endereco_UF;
	}
	public long getEndereco_CEP() {
		return endereco_CEP;
	}
	public void setEndereco_CEP(long endereco_CEP) {
		this.endereco_CEP = endereco_CEP;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	

}
