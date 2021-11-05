package proyecto1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogoutServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");//setcontenttype genera todo lo del bodyes para crear en automatico de los text
		PrintWriter salida= response.getWriter();//te genera todo lo del body
		request.getRequestDispatcher("links.jsp").include(request, response); 
		HttpSession objSesion = request.getSession();
		objSesion.invalidate();
		
		salida.print("Has sido sacado del sistema ");
		salida.close();
		
	}

}
