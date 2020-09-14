package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.funcionarioDAO;

/**
 * Servlet implementation class livros
 */

public class livros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
            {
		    	
	    	RequestDispatcher rd = request.getRequestDispatcher("/livro.jsp");
	        rd.forward(request,response);
	        
    	
    	
            }

}
