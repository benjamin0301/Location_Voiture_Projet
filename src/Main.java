
import Model.Connexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] s) throws SQLException, ClassNotFoundException {
        // creation de la fenetre
        Connexion fenetre = new Connexion("location_voiture", "root", "");
        Voiture v = new Voiture(fenetre, "Renault1", "Clio", "Bleu", "ad", "bleu", 2, 5, 5, 5, 0, 5, 2005, 54567, 5000, false, "Paris", "2022-05-05", "2022-05-10", 500, 1);
        Voiture v2 = new Voiture(fenetre, "Renault2", "Clio", "Bleu", "a", "rouge", 3, 5, 5, 5, 1, 5, 1995, 5445, 57654, true, "Paris", "2022-05-05", "2022-05-10", 500, 2);
        v.chargerInfosDepuisBDD("Renault1");
        v2.chargerInfosDepuisBDD("Renault2");
        v.afficherInfos();
        v2.afficherInfos();

    }
}
