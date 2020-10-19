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
			<label>Título Livro:</label>
			 <input placeholder="Título" class="form-control" type="text" name="titulo" value="${listaLiv.titulo}"></input>
			  <br>
			  <br>
		  		<label>Ano Publicação:</label>
			   <input placeholder="Data" class="form-control" type="date" name="date" value="${listaLiv.ano_publicacao}"></input>
			   <br>
			   <br>
			   
			 <select class="custom-select form-control" id="inputGroupSelect01" name=tipo>
				    <option selected>Classificação...</option>
				    <option value="Auto-ajuda">Auto-ajuda</option>
				    <option value="Aventura">Aventura</option>
				    <option value="Científico">Científico</option>
				    <option value="Conto">Conto</option>
				    <option value="Crônica">Crônica</option>
				    <option value="Didático">Didático</option>
				    <option value="Épico">Épico</option>
				    <option value="Fantasia">Fantasia</option>
				    <option value="Ficção-científica">Ficção-científica</option>
				    <option value="Ficção-histórica">Ficção-histórica</option>
				    <option value="Horror">Horror</option>
				    <option value="Ação">Ação</option>
				    <option value="Drama">Drama</option>
				    <option value="Infantil">Infantil</option>
				    <option value="Jogos">Jogos</option>
				    <option value="Manual">Manual</option>
				    <option value="Poesia">Poesia</option>
				    <option value="Guia de Viagem">Guia de Viagem</option>
				  </select>
		</div>
 		
 		
 		<div class="col-4 espaco">
 	
 		<label>Nome do Autor:</label>
 		 <input placeholder="Nome do Autor" class="form-control" type="text" name="nomeAutor" value="${listaLiv.autor.nome_autor}"></input>
 		 <br>
 		 <br>
 		 <label>ISBN:</label>
 		 <input placeholder="ISBN" class="form-control" type="text" name="isbn" value="${listaLiv.isbn}"></input>
 		 <br>
 		 <br>
 		 <label>Assunto:</label>
 		 <textarea id="form10" placeholder="Assunto" name="assunto" class="md-textarea form-control" rows="3">${listaLiv.assunto.descricaoAssunto}</textarea>
 		 
 		  <br>
			<br>
			
			 
 	
 	
 	
  
    
  </div>
  
  <div class="col-4 espaco">
 	
 		<label>Nome Editora:</label>
 		 <input placeholder="Nome da Editora" class="form-control" type="text" name="nomeEditora" value="${listaLiv.editora.nome_editora}"></input>
 		 <br>
 		 <br>
 		 <label>Cidade Editora:</label>
 		 <input placeholder="Cidade da Editora" class="form-control" type="text" name="cidadeEditora" value="${listaLiv.editora.cidade}"></input>
 		 
 		 
 		  <br>
			<br>
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<div class="input-group-text">
						
							<input type="checkbox" name="visibilidade" value="true">
						</div>
					</div>
						<label  class="form-control"	aria-label="Input text com checkbox">visivel</label>
				</div>
			<br>
			<br>
			<br>
			<br>
 		  <button  type="submit" class="btn btn-default"> Salvar </button>

				  </div>
				  
				 
 	
 	
  
    
  </div>
  
   </form>
  
 </div>
</div>


</body>
</html>