package it.unirc.twd.BuyeDrink.cliente.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.cliente.Cliente;
import it.unirc.twd.BuyeDrink.cliente.ClienteDAO;

/**
 * Servlet implementation class AggiungiCliente
 */
@WebServlet("/AggiungiCliente")
public class AggiungiCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

HttpSession s = request.getSession();

if(s.getAttribute("age")!=null){

		request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request,response);
}
else {
	response.sendRedirect("PreHome");
}

	}







	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String e_mail=request.getParameter("e_mail");
		String password=request.getParameter("password");
		String partita_Iva=request.getParameter("partitaIva");
		String codice_Fiscale=request.getParameter("codiceFiscale");
		String fidelity=request.getParameter("fidelity");
		String via=request.getParameter("via");
		String numero_Civico=request.getParameter("civico");
		
		
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		request.setAttribute("e_mail", e_mail);
		request.setAttribute("partitaIva", partita_Iva);
		request.setAttribute("codiceFiscale", codice_Fiscale);
		request.setAttribute("via", via);
		request.setAttribute("numeroCivico", numero_Civico);
	    
		
			Cliente c=new Cliente();
			boolean pass=c.check(password);
			boolean part=c.controlloPart(partita_Iva);
			ClienteDAO dao=new ClienteDAO();
			
			
			
			if(pass&&part) {
				
				
				
				Cliente cliente=new Cliente("",nome,cognome,partita_Iva,codice_Fiscale,e_mail,0,via,Integer.parseInt(numero_Civico),password);
				int uguali = dao.ContaCliente(cliente);
				
				if(uguali==0){
					System.out.println(uguali);
					dao.salvaCliente(cliente);
					
					response.sendRedirect("Successo");
				}
				
				else {
					
					String errore="m";
					String erroremail="La mail inserita è già presente nel notro sistema";
					
					request.setAttribute("nome", nome);
					request.setAttribute("cognome",cognome);
					request.setAttribute("password", password);
					request.setAttribute("partitaIva",partita_Iva);
					request.setAttribute("codiceFiscale",codice_Fiscale);
					request.setAttribute("via", via);
					request.setAttribute("civico",numero_Civico);
					request.setAttribute("errororem", erroremail );
					request.setAttribute("errore", errore);
					
					request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request, response);
                  				
				}
				
				
			
		 
		 }
			else if(pass && !part) {
				
				
				String errorepart="La partita iva inserita non è valida";
				String errore="pi";
				
				
				request.setAttribute("errorepart", errorepart);
				request.setAttribute("errore", errore);
				
				request.setAttribute("nome", nome);
				request.setAttribute("cognome",cognome);
				request.setAttribute("email", e_mail);
				request.setAttribute("password", password);
				request.setAttribute("partitaIva",partita_Iva);
				request.setAttribute("codiceFiscale",codice_Fiscale);
				request.setAttribute("via", via);
				request.setAttribute("civico",numero_Civico);

				request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request, response);
				
			} else if(!pass&&part) {
				String	 errorepass="Password non valida: Essa deve contenere almeno 8 caratteri,Un numero,Una lettera maiuscola,una minuscola e non può contenere spazi";
				String errore="pw";
				request.setAttribute("errorepass", errorepass);
				request.setAttribute("errore", errore);
				
				request.setAttribute("nome", nome);
				request.setAttribute("cognome",cognome);
				request.setAttribute("email", e_mail);
				request.setAttribute("password", password);
				request.setAttribute("partitaIva",partita_Iva);
				request.setAttribute("codiceFiscale",codice_Fiscale);
				request.setAttribute("via", via);
				request.setAttribute("civico",numero_Civico);

				request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request, response);
	    
			} else if(!pass&&!part) {

				String errorepass="Password non valida: Essa deve contenere almeno 8 caratteri,Un numero,Una lettera maiuscola,una minuscola e non può contenere spazi";
				String errorepart="La partita iva inserita non è valida";
	            String errore="pipw";
	            request.setAttribute("errorepart", errorepart);
				request.setAttribute("errorepass", errorepass);
			    request.setAttribute("errore", errore);
				
				request.setAttribute("nome", nome);
				request.setAttribute("cognome",cognome);
				request.setAttribute("email", e_mail);
				request.setAttribute("password", password);
				request.setAttribute("partitaIva",partita_Iva);
				request.setAttribute("codiceFiscale",codice_Fiscale);
				request.setAttribute("via", via);
				request.setAttribute("civico",numero_Civico);

			    
			    request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request, response);
			}
		
	
	}  

	}

			
	/*	if(ok) {
			
	     
				
	        	
         
		ClienteDAO d=new ClienteDAO();
		Cliente cliente=new Cliente("",nome,cognome,partita_Iva,codice_Fiscale,e_mail,0,via,Integer.parseInt(numero_Civico),password);
	       
	        
		d.salvaCliente(cliente);
		response.sendRedirect("Login");
		}
		else {
			
			String errorepw="la password inserita non è valida : essa deve contenere almeno 8 caratteri di cui, un carattere maiuscolo,un carattere minuscolo e un numero . ";
			
			request.setAttribute("nome", nome);
			request.setAttribute("cognome", cognome);
			request.setAttribute("e_mail", e_mail);
			request.setAttribute("partitaIva", partita_Iva);
			request.setAttribute("codiceFiscale", codice_Fiscale);
			request.setAttribute("via", via);
			request.setAttribute("numeroCivico", numero_Civico);
			
			
			request.setAttribute("errorepw", errorepw);
			request.getRequestDispatcher("WEB-INF/AggiugniCliente.jsp").forward(request, response);
		    
		}
	  */      
	

