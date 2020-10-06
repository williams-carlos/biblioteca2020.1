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

import br.com.projetoGP.model.usuario;

public class usuarioDAO {
	
	private Connection connection;
	
	public usuarioDAO() throws ClassNotFoundException {
		connection = new ConnectionFactory().getConnection();
	}
	
public int cadastrarUsuario(usuario usuario) throws SQLException {
		
		String sql = "insert into usuario (nome_usuario, endereco_logradouro, endereco_numero,"
				+ "endereco_complemento, endereco_bairro, endereco_cidade, endereco_UF,"
				+ "endereco_CEP, telefone, cpf, login, senha, dataNascimento, tipo, visibilidade ) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, usuario.getNome_usuario());
		stmt.setString(2, usuario.getEndereco_logradouro());
		stmt.setInt(3, usuario.getEndereco_numero());
		stmt.setString(4, usuario.getEndereco_complemento());
		stmt.setString(5, usuario.getEndereco_bairro());
		stmt.setString(6, usuario.getEndereco_cidade());
		stmt.setString(7, usuario.getEndereco_UF());
		stmt.setLong(8, usuario.getEndereco_CEP());
		stmt.setLong(9, usuario.getTelefone());
		stmt.setLong(10, usuario.getCpf());
		stmt.setString(11, usuario.getLogin());
		stmt.setString(12, usuario.getSenha());
		stmt.setDate(13, usuario.getDataNascimento());
		stmt.setString(14, usuario.getTipo());
		stmt.setBoolean(15,true);
	
		
		stmt.executeUpdate();
	

		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
	}

		public List<usuario> mostrarUsuarios() throws SQLException {
			List<usuario> lista = new ArrayList<usuario>();
			
			String sql = "select * from usuario";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 Integer id = rs.getInt("idUsuario");
				 String nome = rs.getString("nome_usuario");
				 String logradouro = rs.getString("endereco_logradouro");
				 int numero = rs.getInt("endereco_numero");
				 String complemento = rs.getString("endereco_complemento");
				 String bairro = rs.getString("endereco_bairro");
				 String cidade = rs.getString("endereco_cidade");
				 String uf = rs.getString("endereco_UF");
				 long cep = rs.getLong("endereco_CEP");
				 long telefone = rs.getLong("telefone");
				 long cpf = rs.getLong("CPF");
				 String login = rs.getNString("login");
				 String senha = rs.getNString("senha");
				 Date data = rs.getDate("dataNascimento");
				 String tipo = rs.getString("tipo");
				 boolean visibilidade = rs.getBoolean("visibilidade");
				
				 if(visibilidade) {
					 usuario u = new usuario();
					 u.setCodigo(id);
					 u.setNome_usuario(nome);
					 u.setEndereco_logradouro(logradouro);
					 u.setEndereco_numero(numero);
					 u.setEndereco_complemento(complemento);
					 u.setEndereco_bairro(bairro);
					 u.setEndereco_cidade(cidade);
					 u.setEndereco_UF(uf);
					 u.setEndereco_CEP(cep);
					 u.setTelefone(telefone);
					 u.setCpf(cpf);
					 u.setLogin(login);
					 u.setSenha(senha);
					 u.setDataNascimento(data);
					 u.setTipo(tipo);
					 
					 
					 
					 lista.add(u);
				 }
			 }
			
