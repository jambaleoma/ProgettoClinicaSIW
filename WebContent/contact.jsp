<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="utf-8">

<title>Chi siamo</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<%@include file="header.html"%>

<body>
	<f:view>
		<h:form>
			<div class="panel panel-primary">
				<div align="center">
					<h3>
						Sito a cura di <b>Vincenzo D'Amico</b> e <b>Luca Bernabei</b> <br>
						Corso di Laurea Triennale in Ingegneria Informatica - A.A. 15/16
					</h3>
				</div>
			</div>
		</h:form>
	</f:view>
</body>
</html>