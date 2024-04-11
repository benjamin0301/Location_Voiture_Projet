package ZCA.page_details;

import ZCA.page_principale.conteneurprincipal.gauche.Filtrer;
import ZCA.page_principale.conteneurprincipal.gauche.ResumeTrajet;

import javax.swing.*;
import java.awt.*;

public class ConteneurDroite extends JPanel
{
    public ConteneurDroite()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20)); // Utilisation d'un BorderLayout
        setBackground(Color.decode("#FFFFFF")); // Couleur verte
        setPreferredSize(new Dimension(250, 1500)); // Taille préférée

        // Création du conteneur pour le résumé du trajet
        ResumeMontant resumeMontant = new ResumeMontant();
        resumeMontant.setPreferredSize(new Dimension(230, 300));
        add(resumeMontant);

        // Création du conteneur pour le filtrage
        InfosVoitureSelect infosVoitureSelect = new InfosVoitureSelect();
        infosVoitureSelect.setPreferredSize(new Dimension(230, 800));
        // Ajout du conteneur sous l'espace vertical
        add(infosVoitureSelect);
    }
}
