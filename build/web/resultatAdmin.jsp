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
                List<Etudiant> laListe = (List<Etudiant>)request.getAttribute("laListe");
                
	%>
	<div>
		
                       <table>
                        
                            <tr>
                                <th>Nom</th><th>Prenom</th><th>Note</th>
                                <%for(Etudiant e : laListe){%>
                            <tr><td><% out.print(e.getNom());%></td>
                                <td><% out.print(e.getPrenom());%></td>
                                <td><% out.print(e.getNote());}%></td>
                            </tr>
                                    
                                
                            </tr>
                            
                        </table>
                       
                       
			
                 <%--   <p>Nom : ${ etudiant.nom }</p>
			<p>Prénom : ${ etudiant.prenom }</p>
                        <p>Note : ${ etudiant.note } </p>     --%>
		
        </div>
<p><br> <a href="index.jsp">Cliquez ici</a> pour retourner à l'accueil.
</p>
</body>
</html>