package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.usuarioDAO;
import br.com.projetoGP.model.usuario;

/**
 * Servlet implementation class editarUsuario
 */
public class editarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	int idUsuario = Integer.parseInt(req.getParameter("id"));
    	
    	try {
			usuarioDAO us = new usuarioDAO();
			usuario user = us.pegaUsuarioID(idUsuario);
			req.setAttribute("usuario",user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	RequestDispatcher rd = req.getRequestDispatcher("editarUsuario.jsp");
        rd.forward(req,resp);
    	
    	}

}
