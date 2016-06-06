<!--<%@ page pageEncoding="UTF-8" %>-->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Acces à toutes les notes</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="RequeteAdmin">
                <fieldset>
                    <legend>Informations étudiant</legend>
    
                    <label for="nom">login <span class="requis">*</span></label>
                    <input type="text" id="nom" name="login" value="" size="15" maxlength="15" />
                    <br />
                    
                    <label for="prenom">mot de passe <span class="requis">*</span></label>
                    <input type="text" id="prenom" name="mdp" value="" size="15" maxlength="15" />
                    <br />
    
                    <label for="matiere">Matière <span class="requis">*</span></label>
                    <input type="text" id="matiere" name="matiere" value="" size="15" maxlength="15" />
                    <br />
                    
                </fieldset>
                <input type="submit" value="Valider"  />
            </form>
        </div>
    </body>
</html>
