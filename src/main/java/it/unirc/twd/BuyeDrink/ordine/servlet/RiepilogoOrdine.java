package it.unirc.twd.BuyeDrink.ordine.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.unirc.twd.BuyeDrink.ordine.Ordine;
import it.unirc.twd.BuyeDrink.ordine.OrdineDAO;



/**
 * Servlet implementation class MieiOrdini
 */
@WebServlet("/RiepilogoOrdine")
public class RiepilogoOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RiepilogoOrdine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      
		
	 
     
		
        
		String codiceordine=request.getParameter("codiceordine");
		Ordine o=new Ordine(null,0,Integer.parseInt(codiceordine),0,0,null);
		Vector<Ordine> ordine = new Vector<Ordine>();
		OrdineDAO d=new OrdineDAO();
		ordine = d.getOrdiniByCod(o);
        for(Ordine or:ordine) {
        	Date data1=or.getData_stats();
        	request.setAttribute("data", data1);
        }
         
		request.setAttribute("ordini", ordine);
		
		request.setAttribute("codiceordine", codiceordine);

		request.getRequestDispatcher("WEB-INF/RiepilogoOrdine.jsp").forward(request, response);
	}














	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub





	}}








