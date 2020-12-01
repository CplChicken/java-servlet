

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomFactServlet
 */
public class RandomFactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int hits = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomFactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		hits++;
		ArrayList<String> facts = new ArrayList<String>();
		PrintWriter pw = response.getWriter();
		InputStream stream = getServletContext().getResourceAsStream("WEB-INF/facts.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		Random rand = new Random();
		
		while ((line=reader.readLine()) != null) {
			facts.add(line);
		}
		
		int i = rand.nextInt(10) + 1;
		
		pw.append("<html><head><title>Random Fact</title></head><body><h1>Fact of the Day</h1>");
		
		pw.append("<p>" + facts.get(i) + "</p>" + "<br/>");
		pw.append("<p>Site Hits = " + hits + "</p>");
		pw.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
