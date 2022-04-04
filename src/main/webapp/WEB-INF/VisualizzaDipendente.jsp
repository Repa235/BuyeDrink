<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.unirc.twd.BuyeDrink.magazziniere.Magazziniere"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizza Dipendenti</title>
<%@ include file="/header.jsp"%>
</head>
<body>

<%
Vector<Magazziniere>dipendenti= (Vector<Magazziniere>)request.getAttribute("dipendenti");
%>



<table>
<tbody>


<tr>
<td>ID</td>
<td>Nome</td>
<td>Cognome</td>
<td>E-Mail</td>
<td>Data assunzione</td>
<td></td>


</tr>

<% for(Magazziniere m : dipendenti){ %>

<tr>
<td><%= m.getIdMagazziniere() %></td>
<td><%= m.getNome() %></td>
<td><%= m.getCognome() %></td>
<td><%= m.getEmail() %></td>
<td><%= m.getDataAssunzione() %></td>
<td><a href="LicenziaDipendente?idMagazziniere=<%=m.getIdMagazziniere() %>" >Licenzia </a>  </td>

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

<%@ include file="/footer.jsp" %>

</body>
</html>