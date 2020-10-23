<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<body style="background-image: url(imgs/livro1.jpg);
    background-repeat: no-repeat;
    width: 100%;
    height: 100%;">

<c:import url="cabecalho.jsp" />
<div class="container">
<div class="form-group" >
  <form action = pesquisarUsuarios>
  <div class="row espaco">

  <div class="col-4">
	
			<label style="color:white" >Código: ${usuario.codigo}</label>
			
			<br>
			<br>
			<label style="color:white" >Nome: ${usuario.nome_usuario}</label>
			<br>
			<br>
			<label style="color:white" >CPF: ${usuario.cpf}</label>
			<br>
			<br>
 			<label style="color:white" >Login: ${usuario.login}</label><br>
 		 	<br>
 		 	<br>
 		 	
 		 	

 	</div>
 	
 	<div class="col-4">
 	
 			<label style="color:white" >Data: <fmt:formatDate pattern = "dd-MM-yyyy" value = "${usuario.dataNascimento}" /></label>
 			<br>
 			<br>
 			<label style="color:white" >Telefone: ${usuario.telefone}</label>
			<br>
			<br>
			<label style="color:white" >Logradouro: ${usuario.endereco_logradouro}</label>
			 <br>
			 <br>
			 <label style="color:white" >Numero: ${usuario.endereco_numero}</label>
			 <br><br>
			 <label style="color:white" >Complemento: ${usuario.endereco_complemento}</label>
			 <br>
 			<br>
 		 
 		 	
 		 	
 		 	
 	</div>
 	
 	<div class="col-4">
 	
 	<label style="color:white" >Bairro: ${usuario.endereco_bairro}</label>
	<br>
 	<br>
 	
 	<label style="color:white" >Cidade: ${usuario.endereco_cidade}</label>
			 <br>
 		 	<br>
 	<label style="color:white" >UF: ${usuario.endereco_UF}</label>
			 <br>
			 <br>
	<label style="color:white" >CEP: ${usuario.endereco_CEP}</label>
			 <br>
			 <br>
	<label style="color:white" >Tipo: ${usuario.tipo}</label>
			 <br>
			<br>
			
		 
 	</div>
 		 
 		  	<button class="btn btn-default" id="sair"> Sair </button>
		</div>
				  
	</form>
 </div>
  </div>



</body>
</html>