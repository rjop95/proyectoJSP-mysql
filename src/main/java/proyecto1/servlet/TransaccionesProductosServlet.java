package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TransaccionesProductosServlet")
public class TransaccionesProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TransaccionesProductosServlet() {
        super();
        
}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos los datos del formulario
		//int idProducto = Integer.parseInt(request.getParameter("txtIdproducto"));
		//String nombreProducto = request.getParameter("txtNombreproducto");
	//	double precio = Double.parseDouble(request.getParameter("txtPrecioproducto"));
		
		//Configuramos la salida del objeto response del servidor
		response.setContentType("text/html");
		PrintWriter salida=response.getWriter();
		
		//Seguimos los pasos para bd
		//Declaramos las variables
		String url="jdbc:mysql://localhost:3306/misproductos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario="root";
		String password="root";
		
		//Paso 2 Declaramos los objetos
		Connection conn=null;
		Statement stmnt = null;
		int isRecordSaved=0;//para traer informacion de tabla
		
		//Paso 3 Establecer la estructura del try catch
		
		try
		{
			//Paso 4 Instanciar controlador
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			//Paso 5 Abrir la conecion
			conn=DriverManager.getConnection(url, usuario, password);
			//paso 5,1 Colocamos el autocommit en false para acumular varias ejecuciones de una transaccion
			conn.setAutoCommit(false);
			//Paso 6 Crear el satatement
			stmnt =conn.createStatement();
			try
			{
			//Paso 7 EJecutar las sentencias SQL que queramos
			isRecordSaved = stmnt.executeUpdate("insert into productos values(121,'camisa',250.00)");
			isRecordSaved = stmnt.executeUpdate("insert into productos values(122,'camisa',250.00)");
			isRecordSaved = stmnt.executeUpdate("insert into productos values(123,'camisa',250.00)");
			conn.commit();
			
		}
		catch(SQLException ex)
		{
			System.out.println("Error en la transaccion");
			conn.rollback();
			salida.print("Se hizo un roolback porque alguna instruccion de la transaccion fallo");
		}
			salida.print("</br> <a href=\"Index.jsp\">Regresar</a>");
		}
			catch (Exception e)
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
			System.out.println("Error en la coneccion");
			e.printStackTrace();
		}
		salida.close();
	}
}
		
		
	

