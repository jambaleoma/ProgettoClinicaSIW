<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> 
 <title>Dashboard paziente</title>
  </head>
 <!-- "patient" è il paziente corrente (autenticato) -->
 <body>
	<f:view>
		<%@include file="header.html"%>
		<!-- Single button -->
		<div align="center">
		<h:form>
			<h2>Pannello paziente
				${patientController.patient.firstName}
				${patientController.patient.lastName}</h2><br>
				<button type="button" class="btn btn-default btn-lg" onclick="consultaRisultati();">
  					<span class="glyphicon glyphicon-user"></span> Consulta Risultati
				</button>
				<br>
			</h:form>
		</div>
	</f:view>
	<!--  Utilizzo Ajax -->
   	<script>
   	 function consultaRisultati() {
 		var xhr = new XMLHttpRequest();; 
    		xhr.open("POST", "examResult.jsp", true);
    		xhr.send(null); 
    		xhr.onreadystatechange = function() {
       	if(xhr.readyState == 4 && xhr.status == 200) {
          	var data = xhr.responseText;
          	document.getElementById("box").innerHTML=data;
      	 	}
   		}
	 }
   	 
   	 </script>
   	<br><br>
   <div id="box" align="center"></div>
 </body>
</html>