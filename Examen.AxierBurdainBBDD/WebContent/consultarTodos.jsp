<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONSULTAR TODOS</title>
</head>
<body>
	<jsp:useBean id="todos" class="app.modelo.Personas" scope="request" />
	<jsp:forward page="control?op=4"></jsp:forward>
</body>
</html>