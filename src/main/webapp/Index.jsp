<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="/Navbar.jsp">
<title>Practica JDBC</title>
</head>
<body>

<div class="container" >
<center>
<h2 class="header">Proyecto JDBC</h2>
</center>




<h3>Gestion de productos</h3>




<div class="registro">
<li><a href="IndexLogin.jsp">Registrarse</a></li>
<li><a href="IndexLogin.jsp">Iniciar Sesión</a></li>
</div>
<ul>
<li><a href="ConsultaGeneralProductos.jsp">Consulta General Productos</a></li>
<li><a href="ConsultaIndividualProductos.jsp">Consulta Individual Productos</a></li>
<li><a href="AltaProductos.jsp">Alta Productos Normal</a></li>
<li><a href="AltaProductosPrepared.jsp">Alta Productos Prepared</a></li>
<li><a href="BorrarProductos.jsp">Borrar Productos</a></li>
<li><a href="ModificarProductos.jsp">Modificar Productos</a></li>
<li><a href="TransaccionesProductosServlet">lo mandamos por get cuendp es href Ejemplo de transacciones en productos</a></li>
</ul>

<hr>

<h3>Gestion de Clientes</h3>

<ul>
<li><a href="ConsultaGeneralClientes.jsp">Consulta General Clientes</a></li>
<li><a href="ConsultaIndividualClientes.jsp">Consulta Individual Clientes</a></li>
<li><a href="AltaClientes.jsp">Alta Clientes Normal</a></li>
<li><a href="AltaClientesPrepared.jsp">Alta Clientes Prepared</a></li>
<li><a href="BorrarClientes.jsp">Borrar Clientes</a></li>
<li><a href="ModificarClientes.jsp">Modificar Clientes</a></li>

</ul>

</div>


<script src="js/jquery.js"></script>
<script src="js/script.js"></script>
</body>
</html>