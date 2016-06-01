<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>LoginAdmin</title>    
     <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<%@include file="header.html"%>
<body>

<f:view>
 <%@ include file="header.html" %>
 <div align="center"> <h1>Login Amministratore</h1> </div>
  <h:form>
   <div align="center">
 	<b>Username:</b> <h:inputText value="#{administratorController.username}"
 							required="true"
 							requiredMessage="L'username è obbligatorio"
 							id="username" /> <h:message for="username"/> <br>
 
 	<b>Password:</b> <h:inputSecret value="#{administratorController.password}"
 							required="true"
 							requiredMessage="La password è obbligatoria"
 							id="password" /> <h:message for="password" /> <br>
 							
  	<h:commandButton styleClass="btn btn-primary"  value="Log in" action="#{administratorController.loginAdmin}"/>
  	
  	 
  	</div>
   </h:form>
  </f:view>
 </body>
</html>