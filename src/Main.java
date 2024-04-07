
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
        // Création d'une instance de contrôleur de voiture
        ClientModel client = new ClientModel(connexion, "benoittttt", "Dupont", "aaa", "gendrybenjamin@gmail.com", false, "2000-12-18", 234, 1234, 2345, 12345, 123432432, 0);
        client.setId_client(client.generateUniqueClientId());
        client.ajouterClient(client);
        client.verif_connexion_client("gendrybenjamin@gmail.com", "aaa");
    }
}
