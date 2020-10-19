package br.com.projetoGP.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoGP.DAO.livroDAO;
import br.com.projetoGP.model.livro;

/**
 * Servlet implementation class pesquisarLivros
 */
public class pesquisarLivros extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String acao = req.getParameter("acao");
    	livroDAO ld;
    	
    	List<livro> lista = new ArrayList<livro>();
		try {
			ld = new livroDAO();
			
			//if ((acao.length()>0)? lista=ld.buscarIsbn(isbn): lista=ld.mostrarLivros());
			if(  req.getParameter("busca")=="" || acao == null  ) {
				lista=ld.mostrarLivros();
			}
			
			else if(Integer.parseInt(acao) == 1){
				
				lista=ld.buscarIsbn(Long.parseLong(req.getParameter("busca")));		
			}
			
			else if (Integer.parseInt(acao) == 2){
				
				lista=ld.buscarAutor(req.getParameter("busca"));		
			}
			
			else if (Integer.parseInt(acao) == 3){
	
				lista=ld.buscarTitulo(req.getParameter("busca"));		
			}
			else {
				
				lista=ld.mostrarLivros();
				
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("mostrarLivros.jsp");
			req.setAttribute("lista", lista);
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
