package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel
{
    public ConteneurGauche() {
        setBackground(Color.decode("#46D8FF"));
        setPreferredSize(new Dimension(200, getHeight()));

        // Ajout d'éléments dans le conteneur placé à gauche
        JLabel labelGauche = new JLabel("Conteneur Gauche");
        labelGauche.setForeground(Color.WHITE);
        add(labelGauche);

        JPanel conteneurInterne = new JPanel();
        conteneurInterne.setBackground(Color.decode("#6B21FF")); // Exemple de couleur de fond
        conteneurInterne.setPreferredSize(new Dimension(getWidth(), 100)); // Exemple de taille
    }
}

