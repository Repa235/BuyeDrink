<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Controllo età</title>
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
<script src="assets/js/Script.js"></script>
</head>
<header id="header">
				<div class="innerLogo">
				<a class="logo" >Buy&Drink</a>
				</div>
			</header>

			
			
<body id="LoginForm" >
<div class="login-form">
<br>
<br>
<br>

			<div class="main-div">
<form action="PreHome" method="post">
<h3 style="color: black;">Inserisci la tua età : </h3>
<input type="text" name="eta" value="" onkeypress="return isNumberKey(event)" maxlength=2>
<button type="submit" >ok!</button>
</form>
</div>
</div>
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