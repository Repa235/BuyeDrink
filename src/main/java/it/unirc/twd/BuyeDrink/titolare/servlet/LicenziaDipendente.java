package it.unirc.twd.BuyeDrink.titolare.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.magazziniere.Magazziniere;
import it.unirc.twd.BuyeDrink.magazziniere.MagazziniereDAO;
import it.unirc.twd.BuyeDrink.retribuisce.RetribuisceDAO;
import it.unirc.twd.BuyeDrink.titolare.Titolare;

/**
 * Servlet implementation class LicenziaDipendente
 */
@WebServlet("/LicenziaDipendente")
public class LicenziaDipendente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicenziaDipendente() {
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
    	
    	
		String chiave=(String)session.getAttribute("autenticato");
		Titolare titolare=new Titolare();
		titolare.setEmail(chiave);

        String idMagazziniere=request.getParameter("idMagazziniere");
        
		Magazziniere magazziniere=new Magazziniere(Integer.parseInt(idMagazziniere),"","","","",0, null);
		
		
	    MagazziniereDAO d=new MagazziniereDAO();
	    RetribuisceDAO d1=new RetribuisceDAO();
	    d1.eliminaPagamento(null, magazziniere);
        d.eliminaMagazziniere(magazziniere);
        response.sendRedirect("VisualizzaDipendenti");
        
        
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
