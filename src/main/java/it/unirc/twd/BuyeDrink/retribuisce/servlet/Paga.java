package it.unirc.twd.BuyeDrink.retribuisce.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.ordine.Ordine;
import it.unirc.twd.BuyeDrink.retribuisce.Retribuisce;
import it.unirc.twd.BuyeDrink.retribuisce.RetribuisceDAO;
import it.unirc.twd.BuyeDrink.titolare.Titolare;
import it.unirc.twd.BuyeDrink.titolare.TitolareDAO;

/**
 * Servlet implementation class Paga
 */
@WebServlet("/Paga")
public class Paga extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Paga() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();

		String tipo = (String) session.getAttribute("categoria");

		if(session.getAttribute("autenticato")!=null && tipo.equals("titolare") ) {

			String chiave=(String)session.getAttribute("autenticato");
			Titolare titolare=new Titolare();
			titolare.setEmail(chiave);
			TitolareDAO td = new TitolareDAO();
			titolare = td.getTitolare(titolare);


			String idMag = request.getParameter("idMag");
			String imp = request.getParameter("imp");

			int idM = Integer.parseInt(idMag);			



			Ordine o = new Ordine();

			Retribuisce p = new Retribuisce(titolare.getIdTit(),idM,Double.parseDouble(imp),o.data());

			RetribuisceDAO rd = new RetribuisceDAO();

			rd.salvaPagamento(p);

			response.sendRedirect("ProfiloTitolare");


		}

		else {
			response.sendRedirect("PreLogin");
		}

	}
}