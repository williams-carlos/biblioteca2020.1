<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="imgs/icon1.png">
<meta charset="ISO-8859-1">
<title>Biblioteca</title>
<meta name = "viewport" content = "widht=device-widht, initial-scaele=1.0">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	


    <link rel="stylesheet" href="css/estilo.css">
  </head>
  
  <body style="background-image: url(imgs/livro1.jpg);
    background-repeat: no-repeat;
    width: 100%;
    height: 100%;">
    
    <c:import url="cabecalho.jsp" />
    <div class="container">
    <div class="row">
    <h2 style="color: white; padding-top:50px" class="offset-lg-4 col-lg-4 text-center">Livros</h2>
    </div>
    </div>
    
    
   <div class="container espaco">
   <div class = "row">
   <div class = col-lg-2>
   		<form action= pesquisarUsuarios?id=1 method=post>
   		<label style="color:white">Pesquisar por Nome:</label>
   		<input placeholder="Nome" name=	nome1></input>
   		<button type="submit" class="btn btn-default">Pesquisar</button>
   		</form>
   		<br> <br>
   		<form action= pesquisarUsuarios?id=2 method=post>
   		<label style="color:white">Pesquisar por CPF:</label>
   		<input placeholder="CPF" name=	cpf1></input>
   		<button type="submit" class="btn btn-default">Pesquisar</button>
   		</form>
   		
   </div>

   		

   <div class = "col-lg-8 offset-lg-2 table-wrapper-scroll-y my-custom-scrollbar ">
  	<table class="table table-striped table-bordered table-dark ">
	  <thead>
	    <tr>
	      <th scope="col">Código</th>
	      <th scope="col">Nome</th>
	      <th scope="col">Data de Nascimento</th>
	      <th scope="col">Editar</th>
	      <th scope="col">Remover</th>
	    
	    </tr>
	  </thead>
	  <tbody class="tbody">
	  <c:forEach var="usu" items="${lista}" varStatus="id">
	    <tr>
	      <th scope="row">${usu.codigo}</th>
	      <td>${usu.nome_usuario}</td>
	      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${usu.dataNascimento}" />
	      <td><a href="editarUsuario?id=${usu.codigo}"><i class="fas fa-edit"></i></a></td>
	      <td><a href="removeUsuario?codigo=${usu.codigo}"><i class="fas fa-trash-alt"></i></a></td>
	      
	      
	    </tr>
	       </c:forEach>
	  </tbody>
	</table>
	</div>
</div>
</div>
    
    
</body>
</html>