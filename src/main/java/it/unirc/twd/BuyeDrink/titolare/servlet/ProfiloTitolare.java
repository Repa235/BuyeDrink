package it.unirc.twd.BuyeDrink.titolare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.Statistiche.Statistiche;
import it.unirc.twd.BuyeDrink.Statistiche.StatisticheDAO;
import it.unirc.twd.BuyeDrink.titolare.Titolare;
import it.unirc.twd.BuyeDrink.titolare.TitolareDAO;



/**
 * Servlet implementation class ProfiloTitolare
 */
@WebServlet("/ProfiloTitolare")
public class ProfiloTitolare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfiloTitolare() {
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
			response.sendRedirect("LoginTitolare");

		}else if(session.getAttribute("categoria").equals("titolare")) {

			String email = (String )session.getAttribute("autenticato");

			Titolare titolare = new Titolare();

			titolare.setEmail(email);

			TitolareDAO td = new TitolareDAO();

			titolare = td.getTitolare(titolare);

			Statistiche s=new Statistiche();
			StatisticheDAO da=new StatisticheDAO();
			s.setIncasso(da.IncassoMedio());
			double incassoMedio=s.getIncasso();

			request.setAttribute("incasso", incassoMedio);

			request.setAttribute("profilotitolare", titolare);

			System.out.println("titolare settato");

			request.getRequestDispatcher("/WEB-INF/ProfiloTitolare.jsp").forward(request,response);

		}
		else {
			response.sendRedirect("PreLogin");
		}

	}
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
