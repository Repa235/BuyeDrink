package it.unirc.twd.BuyeDrink.utenti.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





/**
 * Servlet implementation class PreHome
 */
@WebServlet("/PreHome")
public class PreHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s=request.getSession();
		if(s.getAttribute("age")!=null) {
			response.sendRedirect("Home");
		}
		
		else {
			
		
		
		request.getRequestDispatcher("AgeForm.jsp").forward(request,response);
		
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession ses = request.getSession();
		
		String e = request.getParameter("eta");
		
		if(e.equals("")) {
			request.getRequestDispatcher("AgeForm.jsp").forward(request, response);
			
		}
		else {
		int age = Integer.parseInt(e);
			if(age>=18) {
				response.sendRedirect("Home");
				ses.setAttribute("age", e);

			}
			else {
				response.sendRedirect("https://www.asaps.it/58369-_divieto_di_somministrazione_di_alcolici_ai_minorenni_diventa_legge_nazionale__.html");
			}
			
		
		}
		
		
		
		
		
		
		//doGet(request, response);
	}

}
