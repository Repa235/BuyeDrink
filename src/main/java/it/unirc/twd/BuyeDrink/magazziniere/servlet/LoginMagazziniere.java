package it.unirc.twd.BuyeDrink.magazziniere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyEdrink.dao.utils.CheckAccount;
import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;

/**
 * Servlet implementation class LoginMagazziniere
 */
@WebServlet("/LoginMagazziniere")
public class LoginMagazziniere extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginMagazziniere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		if(CheckAccount.clienteAutenticato(session)) {
			response.sendRedirect("ProfiloMagazzinire");
			return;
		}

		request.getRequestDispatcher("WEB-INF/LoginMagazziniere.jsp").forward(request,response);
	}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();

		MagazziniereDAO md=new MagazziniereDAO();

		String email = request.getParameter("email");
		String password = request.getParameter("password");


		Magazziniere m= new Magazziniere(0,"","",email,password,0, null);

		if(md.accesso(m)!=null) {
			md.getMagazziniere(m);



			System.out.println("accesso effettuato");
			System.out.println("codice : "  + email);	


			session.setAttribute("autenticato", email);
			session.setAttribute("categoria", "dipendente");

			if(!CheckAccount.clienteAutenticato(session))
				response.sendRedirect(CheckAccount.PAGINA_SESSIONE_NON_VALIDA); 

			response.sendRedirect("ProfiloMagazzinire");
			System.out.println("accesso effettuato : " +  m.getNome() + " " + m.getCognome());

			

		}
		else {
			// La login e' errata
			response.sendRedirect(CheckAccount.PAGINA_LOGIN_ERRATA);
			System.out.println("accesso negato");


		}

	}



}

