<!--<%@ page pageEncoding="UTF-8" %>-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accès aux notes</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="RequeteNotes">
                <fieldset>
                    <legend>Informations étudiant</legend>
    
                    <label for="nom">Nom Etudiant <span class="requis">*</span></label>
                    <input type="text" id="nom" name="nom" value="" size="15" maxlength="15" />
                    <br />
                    <label for="nom">Prenom Etudiant <span class="requis">*</span></label>
                    <input type="text" id="nom" name="prenom" value="" size="15" maxlength="15" />
                    <br />
                    <label for="nom">Matière <span class="requis">*</span></label>
                    <input type="text" id="nom" name="mat" value="" size="15" maxlength="15" />
                    <br />
                 
                </fieldset>
                <input type="submit" value="Valider"  />
            </form>
        </div>
    </body>
</html>