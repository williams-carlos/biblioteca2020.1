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
	
 
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	
    	
    	String ano = req.getParameter("date");
    	String nome = req.getParameter("titulo");
    	String tipo = req.getParameter("tipo");
    	String nomeAutor = req.getParameter("nomeAutor");
    	String assunto = req.getParameter("assunto");
    	String nomeEditora = req.getParameter("nomeEditora");
    	String cidadeEditora = req.getParameter("cidadeEditora");
    	long isbn = Long.parseLong( req.getParameter("isbn"));
    	
    	int codigoLivro = 0;
    	int keyEditora = 0;
    	
    	
    	java.sql.Date data = null;
    	
    	assunto ass = new assunto();
    	obraAssunto oa = new obraAssunto();
    	
    	try {
			editoraDAO ed = new editoraDAO();
			editora e = new editora();
			e.setNome_editora(nomeEditora);
			e.setCidade(cidadeEditora);
			
			keyEditora = ed.cadastrarEditorar(e);
			
			
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	
    	
    	
    	ass.setDescricaoAssunto(assunto);
    	try {
			assuntoDAO assd = new assuntoDAO();
			oa.setCodigoAssunto(assd.cadastrarAssunto(ass));
			
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e) {
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
			codigoLivro = livrodao.cadastrarLivro(livro1);
			oa.setCodigoObra(codigoLivro);
			obraAssuntoDAO oad = new obraAssuntoDAO();
			oad.cadastrarObraAssunto(oa);
			
			
			
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
			obraAutor oautor = new obraAutor();
			obraAutorDAO oad = new obraAutorDAO();
			autor a = new autor();
			autorDAO ad = new autorDAO();
			a.setNome_autor(nomeAutor);
			oautor.setCodigo_autor(ad.cadastrarAutor(a));
			oautor.setCodigo_obra(codigoLivro);
			oad.cadastrarObraAssunto(oautor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/pesquisarLivros");
        rd.forward(req,resp);
    	
    	
    }

}
