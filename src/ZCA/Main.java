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
        SwingUtilities.invokeLater(() ->
        {
            try {
                Vue vue = new Vue();
                vue.initialize();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        connexion.closeConnection();

    }
}









