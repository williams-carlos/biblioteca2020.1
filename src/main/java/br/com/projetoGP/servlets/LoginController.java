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
import br.com.projetoGP.model.funcionario;

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

    
    public String efetuaLogin(String login, String senha, HttpSession sessao)  {
    	
    	boolean action = false;
				
		
		try {
			
	    	funcionarioDAO f = new funcionarioDAO();
			action = f.existeFuncionario(login, senha);
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
			funcionario func = new funcionario();
			func.setLogin(login);
			func.setSenha(senha);
	    	
	    
			sessao.setAttribute("usuarioLogado", func );
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
		
		forward = efetuaLogin(login, senha, request.getSession());
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
