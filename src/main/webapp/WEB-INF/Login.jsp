<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="assets/css/per_login.css" />
<script src="assets/js/Script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Effettua l'accesso</title>
</head>



<body >
 
  <body id="LoginForm">
  <%@ include file="/header.jsp" %>

<br>
<br>
<br>
<div class="container"> 
<h1 class="form-heading"></h1>
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <h3>Login Cliente</h3>
   <p>Inserire Username e Password</p>
   </div>
    <form action="Login" method="post" >

        <div class="form-group">


            <input type="text" class="form-control"  name="e_mail" id="e_mail" value="">

        </div>

        <div class="form-group">

            <input type="password" class="form-control"  name="Password" value="">
</div>

        
        <div class="forgot">

        
        <span class="registra">
        <a href="AggiungiCliente">Registrati</a>
        
        </span>
</div>
        <button type="submit" class="btn btn-primary"  onclick="return validaEmail(e_mail)">Login</button>

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