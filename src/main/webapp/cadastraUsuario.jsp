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
<body style="background-image: url(imgs/livro1.jpg);
    background-repeat: no-repeat;
    width: 100%;
    height: 100%;">

<c:import url="cabecalho.jsp" />
<div class="container">
<div class="form-group" >
  <form action = adicionarUsuario method="post">
  <div class="row espaco">

  <div class="col-4">
	

			<input placeholder="Nome" class="form-control" type="text" name="nome_usuario" id="nomeUsuario"></input>
			 <br>
			 <br>
 		 	<input placeholder="CPF" class="form-control" type="text" name="cpf" id="cpf"></input>
 		 	<br>
 			<br>
 			
 			<input placeholder="Login" class="form-control" type="text" name="login" id="login"></input>
 		 	<br>
 		 	<br>
 		 
 		 	<input placeholder="Senha" class="form-control" type="password" name="senha" id="senha"></input>
 		 	<br>
 		 	<br>
 		 	
 		 	<input placeholder="Data" class="form-control" type="date" name="dataNascimento" id="dataNascimento"></input>
			 <br>
			 <br>

 	</div>
 	
 	<div class="col-4">
 	
 			<input placeholder="Telefone" class="form-control" type="tel" name="telefone" id="telefone"></input>
			 <br>
			 <br>
		
			<input placeholder="Logradouro" class="form-control" type="text" name="endereco_logradouro" id="logradouro"></input>
			 <br>
			 <br>
		  
			 <input placeholder="Número" class="form-control" type="number" name="endereco_numero" id="numero"></input>
			 <br>
			 <br>
		
 		 	<input placeholder="Complemento" class="form-control" type="text" name="endereco_complemento" id="complemento"></input>
 		 	<br>
 			<br>
 		 
 		 	<input placeholder="Bairro" class="form-control" type="text" name="endereco_bairro" id="bairro"></input>
 		 	<br>
 		 	<br>
 		 	
 		 	
 	</div>
 	
 	<div class="col-4">
 	
 	<input placeholder="Cidade" class="form-control" type="text" name="endereco_cidade" id="cidade"></input>
			 <br>
			 <br>
			 
			 <input placeholder="UF" class="form-control" type="text" name="endereco_UF" id="uf"></input>
			 <br>
			 <br>
			 <input placeholder="CEP" class="form-control" type="number" name="endereco_CEP" id="cep"></input>
			 <br>
			 <br>
		
			<select class="custom-select form-control" id="inputGroupSelect02" name=tipo id="tipo">
				    <option selected>Escolher...</option>
				    <option value="Funcionario">Funcionário</option>
				    <option value="Cliente">Cliente</option>
				    <option value="Administrador">Administrador</option>
				  </select>
		 
 	</div>
 		 
 		  	<button  type="submit" class="btn btn-default"> Cadastrar </button>
		</div>
				  
	</form>
 </div>
  </div>



</body>
</html>