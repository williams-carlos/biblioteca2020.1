package testes;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.projetoGP.DAO.usuarioDAO;
import br.com.projetoGP.model.usuario;

public class testeEditarUsuario {
	
	public static void main(String[] args) throws ParseException, ClassNotFoundException, SQLException {
		
		usuario us = new usuario();
		
		
		
    	
		Date data = Date.valueOf("1991-08-13");
		
		us.setNome_usuario("Vitória Maria");
		us.setDataNascimento(data);
		us.setCpf(1111111222);
		us.setEndereco_logradouro("rua da felicidade");
		us.setEndereco_complemento("perto da estação de metrô");
		us.setEndereco_numero(13);
		us.setEndereco_bairro("bairro da luz");
		us.setEndereco_CEP(55190530);
		us.setEndereco_cidade("vitória");
		us.setEndereco_UF("ES");
		us.setLogin("Vitória");
		us.setSenha("000");
		us.setTipo("Cliente");
		us.setTelefone(81995143219L);
		us.setCodigo(1);
		
		usuarioDAO ud = new usuarioDAO();
		
		ud.editarUsuario(us);
		
	


	
		
		
	}

}
