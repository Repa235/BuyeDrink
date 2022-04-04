package it.unirc.twd.BuyeDrink.cliente.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyEdrink.dao.utils.CheckAccount;

import it.unirc.twd.BuyeDrink.cliente.Cliente;
import it.unirc.twd.BuyeDrink.cliente.ClienteDAO;


/**
 * Servlet implementation class ModificaProfilo
 */
@WebServlet("/ModificaProfilo")
public class ModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProfilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		// Controllo autenticazione dell'utente
		HttpSession session = request.getSession();
		if(!CheckAccount.clienteAutenticato(session)) {
			response.sendRedirect(CheckAccount.PAGINA_SESSIONE_NON_VALIDA);
			return;
		}


		String tipo = (String) session.getAttribute("categoria");

		if(session.getAttribute("autenticato")!=null && tipo.equals("cliente") ) {

			// Recupero le informazioni relative all'utente
			String chiave=(String)session.getAttribute("autenticato");

			Cliente cliente=new Cliente();
			cliente.setE_mail(chiave);

			ClienteDAO d=new ClienteDAO();
			d.getCliente(cliente);

			request.setAttribute("ProfiloCliente", cliente);
			request.getRequestDispatcher("WEB-INF/ModificaProfilo.jsp").forward(request, response);

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

		// Controllo autenticazione dell'utente
		HttpSession session = request.getSession();
		if(!CheckAccount.clienteAutenticato(session)) {
			response.sendRedirect(CheckAccount.PAGINA_SESSIONE_NON_VALIDA);
			return;

		}

		String e_mail=request.getParameter("e_mail");
		String id_Cliente=request.getParameter("id_cliente");
		String nuovaPassword=request.getParameter("password");

		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String partita_Iva=request.getParameter("partita_Iva");	
		String codice_Fiscale=request.getParameter("codice_Fiscale");

		String fidelity=request.getParameter("fidelity");
		String via=request.getParameter("via");
		String numero_Civico=request.getParameter("numero_Civico");

		ClienteDAO d=new ClienteDAO();


		Cliente cliente = new Cliente(id_Cliente,nome,cognome,partita_Iva,codice_Fiscale,e_mail,1,via,Integer.parseInt(numero_Civico),nuovaPassword);

		Cliente c1=new Cliente();
		String emailv = (String) session.getAttribute("autenticato");
		c1.setE_mail(emailv);
		d.getCliente(c1);




		if(cliente.check(nuovaPassword)){

			d.ModificaCliente(cliente);
			System.out.println("modificato");
			response.sendRedirect("Logout");


		}else {

			String errore="w";
			String errorepass="la password non rispetta i criteri";



			request.setAttribute("ProfiloCliente", c1);
			request.setAttribute("errore",errore);
			request.setAttribute("errorepass", errorepass);




			request.getRequestDispatcher("WEB-INF/ModificaProfilo.jsp").forward(request, response);
		}


	}
}