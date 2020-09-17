package testes;

import java.sql.SQLException;

import br.com.projetoGP.DAO.autorDAO;
import br.com.projetoGP.DAO.obraAutorDAO;
import br.com.projetoGP.model.autor;
import br.com.projetoGP.model.obraAutor;

public class TesteObraAutor {
	
	public static void main(String[] args) {
		
		try {
			obraAutor oa = new obraAutor();
			obraAutorDAO oad = new obraAutorDAO();
			autor a = new autor();
			autorDAO ad = new autorDAO();
			a.setNome_autor("Marcelo");
			oa.setCodigo_autor(ad.cadastrarAutor(a));
			oa.setCodigo_obra(1);
			oad.cadastrarObraAssunto(oa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
