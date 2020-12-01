

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorldTimeServlet
 */
public class WorldTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorldTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String location = request.getParameter("location"); 
        PrintWriter pw = response.getWriter();
        
        format.setTimeZone(TimeZone.getTimeZone(location));
        
        if (location == null) {
        	TimeZone timezone = TimeZone.getDefault();
        	pw.append("<html><body><p>" + timezone + " Time: " + format.format(date) + "</p></body></html>");
        	pw.append("<form action=\"/project4/WorldTime.html\">" + "<button type=\"submit\">Go Back</button>"+ "</form>");
        }
        else {
        	pw.append("<html><body><p>" + location + " Time: " + format.format(date) + "</p></body></html>");
        	pw.append("<form action=\"/project4/WorldTime.html\">" + "<button type=\"submit\">Go Back</button>"+ "</form>");
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
