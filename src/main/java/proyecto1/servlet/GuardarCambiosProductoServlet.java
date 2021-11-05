package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GuardarCambiosProductoServlet")
public class GuardarCambiosProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GuardarCambiosProductoServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int idProducto = Integer.parseInt(request.getParameter("txtIdproducto"));
	String nombreProducto=request.getParameter("txtNombreproducto");
	double precio = Double.parseDouble(request.getParameter("txtPrecioproducto"));
	
	response.setContentType("text/html");//Dato Tipo MIME
	PrintWriter salida=response.getWriter();
	
	//Seguimos los pasos para bd
	//Declaramos las variables
	String url="jdbc:mysql://localhost:3306/misproductos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String usuario="root";
	String password="root";
	
	//Paso 2 Declaramos los objetos
	Connection conn=null;
	PreparedStatement stmnt = null;
	int isRecordSaved=0;//para traer informacion de tabla
	
	//Paso 3 Establecer la estructura del try catch
	
	try
	{
		//Paso 4 Instanciar controlador
		Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
		
		//Paso 5 Abrir la conecion
		conn=DriverManager.getConnection(url, usuario, password);
		
		//Paso 6 Crear el satatement
		stmnt =conn.prepareStatement("update productos set  NombreProducto=?, precio=? where IdProducto=?");
		
		//Paso 6.1 Asignar los valores de cada statement
		stmnt.setString(1, nombreProducto);
		stmnt.setDouble(2, precio);
		stmnt.setInt(3, idProducto);
		
		
		
		//Paso 6.2 Ejecutamos el query
		//stmnt.executeUpdate();
		isRecordSaved = stmnt.executeUpdate();
	
	if (isRecordSaved==1)
	{
		salida.print("Guardado con exito");
	}
	else
	{
		salida.print("no se guardo");
	}
	salida.print("<a href=\"AltaProductos.jsp\">Regresar</a>");
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	try
	{
		conn.close();
		stmnt.close();
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

}

	


