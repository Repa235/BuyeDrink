<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.unirc.twd.BuyeDrink.titolare.Titolare"%>
<%
	Titolare t = (Titolare) request.getAttribute("profilotitolare");
	Double incasso = (Double) request.getAttribute("incasso");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profilo Titolare</title>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<!--  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">  -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/css/bootstrap.css" />

<style>
.show-on-hover:hover>ul.dropdown-menu {
	display: block;
	
}
</style>
</head>





<body>

	<!-- Header -->
	<%@include file="/header.jsp"%>


	<table style="height: 500px;" width="702px">
		<tbody>
			<tr>
				<td style="width: 186px; vertical-align: -webkit-baseline-middle;">



					<h3><%=t.getNome() + " " + t.getCognome()%>
					</h3>
					<h4>Titolare</h4>
					<p>&nbsp;</p>
					<p>
						<img src="images/avatar/capo.png" width="286px " height="260px" />
					</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>



<!-- COLONNA BOTTONI -->

				<td style="width: 360px;">
					


					<div class="btn-group dropright" style="width: 330px;">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							style="width: 400px;" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">DIPENDENTI</button>
						<div class="dropdown-menu">
					<a class="dropdown-item" href="AssumiDipendente"><strong>Assumi un dipendente</strong></a> 
					<a class="dropdown-item" href="RichiediModificaDip"><strong>Modifica un dipendente</strong></a>
					<a class="dropdown-item" href="VisualizzaDipendenti"><strong>Visualizza Dipendenti</strong></a> 
					<a class="dropdown-item" href="EffettuaPagamento"><strong>Paga un dipendente</strong></a>
					<a class="dropdown-item" href="VisualizzaPagamenti"><strong>VisualizzaPagamenti</strong></a>

						</div>
					</div>



					<div class="btn-group dropright" style="width: 330px;">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							style="width: 400px;" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">PRODOTTI</button>
						<div class="dropdown-menu">
					<a class="dropdown-item" href="RichiediModProd"><strong>Modifica un prodotto</strong> </a> 
				    <a class="dropdown-item" href="GestioneProdotti"><strong>Visualizza	Prodotti</strong> </a>

						</div>
					</div>



					<div class="btn-group dropright" style="width: 330px;" role="menu">
						<button type="button" class="btn btn-secondary dropdown-toggle"
							style="width: 400px;" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">STATISTICHE VENDITA</button>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="Stats"><strong>Visualizza
									Statistiche</strong> </a>


						</div>


					</div> 



				</td>


				<td style="width: 89px;">
					<!-- COLONNA DATI PERSONALI --> <p6> <strong>&nbsp;&nbsp;
						ID:</strong> </p6>
					<ul>
						<li><%=t.getIdTit()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Email:</strong> </p6>
					<ul>
						<li><%=t.getEmail()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Codice fiscale:</strong> </p6>
					<ul>
						<li><%=t.getCodiceFiscale()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; PARTITA IVA:</strong> </p6>
					<ul>
						<li><%=t.getPartitaIva()%></li>
					</ul> <p6> <strong>&nbsp; &nbsp; Incasso:</strong></p6>
					<ul>
						<li><p6> Euro <%=incasso%></li>
					</ul>

					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>
			</tr>
		</tbody>
	</table>

	<%@ include file="/footer.jsp"%>
</body>
</html>