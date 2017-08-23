import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String database = "thingspeak";
		String user = "root";
		String pw = "mysql";
		SQLSocket sqlSoc = new SQLSocket();
		sqlSoc.setupConnection(database, user, pw);
		sqlSoc.connectToDatabase();
		
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

     
		System.out.println("THIS WILL OUTPUT TO THE CONSOLE");
		System.out.println("FirstName:" + request.getParameter("fname"));
		System.out.println("LastName:" + request.getParameter("lname"));


	}
	

}