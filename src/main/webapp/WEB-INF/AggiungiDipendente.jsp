<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.unirc.twd.BuyeDrink.titolare.Titolare" %>
    <%Titolare t=(Titolare)request.getAttribute("autenticato"); %>
   

    <%@page import="it.unirc.twd.BuyeDrink.magazziniere.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assumi Magazziniere</title>

<link rel="stylesheet" href="assets/css/dropdown.css" />
<link rel="stylesheet" href="assets/css/font-awesome.css" />
<link rel="stylesheet" href="/assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
<script src="assets/js/Script.js"></script>
</head>

<body id="LoginForm">
<br>
<%@ include file="/header.jsp" %>
<div class="login-form">
<div class="main-div">
    <div class="panel">
    <h3>Assumi Magazziniere</h3>
   </div>
   
   
<form action="AssumiDipendente" method="post">

          <div class="form-group">
         <h4>Generalità dipendente da assumere</h4>
        
                            <div class="form-group"> 

           
                                          
            <input type="text" class="form-control" name="nome" placeholder="Nome" required>

        </div>
                <div class="form-group">

            <input type="text" class="form-control" name="cognome" placeholder="Cognome" required>

        </div>
                       <div class="form-group">

            <input type="text" class="form-control" name="e_mail"  placeholder="email" required>

        </div>
               <div class="form-group">

            <input type="password" class="form-control" name="password"  placeholder="Password" required>

        </div>
        

        <button type="submit" class="btn btn-primary" onclick="return validaep(e_mail,password)" >Assumi</button>
</div>
    </form>
    </div>
    </div>
    
<br>
<br>
<br>
<%@ include file="/footer.jsp" %>
</body>
</html>
