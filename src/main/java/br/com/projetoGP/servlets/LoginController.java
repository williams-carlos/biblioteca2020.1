package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoGP.DAO.funcionarioDAO;
import br.com.projetoGP.DAO.usuarioDAO;
import br.com.projetoGP.model.funcionario;
import br.com.projetoGP.model.usuario;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public String efetuaLogin(String login, String senha, HttpSession sessao) throws ClassNotFoundException, SQLException  {
    	
    	boolean action = false;
				
		
		try {
			
	    	usuarioDAO f = new usuarioDAO();
			action = f.existeUsuario(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/erroSQLexception.jsp";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/erroClassNotFoundException.jsp";
		}
		
		
		if (action) {
			
			usuarioDAO usud = new usuarioDAO();
			usuario usu = usud.pegaUsuario(login, senha);
			
	    	
	    
			sessao.setAttribute("usuarioLogado", usu );
			
			return "/telaPrincipal.jsp";
		}else {
			return  "/naoLogin.jsp";
		}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
					
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		try {
			forward = efetuaLogin(login, senha, request.getSession());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		
		request.setAttribute("usuarioLogado", request.getSession().getAttribute("usuarioLogado"));
		
		view.forward(request, response);
	}

}
