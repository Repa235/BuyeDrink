<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/Form_trasparenza.css" />
<script type="text/javascript" src="assets/js/script.js"></script>
<script type="text/javascript" language="JavaScript">
<!--
function oscroller_init() {
		}
		function stop() {
		}
		function show(i) {
		}
		function run() {
		}

//--></script>
<script language="JavaScript1.1" src="assets/js/osscroller.js"></script>
</head>


<body>

<script type="text/javascript" >


	if (!document.cookie.match(/(?:^|; *)alert_shown=1/)) {
		alert("Questo sito utilizza cookies.");
			document.cookie = "alert_shown=1;max-age=" + 60 * 60 * 24 * 365;
	}


</script>


	<!-- Header -->

<%@ include file="/header.jsp" %>


	<!-- form inserimento età e altre cose belle -->



	<!-- Banner-->
	
		<section id="banner">
				<div class="inner">
					<h1><span> </span></h1>
				</div>
			</section>

<!-- One -->
			<section id="one">
				<div class="inner">
				<header>
				
					<body onload="oscroller_init();">
					<table>
                    <tr>
                    <td align="center">
                    <img src="img/0.jpg" height="400" name="partenza" alt="foto di prova">
</td>
</tr>
</table>
			</header>
						<h2>Chi siamo ?</h2>
					</header>
					<p>La Buy & Drink è un'azienda specializzata nel commercio all'ingrosso e al dettaglio di acque gassate e 
					minerali, bevande gassate e non, alcolici e super alcolici. Distribuzione alimentare in generale.</p>
				</div>
			</section>
			
			
				<!-- Two -->
			<section id="two">
				<div class="inner">
					<article>
						<div class="content">
							<header>
								<h3>Dove Trovarci?</h3>
							</header>
							<div class="google-maps">
								<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3141.5409856289048!2d15.663429014812525!3d38.05778047970887!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x13145a3574a59525%3A0x2c9f0232336ca70d!2sVia+Trapezi%2C+79%2C+89134+Reggio+Calabria+RC!5e0!3m2!1sit!2sit!4v1538578344770" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
							</div>
						</div>
					</article>
					<article class="alt">
						<div class="content">
							<header>
								<h3>Contatti</h3>
							</header>
							<p>	Telefono : 392 670 7325<br>
								Email : buyanddrink@gmail.com<br>
			
							</p>
						</div>
					</article>
				</div>
			</section>
<%@ include file="/footer.jsp" %>
</body>
</html>