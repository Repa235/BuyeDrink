package it.unirc.twd.BuyeDrink.cliente.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyEdrink.dao.utils.CheckAccount;
import it.unirc.twd.BuyeDrink.cliente.Cliente;
import it.unirc.twd.BuyeDrink.cliente.ClienteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
			
			
			response.sendRedirect("Profilo");
			return;
		}

		request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request,response);
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

//		ArrayList<String> messaggiErrore = new ArrayList<String>();




		String e_mail=request.getParameter("e_mail");
		String password=request.getParameter("Password");

		Cliente cliente=new Cliente("","","","","",e_mail,1,"",1,password);
		ClienteDAO d=new ClienteDAO();



		if(d.accesso(cliente) != null) {
			// Aggiungiamo in sessione l'username.
			//Quando e' presente l'utente e' autenticato!  

			HttpSession session=request.getSession();
			session.setAttribute("autenticato", e_mail);
			session.setAttribute("categoria", "cliente");
			
			
			//cookie
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
			java.util.Date date = new GregorianCalendar().getTime();
			String tempogiorno = sdf.format(date);
			String tempoora = sdf1.format(date);
			
			String tempo = tempogiorno + "_" + tempoora;
			
			Cookie cookie=new Cookie("accesso",tempo);
			cookie.setMaxAge(3600*60);
			response.addCookie(cookie);

			if(!CheckAccount.clienteAutenticato(session))
				response.sendRedirect(CheckAccount.PAGINA_SESSIONE_NON_VALIDA);

			
			
			response.sendRedirect("Profilo");
		} else {
			// La login e' errata
			response.sendRedirect(CheckAccount.PAGINA_LOGIN_ERRATA);
		}


	}  

}









