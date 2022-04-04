<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.unirc.twd.BuyeDrink.magazziniere.Magazziniere"%>
<%
	Magazziniere m = (Magazziniere) request.getAttribute("mag");

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Profilo Magazziniere</title>


<link rel="stylesheet" href="assets/css/per_profilo.css" />
<link rel="stylesheet" href="assets/css/dropdown.css" />


<link rel="stylesheet" href="assets/css/bootstrap.min.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<style>
.show-on-hover:hover>ul.dropdown-menu {
	display: block;
}
</style>


</head>


<body>

	<!-- Header -->

	<%@ include file="/header.jsp"%>








	<table style="height: 500px;" width="702px">
		<tbody>
			<tr>
				<td style="width: 186px;">
					<p></p>
					<p></p>

					<h3><%=m.getNome() + " " + m.getCognome()%>
					</h3>
					<h4>Magazziniere</h4>
					<p>&nbsp;</p>
					<p>
						<img src="images/avatar/dipendente.png" width="286px "
							height="260px" />
					</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>



				<td style="width: 360px;">





				<div class="btn-group" style="width: 330px;">
					<button type="button" class="btn btn-danger dropdown-toggle"
						style="width: 400px;" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">PRODOTTI</button>


					<ul class="dropdown-menu" role="menu" style="width: 400px;">
						
	                   <li><a href="RichiediModProd"><strong>Modifica un prodotto</strong> </a></li>					
     	               <li><a href="GestioneProdotti"><strong>Visualizza Prodotti</strong> </a></li>

					</ul>
				</div>
 
 
                   
 
 
 
 
</td>

                 







				<!-- RIGA RIEPILOGO -->
				<td style="width: 89px;"><p6> <strong>&nbsp;
						&nbsp; ID:</strong> </p6>
					<ul>
						<li><%=m.getIdMagazziniere()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Email:</strong> </p6>
					<ul>
						<li><%=m.getEmail()%></li>
					</ul>
					<p>&nbsp;
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p></td>
			</tr>
		</tbody>
	</table>
<%@ include file="/footer.jsp" %>
</body>
</html>