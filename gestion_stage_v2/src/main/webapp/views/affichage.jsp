<%@page import="com.jee.business.StageManagerImpl"%>
<%@page import="com.jee.business.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jee.beans.Stage"%>
<%@page import="com.jee.utils.*"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Stages</title>
    <link rel="stylesheet" href="css/affichage.css">
</head>
<body>
    <header>
        <h1>Inscription à un stage</h1>
    </header>

    <main>
        <div class="buttons1">
	        <form action="trie.do" method="GET">
	            <input type="submit" name="sortBy" value="Trier par date" >
	            <input type="submit" name="sortBy" value="Trier par type" >
	        </form>
	    </div>
	    
	    <h4 id="sort"></h4>
		<% 
		    String sortAttribute = (String) request.getAttribute("sort");
		    if (sortAttribute != null) {
		        if (sortAttribute.equals("date")) { %>
		            <script>
		                document.getElementById('sort').textContent = 'Trier par date';
		            </script>
		<%      } else if (sortAttribute.equals("type")) { %>
		            <script>
		                document.getElementById('sort').textContent = 'Trier par type';
		            </script>
		<%      }
		    }
		%>

		
        <% 	
            List<Stage> ls = (List<Stage>)request.getAttribute("ls");
         %>
        <table>
            <thead>
                <tr>
                    <th>Code Stage</th>
                    <th>Type Stage</th>
                    <th>Date du début</th>
                    <th>Date de la fin</th>
                    <th>Nombre de place</th>
                    <th>Nombre inscrit</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for(int i = 0; i < ls.size(); i++) {
                 %>
                <tr>
                    <td><%= ls.get(i).getCode_stage() %></td>
                    <td><%= ls.get(i).getType_stage() %></td>
                    <td><%= ls.get(i).getDebut_stage() %></td>
                    <td><%= ls.get(i).getFin_stage() %></td> 
                    <td><%= ls.get(i).getNbplace_stage() %></td>
                    <td><%= ls.get(i).getNbinscrit_stage() %></td>
                </tr>
                <% 
                    }
                 %>
            </tbody>
        </table>
        <hr style="margin:20px">
        
        <div class="buttons2">
	        <form action="soumettre.do" method="post">
	        	<label> Entrer le code de stage souhaité:</label>
	        	<input type="text" autofocus name="soumettre" >
	            <button type="submit">Soumettre</button>
	        </form>
	    </div>
	    
		<h4 id="error"></h4>
		<% if (request.getAttribute("error") != null) { %>
	        <script>
	            var a = document.getElementById('error');
	            a.textContent = "<%= request.getAttribute("error") %>";
	            a.style.textAlign = 'center';
	            a.style.fontSize = '1.2em'; 
	            a.style.color = 'red';
	        </script>
	    <% } %>
    </main>

    <footer>
        <p>&copy; 2024 - Gestion des Stages</p>
    </footer>
</body>
</html>
