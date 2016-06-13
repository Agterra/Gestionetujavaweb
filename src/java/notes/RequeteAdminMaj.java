package notes;

import Model.DaoBDA;
import Model.DaoJava;
import accesnotes.Requetes;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RequeteAdminMaj", urlPatterns = {"/RequeteAdminMaj"})
public class RequeteAdminMaj extends HttpServlet {

    public static final int OK = 200;
    public static final int NOT_FOUND = 2;
    public static final int ERROR = -1;
    public static List<Etudiant> laListe;
    private DaoJava daoJava;
    private DaoBDA daoBda;
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// doPost : quand on veut "uploader" au niveau de serveur(ex. formulaire remplie)
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        String matiere = request.getParameter("matiere");
        String nom = request.getParameter("NomE");
        String prenom = request.getParameter("PrenomE");
        Double note = Double.parseDouble(request.getParameter("note"));
       // System.out.println(login+" "+mdp+" "+matiere+" ");

        String erreur="Erreur";

        if (login.trim().isEmpty() || mdp.trim().isEmpty()) {
            erreur = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
            request.setAttribute("erreur", erreur);
            this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
        if(!login.equalsIgnoreCase("admin") ||!mdp.equalsIgnoreCase("admin")){
            erreur = "Erreur - Identifiants incorrects.";
            request.setAttribute("erreur", erreur);
            this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
        if(note<0 || note>20){
            erreur = "Erreur - erreur note.";
            request.setAttribute("erreur", erreur);
            this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
        int result=OK;

        Requetes req;
        req=new Requetes(nom,prenom,matiere,note);
      //  result = req.rechEtu();
       if(result==OK){
            try {
               if(req.modifEtu()==false){
                   throw new Exception ("Etu non trouver");
               }
                
            } catch (SQLException ex) {
                result=ERROR;
               erreur="upade err";
               
            }catch(Exception e){
                result=ERROR;
               erreur=e.getMessage();
                
            }
       }
       Etudiant etudiant = req.getEtu();
      //modif
            if (result != OK) {

                request.setAttribute("erreur", erreur);
                this.getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
            }else {
                request.setAttribute("etudiant", etudiant);
                request.setAttribute("matiere", req.getMatiere());
                request.setAttribute("moyenne", req.getMoyenne());
                request.setAttribute("laListe", laListe);
                this.getServletContext().getRequestDispatcher("/resultat.jsp").forward(request, response);
            }
        
       
    }
}
