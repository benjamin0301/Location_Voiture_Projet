package ZCA;

import Controler.ClientController;
import Controler.VoitureController;
import Model.ClientModel;
import Model.Connexion;
import Model.VoitureModel;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Model.Connexion connexion = new Connexion("location_voiture", "root", "");
        System.out.println("Connexion établie avec succès !");

        // Création d'une instance de contrôleur et modele de voiture
        VoitureModel voituremodel = new VoitureModel();
        VoitureController voiturecontroller = new VoitureController();
        ClientModel clientmodel = new ClientModel();
        ClientController clientcontroller = new ClientController();
        SwingUtilities.invokeLater(() ->
        {
            Vue vue = new Vue(voiturecontroller, clientcontroller);
            vue.initialize();
        });
    }
}









