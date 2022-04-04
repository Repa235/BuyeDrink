<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.unirc.twd.BuyeDrink.titolare.Titolare" %>
    <%Titolare t=(Titolare)request.getAttribute("autenticato"); %>
    <% String cod = request.getParameter("codice"); %>
    <%@page import="it.unirc.twd.BuyeDrink.prodotto.*" %>
    <%@page import="it.unirc.twd.BuyeDrink.prodotto.Prodotto"%>
<%@page import="java.util.Vector"%>
<%@page import="it.unirc.twd.BuyeDrink.prodotto.ProdottoDAO"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Prodotto</title>

<link rel="stylesheet" href="assets/css/dropdown.css" />
<link rel="stylesheet" href="assets/css/font-awesome.css" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
</head>

<body id="LoginForm">
<%@ include file="/header.jsp" %>
<div class="login-form">
<div class="main-div">
    <div class="panel">
    <h3>Modifica Prodotto</h3>
   </div>
<form action="ModificaProdotto" method="post">
  
  <h4>Id prodotto da modificare</h4>
  <% Vector<Prodotto> prodotti = (Vector<Prodotto>) request.getAttribute("prodotto"); %>
  
  <div class="form-group">
  			
		<select name="codice">
		<%for(Prodotto p : prodotti){ %>
		<option value="<%=p.getCodice()%>"> <%= p.getNome() + " " + p.getMarca() %></option>
		<%} %>
		</select>
				
        </div>

          <div class="form-group">
         <h4>Parametri da modificare</h4>
            <input type="text" class="form-control" name="prezzo" placeholder="Prezzo">

        </div>
                <div class="form-group">

            <input type="text" class="form-control" name="nome" placeholder="Nome">

        </div>
                       <div class="form-group">

            <input type="text" class="form-control" name="marca" placeholder="Marca">

        </div>
               <div class="form-group">

            <input type="text" class="form-control" name="quantitá" placeholder="Quantitá">

        </div>
      

        <button type="submit" class="btn btn-primary">Modifica</button>

    </form>
    </div>

<%@ include file="/footer.jsp" %>
</body>
</html>
