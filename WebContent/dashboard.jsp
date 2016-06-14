<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> 
 <title>Dashboard amministratore</title>
  </head>
 <!-- "administrator" è l'amministratore corrente (autenticato) -->
 <body>
	<f:view>
		<%@include file="header.html"%>
		<!-- Single button -->
		<div align="center">
		<h:form>
			<h2>Pannello amministrazione
				${administratorController.administrator.firstName}
				${administratorController.administrator.lastName}</h2><br>
				<button type="button" class="btn btn-default btn-lg" onclick="inserisciPaziente();">
  					<span class="glyphicon glyphicon-user"></span> Nuovo Paziente
				</button>
				<button type="button" class="btn btn-default btn-lg" onclick="inserisciTipologia();">
  					<span class="glyphicon glyphicon-plus"></span> Nuova Tipologia
				</button>
				<button type="button" class="btn btn-default btn-lg" onclick="prenotaNuovoEsame();">
  					<span class="glyphicon glyphicon-tint"></span> Prenota Esame
				</button>
				<button type="button" class="btn btn-default btn-lg" onclick="cercaDottore();">
  					<span class="glyphicon glyphicon-search"></span> Ricerca Dottore
				</button>
				<br>
			</h:form>
		</div>
	</f:view>
	<!--  Utilizzo Ajax -->
   	<script>
   	 function inserisciPaziente() {
 		var xhr = new XMLHttpRequest();; 
    		xhr.open("POST", "newPatient.jsp", true);
    		xhr.send(null); 
    		xhr.onreadystatechange = function() {
       	if(xhr.readyState == 4 && xhr.status == 200) {
          	var data = xhr.responseText;
          	document.getElementById("box").innerHTML=data;
      	 	}
   		}
	 }
   	 
   	 function inserisciTipologia() {
    		var xhr = new XMLHttpRequest();; 
       		xhr.open("POST", "newTypology.jsp", true);
       		xhr.send(null);
       		xhr.onreadystatechange = function() {
          	if(xhr.readyState == 4 && xhr.status == 200) {
             	var data = xhr.responseText;
             	document.getElementById("box").innerHTML=data;
         	 	}
      		}
	}
   	
   	function prenotaNuovoEsame() {
 		var xhr = new XMLHttpRequest();; 
    		xhr.open("POST", "newExam.jsp", true);
    		xhr.send(null); 
    		xhr.onreadystatechange = function() {
       	if(xhr.readyState == 4 && xhr.status == 200) {
          	var data = xhr.responseText;
          	document.getElementById("box").innerHTML=data;
      	 	}
   		}
	 }
   	 
   	 function cercaDottore() {
    		var xhr = new XMLHttpRequest();; 
       		xhr.open("POST", "searchDoctors.jsp", true);
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