package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.livroDAO;

/**
 * Servlet implementation class removeObra
 */
public class removeObra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	int codigoObra = Integer.parseInt(req.getParameter("id"));
    	
    	try {
    		livroDAO ld = new livroDAO();
			ld.removerLivro(codigoObra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/pesquisarLivros");
        rd.forward(req,resp);
    	
    }
    
    

}
