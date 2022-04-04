<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.unirc.twd.BuyeDrink.titolare.Titolare"%>
<%@page import="it.unirc.twd.BuyeDrink.magazziniere.Magazziniere"%>
<%@page import="java.util.Vector"%>
<%Titolare t=(Titolare)request.getAttribute("autenticato"); %>
<%
Vector<Magazziniere>dipendenti= (Vector<Magazziniere>)request.getAttribute("dipendenti");
String errore=(String)request.getAttribute("errore");
String errorepass=(String)request.getAttribute("errore-pass");


%>

<%@page import="it.unirc.twd.BuyeDrink.magazziniere.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica attributi Magazziniere</title>

<link rel="stylesheet" href="assets/css/dropdown.css" />
<link rel="stylesheet" href="assets/css/font-awesome.css" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
<script src="assets/js/Script.js"></script>
</head>

<body id="LoginForm">
	<%@ include file="/header.jsp"%>
	<div class="login-form">
		<div class="main-div">
			<div class="panel">
				<h3>Modifica Magazziniere</h3>
			</div>
			<form action="ModificaDipendente" method="post">
				<div class="form-group">
					<h4>Id magazziniere di cui si intende modificare i parametri</h4>

					
					<select name="idMag">
						<% for (Magazziniere d : dipendenti){ %>
						<option value="<%=d.getIdMagazziniere() %>"><%=d.getNome() + " " + d.getCognome() %></option>
						<%} %>
					</select>
				</div>

				<div class="form-group">
					<h4>Parametri da modificare</h4>
					<input type="text" class="form-control" name="nome"
						placeholder="Nome" required>

				</div>
				<div class="form-group">

					<input type="text" class="form-control" name="cognome"
						placeholder="Cognome" required>

				</div>
				<div class="form-group" >

					<input type="text" class="form-control" name="e_mail"
						placeholder="Email" required>

				</div>
				<div class="form-group">
              
					<input type="password" class="form-control" name="password"
						placeholder="Password" required>

				</div>
				
<p>Reinserire password</p>
<div class="form-group">
					<input type="password" class="form-control" name="password2"
						placeholder="Password" required>

				</div>
				<%if(errore=="pw"){%>
				<div class="errore">
						<div class="error-control">
							<li style color="RED;" align="left"><%=errorepass %></li>
						</div>
					</div>
					<%} %>
				<button type="submit" class="btn btn-primary" onclick="return validaep(e_mail,password)">Modifica</button>

			</form>
		</div>
		<%@ include file="/footer.jsp" %>
</body>
</html>
