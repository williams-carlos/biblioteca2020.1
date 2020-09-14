package testes;

import java.sql.SQLException;

import br.com.projetoGP.DAO.obraAssuntoDAO;
import br.com.projetoGP.model.obraAssunto;

public class TtesteCadastraObraAssunto {
	
	public static void main(String[] args)  {
		obraAssunto oa = new obraAssunto();
		oa.setCodigoAssunto(1);
		oa.setCodigoObra(1);
		
		
		try {
			obraAssuntoDAO oad = new obraAssuntoDAO();
			oad.cadastrarObraAssunto(oa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
