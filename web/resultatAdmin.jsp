<%@ page pageEncoding="UTF-8"%>
<%@ page import="notes.Etudiant"%>
<%@ page import="accesnotes.Requetes"%>
<%@page import="notes.RequeteAdmin"%>
<%@page import="java.util.List"%>
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
//Alors, normalement on ne fait pas attribute, on passe par une liste qu'on déclare dans requete
                List<Etudiant> laListe =
                
	%>
	<div>
		
                        <table>
                        
                        <tr>
                            <td>Nom</td>
                            <%for(Etudiant e : laListe){%>
                            <tr> <% out.print(e.getNom());%></tr>
                            <%}%>
                        </tr>
                        
                        <tr>
                            <td>Prenom</td>
                            <%for(Etudiant e : laListe){%>
                            <tr> <% out.print(e.getPrenom());%></tr>
                            <%}%>
                        </tr>
                        
                        <tr>
                            <td>Moyenne</td>
                            <%for(Etudiant e : laListe){%>
                            <tr> <% out.print(e.getNote());%></tr>
                            <%}%>
                        </tr>
                            
                        </table>
                       
			
                 <%--   <p>Nom : ${ etudiant.nom }</p>
			<p>Prénom : ${ etudiant.prenom }</p>
                        <p>Note : ${ etudiant.note } </p>     --%>
		
        </div>
<p><br> <a href="demande.jsp">Cliquez ici</a> pour retourner au formulaire de demande.
</p>
</body>
</html>