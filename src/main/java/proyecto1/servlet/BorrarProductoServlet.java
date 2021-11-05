package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BorrarProductoServlet")
public class BorrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BorrarProductoServlet() {
        super();
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProducto = Integer.parseInt(request.getParameter("txtIdproducto"));//agarramos el id que el usuario intordujo
   		String nombreProducto;
   		double precio;
   		
   		//response.setContentType("text/html");
   		//Eliminamos las salidas por qye solo necesito consultar datos 
   		PrintWriter salida=response.getWriter();
   		
   		//Paso 1 definimos las variables de la  coneccion
   		
   		String url = "jdbc:mysql://localhost:3306/misproductos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   		String nombreusuario = "root";
   		String password = "root";
   		
   		//Paso 2 Definimos los obhetos de la coneccion
   		Connection conn=null;
   		Statement stmnt=null;
   		int isRegistroBorrado=0;
   		
   		//Paso 3 Definimos la estructura del try catch y cerramos los objetos de la coneccion a la base de datos
   		try
   		{
   			//Paso 4 Creamos la instancia del Driver para java 10 
   			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
   			
   			//PAso 5
   			//Avrimos la connecion con el driver manager
   			
   			conn=DriverManager.getConnection(url, nombreusuario, password);
   			//Paso 6 
   			//Creamos el objeto Statement
   			stmnt = conn.createStatement();
   			
   			//Paso 7 Ejecutamos la sentencia sql
   			isRegistroBorrado= stmnt.executeUpdate("delete from productos where IdProducto="+idProducto);
   			
   			//Paso 8  Leer del result set la informacion obtenida
   			//Me ubico en el primer registro del query
   			
   			if (isRegistroBorrado!=0) 
   			{
   				salida.println("Registro borrado Exito");
   			}
   			else
   			{
   				salida.print("No borrado");
   			}
   			//rs.next();
   			//idProducto=rs.getInt("idProducto");//Extraigo su id nombre y precio
   			//nombreProducto = rs.getString("NombreProducto");
   			//precio=rs.getDouble("precio");
   			
   			//request.setAttribute("idProducto", idProducto);
   			//request.setAttribute("nombreProducto", nombreProducto);
   			//request.setAttribute("Precio", precio);
   			
   			//Redireccionamos a Editar Producto.jsp
   			//RequestDispatcher view = request.getRequestDispatcher("EditarProducto.jsp");//dispacher llena el request desspacha una peticion a Editarproductos.jsp
   			//view.forward(request, response);//Son los parametros que cachamos con el servlet .forward significa enviar
   			
   			//salida.print("Id Producto:" + idProducto);
   			//salida.print("Nombre Producto:" + nombreProducto);
   			//salida.print("Precio Producto:" + precio);
   			
   			//while (rs.next())
   		//	{
   			//	salida.print("Id Producto: " + rs.getInt("IdProducto")+" ");
   				//salida.print("Nombre Producto: " + rs.getString("NombreProducto")+" ");
   				//salida.print("Precio Producto: " + rs.getDouble("precio")+" ");
   			//}
   			
   		}
   		catch(Exception e)
   		{
   			e.printStackTrace();
   		}
   		finally
   		{
   			try
   			{
   				//rs.close();
   				stmnt.close();
   				conn.close();
   			}
   			catch(SQLException e)
   			{
   			e.printStackTrace();	
   			}
   			
   		}
   		salida.print("<a href=\"Index.jsp\">Regresar</a>");
   		salida.close();
   		
   		
   		
   		
   	}

   }
