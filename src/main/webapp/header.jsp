<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/main.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body>

<% if(session.getAttribute("autenticato")!=null){ %>
<header id="header">
				<div class="inner">
					<a href="Home" class="logo">Buy&Drink</a>
					<nav id="nav">
						<a href="ToProfilo">&nbsp;Profilo</a>
						<a href="Logout">&nbsp;Logout</a>
						
					<% if(session.getAttribute("categoria").equals("cliente")){ %>
						<a href=" VisualizzaProdotti  ">&nbsp;Prodotti&nbsp;</a>						
						<a href="Carrello"><h2><i class="fa fa-shopping-cart" style="width: 50%;"></i></h2></a>
						<% } %>
						
					</nav>
				</div>
			</header>
			

<% }  else {%>
			
		<header id="header">
				<div class="inner">
					<a href="Home" class="logo">Buy&Drink</a>
					<nav id="nav">
						<a href="PreLogin">&nbsp;Login</a>
						<a href="VisualizzaProdotti">&nbsp;Prodotti&nbsp;</a>
						
						<a href="Carrello"><h2><i class="fa fa-shopping-cart" style="width: 50%;"></i></h2></a>
					</nav>
				</div>
			</header>
			
			
			<% } %>	

</body>
</html>