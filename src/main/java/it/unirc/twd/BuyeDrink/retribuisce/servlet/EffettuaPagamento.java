package it.unirc.twd.BuyeDrink.retribuisce.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;


/**
 * Servlet implementation class EffettuaPagamento
 */
@WebServlet("/EffettuaPagamento")
public class EffettuaPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EffettuaPagamento() {
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

		if(session.getAttribute("autenticato")!=null && tipo.equals("titolare") ) {

			Vector<Magazziniere> dip = new Vector<Magazziniere>();

			MagazziniereDAO md = new MagazziniereDAO();

			dip = md.getMagazzinieri();

			request.setAttribute("dipendenti", dip);

			request.getRequestDispatcher("WEB-INF/Paga.jsp").forward(request, response);;


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






	}

}
