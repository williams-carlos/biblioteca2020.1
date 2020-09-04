<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
			Biblioteca
		</title>
		
		<meta name = "viewport" content = "widht=device-widht, initial-scaele=1.0">
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/estilo.css">
	</head>
	
	<body class=" espaco">

		<div class="container titulo">
			<div class="row">
				<div class="offset-lg-4 col-lg-4 text-center">
			      <h2>Up! Biblioteca</h2>
			      <p>Um mundo de possibilidades</p>
			    </div>
			  

		</div>
		<div class="container">
			<div class="row">
				<div class="offset-lg-4 col-lg-4  bg-primary">
				<form action= "LoginController" method="post">
					<div class="form-group" >
					<br><br>
					  <input name="login" type="text" placeholder= "Login" class="form-control " id="usr">
					<br>
					  <input name="senha" type="password"  placeholder= "Password" class="form-control" id="pwd">
					  <br>
					  <input type="submit" class="btn btn-default" value="Entrar">
					</div>
					</form>
					</div>
				</div>
			</div>
		</div>



			  

		</div>
		

	</body>



</html>