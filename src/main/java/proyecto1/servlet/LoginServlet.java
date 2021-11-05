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
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//le decimos al objeto response que voy a generar una pagina html
		response.setContentType("text/html");
		//Creamos el objetp printwriter para generar una salida
		PrintWriter salida= response.getWriter();
		request.getRequestDispatcher("links.jsp").include(request, response);
		
		//nos traemos el contenido de los textboxes
		String usuarios=request.getParameter("txtusername");
		String passwords=request.getParameter("txtPassword");
		int IdCliente = Integer.parseInt(request.getParameter("txtIdCliente"));
		String NombreCliente = request.getParameter("txtNombreCliente");
		
		String url="jdbc:mysql://localhost:3306/misproductos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario="root";
		String password="root";
		
		Connection conn=null;
		PreparedStatement stmnt = null;
		int isRecordSaved=0;
		
		try
		{
			//Paso 4 Instanciar controlador
			Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
			
			//Paso 5 Abrir la conecion
			conn=DriverManager.getConnection(url, usuario, password);
			
			//Paso 6 Crear el satatement
			stmnt =conn.prepareStatement("insert into usuarios values(?,?,?,?)");
			
			//Paso 6.1 Asignar los valores de cada statement
			stmnt.setInt(1, IdCliente);
			stmnt.setString(2, NombreCliente);
			stmnt.setString(3, usuarios);
			stmnt.setString(4, passwords);
			
			//stmnt.setInt(3, FechaNacimiento);
			
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
		salida.print("<a href=\"Index.jsp\">Regresar</a>");
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
		
		
		/*
		if (password.equals(""))
		{
			salida.print("Bienvenido"+usuario);
			HttpSession objSesion = request.getSession();
			objSesion.setAttribute("usuario", usuario);
			
		}
		else
		{
			salida.println("Lo siento, Pelas");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		salida.close();
		
	}

}*/
