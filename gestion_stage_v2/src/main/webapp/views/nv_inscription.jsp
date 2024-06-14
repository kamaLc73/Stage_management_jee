<%@page import="java.sql.Date"%>
<%@page import="com.jee.business.Facade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.jee.beans.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Nouvelle Inscription</title>
	    <link rel="stylesheet" href="css/nv_inscription.css">
	</head>
	<body>
		<header>
	        <h1>Inscription à un Stage</h1>
	    </header>
	    
	    <main>
	        <% Stage a = (Stage)request.getAttribute("stage");%>	
	
			<div>
	            <form action="inscription.do" method="post" class="inline-form1">
	                <div class="form-group">
	                    <label for="stage"><b>Stage:</b></label>
	                    <input type="text" name="stage" value="<%=a.getCode_stage() %>" readonly maxlength="5">
	                </div>
	                <div class="form-group">
	                    <label for="du"><b>Du:</b></label>
	                    <input type="text" name="du" value="<%=a.getDebut_stage() %>" readonly maxlength="10">
	                </div>
	                <div class="form-group">
	                    <label for="au"><b>Au:</b></label>
	                    <input type="text" name="au" value="<%=a.getFin_stage()%>" readonly maxlength="10">
	                </div>
	            </form>
	        </div>
	 
	        <hr>
	        
	        <% List<Stagiaire> lsi = (List<Stagiaire>)request.getAttribute("lsi"); %>
	        
			<br>
			
			<div class="centered-form">
				<form action="validation.do" method="post" class="inline-form2">  	
                	<div class="form-group">
                		<label for="choix">Sélection Stagiaire:</label>
						<select id="choix" name="num_stagiaire" >
						    <% for (Stagiaire stagiaire : lsi) { %>
						        <option value="<%= stagiaire.getNum_stagiaire() %>"><%= stagiaire.getNom_stagiaire() %></option>
						    <% } %>
						</select>
					</div>
                		
					<br>

                	<div class="form-group">
	                    <label for="statut"><b>Statut:</b></label>
	                    <input type="text" id="statut" name="statut">
					</div>
	                
	                <br>
	                
	                <div class="form-group">
	                	 <label for="code"><b>Code position:</b></label>
                   		 <input type="text" id="code" name="code">
	                </div>
                   	
                   	<br>
                   	
	                <div class="form-group">
						<label for="date"><b>Date inscription:</b></label>
	                    <input type="date" id="date" name="date">
					</div>
					
					<br>
						
            	    <input type="submit" value="Validation">	
	            </form>
			</div>
			
			<script>
			    document.getElementById('choix').addEventListener('change', function() {
			        var selectedStagiaire = this.value; // Récupération de la valeur sélectionnée
			
			        var xhr = new XMLHttpRequest();
			        xhr.open("POST", window.location.href, true);
			        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			        xhr.onreadystatechange = function () {
			            if (xhr.readyState === 4 && xhr.status === 200) {
			                console.log("Stagiaire sélectionné : " + selectedStagiaire);
			            }
			        };
			        xhr.send("selectedStagiaire=" + encodeURIComponent(selectedStagiaire)); // Encode the value before sending
			    });
			</script>
			
			<br>
			
			<div>
				<h4 id="message"></h4>
				
				<% if (request.getAttribute("message") != null) { %>
		        <script>
		            var a = document.getElementById('message');
		            a.textContent = "<%= request.getAttribute("message") %>";
		            a.style.textAlign = 'center';
		            a.style.fontSize = '1.2em'; 
		            a.style.color = 'green';
		        </script>
		   		 <% } %>
			</div>		
						
	        <div class="buttons-form"> 
	            <form action="retour.do" method="post">
	                <button type="submit"class="buttons-container" id="b1">Retour Stage</button>
	            </form>
	            
	            <form action="nouveauStagiaire.do" method="post" >
	                <button type="submit" class="buttons-container" id="b2">Nouveau Stagiaire</button>
	            </form>
	        </div>
	     </main>
	     
	     <footer>
		    <p>&copy; 2024 - Gestion des Stages</p>
		</footer>
	</body>
</html>