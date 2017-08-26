import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String database = "thingspeak";
		String user = "SA";
		String pw = "";
		SQLSocket sqlSoc = new SQLSocket();
		sqlSoc.setupConnection(database, user, pw);
		sqlSoc.connectToDatabase();
		
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String values = "";
		Enumeration<String> parameterNames = request.getParameterNames();
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
//			for (int i = 0; i < paramValues.length; i++) {
			values += "\'" + paramValues[0] + "\',";
//				System.out.println("length: " + paramValues.length);
//				System.out.println("i: " + i);
//				if(i< (paramValues.length -1)){
//					values += ",";
//				}
//			}
			
		}
		values = values.substring(0, values.length() - 1);
		System.out.println(values);
		
		System.out.println("THIS WILL OUTPUT TO THE CONSOLE");
		System.out.println("FirstName:" + request.getParameter("fname"));
		System.out.println("LastName:" + request.getParameter("lname"));

		sqlSoc.pushNewData(values);
	//	out.close();
	}
	

}
