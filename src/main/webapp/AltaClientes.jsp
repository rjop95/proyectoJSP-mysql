<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Alta cliente</title>
</head>
<body>

<h2>Alta cliente Normal</h2>
<form method="POST" action="AltaClienteServlet">
<p>
<label for ="txtIdCliente">Introduce el id del Cliente </label>
<input type="text" id="txtIdCliente" name="txtIdCliente" >
</p>
<p>
<label for ="txtNombreCliente">Introduce el nombre del Cliente </label>
<input type="text" id="txtNombreCliente" name="txtNombreCliente" >
</p>
<p>
<label for ="txtFechaNacimiento">Introduce La feca de nacimiento solo numeros Queda pendiente </label>
<input type="text" id="txtFechaNacimiento" name="txtFechaNacimiento" >
</p>

<p>

<input type="submit" value="Alta Cliente" >
</p>
<ul><li><a href="Index.jsp">MenuPrincipal</a></li></ul>
</form>




<script src="js/jquery.js"></script>
<script src="js/scripAltaproductos.js"></script>
</body>
</html>