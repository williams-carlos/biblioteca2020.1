package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import br.com.projetoGP.DAO.funcionarioDAO;
import br.com.projetoGP.model.funcionario;

/**
 * Servlet implementation class entrar
 */


public class entrar extends HttpServlet {

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
