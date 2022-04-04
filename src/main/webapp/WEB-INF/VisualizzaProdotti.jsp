<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.unirc.twd.BuyeDrink.prodotto.Prodotto"%>
<%@page import="java.util.Vector"%>
<%@page import="it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Visualizza Prodotti</title>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="assets/css/Shop.css" />
<link rel="stylesheet" href="assets/css/footer.css" />
<script src="assets/js/Script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

	<%
		Vector<Prodotto> prodotti = (Vector<Prodotto>) request.getAttribute("prodotto");
	
	     Vector<Prodotto>carrello=(Vector<Prodotto>)session.getAttribute("carrello");
	    
	
	%>

<div class="wrapper">
		<h1>I NOSTRI PRODOTTI</h1>
		<br> <br> 
		
		
                 	
		<form method="get" action="Ricerca">
			<input type="text" name="ricerca" value=""
				placeholder="Cerca" style="color: white; width: 87%; " onkeyup="return Cap(event)" />

		</form>
	</div>
    
    
<div class="wrapper">
   
        
   
    <% for(Prodotto p1:prodotti){ 
    String linkimmagine = ("Prodotti/"+p1.getCodice()+".jpg");
    
    if(p1.getQuantitá()>0){
    	
    %>
    
    
    <div class="items">
        <!-- single item -->
        
        
        
        <div class="item">
        
		<div class="zoom pic">
            <img src= "<%= linkimmagine %>" alt="item" width= "200px" height="200px" onclick="Show()" />
           
          
            
             </div>
            <form action="Carrello" method="get">
				<h2>
					<%= p1.getMarca()  %>
					,
					<%= p1.getNome()  %>
				</h2>
				<p>
					Disponibili :
					<%= p1.getQuantitá()  %>
					<br> Prezzo : <em>&#8364;<%= p1.getPrezzo()  %> </em>
				</p>
				<input type="hidden" name="id" value="<%=p1.getCodice() %>">
				<select name="quant">
				<%for(int i=1;i<=p1.getQuantitá();i++){ %>
				<option value="<%=i %>"><%=i %></option>
				<%} %>
				</select>
			<button type="submit"> Aggiungi </button>
			</form>
			</div>


			<% }} %>
			
			
		</div>
         
</div>


             </body>
</html>