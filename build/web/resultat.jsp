<%@ page pageEncoding="UTF-8"%>
<%@ page import="notes.Etudiant"%>
<%@ page import="accesnotes.Requetes"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Résultat de votre requete</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<%-- Affichage de la chaîne "message" transmise par la servlet --%>
	<%--<p class="info">${ message }</p>--%>
        <%
		Etudiant etu = (Etudiant) request.getAttribute("etudiant");
                
        %>
	<div>
		<fieldset>
			<legend>Informations étudiant</legend>
			<%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
                        <p>Nom     : <% out.print(etu.getNom()); %></p>
                        <p>prenom     : <% out.print(etu.getPrenom()); %></p>
                        <p>Matiere     : <% out.print((String)request.getAttribute("matiere")); %></p>
                        <p>Note     : <% out.print(etu.getNote()); %></p>
                         <p>Moyenne     : <% out.print((double)request.getAttribute("moyenne")); %></p>
                        <%--   <p>Nom : ${ etudiant.nom }</p>
			<p>Prénom : ${ etudiant.prenom }</p>
                        <p>Note : ${ etudiant.note } </p>     --%>
		</fieldset>
        </div>
<p><br> <a href="demande.jsp">Cliquez ici</a> pour retourner au formulaire de demande.
</p>
  </body>
</html>