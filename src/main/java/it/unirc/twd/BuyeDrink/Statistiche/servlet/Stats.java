package it.unirc.twd.BuyeDrink.Statistiche.servlet;


import java.awt.image.RenderedImage;

import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.Statistiche.Statistiche;
import it.unirc.twd.BuyeDrink.Statistiche.StatisticheDAO;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;


/**
 * Servlet implementation class Stats
 */
@WebServlet("/Stats")
public class Stats extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stats() {
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
		
		
		Vector<Statistiche> stat = new Vector<Statistiche>();
		
		StatisticheDAO sd = new StatisticheDAO();
		
		stat=sd.getOrdiniByMonth();
		

		


		  ServletOutputStream os = response.getOutputStream();

		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		  for(Statistiche s : stat) {
		  dataset.addValue(s.getNumOrdini(), Integer.toString(s.getMese()) , Integer.toString(s.getAnno()) );
		  }

		
		  JFreeChart chart = ChartFactory.createBarChart("Vendita Prodotti", "Mese" , "Numero vendite", dataset );
		  chart.setBackgroundPaint(java.awt.Color.WHITE);

		  RenderedImage chartImage = chart.createBufferedImage(600, 600);
		  ImageIO.write(chartImage, "png", os);
		  os.flush();
		  os.close();
		 
		response.setContentType("images/png");
		
		
		
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
		doGet(request, response);
	}

}
