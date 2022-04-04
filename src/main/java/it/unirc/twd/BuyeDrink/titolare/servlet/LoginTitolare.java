package it.unirc.twd.BuyeDrink.titolare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buyEdrink.dao.utils.CheckAccount;
import it.unirc.twd.BuyeDrink.titolare.Titolare;
import it.unirc.twd.BuyeDrink.titolare.TitolareDAO;


/**
 * Servlet implementation class LoginTitolare
 */
@WebServlet("/LoginTitolare")
public class LoginTitolare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTitolare() {
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
			response.sendRedirect("ProfiloTitolare");
			return;
		}
		
request.getRequestDispatcher("WEB-INF/LoginTitolare.jsp").forward(request,response);


	}
		
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		TitolareDAO td=new TitolareDAO();
		
		String email = request.getParameter("mail");
		String password = request.getParameter("password");
	
		Titolare t = new Titolare(0, "", "", email, "","", password);
		
		if(td.accesso(t)!=null) {
			td.getTitolare(t);
			
			
		
			System.out.println("accesso effettuato");
			System.out.println("Titolare codice : "  + email);	
			
			session.setAttribute("categoria", "titolare");
			session.setAttribute("autenticato", email);
			
			if(!CheckAccount.clienteAutenticato(session))
				response.sendRedirect(CheckAccount.PAGINA_SESSIONE_NON_VALIDA);
			
			response.sendRedirect("ProfiloTitolare");
			System.out.println("accesso effettuato : " +  t.getNome() + " " + t.getCognome());

		}
		else {
			// La login e' errata
			response.sendRedirect(CheckAccount.PAGINA_LOGIN_ERRATA);
			System.out.println("accesso negato");
			
			
		}
		
	
		
	}
		
		

	}


