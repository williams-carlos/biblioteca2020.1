package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.livroDAO;
import br.com.projetoGP.model.livro;

/**
 * Servlet implementation class pesquisarLivros
 */
public class pesquisarLivros extends HttpServlet {

       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	livroDAO ld;
		try {
			ld = new livroDAO();
			List<livro> lista = ld.mostrarLivros();
			req.setAttribute("lista", lista);
			
			RequestDispatcher rd = req.getRequestDispatcher("mostrarLivros.jsp");
	        rd.forward(req,resp);
	        
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
}
