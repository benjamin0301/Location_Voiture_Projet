
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
        VoitureController voiturecontroller = new VoitureController(voituremodel);
        ClientModel clientmodel = new ClientModel();
        ClientController clientcontroller = new ClientController();
        //voiturecontroller.ajouterNouvelleVoiture(connexion, "1234", "Audi", "SUV", "noir", "diesel", 5, 5, 5, "automatique", 50, 2020, 1000, 100, "Paris", 1000, "BMW");



    }
}
