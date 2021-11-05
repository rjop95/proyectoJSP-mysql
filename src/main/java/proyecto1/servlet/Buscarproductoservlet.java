package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Buscarproductoservlet")
public class Buscarproductoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Buscarproductoservlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProducto = request.getParameter("txtIdproducto");
		response.setContentType("text/html");
		
		PrintWriter salida= response.getWriter();
		
		/*Definimos las variables de conection a las bases de datos La url significa que me voy a conectar a un servidor de base de datos*/
		/*salida.print("El valor del producto es:" +idProducto);*/
		String url="jdbc:mysql://localhost:3306/misproductos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";/*Direccion de base de datos accedemos atraves del conector*/
		String nombreusuario = "root";
		String password = "root";
		
		//Encerrar en un try catch las operaciones de base de datos
		
		try
		{
			//Crear un objeto Driver del package com.mysql.jdbc
			//Driver objDriver = new Driver();Esti es lo mismo que lo de abajo
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//se abre la coneccion
		Connection conn = DriverManager.getConnection(url, nombreusuario, password);
		//se declara el statement
		Statement stmnt = conn.createStatement();
		ResultSet rs = stmnt.executeQuery("select*from productos");
		while (rs.next())
		{/*
			salida.println("Campo idProducto: "+rs.getInt(1));
			salida.print("Campo nombre producto: "+rs.getString(2));
			salida.print("Campo presio: "+rs.getDouble(3));
			*/
			
			
			salida.println("<h3>" +"Campo idProducto: "+rs.getInt("IdProducto") +"</h3>");
			salida.print("Campo nombre producto: "+rs.getString("NombreProducto"));
			salida.print("Campo presio: "+rs.getDouble("precio"));
			salida.println("<br/>");
			
		}
		
		//se cierra la coneccion
		rs.close();
		stmnt.close();
		conn.close();
		
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
		}
		finally
		{
			
		}
		salida.close();
	}

}
