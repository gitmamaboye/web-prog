package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServletXml
 */
public class MyServletXml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletXml() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   resp.setContentType( "text/xml;charset=UTF-8" );
		      PrintWriter out = resp.getWriter();
		      out.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		      out.append( "<h3> Hello from MyServletXml! </h3>" );
		      out.append( "<a href='/web-prog/'>Go back!</a>" );
		      out.append( "</xml>" );
		      out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
