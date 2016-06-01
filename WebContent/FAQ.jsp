<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">

<title>FAQ</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <%@include file="header.html"%>
  
  <body>
<br>
<br>
<br>
<h1>&nbsp;&nbsp;&nbsp;&nbsp;Operazioni disponibili nei nostri centri:</h1>
	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>Per avere informazioni aggiuntive cliccare sulle operazioni desiderate.</u></div>
<br>
<br>
<br>
<ul class="list-group">
	<li class="list-group-item"><div class="container"><a href="#demo01" class="btn btn-success" data-toggle="collapse">Consulta Offerta</a>
  	<div id="demo01" class="collapse">Attore primario: <u>Utente non registrato</u><br>Scenario principale di successo:<br>L'utente consulta l'elenco delle tipologie di esame<br>L'utente sceglie una tipologia di esame e ne richiede i dettagli<br>Il sistema mostra i dettagli della tipologia di esame scelta dall'utente<br>L'utente ripete i passi precedenti un numero indefinito di volte</li>
	<li class="list-group-item"><div class="container"><a href="#demo02" class="btn btn-success" data-toggle="collapse">Crea Esame</a>
	<div id="demo02" class="collapse">Attore primario: <u>Amministrazione</u><br>Scenario principale di successo:<br>L'ammistrazione crea un esame<br>L'amministrazione imposta una tipologia di esame all'esame creato<br>L'amministrazione associa un medico all'esame creato<br>L'amministrazione associa un paziente all'esame creato<br>Il sistema registra l'esame (impostando automaticamente la data di prenotazione)<br>Precondizioni: l'amministratore e' identificato e autenticato</li>
	<li class="list-group-item"><div class="container"><a href="#demo03" class="btn btn-success" data-toggle="collapse">Consulta risultati proprio esame</a>
	<div id="demo03" class="collapse">Attore primario: <u>Paziente</u><br>Scenario principale:<br>Il paziente consulta l'elenco dei propri esami<br>Il sistema mostra al paziente l'elenco dei suoi esami<br>Il paziente chiede il dettaglio di un esame<br>Il sistema mostra il dettaglio dell'esame<br>Il paziente ripete i passi precedenti finche' necessario<br>Precondizioni: il paziente e' identificato e autenticato</li>
	<li class="list-group-item"><div class="container"><a href="#demo04" class="btn btn-success" data-toggle="collapse">Inserimento tipologia di esame</a>
	<div id="demo04" class="collapse">Attore primario: <u>Amministrazione</u><br>Scenario principale:<br>L'amministratore inserisce una nuova tipologia di esame specificandone i dettagli<br>Il sistema registra la tipologia di esame<br>I punti precedenti vengono ripetuti fino a che necessario<br>Precondizioni: l'amministratore e' identificato e autenticato</li>
	<li class="list-group-item"><div class="container"><a href="#demo05" class="btn btn-success" data-toggle="collapse">Esami effettuati da un medico</a>
	<div id="demo05" class="collapse">Attore primario: <u>Amministrazione</u><br>Scenario principale:<br>L'amministratore fornisce nome e cognome di un medico<br>Il sistema mostra all'amministratore tutti gli esami effettuati dal medico<br>Precondizioni: l'amministratore e' identificato e autenticato</li>
	<li class="list-group-item"><div class="container"><a href="#demo06" class="btn btn-success" data-toggle="collapse">Inserimento risultati esame</a>
	<div id="demo06" class="collapse">Attore primario: <u>Amministrazione</u><br>Scenario principale:<br>L'amministrazione inserisce un codice esame<br>Il sistema presenta all'amministratore l'esame corrispondente al codice immesso<br>L'amministratore inserisce tutti i risultati dell'esame<br>Precondizioni:<br>l'amministratore e' identificato e autenticato</li>
	
</ul>

</body>
</html>