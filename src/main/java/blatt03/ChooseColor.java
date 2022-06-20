package blatt03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;


@WebServlet("/choosecolor")
public class ChooseColor extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ChooseColor() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		String color = req.getParameter("color");
		if(color != null && color != "") {
			res.setContentType("text/html");
			out.print(zweiteSeite(color));
			HttpSession session = req.getSession(true);
			if (session.isNew()) {
				Cookie co = new Cookie("color", color);
			session.setAttribute("color", color);
			session.setAttribute("points", 0);
			session.getAttribute(color);
			co.setMaxAge(60*30*24);
			req.setAttribute("color", color);
			}
		}
		else res.sendRedirect( "blatt03.html" );
		
		
		
		
//	    Vector<String> data = (Vector<String>) session.getAttribute("color");
//		String[] selection = req.getParameterValues("color");
//		if (selection != null) {
//		for (String s: selection) {
//		data.addElement("value: " + s + " ("
//		+ new Date() + ")");
//		}
//		}
	}
	
	String zweiteSeite(String color) {
		return "<body bgcolor="+color+ "> <h3> Heyy schöne Auswahl! </h3>"
				+"<img width=\"600\" height=\"600\"src='https://www.spuersinn24.de/images/product_images/popup_images/FAIRWERK-Geschicklichkeitsspiel-Holzspiel-SNAP--10298_2.jpg'>"
				+ " </body></html>";
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
