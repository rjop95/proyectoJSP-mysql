<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Modificar Productos </title>
</head>
<body>

<h2>Modificar Productos</h2>
<form method="POST" action="BuscarActualizarProductoServlet">
<p>
<label for ="txtIdproducto">Introduce el id del producto que quieres modificar</label>
<input type="text" id="txtIdproducto" name="txtIdproducto" >
</p>
<p>

<input type="submit" value="Buscar Producto" >
</p>
</form>




<script src="js/jquery.js"></script>
<script src="js/scriptmodificarproducto.js"></script>
</body>
</html>