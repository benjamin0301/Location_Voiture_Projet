
import Controler.ClientController;
import Model.ClientModel;
import Model.Connexion;
import Controler.VoitureController;
import Model.VoitureModel;


import java.sql.SQLException;

public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException {
        // creation de la fenetre
        Connexion connexion = new Connexion("location_voiture", "root", "");
        System.out.println("Connexion établie avec succès !");

        // Création d'une instance de contrôleur et modele de voiture
        VoitureModel voituremodel = new VoitureModel();
        VoitureController voiturecontroller = new VoitureController();
        ClientModel clientmodel = new ClientModel();
        ClientController clientcontroller = new ClientController();
        voiturecontroller.ajouterNouvelleVoiture(connexion, "GO-317-AT", "Cybertruck", "Spécial", "Chrome", "Electrique", 5, 5, 5, "automatique", 50, 2024, 100, 250, "Paris", 1000, "Tesla");



    }
}
