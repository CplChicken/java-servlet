

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderFormServlet
 */
public class OrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		
		String desc = request.getParameter("description");
		String code = request.getParameter("code");
		String qty = request.getParameter("quantity");
		String delivery = request.getParameter("delivery");
		String id = request.getParameter("id");
		
		if ("Same Day".equals(delivery)) {
			delivery = "Same Day";
		}
		else if ("Express".equals(delivery)) {
			delivery = "Express";
		}
		else if ("Standard".equals(delivery)) {
			delivery = "Standard";
		}
		
		pw.append("<html><head><title>LoginServlet</title></head><body><h1>Testing doPost...</h1><p>description = ");
		pw.append(desc);
		pw.append("</p><p>productCode = ");
		pw.append(code);
		pw.append("</p><p>quantity = ");
		pw.append(qty);
		pw.append("</p><p>delvieryMode = ");
		pw.append(delivery);
		pw.append("</p><p>customerNumber = ");
		pw.append(id);
		pw.append("</p></body></html>");
	}

}
