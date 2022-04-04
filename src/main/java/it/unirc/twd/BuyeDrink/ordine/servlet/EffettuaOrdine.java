package it.unirc.twd.BuyeDrink.ordine.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;

import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.BuyeDrink.cliente.Cliente;
import it.unirc.twd.BuyeDrink.cliente.ClienteDAO;
import it.unirc.twd.BuyeDrink.ordine.Ordine;
import it.unirc.twd.BuyeDrink.ordine.OrdineDAO;
import it.unirc.twd.BuyeDrink.prodotto.Prodotto;
import it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO;

/**
 * Servlet implementation class EffettuaOrdine
 */
@WebServlet("/EffettuaOrdine")
public class EffettuaOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EffettuaOrdine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Vector<Prodotto> carrello = (Vector<Prodotto>)session.getAttribute("carrello");
		int codiceordine = ((int)(Math.random()*(9999-1000))+1000);



		String chiave=(String)session.getAttribute("autenticato");

		Cliente cliente=new Cliente();
		cliente.setE_mail(chiave);
		ClienteDAO d=new ClienteDAO();
		d.getCliente(cliente);

		String idcliente = cliente.getId_Cliente();
		Ordine or = new Ordine();
		Date dataoggi=or.data();

		Prodotto mod = new Prodotto();

		ProdottoDAO pmod = new ProdottoDAO();

		for (Prodotto p : carrello) {

			int cod = p.getCodice();
			int quant = p.getQuantitá(); 
			double prezzo = (p.getPrezzo()*quant);


			/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:SSSS");
			GregorianCalendar gc=new GregorianCalendar();
			String now=sdf.format(gc.getTime());
*/





			Ordine o = new Ordine(idcliente,cod,codiceordine,prezzo,quant,or.data()) ;
			OrdineDAO od = new OrdineDAO();
			od.salvaOrdine(o);

			mod.setCodice(cod);
			mod = pmod.getProdotto(mod);
			Prodotto mod1 = new Prodotto((mod.getQuantitá()-p.getQuantitá()),cod,mod.getMarca(),mod.getNome(),mod.getPrezzo());
			pmod.modificaQuantProdotti(mod1);




		}
		carrello.setSize(0);

		// Aggiunge l'ordine nella lista degli ultimi ordini effettuati

		String codiceor = Integer.toString(codiceordine);
		/*Cookie cookie = new Cookie("ultimoordine"+(cliente.getId_Cliente()) , codiceor);
		
		cookie.setMaxAge(60*60*24*30); // durata di 30 giorni
		response.addCookie(cookie);
*/

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String oggi = df.format(dataoggi);
		request.setAttribute("oggi", oggi);	
		response.sendRedirect("RiepilogoOrdine?codiceordine="+codiceordine);


     // System.out.println(""+cookie.getMaxAge());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
