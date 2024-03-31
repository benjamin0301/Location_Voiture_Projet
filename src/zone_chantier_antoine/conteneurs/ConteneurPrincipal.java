package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurPrincipal extends JPanel {
    public ConteneurPrincipal() {
        // Création du conteneur gris qui enveloppe le contenu existant
        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.decode("#E4E4E4")); // Fond gris
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85)); // Ajout d'un espace vide

        // Définition du layout pour le ConteneurPrincipal actuel
        setLayout(new BorderLayout());

        // Création de la bande rose
        Progression progression = new Progression(); // Création de l'instance de la classe Progression
        conteneurGris.add(progression, BorderLayout.NORTH); // Ajou // Ajout de la bande rose au conteneur gris

        // Création du conteneur horizontal pour la gauche
        ConteneurGauche conteneurGauche = new ConteneurGauche();
        // Ajout du conteneur gauche au conteneur gris
        conteneurGris.add(conteneurGauche, BorderLayout.WEST);

        // Création du conteneur pour les bandes oranges
        CarouselVoitures carouselVoitures = new CarouselVoitures(); // Création du carousel de voitures
        conteneurGris.add(carouselVoitures, BorderLayout.CENTER); // Ajout du carousel au conteneur gris

        // Ajout du conteneur gris à ConteneurPrincipal
        add(conteneurGris, BorderLayout.CENTER);
    }
}
