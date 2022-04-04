<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.unirc.twd.BuyeDrink.prodotto.Prodotto"%>
<%@page import="java.util.Vector"%>
<%@page import="it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Prodotti</title>



<%@ include file="/header.jsp"%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



</head>
<body>



	<%
Vector<Prodotto>prodotti= (Vector<Prodotto>)request.getAttribute("prodotto");
%>

<table>
<tbody>


<tr>
<td>Foto</td>
<td>ID</td>
<td>Marca</td>
<td>Nome</td>
<td>Prezzo</td>
<td>Quantità</td>
<td>Elimina </td>

</tr>




		<% for(Prodotto p1:prodotti){ 
    String linkimmagine = ("Prodotti/"+p1.getCodice()+".jpg");
    %>

<tr>
<td><img src="<%= linkimmagine %>" alt="item" width="200px" height="200px" /></td>
<td><%=p1.getCodice()%></td>
<td><%=p1.getMarca()%></td>
<td><%=p1.getNome()%></td>
<td><%=p1.getPrezzo()%></td>
<td><%=p1.getQuantitá()%></td>
<td><form action="EliminaProdotto" method="get">
<input type="hidden" name="codice" value="<%=p1.getCodice() %>">
<button type="submit" >Elimina</button>
</form>
</td>

</tr>


			<% } %>
		
			
			




<%@ include file="/footer.jsp" %>
</body>
</html>