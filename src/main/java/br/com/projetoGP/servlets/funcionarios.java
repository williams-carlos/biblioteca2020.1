package br.com.projetoGP.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class funcionarios
 */
public class funcionarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
            {
		    	
	    	RequestDispatcher rd = request.getRequestDispatcher("/funcionario.jsp");
	        rd.forward(request,response);
	        
    	
    	
            }

}
