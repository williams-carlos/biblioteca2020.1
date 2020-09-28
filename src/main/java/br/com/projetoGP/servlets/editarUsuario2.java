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

import br.com.projetoGP.DAO.usuarioDAO;
import br.com.projetoGP.model.usuario;

/**
 * Servlet implementation class editarUsuario2
 */
public class editarUsuario2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	int codigo = Integer.parseInt(req.getParameter("codigo"));
    	String dataNascimento = req.getParameter("dataNascimento");
    	String nome = req.getParameter("nome_usuario");
    	String login = req.getParameter("login");
    	String senha = req.getParameter("senha");
    	long cpf = Long.parseLong(req.getParameter("cpf"));
    	
    	long telefone = Long.parseLong(req.getParameter("telefone"));
    	String logradouro = req.getParameter("endereco_logradouro");
    	int numero = Integer.parseInt(req.getParameter("endereco_numero"));
    	String complemento = req.getParameter("endereco_complemento");
    	String bairro = req.getParameter("endereco_bairro");
    	
    	String cidade = req.getParameter("endereco_cidade");
    	String uf = req.getParameter("endereco_UF");
    	long cep = Long.parseLong(req.getParameter("endereco_CEP"));
    	String tipo = req.getParameter("tipo");
    	
    	
    	
    	java.sql.Date data = null;
    	
    	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			data = new Date(dfm.parse(dataNascimento).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	usuarioDAO ud;
		try {
			ud = new usuarioDAO();
			usuario u = new usuario();
	    	
			u.setCodigo(codigo);
			u.setDataNascimento(data);
			u.setNome_usuario(nome);
			u.setLogin(login);
			u.setSenha(senha);
			u.setCpf(cpf);
			
			u.setTelefone(telefone);
			u.setEndereco_logradouro(logradouro);
			u.setEndereco_numero(numero);
			u.setEndereco_complemento(complemento);
			u.setEndereco_bairro(bairro);
			
			u.setEndereco_cidade(cidade);
			u.setEndereco_UF(uf);
			u.setEndereco_CEP(cep);
			u.setTipo(tipo);
			u.setVisibilidade(true);
			
	    	ud.editarUsuario(u);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/pesquisarUsuarios");
        rd.forward(req,resp);
    	}
}
