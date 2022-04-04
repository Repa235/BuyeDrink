package it.unirc.twd.BuyeDrink.prodotto.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.prodotto.Prodotto;
import it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO;


/**
 * Servlet implementation class ModificaProdotto
 */
@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProdotto() {
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




		String quantitá=request.getParameter("quantitá");
		String prezzo=request.getParameter("prezzo");
		String nome=request.getParameter("nome");
		String marca=request.getParameter("marca");
		String codice=request.getParameter("codice");








		Prodotto prodotto=new Prodotto(Integer.parseInt(quantitá), Integer.parseInt(codice), marca, nome, Integer.parseInt(prezzo));
		ProdottoDAO d=new ProdottoDAO();

		d.modificaProdotto(prodotto);
		response.sendRedirect("ProfiloTitolare");

	}
}

