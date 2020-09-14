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
 * Servlet implementation class entrar
 */


public class entrar extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException
            {

				
		
		    	String login = request.getParameter("login");
		    	String senha = request.getParameter("senha");
		    	
		    	
		    	
		  try {  
    	funcionarioDAO f = new funcionarioDAO();
    	boolean a = f.existeFuncionario(login, senha);
    	
    	if(a) {
    		
	    	RequestDispatcher rd = request.getRequestDispatcher("/telaPrincipal.jsp");
	    	
	    	rd.forward(request,response);
	        
	        }else {
	        	RequestDispatcher rd = request.getRequestDispatcher("/naoLogin.jsp");
		        rd.forward(request,response);
	        }
    	
		  }catch (ClassNotFoundException e) {
			  System.out.println(e.getMessage());
		  }catch(SQLException sql) {
			  System.out.println(sql.getMessage());
		  }
    	
    	
            }
	
	


    
}
