<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

<title>Clinica & Analisi</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
</style>
</head>
<body>

<!--BARRA DI NAVIGAZIONE -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Clinica & Analisi</a>
		</div>
		<div class="navbar-collapse collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="index.jsp">Home</a></li>
				<li><a href="typologies.jsp">Esami</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Chi Siamo <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li class="dropdown-header">Personale Ospedaliero</li>
						<li><a href="doctors.jsp">Dottori</a></li>
						<li><a href="urses.jsp">Infermieri</a></li>
						<li><a href="trainees">Specializzandi</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Personale Informatico</li>
						<li><a href="administrators.jsp">Amministratori</a></li>
					</ul>
				<li><a href="contanct.jsp">Contatti</a></li>
				<li><a href="FAQ.jsp">FAQ</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="login.jsp"><span class="glyphicon glyphicon-user"></span> Account Personale</a></li>
			</ul>
		</div>
	</div>
</nav>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<h1 align="center">Clinica & Analisi</h1>
	<br>
	<br>
	<br>
	<td style="text-align: right;">
		<div id="userProfileBox">
			<table>
				<tr>
					<div style="text-align: center;">
						<form class="profileBoxForm" action="login.jsp">
							<input class="profileBoxFormInput" type="submit" value="Login">
						</form>
					</div>

					<div style="text-align: right;">
						<form class="profileBoxForm" action="register.jsp">
							<input class="profileBoxFormInput" type="submit"
								value="Registrazione(Admin)">
						</form>
					</div>
				</tr>
			</table>
		</div>
	</td>

</body>
</html>