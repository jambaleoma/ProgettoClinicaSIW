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

<title>Esami Diponibili</title>
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
<h1>Esami disponibili nei nostri centri:</h1>
<u>Per avere informazioni aggiuntive cliccare sull'esame desiderato.</u>
<br>
<br>
<br>
<ul class="list-group">
	<li class="list-group-item"><div class="container"><a href="#demo01" class="btn btn-info" data-toggle="collapse">Esami delle Urine</a>
  	<div id="demo01" class="collapse">L'esame delle urine comprende un insieme di esami di laboratorio che consente di analizzare le caratteristiche chimiche e fisiche delle urine e del relativo sedimento.</li>
	<li class="list-group-item"><div class="container"><a href="#demo02" class="btn btn-info" data-toggle="collapse">Esami del sangue</a>
	<div id="demo02" class="collapse">Gli esami del sangue sono una tecnica di diagnostica medica che attraverso il prelievo venoso di sangue valutano i parametri ematici del paziente evidenziando il suo stato di salute.</li>
	<li class="list-group-item"><div class="container"><a href="#demo03" class="btn btn-info" data-toggle="collapse">Esami della vista base</a>
	<div id="demo03" class="collapse">L'esame visivo base prevede un accurato esame refrattivo informatizzato orientato alla ricerca e alla valutazione della migliore soluzione ottica studiata con test particolari per valutare sempre l'accettazione delle lenti e l'efficacia nel tempo delle stesse.</li>
	<li class="list-group-item"><div class="container"><a href="#demo04" class="btn btn-info" data-toggle="collapse">Esami neurologici</a>
	<div id="demo04" class="collapse">L'esame neurologico inizia con un'attenta osservazione del paziente durante la raccolta dell'anamnesi. Sono valutate la velocita', la simmetria e la coordinazione richieste per il semplice atto dell'alzarsi dalla sedia e salire sul lettino, insieme alla postura e all'andatura. Il comportamento, l'abbigliamento e le reazioni del paziente forniscono notizie sulla sua personalita' e sull'adattamento sociale.</li>
	<li class="list-group-item"><div class="container"><a href="#demo05" class="btn btn-info" data-toggle="collapse">Prove allergiche</a>
	<div id="demo05" class="collapse">In caso di sospetto di allergia, puo' essere effettuato un test per identificare o escludere un allergene specifico. Si distingue tra test cutanei, ematici e di provocazione.</li>
</ul>

</body>
</html>