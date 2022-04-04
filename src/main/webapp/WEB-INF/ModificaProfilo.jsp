<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="it.unirc.twd.BuyeDrink.cliente.Cliente" %>
    
    <% Cliente cliente=(Cliente) request.getAttribute("ProfiloCliente");
    String errori= (String) request.getAttribute("errorepass"); 
    String errore=(String)request.getAttribute("errore");
   
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="assets/js/Script.js"></script>
<link rel="stylesheet" href="assets/css/per_login.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Profilo</title>

 <%@ include file="/header.jsp" %>
    </head>
	  <body id="LoginForm">
<div class="container"> 

<div class="login-form">
<div class="main-div">
    <div class="panel">
	                  <h3>Informazioni Personali</h3>
	             
 
	                  	
	                    <form  action="ModificaProfilo" method="POST">
	                    
	                  
	                         <input type="hidden" name="id_cliente" value="<%=cliente.getId_Cliente() %>" >
	                      
	              
	                    
	                      <div class="form-group">
	                         <input type="text" name="e_mail" value=<%=cliente.getE_mail() %>  placeholder="email" required>
	                        </div>
	                       
	                      
	                       
	                       
                            <div class="form-group">
	                          <input name="password" value="" placeholder="password" type="password" >
	                        </div>
	                         <%if(errore!=null){ %>
	                       <%if(errori!=null){ %>
	                       <div class="errore">
						<div class="error-control">
							<li style color="RED;" align="left"><%=errori %></li>

					</div></div>
					<%}} %>
	                      
	                        <div class="form-group">
	                          <input name="nome" value="<%=cliente.getNome() %>"  type="text" placeholder="nome" required>
	                        </div>
	                
	                        <div class="form-group">
	                          <input   name="cognome" value="<%=cliente.getCognome() %>" type="text" placeholder="cognome" required>
	                        </div>
	             
	   						<div class="form-group">
	                          <input type="text" id="via"  name="via" value="<%=cliente.getVia() %>" placeholder="via" >
	                        </div>
	                        
	                       <div class="form-group">
                              <input type="text"  name="numero_Civico" value="<%=cliente.getNumero_Civico() %>" placeholder="n°civico" >
	                        </div>
	              
	                      
	       
	                        <div>
	                          <button type="reset" >Cancella</button>
	                          <button type="submit"  onclick="return validaEmail(e_mail)">Invia Modifiche</button>
	                        </div>
	               
	                    </form>
	        </div>
	        </div>
          </div>
          </div>
	<%@ include file="/footer.jsp" %>
	</body>
</html>


