<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Pagina Login</h2>

<form method="POST"action="LoginServlet">

<p>
<label for ="txtIdCliente">Introduce el id del Cliente </label>
<input type="text" id="txtIdCliente" name="txtIdCliente" >
</p>
<p>
<label for ="txtNombreCliente">Introduce el nombre del Cliente </label>
<input type="text" id="txtNombreCliente" name="txtNombreCliente" >
</p>
<p>
<label for="txtusername">nombre usuario</label>
<input type="text" name="txtusername"><br>  
</p>
<p>
<label for="txtPassword">Password</label>
<input type="password" id="txtPassword" name="txtPassword"><br>
</p>

<p>  
<input type="submit" value="Registrar Usuario">
</p>


</form>

</body>
</html>