package it.unirc.twd.BuyeDrink.prodotto.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.prodotto.Prodotto;
import it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO;

/**
 * Servlet implementation class RichiediModProd
 */
@WebServlet("/RichiediModProd")
public class RichiediModProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RichiediModProd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();

		String tipo = (String) session.getAttribute("categoria");

		if(session.getAttribute("autenticato")!=null && (tipo.equals("titolare") || tipo.equals("dipendente")) ) {

			Vector<Prodotto> prodotti = new Vector<Prodotto>();

			ProdottoDAO d=new ProdottoDAO();
			prodotti = d.getProdotti();


			request.setAttribute("prodotto", prodotti);

			request.getRequestDispatcher("WEB-INF/ModificaProdotto.jsp").forward(request, response);
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
