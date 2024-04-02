package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel {
    public ConteneurGauche()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10)); // Utilisation d'un BorderLayout
        setBackground(Color.decode("#9D6BFF")); // Couleur verte
        setPreferredSize(new Dimension(250, 1500)); // Taille préférée

        // Création du conteneur pour le résumé du trajet
        ResumeTrajet resumeTrajet = new ResumeTrajet();
        resumeTrajet.setPreferredSize(new Dimension(230, 300));
        add(resumeTrajet);

        // Création du conteneur pour le filtrage
        Filtrer filtrer = new Filtrer();
        filtrer.setPreferredSize(new Dimension(230, 800));
        // Ajout du conteneur sous l'espace vertical
        add(filtrer);
    }
}
