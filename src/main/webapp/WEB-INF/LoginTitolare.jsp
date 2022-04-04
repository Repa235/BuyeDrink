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
<title>Accesso Titolare</title>
</head>
<body id="LoginForm">
<%@ include file="/header.jsp" %>

<br>
<br>
<div class="container">

<div class="login-form">
<div class="main-div">
    <div class="panel">
<h3>Login Titolare</h3>
<h2>Inserisci e-mail e password</h2>
<br>
<br>
   </div>
    <form id="Login" action="LoginTitolare" method="post">

        <div class="form-group">


            <input type="email" class="form-control" name="mail" id="e_mail" placeholder="Email Address">

        </div>

        <div class="form-group">

            <input type="password" class="form-control" name="password" placeholder="Password">

        </div>

        <button type="submit" class="btn btn-primary" onclick="return validaEmail(e_mail)">Login</button>

    </form>
    </div>

</div></div>
<br>
<br>
<br>

<%@ include file="/footer.jsp" %>
</body>
</html>