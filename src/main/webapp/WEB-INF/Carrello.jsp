<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.unirc.twd.BuyeDrink.prodotto.Prodotto" %>
    <%@page import="java.util.Vector" %>
     <%@page import="it.unirc.twd.BuyeDrink.ordine.Ordine" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrello</title>

<script type="text/javascript" src="/assets/js/Quantity.js"></script>  
</head>
<body>
	<%@ include file="/header.jsp"%>

	<%
		Vector<Prodotto> carrello = (Vector<Prodotto>) session.getAttribute("carrello");
	   String codicer=(String)request.getAttribute("codice");
	   
	%>

	
	<%if (carrello==null || carrello.capacity()==0 || carrello.size()==0){%>
			
			   <h1>carrello vuoto</h1>
			
	
	<a href="VisualizzaProdotti"> Continua lo shopping</a>
	    <% } else {%>
	    <a href="VisualizzaProdotti"> Continua lo shopping</a>
	<table style="height: 251px;" width="587">
		
		
		<tbody>
			<tr style="height: 21px;">
				<td style="width: 188px; height: 21px;"></td>
				<td style="width: 188px; height: 21px;">Prodotto</td>
				<td style="width: 188px; height: 21px;">Quantit&agrave;</td>
				<td style="width: 189px; height: 21px;">Prezzo</td>
				<td style="width: 189px; height: 21px;">Elimina</td>
			</tr>
    
               
			
			<%
				for (Prodotto p : carrello) {
					String linkimmagine = ("Prodotti/" + p.getCodice() + ".jpg");
			%>
              
			
			<tr style="height: 21px;">
				<td style="width: 188px; height: 21px;"><img alt=""
					src="<%=linkimmagine%>" style="width: 80%;"></td>
				<td style="width: 188px; height: 21px;"><%=p.getMarca()%>&nbsp;</td>
				<td style="width: 188px; height: 21px;"><%=p.getQuantitá() %>
		
			
				<td style="width: 189px; height: 21px;">&#8364;<%=p.getPrezzo()%>&nbsp;</td>
				<td style="width: 189px; height: 21px;"><a
					href="EliminaDaCarrello?quant=<%=p.getQuantitá()%>&id=<%=p.getCodice()%>&m=<%=p.getMarca()%>&n=<%=p.getNome()%>&p=<%=p.getPrezzo()%>"> Elimina </a></td>
					<%if (carrello.capacity()<1){
						carrello.removeAllElements();
						%>
					
					<h1>carrello vuoto</h1>
      <%}} %>
      	</tbody>
	</table>
<%
		if (session.getAttribute("autenticato") != null) {
			
	%>
	<a href="EffettuaOrdine">ORDINA PRODOTTI</a>
	
	<%
		}else{%>
	
	<p>
		per confermare l'ordine devi effettuare il <a
			href="Login">Login</a>
	</p>
	<% }}  %>
				
			

</body>
</html>
</html>