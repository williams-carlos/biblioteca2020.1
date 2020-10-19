<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="imgs/icon1.png">
<meta charset="ISO-8859-1">
<title>Biblioteca</title>
<meta name="viewport" content="widht=device-widht, initial-scaele=1.0">
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">



<link rel="stylesheet" href="css/estilo.css">

<script type="text/javascript">
	function confirma(id){
		if (window.confirm("realmente excluir?"))
			location.href= "removeObra?id="+id ;
	}
</script>


</head>

<script type="text/javascript">
	function verificaIsbn(isbnN){
		/* isbnN = isbnN.replace(/\D/g, ''); */
		console.log(isbnN);
		if(!isNaN(isbnN) && isbnN!=0){
			locale.action = "pesquisarLivros?acao=1";  
			}
		else {
			alert("Digite apenas nunmero na pesquisa ISBN!")
			}
		}		
</script>

<body
	style="background-image: url(imgs/livro1.jpg); background-repeat: no-repeat; width: 100%; height: 100%;">

	<c:import url="cabecalho.jsp" />
	<div class="container">
		<div class="row">
			<h2 style="color: white; padding-top: 50px"
				class="offset-lg-4 col-lg-4 text-center">Livros</h2>
		</div>
	</div>

	<div class="container espaco">
	<div class="input-group">
					
					<div class="input-group-append">
						<button class="p-2 mb-2 btn dropdown-toggle"
							id="dropdownMenu2" type="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">PESQUISAR POR</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
							
							<form action="pesquisarLivros?acao=1" method="post"
							onsubmit="javascript:verificaIsbn(this.isbn.value); return false;">
							<input type="text" class="form-control " name="isbn" id="inputBusca"
						aria-label="Input text com botão dropdown"
						placeholder="busca por isbn"/>
							<button class="dropdown-item"  id="isbnBusca" type="submit">ISBN</button>
							</form>
							
							<form action="pesquisarLivros?acao=2" method="post">
							<input type="text" class="form-control " name="autor" id="inputBusca"
						aria-label="Input text com botão dropdown"
						placeholder="busca por autor"/>
							<button class="dropdown-item"  type="submit">AUTOR</button>
							</form>
							
							<form action="pesquisarLivros?acao=3" method="post">
							<input type="text" class="form-control " name="titulo" id="inputBusca"
						aria-label="Input text com botão dropdown"
						placeholder="busca por titulo">
							<button class="dropdown-item"  type="submit">TÍTULO</button>
   							</form>
							
					   </div> 
						
					</div>
				</div>
		<div class="col-lg-8 offset-lg-2 table-wrapper-scroll-y my-custom-scrollbar ">
		
			 
				
			
		 
			<table class="table table-striped table-bordered table-dark ">
				<thead>
					<tr>
						<th scope="col">Código</th>
						<th scope="col">Nome</th>
						<th scope="col">ISBN</th>
						<th scope="col">Autor</th>
						<th scope="col">Data</th>
						<th scope="col">Remover</th>
						<th scope="col">Editar</th>

					</tr>
				</thead>
				<tbody class="tbody">
					<c:forEach var="livro" items="${lista}" varStatus="id">
						<tr> 
						
							<th scope="row">${livro.codigo}</th>
							<td>${livro.titulo}</td>
							<td>${livro.isbn}</td>
							<td>${livro.autor.nome_autor}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${livro.ano_publicacao}" /></td>
							<td><a href= javascript:confirma(${livro.codigo})><i	class="fas fa-trash-alt"></i></a></td>
							<td><a href= adicionarLivro?edit=${livro.codigo}><i	class="fas fa-edit"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>

<!--  <a class="dropdown-item" href=javascript:acao(123) id="isbnBusc">ISBN</a>
   							 <a class="dropdown-item" href="#" id="autorBusca">Autor</a>
   							 <a class="dropdown-item" href=javascript:acao(titulo) id="tituloBusca">Titulo</a> -->

<!-- <input type="submit" class="btn btn-secondary" value="ISBN" id="buscaIsbn">
							<input type="submit" class="btn btn-secondary" value="AUTOR" id="buscaAutor">
							<input type="submit" class="btn btn-secondary" value="TÍTULO" id="buscaTitulo">
<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">Dropdown</button>
		<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
			<button class="dropdown-item" type="button">ISBN</button>
			<button class="dropdown-item" type="button">AUTOR</button>
			<button class="dropdown-item" type="button">TÍTULO</button>
		</div>
	</div>
 -->

<!-- <div class="container">
		<form action="pesquisarLivros" method="post">
			<div class="form-row">
				<div>

					<input type="text" name="isbn" id="isbn" placeholder="digite o ISBN aqui..."> 
					<input type="submit" class="btn btn-secondary" value="ISBN">

				</div>
			</div>
		</form>
	</div>
 -->
 <!-- <button class="dropdown-item" type="button" value="isbn" id="isbn">ISBN</button>
							<button class="dropdown-item" type="button" value="autor">AUTOR</button>
							<button class="dropdown-item" type="button" value="titulo" id="btnTitulo">TÍTULO</button> -->