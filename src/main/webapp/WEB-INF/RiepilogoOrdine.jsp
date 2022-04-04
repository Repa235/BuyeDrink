<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.unirc.twd.BuyeDrink.ordine.Ordine"%>
<%@ page import="java.util.Vector"%>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<%
	Vector<Ordine> ordine = (Vector<Ordine>) request.getAttribute("ordini");
	String codiceordine = (String) request.getAttribute("codiceordine");
	Date ciao = (Date) request.getAttribute("data");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Riepilogo Ordine</title>
</head>
<body>
	<%@ include file="/header.jsp"%>

	<h1>Il tuo ordine è stato confermato</h1>
	<h1>Ecco un riepilogo del tuo ultimo ordine:</h1>

	<p>
		Codice ordine :
		<%=codiceordine%>
		&nbsp; &nbsp; &nbsp;Data ordine :
		<%=ciao%></p>



	<table>
		<tbody>
			<tr style="height: 21px;">
				<td style="width: 188px; height: 21px;">Codice Prodotto</td>
				<td style="width: 188px; height: 21px;">Quantità</td>
				<td style="width: 188px; height: 21px;">Prezzo</td>
				<td style="width: 188px; height: 21px;">Foto</td>
			</tr>
			<%
				double somma = 0;
				for (Ordine o : ordine) {
					String linkimmagine = ("Prodotti/" + o.getCodice_prodotto() + ".jpg");
			%>
			<tr style="height: 21px;">
				<td style="width: 188px; height: 21px;"><%=o.getCodice_prodotto()%></td>
				<td style="width: 188px; height: 21px;"><%=o.getQuantita_richiesta()%></td>
				<td style="width: 188px; height: 21px;"><%=o.getPrezzo_totale()%></td>
				<td style="width: 188px; height: 21px;">                                                                                                                                                                                                                                                               
				
				<img	src="<%=linkimmagine%>" style="width: 50%;"></td>
			</tr>

			<%
				somma += o.getPrezzo_totale();
				}
			%>

		</tbody>
	</table>

	<h2>
		Totale spesa : &#8364;
		<%=somma%></h2>
	<a href="Home">Torna alla home</a>
	<%@ include file="/footer.jsp"%>
</body>
</html>