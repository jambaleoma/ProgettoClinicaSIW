<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registrazione Nuovo Paziente</title>
</head>
<body>
	<f:view>
		<h:form>
			<p align="center">
				<b>${patientController.message}</b>
			</p>
			<table class="table pagination">
				<tr>
					<td><h2>Anagrafica del nuovo Paziente</h2></td>
				</tr>
				<tr>
					<td><b>Username: </b></td>
					<td><h:inputText value="#{patientController.username}"
							required="true" requiredMessage="L' Username è obbligatorio"
							id="username" /> <h:message for="username" /></td>
				</tr>
				<tr>
					<td><b>Password: </b></td>
					<td><h:inputSecret value="#{patientController.password}"
							required="true" requiredMessage="La Password è obbligatoria"
							id="password" /> <h:message for="password" /></td>
				</tr>
				<tr>
					<td><b>Nome: </b></td>
					<td><h:inputText value="#{patientController.firstName}"
							required="true" requiredMessage="Il nome è obbligatorio"
							id="firstName" /> <h:message for="firstName" /></td>
				</tr>
				<tr>
					<td><b>Cognome: </b></td>
					<td><h:inputText value="#{patientController.lastName}"
							required="true" requiredMessage="Il cognome è obbligatorio"
							id="lastName" /> <h:message for="lastName" /></td>
				</tr>
				<tr>
					<td><b>Data di nascita: </b></td>
					<td><h:inputText value="#{patientController.dateOfBirth}">
							<f:convertDateTime pattern="dd-mm-yyyy" />
						</h:inputText></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<h:commandButton styleClass="btn btn-primary" value="Registra nuovo Paziente"
					action="#{patientController.createPatientByRegistration}" />
			</div>
			<br>
		</h:form>
	</f:view>
</body>
</html>