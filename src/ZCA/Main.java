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
        System.out.println("Connexion etablie avec succès !");

        // Creation d'une instance de contrôleur et modele de voiture
        SwingUtilities.invokeLater(() ->
        {
            try {
                Vue vue = new Vue();
                vue.initialize();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}









