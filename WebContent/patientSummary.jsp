<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cliente selezionato</title>
</head>
 <body>
  <f:view>
  <%@ include file="header.html" %>
  <div align="center"><h1>Il mio profilo</h1></div><br>
  <h3><b>${customerController.customer.firstName} ${customerController.customer.lastName}</b></h3><br>
   <h:form>
   <table class="table">
       	<tr><td>Id</td><td>${patientController.patient.id}</td>
    	<tr><td>Username</td><td>${patientController.patient.username}</td></tr> 
    	<tr><td>Nome</td><td>${patientController.patient.firstName}</td></tr> 
    	<tr><td>Cognome</td><td>${patientController.patient.lastName}</td></tr> 
    	<tr><td>Data di nascita</td><td>${patientController.patient.dateOfBirth}</td></tr>
    </table>
   </h:form>
  </f:view>
 </body>
</html>