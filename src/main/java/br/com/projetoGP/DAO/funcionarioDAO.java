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
import br.com.projetoGP.model.funcionario;
import br.com.projetoGP.model.livro;


public class funcionarioDAO {
	
private Connection connection;
	
	public funcionarioDAO() throws ClassNotFoundException {
		connection = new ConnectionFactory().getConnection();
	}
	
public int cadastrarFuncionario(funcionario funcionario) throws SQLException {
		
		String sql = "insert into funcionario (nome_funcionario, senha, login, dataNascimento ) values (?,?,?,?)";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getSenha());
		stmt.setString(3, funcionario.getLogin());
		stmt.setDate(4,  funcionario.getDataNascimento());
	
		
		stmt.executeUpdate();
	

		ResultSet rs = stmt.getGeneratedKeys();
		int key = rs.next() ? rs.getInt(1) : 0;
		return key;
	}
	
	
	public boolean existeFuncionario(String login, String senha) throws SQLException {
		
		String sql = "select * from funcionario where login= ? and senha= ?";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 return true;
		 }
		
        
		
		
		
		
		
		return false;
		
		
	}

	
	public List<funcionario> mostrarFuncionarios() throws SQLException{
		List<funcionario> lista = new ArrayList<funcionario>();
		
		String sql = "select * from funcionario";
		
		
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		
		 ResultSet rs = stmt.executeQuery();
		 
		 while (rs.next()) {
			 Integer id = rs.getInt("idFuncionario");
			 String nome = rs.getString("nome_funcionario");
			 Date data = rs.getDate("dataNascimento");
			 String login = rs.getNString("login");
			 String senha = rs.getNString("senha");
			 
			 funcionario f = new funcionario();
	
			 f.setDataNascimento(data);
			 f.setLogin(login);
			 f.setNome(nome);
			 f.setSenha(senha);
			 f.setId(id);
			 
			 lista.add(f);
			 
		 }
		
		return lista;
		
		
	}
}
