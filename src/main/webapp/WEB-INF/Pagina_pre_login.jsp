<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/assets/css/main.css" />
<title>Seleziona utente</title>
</head>
<body>

	<%@ include file="/header.jsp"%>

	<section id="three">
	<div class="inner">

		<table style="height: 260px;" width="608">
			<tbody>
				<tr>
					<td>&nbsp; <article>
						<div class="image fit">
							<img src="images/avatar/capo.png" alt="" style="width:200%;"  />
						</div>
						<header>
						<h3>Login Titolare</h3>
						</header> <a href="LoginTitolare" class="button alt">Login</a> </article>
					</td>
					<td>&nbsp; <article>
						<div class="image fit">
							<img src="images/avatar/dipendente.png" alt="" style="width:200%;"  />
						</div>
						<header>
						<h3>Login Dipendente</h3>
						</header>
						<ul class="actions">
							<li><a href="LoginMagazziniere"
								class="button alt">Login</a></li>
						</ul>
						</div>
						</article>

					</td>
					<td>&nbsp; <article>
						<div class="image fit">
							<img src="images/avatar/cristiano.png" alt="" style="width:200%;"  />
						</div>
						<h3>Login Cliente</h3>
						</header>
						<ul class="actions">
							<li><a href="Login" class="button alt">Login</a></li>
						</ul>
						</div>
						</article>
					</td>
				</tr>
			</tbody>
		</table>
		<!-- Three -->




	</div>
	</section>
<%@ include file="/footer.jsp" %>
</body>
</html>