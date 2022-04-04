package it.unirc.twd.BuyeDrink.utenti.servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String a = (String)session.getAttribute("age");
		
		
		if(session.getAttribute("age")==null) {
			request.getRequestDispatcher("AgeForm.jsp").forward(request, response);
		}
		
		
		else {
			int age = Integer.parseInt(a);
		if(age>=18) {
		
		
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}
	
		else {
			request.getRequestDispatcher("AgeForm.jsp").forward(request, response);
		}
		
		
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