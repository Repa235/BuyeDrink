<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.unirc.twd.BuyeDrink.magazziniere.Magazziniere"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/per_login.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paga un Dipendente</title>
  <%@ include file="/header.jsp" %>
  

  
</head>
<body>
<br>
<br>

<%
Vector<Magazziniere>dipendenti= (Vector<Magazziniere>)request.getAttribute("dipendenti");
%>
  <body id="LoginForm">

<div class="container"> 
<h1 class="form-heading"></h1>
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h3>Effettua un pagamento</h3>
   <h2>Inserire importo:</p>
   </div>
    <form action="Paga" method="post">
    
            <div class="form-group">
 
        
        	<select name="idMag">
				<% for (Magazziniere d : dipendenti){ %>
				<option value="<%=d.getIdMagazziniere() %>"><%=d.getNome() + " " + d.getCognome() %></option>
				<%} %>
				</select>
    
           </div>

        <div class="form-group">


            <input type="text" class="form-control"  name="imp" value="">

        </div>


        <button type="submit" class="btn btn-primary">Paga</button>

    </form>
    </div>

</div></div>
<br>

<br>
<br>
<br>
<%@ include file="/footer.jsp" %>
</body>
</html>