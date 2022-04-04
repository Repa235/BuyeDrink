<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.unirc.twd.BuyeDrink.titolare.Titolare" %>
    <%Titolare t=(Titolare)request.getAttribute("autenticato"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aggiungi Prodotto</title>

<link rel="stylesheet" href="assets/css/dropdown.css" />
<link rel="stylesheet" href="assets/css/font-awesome.css" />
<link rel="stylesheet" href="/assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
</head>

<body id="LoginForm">
<%@ include file="/header.jsp" %>
<div class="login-form">
<div class="main-div">
    <div class="panel">
    <h3>Aggiungi Prodotto</h3>
   </div>
<form action="AggiungiProdotto" method="post">

          <div class="form-group">
  
                            <div class="form-group">

           
                                          
            <input type="text" class="form-control" name="codice" placeholder="Codice">

        </div>
                <div class="form-group">

            <input type="text" class="form-control" name="quantità" placeholder="Quantità">

        </div>
            <div class="form-group">

            <input type="text" class="form-control" name="prezzo" placeholder="Prezzo">

        </div>
        
                       <div class="form-group">

            <input type="text" class="form-control" name="marca" placeholder="Marca">

        </div>
               <div class="form-group">

            <input type="text" class="form-control" name="nome" placeholder="Nome">

        </div>
        

        <button type="submit" class="btn btn-primary">Aggiungi</button>

    </form>
    </div>
    </div>
    
<br>
<br>
<br>
<br>

<%@ include file="/footer.jsp" %>
</body>
</html>
