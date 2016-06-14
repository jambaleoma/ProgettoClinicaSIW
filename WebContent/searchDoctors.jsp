<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cerca Dottore</title>
</head>
<body>
 <f:view>
  <h:form>
   <div align="center">
   <b> Cognome Medico </b> <h:inputText value="#{doctorController.id}"
    					   required="true"
    					   requiredMessage="Non è stato inserito nessun Cognome"
    					   id="doctorId"/> <h:message for="doctorId"/><br><br>
    <h:commandButton styleClass="btn btn-primary"  value="Cerca Medico" action="#{doctorController.findDoctorByLastname}"/>
   </div>
  </h:form>
 </f:view>
</body>
</html>