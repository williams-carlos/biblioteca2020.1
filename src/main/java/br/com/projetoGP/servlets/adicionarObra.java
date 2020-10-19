package br.com.projetoGP.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.model.livro;

/**
 * Servlet implementation class adicionarObra
 */
public class adicionarObra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 protected void service(HttpServletRequest request,
	            HttpServletResponse response) throws IOException, ServletException
	            {
		 livro liv = new livro();
		 liv.setCodigo(-1);

    	RequestDispatcher rd = request.getRequestDispatcher("/cadastrarLivro.jsp");
    	request.setAttribute("listaLiv", liv);
    	rd.forward(request,response);
    }

	

}
