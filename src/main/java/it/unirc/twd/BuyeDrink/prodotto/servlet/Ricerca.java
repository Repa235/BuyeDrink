package it.unirc.twd.BuyeDrink.prodotto.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unirc.twd.BuyeDrink.prodotto.Prodotto;
import it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ricerca() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		String marca=request.getParameter("ricerca");

		ProdottoDAO d=new ProdottoDAO();
		Prodotto p2=new Prodotto(0,0,marca,"",0);

		Prodotto p3=d.RicercaProdotto(p2);





		request.setAttribute("trovato", p3);
		request.getRequestDispatcher("WEB-INF/VisualizzaProdottiCercati.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
}