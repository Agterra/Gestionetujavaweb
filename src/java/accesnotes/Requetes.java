package accesnotes;

import Model.DaoBDA;
import Model.DaoJava;
import Model.SourceOracleDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import notes.Etudiant;
import static notes.RequeteAdmin.ERROR;
import static notes.RequeteAdmin.laListe;

public class Requetes {

    private static Etudiant etu; // en E/S;
    // en entrée ( nom, prénom à chercher(en maj ou min)
    // en sortie ( nom(en MAJ), prénom, note trouvés)
    private static String matiere;
    private static boolean erreur_matiere;
    public static final String MATIERE1 = "BDA_G2S3";
    public static final String MATIERE2 = "JAVA_WEB_G2S3";
    public static final int OK = 200; // valeur à renvoyer en cas de succès
    public static final int NOT_FOUND = 2;
    public static final int ERREUR_MATIERE = 3;
    public static final int ERROR = -1;
    private static DaoJava daoJava;
    private static DaoBDA daoBD;
   
    public static List<Etudiant> laListe;

    public Requetes(String matiere) {
         this.matiere = matiere;
         try {

            daoJava = new DaoJava(SourceOracleDAO.getSource());
            daoBD = new DaoBDA(SourceOracleDAO.getSource());
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public Requetes(String nom, String prenom, String matiere) {
        etu = new Etudiant(nom, prenom, 0.0); // en entrée
        Requetes.matiere = matiere;
        erreur_matiere = false;

        try {

            daoJava = new DaoJava(SourceOracleDAO.getSource());
            daoBD = new DaoBDA(SourceOracleDAO.getSource());
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
     public Requetes(String nom, String prenom, String matiere, double note) {
        etu = new Etudiant(nom, prenom, note); // en entrée
        Requetes.matiere = matiere;
        erreur_matiere = false;

        try {

            daoJava = new DaoJava(SourceOracleDAO.getSource());
            daoBD = new DaoBDA(SourceOracleDAO.getSource());
        } catch (SQLException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    public Etudiant getEtu() {
        return etu;
    }

    public  int rechEtu() {

        if (erreur_matiere == true) {
            return ERREUR_MATIERE;
        }
        /* Recherche étudiant */
        
        boolean trouve = false;
        if (etu.getNom().equalsIgnoreCase("?") && etu.getPrenom().equalsIgnoreCase("?")){
         try{
            int i;
            boolean m; 
            Random rand = new Random();
             m=rand.nextBoolean();
             if (m==true){
                 rand = new Random();
                 i = rand.nextInt(daoJava.getCount());
                 etu=daoJava.GetAlea(i);
                 matiere=MATIERE2;
                 trouve = true;
             }else{
                 rand = new Random();
                 i = rand.nextInt(daoBD.getCount());
                 etu=daoBD.GetAlea(i);
                 matiere=MATIERE1;
                 trouve = true;
                 
             }
         } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }

        
        if (matiere.equalsIgnoreCase(MATIERE2)&& trouve==false) {
            try {

             etu=daoJava.GetEtu(etu);
            // System.out.println("aa " + etu.getNote());
                if(etu!=null){
                    trouve = true;
               }
            } catch (SQLException e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        } else {
            try {
                   
               etu=daoBD.GetEtu(etu);
                
               if(etu!=null){
                    trouve = true;
               }
               
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }

        }
        if (trouve == false) {
            return NOT_FOUND;
        } else {
            return OK;
        }
    }

    public  double getMoyenne() {
        /* calcul et renvoi de la moyenne */
        double moyenne=0;
        double tot = 0;
        int nombre = 0;
        try{
            if (matiere.equalsIgnoreCase(MATIERE1)) {
                moyenne=daoBD.getMoy();
            } else {
                moyenne=daoJava.getMoy();
            }
        }catch(Exception e){
            System.out.println("Erreur: " + e.getMessage());
        }
      moyenne = (int) ( moyenne * 100 + 0.5) / 100.0;

        return moyenne;

    }
    public List<Etudiant> GetListEtu() throws SQLException{
        laListe=new ArrayList<Etudiant>();
            if (matiere.equalsIgnoreCase(MATIERE2)) {
                     laListe= daoJava.lireLesEtu();
                
            } else {
               laListe= daoBD.lireLesEtu();                

            }
            return laListe;
     
    }
    public void modifEtu() throws SQLException{
        if (matiere.equalsIgnoreCase(MATIERE2)) {
                     daoJava.modifNote(etu);
                
            } else {
               daoBD.modifNote(etu);                

            }
    }
    public  String getMatiere() {
        return Requetes.matiere.toUpperCase();
    }
} // fin classe Requetes
