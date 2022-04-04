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
 * Servlet implementation class AggiungiProdotto
 */
@WebServlet("/AggiungiProdotto")
public class AggiungiProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiProdotto() {
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

		if(session.getAttribute("autenticato")!=null && (tipo.equals("titolare"))) {

			request.getRequestDispatcher("WEB-INF/AggiungiProdotto.jsp").forward(request, response);

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




		String quantità=request.getParameter("quantità");
		String prezzo=request.getParameter("prezzo");
		String codice=request.getParameter("codice");
		String marca=request.getParameter("marca");
		String nome=request.getParameter("nome");


		Prodotto prodotto=new Prodotto(Integer.parseInt(quantità),Integer.parseInt(codice),marca,nome,Double.parseDouble(prezzo));
		ProdottoDAO d=new ProdottoDAO();
		d.salvaProdotto(prodotto);
		response.sendRedirect("ProfiloTitolare");
       
























	}

}
