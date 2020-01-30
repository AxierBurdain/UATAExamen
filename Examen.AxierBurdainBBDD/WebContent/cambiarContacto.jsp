<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MODIFICAR UN CONTACTO</title>
</head>
<body>
	<%
		if (request.getParameter("id") != null) {
	%>
	<jsp:useBean id="contacto" class="app.modelo.Personas" scope="request" />
	<jsp:setProperty property="id" name="contacto" />
	<jsp:forward page="control?op=1"></jsp:forward>
	<%
		}
	%>
	<h1>Modifica un Contacto</h1>
	<form action="cambiarContacto.jsp" method="get">
		Id. Contacto <input type="number" name="id"><br /> <br />
		Nombre <input type="text" name="nombre"><br /> <br /> Email
		<input type="text" name="email"><br /> <br /> Telefono <input
			type="text" name="telefono"><br /> <br /> <input
			type="submit" value="Cambiar" />
	</form>
</body>
</html>