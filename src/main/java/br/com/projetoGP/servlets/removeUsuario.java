package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.usuarioDAO;

/**
 * Servlet implementation class removeUsuario
 */
public class removeUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
  		int codigo = Integer.parseInt(req.getParameter("codigo"));
  		
  		try {
			usuarioDAO ud = new usuarioDAO();
			ud.removerUsuario(codigo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		RequestDispatcher rd = req.getRequestDispatcher("/pesquisarUsuarios");
        rd.forward(req,resp);
  		
  		
  		
   	}
}
