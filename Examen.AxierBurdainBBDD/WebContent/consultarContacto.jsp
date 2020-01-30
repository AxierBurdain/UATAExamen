<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONSULTAR UN CONTACTO</title>
</head>
<body>
	<%
		if (request.getParameter("id") != null) {
	%>
	<jsp:useBean id="contacto" class="app.modelo.Personas" scope="request" />
	<jsp:setProperty property="id" name="contacto" />
	<jsp:forward page="control?op=2"></jsp:forward>
	<%
		}
	%>
	<h1>Consulta un Contacto</h1>
	<form action="consultarContacto.jsp" method="get">
		Id. Contacto <input type="number" name="id"><br /> <br /> <input
			type="submit" value="Consultar" />
	</form>
</body>
</html>