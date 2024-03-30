package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurPrincipal extends JPanel {
    public ConteneurPrincipal() {
        // Création du conteneur gris qui enveloppe le contenu existant
        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.GRAY); // Fond gris
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85)); // Ajout d'un espace vide

        // Définition du layout pour le ConteneurPrincipal actuel
        setLayout(new BorderLayout());

        // Création de la bande rose
        JPanel bandeRose = new JPanel();
        bandeRose.setBackground(Color.PINK);
        bandeRose.setPreferredSize(new Dimension(getWidth(), 70)); // Hauteur de 70px
        conteneurGris.add(bandeRose, BorderLayout.NORTH); // Ajout de la bande rose au conteneur gris

        // Création du conteneur horizontal pour la gauche
        JPanel conteneurGauche = new JPanel();
        conteneurGauche.setLayout(new BoxLayout(conteneurGauche, BoxLayout.Y_AXIS));
        conteneurGauche.setBackground(Color.decode("#000000")); // Couleur verte
        conteneurGauche.setPreferredSize(new Dimension(250, getHeight())); // Taille préférée
        conteneurGris.add(conteneurGauche, BorderLayout.WEST); // Ajout du conteneur gauche au conteneur gris

        // Ajout du conteneur gris à ConteneurPrincipal
        add(conteneurGris, BorderLayout.CENTER);

        // Création du conteneur pour les bandes bleues
        JPanel conteneurBleu = new JPanel();
        conteneurBleu.setLayout(new BoxLayout(conteneurBleu, BoxLayout.Y_AXIS)); // Utilisation d'un BoxLayout vertical

        // Ajout des bandes bleues au conteneur bleu
        for (int i = 0; i < 20; i++) {
            JPanel petitPanel = new JPanel();
            if (i % 2 == 0) {
                petitPanel.setBackground(Color.decode("#2B51FF")); // Bleu clair
            } else {
                petitPanel.setBackground(Color.decode("#0066CC")); // Bleu foncé
            }
            petitPanel.setPreferredSize(new Dimension(100, 50));
            conteneurBleu.add(petitPanel);
        }

        // Ajout du conteneur bleu au conteneur principal
        conteneurGris.add(conteneurBleu, BorderLayout.CENTER);
    }
}
