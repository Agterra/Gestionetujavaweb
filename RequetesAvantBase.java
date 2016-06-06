package accesnotes;

import java.util.List;
import java.util.ArrayList;

import notes.Etudiant;

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

    public static List<Etudiant> listeEtudiants1, listeEtudiants2;

    public Requetes(String nom, String prenom, String matiere) {
        etu = new Etudiant(nom, prenom, 0.0); // en entrée
        Requetes.matiere = matiere;
        erreur_matiere = false;
        listeEtudiants1 = new ArrayList<>();
        listeEtudiants2 = new ArrayList<>();
        if (matiere.equalsIgnoreCase(MATIERE1)) {
            listeEtudiants1.add(new Etudiant("DUPOND", "Jean", 11.50));
            listeEtudiants1.add(new Etudiant("DURAND", "Jacques", 12.50));
            listeEtudiants1.add(new Etudiant("GABRIELE", "Patricia", 13.50));
        } else {
            if (matiere.equalsIgnoreCase(MATIERE2)) {
                listeEtudiants2.add(new Etudiant("MARTIN", "Jacques", 11.00));
                listeEtudiants2.add(new Etudiant("MATHIEU", "Henri", 13.50));
                listeEtudiants2.add(new Etudiant("TRIOLET", "Elsa", 16.50));
            } else {
                erreur_matiere = true;
            }
        }
    }

    public Etudiant getEtu() {
        return etu;
    }

    public static int rechEtu() {
        if (erreur_matiere) {
            return ERREUR_MATIERE;
        }
        /* Recherche étudiant */
        Etudiant etudiant = null;
        boolean trouve = false; //= false;
        int i = 0;
        if (matiere.equalsIgnoreCase(MATIERE1)) {
            for (Etudiant student : listeEtudiants1) {
                if ((student.getNom().contains(etu.getNom().toUpperCase())) && (student.getPrenom().toUpperCase().contains(etu.getPrenom().toUpperCase()))) {
                    etudiant = listeEtudiants1.get(i);
                    trouve = true;

                    break;
                }
                i++;

            }
        } else {
            for (Etudiant student : listeEtudiants2) {
                if ((student.getNom().contains(etu.getNom().toUpperCase())) && (student.getPrenom().toUpperCase().contains(etu.getPrenom().toUpperCase()))) {
                    etudiant = listeEtudiants2.get(i);
                    trouve = true;

                    break;
                }
                i++;

            }
        }
        if (!trouve) {
            return NOT_FOUND;
        } else {
                etu.setNom(etudiant.getNom());
                etu.setPrenom(etudiant.getPrenom());
                etu.setNote(etudiant.getNote());
            return OK;
        }
    }

    public static double getMoyenne() {
        /* calcul et renvoi de la moyenne */
        double moyenne = 0.0;
        if (matiere.equalsIgnoreCase(MATIERE1)) {
            for (Etudiant stu : listeEtudiants1) {
                moyenne += stu.getNote();
            }

            moyenne = (int) ((moyenne / listeEtudiants1.size() * 100.0 + 0.5)) / 100.0;
        } else {
            for (Etudiant stu : listeEtudiants2) {
                moyenne += stu.getNote();
            }

            moyenne = (int) ((moyenne / listeEtudiants2.size() * 100.0 + 0.5)) / 100.0;
        }
        return moyenne;

    }

    public static String getMatiere() {
        return Requetes.matiere.toUpperCase();
    }
} // fin classe Requetes
