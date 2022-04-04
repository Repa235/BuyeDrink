<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="it.unirc.twd.BuyeDrink.prodotto.Prodotto" %>
      <%@page import="java.util.Vector"%>
      <%@page import="it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO" %>
      <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cercato</title>
<%@ include file="/header.jsp"%>
	
    	<link rel="stylesheet" href="assets/css/Shop.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



</head>
<body>



<%

Prodotto trovato =(Prodotto)request.getAttribute("trovato");

%>


			




    
     
     <%if(trovato.getQuantitá()>0){ %>
     <div class="wrapper">
     <h1> Prodotto : </h1>  
     
     
</div>

    <div class="clear"></div>
    <!-- items -->
    <% 
    String linkimmagine = ("Prodotti/"+trovato.getCodice()+".jpg");
        %>
    
    
    <div class="items">
        <!-- single item -->
        <div class="item">

				<div class="zoom pic">
					<img src="<%= linkimmagine %>" alt="item" width="200px"
						height="200px" />
				</div>
			<form action="Carrello" method="get">
				<h2>
					<%= trovato.getMarca()  %>
					,
					<%=trovato.getNome()  %>
				</h2>
				<p>
					Disponibili :
					<%= trovato.getQuantitá()  %>
					<br> Prezzo : <em> &#8364; <%= trovato.getPrezzo()  %> </em>
				</p>
				<input type="hidden" name="id" value="<%=trovato.getCodice()%>"> 
				<select name="quant" >
				<%for(int i=1 ; i <=trovato.getQuantitá();i++){%>
				<option value="<%= i %>"><%= i %></option>
				<%}%> 
				</select>
				<button type="submit"> Aggiungi </button>
				</form>

      
	</div>
	</div>

<%} else {   %>
<br>
<br>
<br>
 <h1> Prodotto non trovato o temporaneamente non disponibile </h1>  

<%} %>

</body>
</html>