package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.funcionarioDAO;
import br.com.projetoGP.DAO.usuarioDAO;
import br.com.projetoGP.model.funcionario;
import br.com.projetoGP.model.usuario;

/**
 * Servlet implementation class pesquisarUsuarios
 */
public class pesquisarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	usuarioDAO ud;
		try {
			ud = new usuarioDAO();
			List<usuario> lista = ud.mostrarUsuarios();
			req.setAttribute("lista", lista);
			
			RequestDispatcher rd = req.getRequestDispatcher("mostrarUsuarios.jsp");
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
