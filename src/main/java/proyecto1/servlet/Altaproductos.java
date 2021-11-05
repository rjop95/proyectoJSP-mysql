package proyecto1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



/**
 * Servlet implementation class Altaproductos
 */
@WebServlet("/Altaproductos")
public class Altaproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Altaproductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		int idProducto = Integer.parseInt(request.getParameter("txtIdproducto"));
		String nombreProducto = request.getParameter("txtNombreproducto");
		double precio = Double.parseDouble(request.getParameter("txtPrecioproducto"));
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
			//Paso 6 Crear el satatement
			stmnt =conn.createStatement();
			//Paso 7 EJecutar la insercion de datos
			isRecordSaved = stmnt.executeUpdate("insert into productos values("+idProducto+",'"+nombreProducto+"',"+precio+")");
		
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
