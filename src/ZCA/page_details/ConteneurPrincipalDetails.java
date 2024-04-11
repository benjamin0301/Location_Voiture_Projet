package ZCA.page_details;

import Controler.ClientController;
import Controler.VoitureController;
import ZCA.page_principale.conteneurprincipal.Progression;
import ZCA.page_principale.conteneurprincipal.gauche.ConteneurGauche;
import ZCA.page_principale.conteneurprincipal.voitures.ConteneurVoitures;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ConteneurPrincipalDetails extends JPanel {


    public ConteneurPrincipalDetails() throws SQLException, ClassNotFoundException {
        //ClientController clientcontroller = new ClientController();
        //VoitureController voiturecontroller = new VoitureController();

    }

    public void initConteneurPrincipalDetails() throws SQLException, ClassNotFoundException {
        // Création du conteneur gris qui enveloppe le contenu existant
        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.decode("#E4E4E4")); // Fond gris
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85)); // Ajout d'un espace vide

        // Définition du layout pour le ConteneurPrincipal actuel
        setLayout(new BorderLayout());

        // Création de la bande rose
        Progression progression = new Progression(); // Création de l'instance de la classe Progression
        conteneurGris.add(progression, BorderLayout.NORTH); // Ajout de la bande rose au conteneur gris

        // Création du conteneur horizontal pour la gauche
        ConteneurDroite conteneurDroite = new ConteneurDroite();
        // Ajout du conteneur gauche au conteneur gris
        conteneurGris.add(conteneurDroite, BorderLayout.EAST);

        // Création du conteneur pour les bandes oranges
        ConteneurFormulaires conteneurFormulaires = new ConteneurFormulaires();
        // Ajout du conteneurVoitures au conteneur gris
        conteneurGris.add(conteneurFormulaires, BorderLayout.CENTER);

        // Ajout du conteneur gris à ConteneurPrincipal
        add(conteneurGris, BorderLayout.CENTER);
    }
}


