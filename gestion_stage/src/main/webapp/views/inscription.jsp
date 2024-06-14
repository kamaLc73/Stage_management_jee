<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.jee.beans.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des inscrits</title>
    <link rel="stylesheet" href="css/inscription.css">
</head>
<body>
    <header>
        <h1>Inscription à un Stage</h1>
    </header>
    
   <main>
    <% Stage a = (Stage)request.getAttribute("stage"); %>
   
    <div class="form-container">
        <form action="inscription.do" method="post" class="inline-form">
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

    <h2>Liste des inscrits</h2>

    <div class="table-container">
        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                </tr>
            </thead>
            <tbody>
                
                <%
                     for (Inscription i : (List<Inscription>)request.getAttribute("li") ) {
                %>
                <tr>
                    <td><%= i.getStagiaire().getNom_stagiaire() %></td>
                    <td><%= i.getStagiaire().getPrenom_stagiaire()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
    
    <div class="buttons-container"> 
        <form action="retour.do" method="post">
            <input type="submit" value="Retour liste stage">
        </form>
        <form action="nouvelle.do" method="post">
            <input type="submit" value="Nouvelle inscription">
            <input type="hidden" name="nouvelle" value="<%=a.getCode_stage() %>">        
        </form>
    </div>
</main>
    <footer>
        <p>&copy; 2024 - Gestion des Stages</p>
    </footer>
</body>
</html>