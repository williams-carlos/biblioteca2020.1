package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.funcionarioDAO;
import br.com.projetoGP.model.funcionario;

/**
 * Servlet implementation class adicionarFuncionario
 */
public class adicionarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			
			String ano = req.getParameter("date");
	    	String nome = req.getParameter("nome");
	    	String login = req.getParameter("login");
	    	String senha = req.getParameter("senha");
	    	
	    	java.sql.Date data = null;
	    	
	    	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
			try {
				data = new Date(dfm.parse(ano).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	
	    	funcionarioDAO fd;
			try {
				fd = new funcionarioDAO();
				funcionario f = new funcionario();
		    	f.setNome(nome);
		    	f.setLogin(login);
		    	f.setSenha(senha);
		    	f.setDataNascimento(data);
		    	fd.cadastrarFuncionario(f);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/pesquisarFuncionarios");
	        rd.forward(req,resp);
	    	
	    	
		}

		
}
