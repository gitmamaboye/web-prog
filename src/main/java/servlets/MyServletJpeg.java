package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Servlet implementation class MyServletJpeg
 */
public class MyServletJpeg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletJpeg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("image/jpeg");

		    //create image
		    int width = 200;
		    int height = 30;
		    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		    //get drawing context
		    Graphics2D g = (Graphics2D) image.getGraphics();
		    g.setColor(Color.GRAY);
		    g.fillRect(0, 0, width, height);

		    //draw a string
		    g.setColor(Color.WHITE);
		    g.setFont(new Font("Dialog", Font.PLAIN, 14));
		    g.drawString("My String!", 10, height / 2 + 4);

		    //draw a border
		    g.setColor(Color.BLACK);
		    g.drawRect(0, 0, width - 1, height - 1);

		    //dispose context
		    g.dispose();

		    //send back image to the client
		    ServletOutputStream sos = response.getOutputStream();
		    //com.sun.image.codec.jpeg.JPEGImageEncoder encoder = JPEGCodec // Compile Time Error, cant find JPEGCodec

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
