package ZCA.page_principale.conteneurprincipal;

import Controler.ClientController;
import Controler.VoitureController;
import ZCA.page_principale.conteneurprincipal.gauche.ConteneurGauche;
import ZCA.page_principale.conteneurprincipal.voitures.ConteneurVoitures;

import javax.swing.*;
import java.awt.*;

public class ConteneurPrincipal extends JPanel {

    private ClientController clientcontroller;

    private VoitureController voiturecontroller;

    public ConteneurPrincipal(ClientController clientController, VoitureController voitureController) {
        this.clientcontroller = clientController;
        this.voiturecontroller = voitureController;

    }

    public void initConteneurPrincipal(){
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
        ConteneurGauche conteneurGauche = new ConteneurGauche();
        // Ajout du conteneur gauche au conteneur gris
        conteneurGris.add(conteneurGauche, BorderLayout.WEST);

        // Création du conteneur pour les bandes oranges
        ConteneurVoitures conteneurVoitures = new ConteneurVoitures(clientcontroller, voiturecontroller);
        // Ajout du conteneurVoitures au conteneur gris
        conteneurGris.add(conteneurVoitures, BorderLayout.CENTER);

        // Ajout du conteneur gris à ConteneurPrincipal
        add(conteneurGris, BorderLayout.CENTER);
    }
}

