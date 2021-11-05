package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PerfilServlet")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PerfilServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter salida=response.getWriter();//crea una salida
		
		
		
		HttpSession objSesion = request.getSession();//treame o creame el objeto session
		if(objSesion !=null && objSesion.getAttribute("usuario")!=null)
		{
			request.getRequestDispatcher("links.jsp").include(request, response);//me traigo el contenido de links envia a la pagina se ejecuta y trae el response
			String usuario = (String) objSesion.getAttribute("usuario");//crealo como string
			salida.println("Hola"+usuario+"Bienvendo a tu perfil");
			
		}
		else
		{
			salida.println("Por favor logeate ");
			request.getRequestDispatcher("login.jsp").include(request, response);//me manda a login
			
		}
		salida.close();
		
		
	}

}
