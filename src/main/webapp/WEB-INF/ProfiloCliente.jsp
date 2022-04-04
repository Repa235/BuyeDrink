<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unirc.twd.BuyeDrink.cliente.Cliente"%>
<%@ page import="it.unirc.twd.BuyeDrink.ordine.*"%>
<%@page import="java.util.Vector"%>

<%
	Cliente cliente = (Cliente) request.getAttribute("ProfiloCliente");
	Vector<Ordine> ordini = (Vector<Ordine>) request.getAttribute("ordini");
	Vector<Ordine> ordiniMese = (Vector<Ordine>) request.getAttribute("ordiniMese");
	String messaggio = (String) request.getAttribute("ultimAcc");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo Cliente</title>


<link rel="stylesheet" href="assets/css/per_profilo.css" />
<link rel="stylesheet" href="assets/css/dropdown.css" />


<link rel="stylesheet" href="assets/css/bootstrap.min.css" />

<!--  
 <link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet"> 
-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<style>
.show-on-hover:hover>ul.dropdown-menu {
	display: block;
}
</style>


</head>

<body>


	<%@ include file="/header.jsp"%>


	<table style="height: 500px;" width="702px">
		<tbody>
			<tr>
				<td style="width: 186px;">
					<p>
						<strong>BENTORNATO <%=cliente.getNome() + " " + cliente.getCognome()%></strong>
					</p>
					<p span style="color: #ff0000;">
						<em> &nbsp;il tuo ultimo accesso: <%=messaggio%>
					</p>
					<p>&nbsp;</p>
					<p>
						<img src="images/avatar/cristiano.png" width="286px "
							height="260px" />
					</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>

				<td style="width: 360px;">

					<div class="btn-group" style="width: 330px;">
						<button type="button" class="btn btn-danger dropdown-toggle"
							style="width: 400px;" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">I tuoi ordini</button>


						<ul class="dropdown-menu" role="menu" style="width: 400px;">
							<li>
								<%if(ordiniMese==null)  {%>
								<p>Non hai effettuato alcun ordine</p> <%}else{ %> <%for(Ordine o:ordiniMese){ %>
								<p>
									<strong><a
										href="RiepilogoOrdine?codiceordine=<%= o.getCodice_ordine() %>">
											<%=o.getCodice_ordine() %></a></strong>
								</p> <%}} %>




							</li>
						</ul>
					</div>

				</td>


				<!-- INIZIO COLONNA DATI CLIENTE  -->


				</td>
				<td style="width: 89px;"><p6> <strong>&nbsp;
						&nbsp; ID:</strong> </p6>
					<ul>
						<li><%=cliente.getId_Cliente()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Email:</strong> </p6>
					<ul>
						<li><%=cliente.getE_mail()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Via:</strong> </p6>
					<ul>
						<li><%=cliente.getVia()%> , <%=cliente.getNumero_Civico()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Codice fiscale:</strong> </p6>
					<ul>
						<li><%=cliente.getCodice_Fiscale()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; PARTITA IVA:</strong> </p6>
					<ul>
						<li><%=cliente.getPartita_Iva()%></li>
					</ul> <p6> &nbsp; <a href="ModificaProfilo"> Modifica i tuoi
						dati</a> </p6>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p></td>
			</tr>
		</tbody>
	</table>

	<%@ include file="/footer.jsp"%>
</body>
</html>

