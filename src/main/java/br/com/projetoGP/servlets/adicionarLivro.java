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

import br.com.projetoGP.DAO.livroDAO;
import br.com.projetoGP.model.livro;

/**
 * Servlet implementation class adicionarLivro
 */
public class adicionarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	
    	
    	String ano = req.getParameter("date");
    	String nome = req.getParameter("titulo");
    	String tipo = req.getParameter("tipo");
    	java.sql.Date data = null;
    	
    	
		try {
		
			DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
			data = new Date(dfm.parse(ano).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	try {
			livroDAO livrodao = new livroDAO();
			livro livro1 = new livro();
			livro1.setAno_publicacao(data);
			livro1.setTitulo(nome);
			livro1.setTipo_obra(tipo);
			livrodao.cadastrarLivro(livro1);
			
			RequestDispatcher rd = req.getRequestDispatcher("/pesquisarLivros");
	        rd.forward(req,resp);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }

}
