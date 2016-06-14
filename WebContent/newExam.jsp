<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Prenotazione Nuovo Esame</title>
</head>
<body>
	<f:view>
		<h:form>
			<p align="center">
				<b>${examController.message}</b>
			</p>
			<table class="table pagination">
				<tr>
					<td><h2>Informazioni nuovo Esame</h2></td>
				</tr>
				<tr>
					<td><b>Data Esame: </b></td>
					<td><h:inputText value="#{examController.examDate}"
							required="true" requiredMessage="La data è obbligatoria"
							id="examDate" /> <h:message for="examDate" /></td>
				</tr>
				<tr>
					<td><b>Tipologia: </b></td>
					<td><h:inputText value="#{examController.typology}"
							required="true" requiredMessage="Il tipologia è obbligatoria"
							id="typology" /> <h:message for="typology" /></td>
				</tr>
				<tr>
					<td><b>Paziente: </b></td>
					<td><h:inputText value="#{examController.patient}"
							required="true" requiredMessage="Il paziente è obbligatorio"
							id="patient" /> <h:message for="patient" /></td>
				</tr>
				<tr>
					<td><b>Medico: </b></td>
					<td><h:inputText value="#{examController.doctor}"
							required="true" requiredMessage="Il paziente è obbligatorio"
							id="patient" /> <h:message for="patient" /></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<h:commandButton styleClass="btn btn-primary" value="Prenota Nuovo Esame"
					action="#{examController.createExam}" />
			</div>
			<br>
		</h:form>
	</f:view>
</body>
</html>