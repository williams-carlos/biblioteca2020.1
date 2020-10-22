<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="imgs/icon1.png">
<meta charset="ISO-8859-1">
<title>
			Biblioteca
		</title>
		<meta name = "viewport" content = "widht=device-widht, initial-scaele=1.0">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
	 <link rel="stylesheet" href="css/estilo.css">
	</head>
	
	
<script type="text/javascript">
	function verificaIsbn(isbnN){
		/* isbnN = isbnN.replace(/\D/g, ''); */
		console.log(isbnN);
		if(!isNaN(isbnN) && isbnN!=0){
			locale.action = "pesquisarLivros?acao=1";  
			}
		else {
			alert("Digite apenas número no campo ISBN!")
			}
		}		
</script>


<body style="background-image: url(imgs/livro1.jpg);
    background-repeat: no-repeat;
    width: 100%;
    height: 100%;">

<c:import url="cabecalho.jsp" />
		
<div class="container">
<div class="form-group" >
<form action = adicionarLivro method="post" onsubmit="javascript:verificaIsbn(this.isbn.value); return false;">
  <div class="row ">
  <div class= "col-4 espaco">
	
			 <input type="hidden" name="id" value="${listaLiv.codigo}" >
			<label style="color: white">Título Livro:</label>
			 <input placeholder="Título" class="form-control" type="text" id="tituloLivro" name="titulo" value="${listaLiv.titulo}"></input>
			  <br>
			  <br>
		  		<label style="color: white">Ano Publicação:</label>
			   <input placeholder="Data" class="form-control" type="date" id="anoPublicacaoLivro" name="date" value="${listaLiv.ano_publicacao}"></input>
			   <br>
			   <br>
			   
			 <select class="custom-select form-control" id="classificacaoLivro" name=tipo >
				    <option selected value="${listaLiv.tipo_obra }" >Classificação...</option>
				    <option id="autoAjuda" value="Auto-ajuda">Auto-ajuda</option>
				    <option id="aventura" value="Aventura">Aventura</option>
				    <option id="cientifico" value="Científico">Científico</option>
				    <option id="conto" value="Conto">Conto</option>
				    <option id="cronica" value="Crônica">Crônica</option>
				    <option id="didatico" value="Didático">Didático</option>
				    <option id="epico" value="Épico">Épico</option>
				    <option id="fantasia" value="Fantasia">Fantasia</option>
				    <option id="ficcaoCientifica" value="Ficção-científica">Ficção-científica</option>
				    <option id="ficcaoHistorica" value="Ficção-histórica">Ficção-histórica</option>
				    <option id="horror" value="Horror">Horror</option>
				    <option id="acao" value="Ação">Ação</option>
				    <option id="drama" value="Drama">Drama</option>
				    <option id="infantil" value="Infantil">Infantil</option>
				    <option id="jogos" value="Jogos">Jogos</option>
				    <option id="manual" value="Manual">Manual</option>
				    <option id="poesia" value="Poesia">Poesia</option>
				    <option id="guiaViagem" value="Guia de Viagem">Guia de Viagem</option>
				  </select>
		</div>
 		
 		
 		<div class="col-4 espaco">
 	
 		<label style="color: white">Nome do Autor:</label>
 		 <input placeholder="Nome do Autor" class="form-control" type="text" id="nomeAutorLivro" name="nomeAutor" value="${listaLiv.autor.nome_autor}"></input>
 		 <br>
 		 <br>
 		 <label style="color: white">ISBN:</label>
 		 <input placeholder="ISBN" class="form-control" type="text" id="isbnLivro" name="isbn" value="${listaLiv.isbn}"></input>
 		 <br>
 		 <br>
 		 <label style="color: white">Assunto:</label>
 		 <textarea id="form10" placeholder="Assunto" name="assunto" id="assuntoLivro" class="md-textarea form-control" rows="3">${listaLiv.assunto.descricaoAssunto}</textarea>
 		 
 		  <br>
			<br>
			
			 
 	
 	
 	
  
    
  </div>
  
  <div class="col-4 espaco">
 	
 		<label style="color: white">Nome Editora:</label>
 		 <input placeholder="Nome da Editora" class="form-control" type="text" id="nomeEditoraLivro" name="nomeEditora" value="${listaLiv.editora.nome_editora}"></input>
 		 <br>
 		 <br>
 		 <label style="color: white">Cidade Editora:</label>
 		 <input placeholder="Cidade da Editora" class="form-control" type="text" id="cidadeEditoraLivro" name="cidadeEditora" value="${listaLiv.editora.cidade}"></input>
 		 
 		 
 		  <br>
			<br>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<div class="input-group-text">
						
							<input type="checkbox" id="visivel" name="visibilidade" value="true">
						</div>
					</div>
						<label  class="form-control"	aria-label="Input text com checkbox">visivel</label>
				</div>
			<br>
			<br>
			<br>
			<br>
 		  <button  type="submit" class="btn btn-default" id="salvarLivro"> Salvar </button>

				  </div>
				  
				 
 	
 	
  
    
  </div>
  
   </form>
  
 </div>
</div>


</body>
</html>