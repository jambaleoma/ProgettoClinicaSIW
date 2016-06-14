<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Risultati Esame</title>
</head>
<body>

		<%@include file="header.html"%>
		<f:view>
			<div align="center">
			<h2>Elenco Esami per: <h:outputText value="#{patientController.patientProfile}"/></h2>
		</div>
			<hr style="width: 50%; color:black; height: 1px; background-color:black;"/>
			<h:form>
				<div align="center">
				<h:dataTable value="#{consultaRisultatiController.esamiDelPazienteModel}" var="esamePaziente" styleClass="esamePazienteTable" headerClass="esamePazienteTableHeader" rowClasses="esamePazienteTableOddRow,esamePazienteTableEvenRow" border="1" width="45%">
   					<h:column> 
   						<f:facet name="header"><h:outputText value="Codice"/></f:facet>   					  				
      					<h:outputText value="#{examController.id}"/>
   					</h:column>
   					<h:column> 
   						<f:facet name="header"><h:outputText value="Data"/></f:facet>   					  				
      					<h:outputText value="#{examController.date}"/>
   					</h:column>
   					<h:column>			
      					<f:facet name="header"><h:outputText value="CF Paziente"/></f:facet>   				
      					<h:outputText value="#{examController.patient.id}"/>
   					</h:column>
   					<h:column> 				
      					<f:facet name="header"><h:outputText value="Paziente"/></f:facet>   				
      					<h:outputText value="#{examController.patient.firstName} #{examController.patient.lastName}"/>
   					</h:column>
   					<h:column> 				
      					<f:facet name="header"><h:outputText value="Tipologia"/></f:facet>    				
      					<h:outputText value="#{examController.tipology.name}"/>
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value="Medico"/></f:facet> 
      					<h:outputText value="#{examController.doctor.firstName} #{examController.doctor.lastName}" />
   					</h:column>
   					<h:column>
      					<f:facet name="header"><h:outputText value=""/></f:facet>
      					<div align="center">
							<h:commandButton value="Controlla" action="#{examController.controlloRisultati}" styleClass="btn btn-lg btn-success"/>
						</div>
   					</h:column>
   				</h:dataTable>
			</div>
			</h:form>
		</f:view>
	</body>
</html>