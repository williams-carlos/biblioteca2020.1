package testes;

import java.sql.SQLException;
import java.util.List;

import br.com.projetoGP.DAO.livroDAO;
import br.com.projetoGP.model.livro;

public class testeLivro {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*livro l = new livro();
		l.setCodigo("1");
		l.setNome("Crepusculo");
		*/
		livroDAO l1 = new livroDAO();
		//l1.cadastrarLivro(l);
		
		List<livro> lista = l1.mostrarLivros();
		
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i);
		}
		
	}

}
