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

import br.com.projetoGP.DAO.assuntoDAO;
import br.com.projetoGP.DAO.autorDAO;
import br.com.projetoGP.DAO.editoraDAO;
import br.com.projetoGP.DAO.livroDAO;
import br.com.projetoGP.DAO.obraAssuntoDAO;
import br.com.projetoGP.DAO.obraAutorDAO;
import br.com.projetoGP.model.assunto;
import br.com.projetoGP.model.autor;
import br.com.projetoGP.model.editora;
import br.com.projetoGP.model.livro;
import br.com.projetoGP.model.obraAssunto;
import br.com.projetoGP.model.obraAutor;

/**
 * Servlet implementation class adicionarLivro
 */
public class adicionarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	


@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
		int codigo = Integer.parseInt(req.getParameter("id"));
		
    	String ano = req.getParameter("date");
    	String nome = req.getParameter("titulo");
    	String tipo = req.getParameter("tipo");
    	String nomeAutor = req.getParameter("nomeAutor");
    	String assunto = req.getParameter("assunto");
    	String nomeEditora = req.getParameter("nomeEditora");
    	String cidadeEditora = req.getParameter("cidadeEditora");
    	long isbn = Long.parseLong( req.getParameter("isbn"));
    	boolean visibilidade = Boolean.parseBoolean(req.getParameter("visibilidade"));
    	
    	java.sql.Date data = null;
    	
    	if(codigo == -1) {
    	
    	int codigoLivro = 0;
    	int keyEditora = 0;
    		
    	
    	
    	
    	try {
    		editoraDAO ed = new editoraDAO();
			editora e = new editora();
			e.setNome_editora(nomeEditora);
			e.setCidade(cidadeEditora);
			
			keyEditora = ed.cadastrarEditorar(e);
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	
    	
    	assunto ass = new assunto();
    	obraAssunto oa = new obraAssunto();
    	ass.setDescricaoAssunto(assunto);
    	try {
    		assuntoDAO assd = new assuntoDAO();
			oa.setCodigoAssunto(assd.cadastrarAssunto(ass));
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	  	
    	
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
			livro1.setCodigo_editora(keyEditora);
			livro1.setIsbn(isbn);
			livro1.setVisibilidade(visibilidade);
			codigoLivro = livrodao.cadastrarLivro(livro1);
			oa.setCodigoObra(codigoLivro);
			obraAssuntoDAO oasd = new obraAssuntoDAO();
			oasd.cadastrarObraAssunto(oa);
					
		} catch (ClassNotFoundException e) {
			RequestDispatcher rd = req.getRequestDispatcher("/erroClassNotFoundException.jsp");
	        rd.forward(req,resp);
			e.printStackTrace();
		} catch (SQLException e) {
			RequestDispatcher rd = req.getRequestDispatcher("/erroSQLexception.jsp");
	        rd.forward(req,resp);
			e.printStackTrace();
		}
    	
    		
    	try {
    		autor a = new autor();
    		autorDAO ad = new autorDAO();
    		obraAutorDAO oaud = new obraAutorDAO();
    		obraAutor oautor = new obraAutor();
			a.setNome_autor(nomeAutor);
			oautor.setCodigo_autor(ad.cadastrarAutor(a));
			oautor.setCodigo_obra(codigoLivro);
			oaud.cadastrarObraAssunto(oautor);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/pesquisarLivros");
        rd.forward(req,resp);
		}
		else {
			try {
				
				DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
				data = new Date(dfm.parse(ano).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			livro livro2 = new livro();
			livro2.setAno_publicacao(data);
			livro2.setTitulo(nome);
			livro2.setTipo_obra(tipo);
			livro2.getEditora().setNome_editora(nomeEditora);
			livro2.getEditora().setCidade(cidadeEditora);
			livro2.setIsbn(isbn);
			livro2.setVisibilidade(visibilidade);
			livro2.getAssunto().setDescricaoAssunto(assunto);
			livro2.getAutor().setNome_autor(nomeAutor);
			 try {
				livroDAO livrodao = new livroDAO();
				livrodao.upDateLivro(codigo, livro2);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			RequestDispatcher rd = req.getRequestDispatcher("/pesquisarLivros");
		    rd.forward(req,resp);
			
		}
	}	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	livro liv = new livro();
	int codigoObra = Integer.parseInt(req.getParameter("edit"));
	try {
		livroDAO livrodao = new livroDAO();
		liv =  livrodao.editaLivro(codigoObra);
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	RequestDispatcher rd = req.getRequestDispatcher("/cadastrarLivro.jsp");
	req.setAttribute("listaLiv", liv);
    rd.forward(req,resp);
	
	
}

}
