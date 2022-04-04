package it.unirc.twd.BuyeDrink.prodotto.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.prodotto.Prodotto;
import it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO;


/**
 * Servlet implementation class VisualizzaProdotti
 */
@WebServlet("/VisualizzaProdotti")
public class VisualizzaProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaProdotti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	
	
	  
	    
		Vector<Prodotto> prodotti = new Vector<Prodotto>();
		
		ProdottoDAO d=new ProdottoDAO();
		prodotti = d.getProdotti();
		 
		
		request.setAttribute("prodotto", prodotti);
		
		request.getRequestDispatcher("/WEB-INF/VisualizzaProdotti.jsp").forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
