package it.unirc.twd.BuyeDrink.prodotto.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import it.unirc.twd.BuyeDrink.prodotto.Prodotto;


/**
 * Servlet implementation class EliminaDaCarrello
 */
@WebServlet("/EliminaDaCarrello")
public class EliminaDaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaDaCarrello() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		HttpSession session = request.getSession();

		String codice = request.getParameter("id"); 
		int q=Integer.parseInt(request.getParameter("quant"));
		String n=request.getParameter("n");
		String m=request.getParameter("m");
		double pr=Double.parseDouble(request.getParameter("p"));
		Prodotto p= new Prodotto(q,Integer.parseInt(codice),n,m,pr);





		if(codice!=null) {

			if(session.getAttribute("carrello")!=null) {
				Vector<Prodotto>carrello=(Vector<Prodotto>)session.getAttribute("carrello");
				Iterator<Prodotto> iter = carrello.iterator();
				while(iter.hasNext()) {
					Prodotto p2=iter.next();



					if(p2.getCodice()==p.getCodice()) {
						iter.remove();

					}

				}
				if(carrello.isEmpty()) {
					carrello=null;
				}


				session.setAttribute("carrello", carrello);
				response.sendRedirect("Carrello"); 

			}


		}





	}


	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
