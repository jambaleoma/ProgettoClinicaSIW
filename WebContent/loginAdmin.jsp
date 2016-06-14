<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ include file="header.html"%>
<body>
<f:view>
<div align="center"><h1>Login Amministratore</h1></div>
<h:form>
<div align="center">
<table>
    <tr><td><b>Username</b></td><td><h:inputText value="#{administratorController.username}" styleClass="form-control" 
                     required="true"
                     requiredMessage="Username obbligatorio!"
                     id="username"/></td></tr>
    <tr><td><b>Password</b></td><td><h:inputSecret value="#{administratorController.password}"  styleClass="form-control" 
    	               required="true"
                     requiredMessage="Password obbligatoria!"
                     id="password"/></td></tr></table><br>
     <h:commandButton styleClass="btn btn-primary" value="Login!"  action="#{administratorController.login}"/>
    <h:message for="username"/>
    <h:message for="password"/>
    <p align="center"><b>${administratorController.message}</b></p><br>
    
    </div>
</h:form>
</f:view>
</body>
</html>