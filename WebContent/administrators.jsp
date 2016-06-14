<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">

<title>Clinica & Analisi:Administrators</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<%@include file="header.html"%>

<body>
	<div class="container">
		<h2>Amministratori</h2>
		<p>Elenco del personale Tecnico Informatico:</p>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<tr class="info">
					<td>Admin</td>
					<td>1</td>
					<td>Admin.1@clinic.com</td>
				</tr>
				<tr class="info">
					<td>Admin</td>
					<td>2</td>
					<td>Admin.2@clinic.com</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>