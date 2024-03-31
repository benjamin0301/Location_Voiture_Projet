
import Model.Connexion;
import Controler.VoitureController;
import java.sql.SQLException;

public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException {
        // creation de la fenetre
        Connexion connexion = new Connexion("location_voiture", "root", "");
        System.out.println("Connexion établie avec succès !");
        // Création d'une instance de contrôleur de voiture
        VoitureController voitureController = new VoitureController();

        // Appel de la méthode pour ajouter une nouvelle voiture avec des données fictives
        boolean success = voitureController.ajouterNouvelleVoiture(
                connexion,
                "ABC23",
                "ModèleXYZ",
                "TypeXYZ",
                "Bleu",
                "Essence",
                5,
                5,
                4,
                "Manuelle",
                50,
                2022,
                10000,
                15000.0f,
                "Paris",
                20000
        );

        // Vérification du succès de l'opération
        if (success) {
            System.out.println("Nouvelle voiture ajoutée avec succès !");
        } else {
            System.out.println("Échec de l'ajout de la nouvelle voiture.");
        }


    }
}