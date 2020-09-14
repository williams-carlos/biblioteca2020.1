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
   <div class = "col-lg-8 offset-lg-2 table-wrapper-scroll-y my-custom-scrollbar ">
  	<table class="table table-striped table-bordered table-dark ">
	  <thead>
	    <tr>
	      <th scope="col">Código</th>
	      <th scope="col">Nome</th>
	      <th scope="col">Data</th>
	    
	    </tr>
	  </thead>
	  <tbody class="tbody">
	  <c:forEach var="livro" items="${lista}" varStatus="id">
	    <tr>
	      <th scope="row">${livro.codigo}</th>
	      <td>${livro.titulo}</td>
	      <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${livro.ano_publicacao}" />
	      </td>
	      
	    </tr>
	       </c:forEach>
	  </tbody>
	</table>
	</div>
</div>
    
    
</body>
</html>