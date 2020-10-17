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
  <form action = editarUsuario2 method="post">
  <div class="row espaco">

  <div class="col-4">
	
			<input readonly="true" name="codigo" id="codigo" value="${usuario.codigo}"></input>
			<br>
			<br>
			<label style="color:white">Nome</label>
			<input placeholder="Nome" class="form-control" type="text" name="nome_usuario" id="nome" value="${usuario.nome_usuario} "></input>
			 <br>
			 <label style="color:white">CPF</label>
 		 	<input placeholder="CPF" class="form-control" type="text" name="cpf" id="cpf" value="${usuario.cpf}"></input>
 		 	<br>
 			<label style="color:white">Login</label>
 			<input placeholder="Login" class="form-control" type="text" name="login" id="login" value="${usuario.login}"></input>
 		 	<br>
 		 	<label style="color:white">Senha</label>
 		 	<input placeholder="Senha" class="form-control" type="password" name="senha" id="senha" value="${usuario.senha}" ></input>
 		 	<br>
 		 	<br>
 		 	
 		 	

 	</div>
 	
 	<div class="col-4">
 	
 			<label style="color:white">Data</label>
 			<input placeholder="Data" class="form-control" type="date" name="dataNascimento" id="dataNascimento" value="${usuario.dataNascimento}"></input>
			<br>
			<label style="color:white">Telefone</label>
 			<input placeholder="Telefone" class="form-control" type="tel" name="telefone" id="telefone" value="${usuario.telefone}"></input>
			 <br>
			 <label style="color:white">Logradouro</label>
			<input placeholder="Logradouro" class="form-control" type="text" name="endereco_logradouro" id="logradouro" value="${usuario.endereco_logradouro}"></input>
			 <br>
			 <label style="color:white">Número</label>
			 <input placeholder="Número" class="form-control" type="number" name="endereco_numero" id="numero" value="${usuario.endereco_numero}"></input>
			 <br>
			 <label style="color:white">Complemento</label>
 		 	<input placeholder="Complemento" class="form-control" type="text" name="endereco_complemento" id="complemento" value="${usuario.endereco_complemento}"></input>
 		 	<br>
 			<br>
 		 
 		 	
 		 	
 		 	
 	</div>
 	
 	<div class="col-4">
 	<label style="color:white">Bairro</label>
 	<input placeholder="Bairro" class="form-control" type="text" name="endereco_bairro" id="bairro" value="${usuario.endereco_bairro}"></input>
 		 	<br>
 		 	<label style="color:white">Cidade</label>
 	<input placeholder="Cidade" class="form-control" type="text" name="endereco_cidade" id="cidade" value="${usuario.endereco_cidade}"></input>
			 <br>
			 <label style="color:white">UF</label>
			 <input placeholder="UF" class="form-control" type="text" name="endereco_UF" id="uf" value="${usuario.endereco_UF}"></input>
			 <br>
			 <label style="color:white">CEP</label>
			 <input placeholder="CEP" class="form-control" type="number" name="endereco_CEP" id="cep" value="${usuario.endereco_CEP}"></input>
			 <br>
			 <br>
		<label style="color:white">Tipo</label>
			<select class="custom-select form-control" id="inputGroupSelect02" name=tipo>
				    <option selected>${usuario.tipo}</option>
				    <option value="Funcionario">Funcionário</option>
				    <option value="Cliente">Cliente</option>
				    <option value="Administrador">Administrador</option>
				  </select>
				  
			<br>
			<br>
			<br>
			
		 
 	</div>
 		 
 		  	<button  type="submit" class="btn btn-default"> Editar </button>
		</div>
				  
	</form>
 </div>
  </div>



</body>
</html>