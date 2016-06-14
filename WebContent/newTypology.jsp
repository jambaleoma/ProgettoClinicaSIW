<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Inserimento Nuova Tipologia</title>
</head>
<body>
	<f:view>
		<h:form>
			<p align="center">
				<b>${typologyController.message}</b>
			</p>
			<table class="table pagination">
				<tr>
					<td><h2>Nuova Tipologia</h2></td>
				</tr>				
				<tr>
					<td><b>Codice: </b><h:inputText value="#{typologyController.code}"
							required="true" requiredMessage="Inserisci il codice" id="code" />
						<h:message for="code" /></td>
				</tr>
				<tr>
					<td><b>Nome: </b><h:inputText value="#{typologyController.name}"
							required="true" requiredMessage="Inserisci il nome" id="name" />
						<h:message for="name" /></td>
				</tr>
				<tr>
					<td><b>Details: </b><h:inputTextarea value="#{typologyController.details}"
							required="false" cols="20"
							rows="5" /></td>
				</tr>
			</table>
			<div>
				<h:commandButton styleClass="btn btn-primary" value="Aggiungi Tipologia"
					action="#{typologyController.createProduct}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>