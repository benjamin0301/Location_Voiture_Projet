package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel {
    public ConteneurGauche() {
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setBackground(Color.decode("#9D6BFF")); // Couleur verte
        setPreferredSize(new Dimension(250, getHeight())); // Taille préférée

        // Création du conteneur pour le résumé du trajet
        ResumeTrajet resumeTrajet = new ResumeTrajet();
        // Ajout du conteneur au nord avec marge de 20 pixels
        add(resumeTrajet, BorderLayout.NORTH);

        // Création de l'espace vertical entre le résumé du trajet et le conteneur "Filtrer"
        JPanel espaceVertical = new JPanel();
        espaceVertical.setPreferredSize(new Dimension(10, 15)); // Taille de l'espace vertical
        espaceVertical.setBackground(Color.decode("#9D6BFF")); // Couleur verte
        add(espaceVertical, BorderLayout.CENTER);

        // Création du conteneur pour le filtrage
        Filtrer filtrer = new Filtrer();
        // Ajout du conteneur sous l'espace vertical
        add(filtrer, BorderLayout.SOUTH);

        // Ajout d'une bordure avec une marge de 15 pixels sur les quatre côtés
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }
}
