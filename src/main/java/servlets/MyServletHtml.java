package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet")
public class MyServletHtml extends HttpServlet {
	static final long serialVersionUID = 1L;
	
	private int counter = -999;

	protected synchronized int getCounter() {
		return counter;
	}

	protected synchronized void incrCounter() {
		++counter;
	}

	protected synchronized void resetCounter() {
		counter = 0;
	}

	@Override
	public void service(HttpServletRequest requ, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		@SuppressWarnings("unchecked")
	//	Map<String, Object> model = (Map<String, Object>)requ.getAttribute("parameters");
		String name_ = requ.getParameter("name");
		out.println("<html>");
		out.print("<body style='color:blue'>");
		out.println("<h3> Hello from MyServletHtml! </h3>");
		
		Enumeration<String> en = requ.getParameterNames();
		if(en.hasMoreElements()) {
			out.print("<ul>");
			while (en.hasMoreElements()) {
				final String name = en.nextElement();
				final String value = requ.getParameter(name);
				
				out.print("<li>"+name);
				out.print(" : ");
				out.print(value + "</li>");
			}
			out.println("</ul>");
		}
		
		//out.println("<a href='/web-prog/'>Go back!</a>");
		out.println("</body></html>");
		out.close();
	}

	protected String makeCounterAnchor(HttpServletResponse response) {
		
		String uri = getClass().getName() + "?counter value=" + getCounter();
		
		String html = "<center><h2>" + "<a href=\"" + response.encodeURL(uri) + "\">" + getCounter()
				+ ". call of this servlet" + "</a>" + "</h2></center>";
		return html;
	}

//	protected String makeParameterList(HttpServletRequest request) {
//		String html = "<h3>Parameters</h3>";
//		Enumeration<String> en = request.getParameterNames();
//		if (en.hasMoreElements()) {
//			html += "<table border=\"1\">" + "<th align=\"center\">name</th>" + "<th align=\"center\">value</th>";
//			while (en.hasMoreElements()) {
//				final String name = en.nextElement();
//				final String value = request.getParameter(name);
//				html += "<tr><td align=\"center\">" + name + "</td>" + "<td align=\"center\">" + value + "</td></tr>";
//			}
//			html += "</table>";
//		} else {
//			html += "none";
//		}
//		return html;
//	}
//
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		incrCounter();
//		String titleString = "This is a counter with a link...";
//		String html = "<html><head><title>" + titleString + "</title></head><body><center>" + "<h1>Counter Servlet</h1>"
//				+ makeCounterAnchor(response) + makeParameterList(request) + "</center></body></html>";
//		out.println(html);
//		out.close();
//	}

	//
	@Override
	public void destroy() {
		// killt die TomCat virtuelle Maschine Also nicht empfohlen
		System.exit(1);
	}
}
