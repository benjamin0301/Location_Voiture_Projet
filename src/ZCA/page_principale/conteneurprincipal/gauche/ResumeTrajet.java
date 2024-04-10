package ZCA.page_principale.conteneurprincipal.gauche;

import javax.swing.*;
import java.awt.*;

public class ResumeTrajet extends JPanel {
    public ResumeTrajet() {
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setPreferredSize(new Dimension(230, 300)); // Largeur de 230px, hauteur de 300px
        setBackground(Color.decode("#FFFFFF")); // Couleur jaune
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

        // Création de la zone "Résumé du trajet" au nord
        JLabel labelResume = new JLabel("Résumé du trajet");
        labelResume.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelResume.setVerticalAlignment(SwingConstants.CENTER); // Centre le texte verticalement
        labelResume.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelResume.setBackground(Color.decode("#E6E6E6")); // Couleur jaune moutarde
        labelResume.setPreferredSize(new Dimension(getWidth(), 50)); // Hauteur de 50px
        labelResume.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        add(labelResume, BorderLayout.NORTH);

        // Création de la deuxième zone avec le texte spécifié
        JPanel zoneTexte = new JPanel(new GridLayout(0, 1)); // GridLayout avec une colonne, plusieurs lignes
        zoneTexte.setBackground(Color.decode("#FFFFFF")); // Couleur de fond jaune

        String texte = "Prise en charge\n" +
                "Paris - Aéroport d'Orly\n" +
                "4 avril 2024\n" +
                "10:00\n" +
                "\n" +
                "Retour\n" +
                "Paris - Aéroport d'Orly\n" +
                "5 avril 2024\n" +
                "10:00\n" +
                "\n" +
                "Devise : EUR";

        JTextArea textArea = new JTextArea(texte);
        textArea.setEditable(false); // Empêche l'édition du texte
        textArea.setOpaque(false); // Rend le fond transparent

        // Ajout d'une marge à la zone de texte
        zoneTexte.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 0));
        zoneTexte.add(textArea);

        add(zoneTexte, BorderLayout.CENTER);

        // Création du bouton "Modifier" en bas à droite
        JButton boutonModifier = new JButton("Modifier");
        JPanel panelBouton = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alignement à droite
        panelBouton.add(boutonModifier);
        panelBouton.setBackground(Color.decode("#FFFFFF"));
        add(panelBouton, BorderLayout.SOUTH);
    }
}
