package ZCA.page_principale.conteneurprincipal.gauche;

import javax.swing.*;
import java.awt.*;

public class ConteneurGauche extends JPanel {
    public ConteneurGauche()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Utilisation d'un BorderLayout
        setBackground(Color.decode("#FFFFFF")); // Couleur verte
        setPreferredSize(new Dimension(250, 1500)); // Taille préférée

        // Création du conteneur pour le résumé du trajet
        ResumeTrajet resumeTrajet = new ResumeTrajet();
        resumeTrajet.setPreferredSize(new Dimension(230, 300));
        add(resumeTrajet);

        // Création du conteneur pour le filtrage
        Filtrer filtrer = new Filtrer();
        filtrer.setPreferredSize(new Dimension(230, 900));
        // Ajout du conteneur sous l'espace vertical
        add(filtrer);
    }
}
