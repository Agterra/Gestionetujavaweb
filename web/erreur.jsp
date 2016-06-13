<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Erreur de saisie</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <%
           String erreur = (String) request.getAttribute("erreur");
           
        %>
           <p class="erreur">${ erreur }</p>  
<p><br> <a href="index.jsp">Cliquez ici</a> pour retourner a l'index.
</p>
    </body>
</html>