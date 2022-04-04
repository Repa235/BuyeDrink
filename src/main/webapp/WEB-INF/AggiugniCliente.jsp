<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.unirc.twd.BuyeDrink.cliente.Cliente"%>
<% String errori= (String) request.getAttribute("errorepass"); 
	 String errori1=(String) request.getAttribute("errorepart"); 
	    String errore=(String)request.getAttribute("errore"); 
	    String nome=(String) request.getAttribute("nome"); 
	    String cognome=(String)request.getAttribute("cognome"); 
	    String email=(String)request.getAttribute("email");
	    String password=(String)request.getAttribute("password");
		String partitaIva=(String)request.getAttribute("partitaIva");
		String codiceFiscale=(String)request.getAttribute("codiceFiscale");
		String via=(String)request.getAttribute("via");
	    String civico=(String)request.getAttribute("civico");
	    
	    String errore3=(String)request.getAttribute("errororem");
	    
	    %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione Cliente</title>
<link rel="stylesheet" href="assets/css/dropdown.css" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/per_login.css" />
<script src="assets/js/Script.js"></script>


</head>
<body id="LoginForm">






	<%@ include file="/header.jsp"%>
	<div class="login-form">
		<div class="main-div">
			<div class="panel">
				<h3>Inserisci i tuoi dati</h3>
			</div>


			<% if(errore!=null) {%>

			<form action="AggiungiCliente" method="post"> 



				<div class="form-group">



					<input type="text" class="form-control" name="nome"
						placeholder="Nome" value="<%=nome %>" required>

				</div>
				<div class="form-group">

					<input type="text" class="form-control" name="cognome"
						placeholder="Cognome" value="<%=cognome %>" required>

				</div>
				
				
				
			
					<%if(errore.equals("m")){ %>
					<div class="form-group">

					<input type="text" class="form-control" name="e_mail"
						placeholder="Email" value="" required>

				</div>
					<div class="errore">
						<div class="error-control">
							<li style color="RED;" align="left"><%=errore3 %></li>
						</div>
					</div>
					
                <div class="form-group">

					<input type="text" class="form-control" name="partitaIva"
						placeholder="Partita Iva" value="<%=partitaIva %>" required>
				</div>

					<%} else {%>
					<div class="form-group">
						<input type="text" class="form-control" name="e_mail"
							placeholder="Email" 
						  	
										
							value="<%=email %>" required>
					</div>
				
				<%} %>



				<div class="form-group">

					<input type="password" class="form-control" name="password"
						placeholder="Password" required>
						</div>
					<%if(errori!=null){ %>
					<div class="errore">
						<div class="error-control">
							<li style color="RED;" align="left"><%=errori %></li>




						</div>
					</div>
					<%} %>
				

				<%if(errore.equals("pw")){ %>
				<div class="form-group">

					<input type="text" class="form-control" name="partitaIva"
						placeholder="Partita Iva" value="<%=partitaIva %>" required>
				</div>
				<%} else {%>
					<% if(errori1!=null){ %>
				
				<div class="form-group">

					<input type="text" class="form-control" name="partitaIva"
						placeholder="Partita Iva" required>

				</div>
				<div class="errore">
					<div class="error-control">
						<p style="color: RED;" align="left"><%= errori1 %></p>
					</div>

					
				</div>
<%}} %>

				<div class="form-group">

					<input type="text" class="form-control" name="codiceFiscale"
						placeholder="Codice fiscale"
						pattern="[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]"
						value="<%=codiceFiscale %>" required>

				</div>

				<div class="form-group">

					<input type="text" class="form-control" name="via"
						placeholder="Via" value="<%=via %>" required>

				</div>

				<div class="form-group">

					<input type="text" class="form-control" name="civico"
						placeholder="Civico" value="<%=civico %>" required>

				</div>

				<button type="submit" class="btn btn-primary" onclick="return validaEmail(e_mail)">Registrati</button>
			</form>

          
      



		<%} else { %>
		<form action="AggiungiCliente" method="post">




			<div class="form-group">



				<input type="text" class="form-control" name="nome"
					placeholder="Nome" required>

			</div>
			<div class="form-group">

				<input type="text" class="form-control" name="cognome"
					placeholder="Cognome" required>

			</div>
			<div class="form-group">

				<input type="text" class="form-control" name="e_mail"
					placeholder="Email"  >

			</div>
			<div class="form-group">

				<input type="password" class="form-control" name="password"
					placeholder="Password" required>


			</div>


			<div class="form-group">

				<input type="text" class="form-control" name="partitaIva"
					placeholder="Partita Iva" required>

			</div>

			<div class="form-group">

				<input type="text" class="form-control" name="codiceFiscale"
					placeholder="Codice fiscale" required
					pattern="[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]">

			</div>

			<div class="form-group">

				<input type="text" class="form-control" name="via" placeholder="Via"
					required>

			</div>

			<div class="form-group">

				<input type="text" class="form-control" name="civico"
					placeholder="Civico" required>

			</div>

			<button type="submit" class="btn btn-primary" onclick="return validaEmail(e_mail)">Registrati</button>
		
		</form>




	
	<%} %>
</div></div>

	<%@ include file="/footer.jsp"%>
</body>

</html>