			return lista;
		}

		
		public boolean existeUsuario(String login, String senha) throws SQLException {
			
			String sql = "select * from usuario where login= ? and senha= ? and visibilidade = 1";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 return true;
			 }
			return false;
		}
		
		public usuario pegaUsuario(String login, String senha) throws SQLException {
			
			
			usuario usu = new usuario();
			String sql = "select * from usuario where login= ? and senha= ?";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 
				 String nome = rs.getString("nome_usuario");
				 String tipo = rs.getString("tipo");
			
				 usu.setNome_usuario(nome);
				 usu.setTipo(tipo);
				 
				 
			
			 }
			return usu;
		}
		
		public usuario pegaUsuarioID(int id) throws SQLException {
			
			
			usuario usu = new usuario();
			String sql = "select * from usuario where idUsuario= ?";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 
				 String nome = rs.getString("nome_usuario");
				 String logradouro = rs.getNString("endereco_logradouro");
				 int numero = rs.getInt("endereco_numero");
				 String complemento = rs.getString("endereco_complemento");
				 String bairro = rs.getString("endereco_bairro");
				 String cidade = rs.getString("endereco_cidade");
				 String uf = rs.getString("endereco_UF");
				 Long cep = rs.getLong("endereco_CEP");
				 Long telefone = rs.getLong("telefone");
				 Long cpf = rs.getLong("CPF");
				 String login = rs.getString("login");
				 String senha = rs.getString("senha");
				 Date data = rs.getDate("dataNascimento");
				 String tipo = rs.getString("tipo");
				 
			
				 usu.setNome_usuario(nome);
				 usu.setEndereco_logradouro(logradouro);
				 usu.setEndereco_numero(numero);
				 usu.setEndereco_complemento(complemento);
				 usu.setEndereco_bairro(bairro);
				 usu.setEndereco_cidade(cidade);
				 usu.setEndereco_UF(uf);
				 usu.setEndereco_CEP(cep);
				 usu.setTelefone(telefone);
				 usu.setCpf(cpf);
				 usu.setLogin(login);
				 usu.setSenha(senha);
				 usu.setDataNascimento(data);
				 usu.setTipo(tipo);
				 usu.setCodigo(id);
				 
				 
			
			 }
			return usu;
		}
		
		
		public void editarUsuario(usuario user) throws SQLException {
			String sql = ("update usuario set nome_usuario = ?, endereco_logradouro =?, endereco_numero =?, " 
								+ "endereco_complemento=?, endereco_bairro=?, endereco_cidade=?, endereco_UF=?, "
							+ "endereco_CEP=?, telefone=?, cpf=?, login=?, senha=?, dataNascimento=?, tipo=? where idUsuario = ?");
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getNome_usuario());
			stmt.setString(2, user.getEndereco_logradouro());
			stmt.setInt(3, user.getEndereco_numero());
			stmt.setString(4, user.getEndereco_complemento());
			stmt.setString(5, user.getEndereco_bairro());
			stmt.setString(6, user.getEndereco_cidade());
			stmt.setString(7, user.getEndereco_UF());
			stmt.setLong(8, user.getEndereco_CEP());
			stmt.setLong(9, user.getTelefone());
			stmt.setLong(10, user.getCpf());
			stmt.setString(11, user.getLogin());
			stmt.setString(12, user.getSenha());
			stmt.setDate(13, user.getDataNascimento());
			stmt.setString(14, user.getTipo());
			stmt.setInt(15, user.getCodigo());
		
			
			
			stmt.executeUpdate();
			
		}

		
		public void removerUsuario(int codigo) throws SQLException {
			
			String sql = "update usuario set visibilidade = ? where idUsuario = ?";
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, false);
			stmt.setInt(2, codigo);
			
			stmt.executeUpdate();
			
			
			
		}
		
		public List<usuario> mostrarUsuariosPorNome(String nomeUsuario) throws SQLException {
			List<usuario> lista = new ArrayList<usuario>();
			
			String sql = "select * from usuario where nome_usuario like ? ";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "%"+nomeUsuario+"%");
			
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 Integer id = rs.getInt("idUsuario");
				 String nome = rs.getString("nome_usuario");
				 String logradouro = rs.getString("endereco_logradouro");
				 int numero = rs.getInt("endereco_numero");
				 String complemento = rs.getString("endereco_complemento");
				 String bairro = rs.getString("endereco_bairro");
				 String cidade = rs.getString("endereco_cidade");
				 String uf = rs.getString("endereco_UF");
				 long cep = rs.getLong("endereco_CEP");
				 long telefone = rs.getLong("telefone");
				 long cpf = rs.getLong("CPF");
				 String login = rs.getNString("login");
				 String senha = rs.getNString("senha");
				 Date data = rs.getDate("dataNascimento");
				 String tipo = rs.getString("tipo");
				 boolean visibilidade = rs.getBoolean("visibilidade");
				
				 if(visibilidade) {
					 usuario u = new usuario();
					 u.setCodigo(id);
					 u.setNome_usuario(nome);
					 u.setEndereco_logradouro(logradouro);
					 u.setEndereco_numero(numero);
					 u.setEndereco_complemento(complemento);
					 u.setEndereco_bairro(bairro);
					 u.setEndereco_cidade(cidade);
					 u.setEndereco_UF(uf);
					 u.setEndereco_CEP(cep);
					 u.setTelefone(telefone);
					 u.setCpf(cpf);
					 u.setLogin(login);
					 u.setSenha(senha);
					 u.setDataNascimento(data);
					 u.setTipo(tipo);
					 
					 
					 
					 lista.add(u);
				 }
			 }
			
		
			return lista;
		}
		
		public List<usuario> mostrarUsuariosPorCPF(long cpfUsuario) throws SQLException {
			List<usuario> lista = new ArrayList<usuario>();
			
			String sql = "select * from usuario where CPF = ? ";
			
			
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cpfUsuario);
			
			
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 Integer id = rs.getInt("idUsuario");
				 String nome = rs.getString("nome_usuario");
				 String logradouro = rs.getString("endereco_logradouro");
				 int numero = rs.getInt("endereco_numero");
				 String complemento = rs.getString("endereco_complemento");
				 String bairro = rs.getString("endereco_bairro");
				 String cidade = rs.getString("endereco_cidade");
				 String uf = rs.getString("endereco_UF");
				 long cep = rs.getLong("endereco_CEP");
				 long telefone = rs.getLong("telefone");
				 long cpf = rs.getLong("CPF");
				 String login = rs.getNString("login");
				 String senha = rs.getNString("senha");
				 Date data = rs.getDate("dataNascimento");
				 String tipo = rs.getString("tipo");
				 boolean visibilidade = rs.getBoolean("visibilidade");
				
				 if(visibilidade) {
					 usuario u = new usuario();
					 u.setCodigo(id);
					 u.setNome_usuario(nome);
					 u.setEndereco_logradouro(logradouro);
					 u.setEndereco_numero(numero);
					 u.setEndereco_complemento(complemento);
					 u.setEndereco_bairro(bairro);
					 u.setEndereco_cidade(cidade);
					 u.setEndereco_UF(uf);
					 u.setEndereco_CEP(cep);
					 u.setTelefone(telefone);
					 u.setCpf(cpf);
					 u.setLogin(login);
					 u.setSenha(senha);
					 u.setDataNascimento(data);
					 u.setTipo(tipo);
					 
					 
					 
					 lista.add(u);
				 }
			 }
			
		
			return lista;
		}
}
