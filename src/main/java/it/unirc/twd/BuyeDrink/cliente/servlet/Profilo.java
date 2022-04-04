package it.unirc.twd.BuyeDrink.cliente.servlet;



import java.io.IOException;
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


/**
 * Servlet implementation class Profilo
 */
@WebServlet("/Profilo")
public class Profilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profilo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		if(session.getAttribute("autenticato")==null) {
			response.sendRedirect("Login");

		}else if(session.getAttribute("categoria").equals("cliente")) {
			String chiave=(String)session.getAttribute("autenticato");

			Cliente cliente=new Cliente();
			cliente.setE_mail(chiave);

			ClienteDAO d=new ClienteDAO();
			cliente=d.getCliente(cliente);
			Ordine od=new Ordine();

			Vector<Ordine>ordiniTotali=new Vector<Ordine>();
			Vector<Ordine>ordiniMensili=new Vector<Ordine>();
			OrdineDAO dao=new OrdineDAO();
			ordiniTotali=dao.getOrdiniMensili();
			//	int meseCorrente=od.data().getMonth();
			//int annoCorrente=od.data().getYear();

			for(Ordine o:ordiniTotali) {
				if(o.getId_Cliente().equals(cliente.getId_Cliente())) {
					ordiniMensili.add(o);

				}
				request.setAttribute("ordiniMese",ordiniMensili);
			}




			String accesso=null;
			Cookie cookie=null;
			Cookie[] cookies=request.getCookies();

			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					if(cookies[i].getName().equals("accesso")){
						cookie=cookies[i];
						accesso=cookie.getValue();
						//System.out.println(""+cookie.getMaxAge());
  request.setAttribute("ultimAcc", accesso);
					}


				}






				
			}

			request.setAttribute("ProfiloCliente", cliente);
			request.getRequestDispatcher("WEB-INF/ProfiloCliente.jsp").forward(request, response);

		}
		else {
			response.sendRedirect("PreLogin");
		}


	}
}
