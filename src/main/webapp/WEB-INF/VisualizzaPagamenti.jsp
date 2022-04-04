<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Vector"%>
    <%@page import="it.unirc.twd.BuyeDrink.retribuisce.Retribuisce"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagamenti effettuati</title>
<%@ include file="/header.jsp"%>
</head>
<body>
<%
Vector<Retribuisce> pagamenti = (Vector<Retribuisce>)session.getAttribute("pagamenti");
%>



<table>
<tbody>


<tr>
<td>ID Dipendente</td>
<td>Importo</td>
<td>Data</td>



</tr>

<% for(Retribuisce r : pagamenti){ %>

<tr>
<td><%= r.getIdMagazziniere() %></td>
<td><%= r.getImporto() %></td>
<td><%= r.getDataPagamento() %></td>


</tr>

<%} %>

</tbody>
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br> 
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="/footer.jsp" %>
</body>
</html>