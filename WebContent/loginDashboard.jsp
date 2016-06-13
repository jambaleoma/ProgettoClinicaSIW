<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
 	<title>Login Amministratore</title>
 </head>
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