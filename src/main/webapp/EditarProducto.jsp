<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Consulta individual</title>
</head>
<body>

<h2>Editar Produtos seleccionado</h2>
<form method="POST" action="GuardarCambiosProductoServlet">
<p>
<label for ="txtIdproducto">Introduce el id del producto </label>
<input type="text" id="txtIdproducto" name="txtIdproducto" value="<%=request.getAttribute("idProducto") %>" readonly >
</p>
<p>
<label for ="txtNombreproducto">Introduce el nombre del producto </label>
<input type="text" id="txtNombreproducto" name="txtNombreproducto" value="<%=request.getAttribute("nombreProducto") %>"  >
</p>
<p>
<label for ="txtPrecioproducto">Introduce el precio producto </label>
<input type="text" id="txtPrecioproducto" name="txtPrecioproducto" value="<%=request.getAttribute("Precio") %>" >
</p>

<p>

<input type="submit" value="Editar Producto" >
</p>
<ul><li><a href="Index.jsp">MenuPrincipal</a></li></ul>
</form>




<script src="js/jquery.js"></script>
<script src="js/scripAltaproductos.js"></script>
</body>
</html>