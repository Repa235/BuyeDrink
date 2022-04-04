package it.unirc.twd.BuyeDrink.magazziniere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;

/**
 * Servlet implementation class ProfiloMagazzinire
 */
@WebServlet("/ProfiloMagazzinire")
public class ProfiloMagazzinire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfiloMagazzinire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	HttpSession session = request.getSession();

		if(session.getAttribute("autenticato")==null) {
			response.sendRedirect("LoginMagazziniere");

		}else if(session.getAttribute("categoria").equals("dipendente")) {
		
		String email = (String)session.getAttribute("autenticato");
		
		Magazziniere magazziniere = new Magazziniere();
		
		 magazziniere.setEmail(email);
		
		 MagazziniereDAO md = new MagazziniereDAO();
		
		magazziniere = md.getMagazziniere(magazziniere);
		
		request.setAttribute("mag", magazziniere);

		request.getRequestDispatcher("WEB-INF/ProfiloMagazziniere.jsp").forward(request,response);
		
	}
		else {
			response.sendRedirect("PreLogin");
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

	
	
	
	
	
	
	
	
	
	
	
	






