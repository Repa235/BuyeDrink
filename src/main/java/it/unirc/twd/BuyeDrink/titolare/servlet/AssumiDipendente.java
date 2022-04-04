package it.unirc.twd.BuyeDrink.titolare.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;
import it.unirc.twd.BuyeDrink.ordine.Ordine;
import it.unirc.twd.BuyeDrink.titolare.Titolare;
import it.unirc.twd.BuyeDrink.titolare.TitolareDAO;

/**
 * Servlet implementation class AssumiDipendente
 */
@WebServlet("/AssumiDipendente")
public class AssumiDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AssumiDipendente() {
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
		
		request.getRequestDispatcher("WEB-INF/AggiungiDipendente.jsp").forward(request, response);
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
		HttpSession session=request.getSession();

		String tipo = (String) session.getAttribute("categoria");
		
		if(session.getAttribute("autenticato")!=null && tipo.equals("titolare") ) {

			

				String chiave=(String)session.getAttribute("autenticato");
				Titolare titolare=new Titolare();
				titolare.setEmail(chiave);
				TitolareDAO td = new TitolareDAO();
				titolare = td.getTitolare(titolare);

				Ordine o = new Ordine();

				String nome=request.getParameter("nome");
				String cognome=request.getParameter("cognome");
				String email=request.getParameter("e_mail");
				String password=request.getParameter("password");
				int idTitolare=titolare.getIdTit();

			

				Magazziniere magazziniere=new Magazziniere(0,nome,cognome,email,password,idTitolare,o.data());
				MagazziniereDAO d=new MagazziniereDAO();
				d.salvaMagazziniere(magazziniere);
				response.sendRedirect("ProfiloTitolare");

               


			}
		}
	}

