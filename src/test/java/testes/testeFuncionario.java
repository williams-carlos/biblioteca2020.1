package testes;

import java.sql.SQLException;

import br.com.projetoGP.DAO.funcionarioDAO;


public class testeFuncionario {
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		funcionarioDAO fd = new funcionarioDAO();
		
	
		
		boolean a = fd.existeFuncionario("pri", "123");
		
		System.out.println(a);
		
	}
	
	

}
