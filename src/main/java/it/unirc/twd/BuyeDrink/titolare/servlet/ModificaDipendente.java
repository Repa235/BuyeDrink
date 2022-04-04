package it.unirc.twd.BuyeDrink.titolare.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;

/**
 * Servlet implementation class ModificaDipendente
 */
@WebServlet("/ModificaDipendente")
public class ModificaDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDipendente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/ModificaDipendente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();

		String tipo = (String) session.getAttribute("categoria");
		
		if(session.getAttribute("autenticato")!=null && tipo.equals("titolare") ) {

		String idMagazziniere=request.getParameter("idMag");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email=request.getParameter("e_mail");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		
	if(password.equals(password2)) {
		
	

		Magazziniere magazziniere=new Magazziniere(Integer.parseInt(idMagazziniere),nome,cognome,email,password,0, null);
	    MagazziniereDAO d=new MagazziniereDAO();
	    d.modificaMagazziniere(magazziniere);
	    response.sendRedirect("ProfiloTitolare");
	    
	    
	
	}
	else {
		
		Vector<Magazziniere> dip = new Vector<Magazziniere>();

		MagazziniereDAO md = new MagazziniereDAO();

		dip = md.getMagazzinieri();

		request.setAttribute("dipendenti", dip);

		
		String errorepass="la password deve essere uguale";
		request.setAttribute("errore", "pw");
		request.setAttribute("errore-pass", errorepass);
		request.getRequestDispatcher("WEB-INF/ModificaDipendente.jsp").forward(request, response);
		
	}
		}
		else {
			response.sendRedirect("PreLogin");
		}
		}
		
	}
