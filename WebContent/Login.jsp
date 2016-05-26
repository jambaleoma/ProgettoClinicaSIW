<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="controllerLogin" method="post">
		Username: <input type="text" name="username"
			value='${param["username"]}' /> 
		Password: <input type="password" name="password" 
		 	value='${param["password"]}' />
		 	
		<button type="submit" name="login" value="login">Login</button>
	</form>
</body>
</html>