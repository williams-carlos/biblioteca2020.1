<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca</title>

</head>
<body>

<nav class="navbar bg-light navbar-light">
  <a class="navbar-brand" href="#">Up! Biblioteca</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">Opções
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Funcionários</a>
      </li>
      
      <li class="nav-item">
    <form action="livros">
        <button class="nav-link btn btn-default btn-light" >Livros</button>
    </form>
      </li>
          
      <li class="nav-item">
        <a class="nav-link" href="#">Alunos</a>
      </li>   
      <li class="nav-item">
        <a class="nav-link" href="#">Empréstimos</a>
      </li> 
    </ul>
  </div>  
</nav>


</body>
</html>