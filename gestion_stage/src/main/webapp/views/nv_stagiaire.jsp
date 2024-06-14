<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nouveau Stagiaire</title>
    <link rel="stylesheet" type="text/css" href="css/nv_stagiaire.css">
</head>
<body>
    <header>
        <h1>Création d'un nouveau stagiaire</h1>
    </header>

    <main>
        <div class="centered-form">
	        <form action="creer.do" method="post" class="inline-form">
	            <label for="num_stagiaire">Numéro de stagiaire:</label>
	            <input type="text" id="num_stagiaire" name="num_stagiaire" required><br>
	
	            <label for="nom_stagiaire">Nom:</label>
	            <input type="text" id="nom_stagiaire" name="nom_stagiaire" required><br>
	
	            <label for="prenom_stagiaire">Prénom:</label>
	            <input type="text" id="prenom_stagiaire" name="prenom_stagiaire" required><br>
	
	            <label for="sexe_stagiaire">Sexe:</label>
	            <select id="sexe_stagiaire" name="sexe_stagiaire">
	                <option value="M">Masculin</option>
	                <option value="F">Féminin</option>
	            </select><br>
	
	            <label for="dnaiss_stagiaire">Date de naissance:</label>
	            <input type="date" id="dnaiss_stagiaire" name="dnaiss_stagiaire" required><br>
	
	            <label for="diplo_stagiaire">Diplôme:</label>
	            <input type="text" id="diplo_stagiaire" name="diplo_stagiaire" required><br>
	
	            <button type="submit">Ajouter</button>
	        </form> 
        </div>

        <div class="buttons-form">
            <form action="ri.do" method="post" class="buttons-container" id="b1">
                <button type="submit">Retour à l'inscription</button>
            </form>
            
            <form action="retour.do" method="post" class="buttons-container" id="b2">
                <button type="submit">Retour liste des stages</button>
            </form>	   
        </div>
    </main>

    <footer>
        <p>&copy; 2024 - Gestion des Stages</p>
    </footer>
</body>
</html>
