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
 * Servlet implementation class Carrello
 */
@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Carrello() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String codice = request.getParameter("id");
		String quant=request.getParameter("quant");
		HttpSession session = request.getSession();





		if(codice!=null) {


			Prodotto p= new Prodotto(0,Integer.parseInt(codice),"","",0);

			ProdottoDAO pd = new ProdottoDAO();

			Prodotto p2=pd.getProdotto(p);

			if(session.getAttribute("carrello")==null ) {

				Vector<Prodotto>carrello=new Vector<Prodotto>();

				p2.setQuantitá(Integer.parseInt(quant));

				carrello.add(p2);


				session.setAttribute("carrello", carrello);
				System.out.println(carrello);
			}
			else {
				Vector<Prodotto>carrello=(Vector<Prodotto>)session.getAttribute("carrello");
				if(!carrello.contains(p2)) {
					p2.setQuantitá(Integer.parseInt(quant));
					carrello.add(p2);

					session.setAttribute("carrello", carrello);

					System.out.println(carrello);

				}

				else {
					System.out.println("prodotto già presente");
				}
			}

		}

		response.sendRedirect("VediCarrello");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
