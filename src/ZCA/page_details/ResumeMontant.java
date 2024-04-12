package ZCA.page_details;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class ResumeMontant extends JPanel
{
    public ResumeMontant(VoitureModel voiture)
    {
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setPreferredSize(new Dimension(230, 300)); // Largeur de 230px, hauteur de 300px
        setBackground(Color.decode("#FFFFFF")); // Couleur jaune
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

        // Creation de la zone "Resume du trajet" au nord
        JLabel labelResume = new JLabel("Resume du montant");
        labelResume.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelResume.setVerticalAlignment(SwingConstants.CENTER); // Centre le texte verticalement
        labelResume.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelResume.setBackground(Color.decode("#E6E6E6")); // Couleur jaune moutarde
        labelResume.setPreferredSize(new Dimension(getWidth(), 50)); // Hauteur de 50px
        labelResume.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        add(labelResume, BorderLayout.NORTH);

        // Creation de la deuxième zone avec le texte specifie
        JPanel zoneTexte = new JPanel(new GridLayout(0, 1)); // GridLayout avec une colonne, plusieurs lignes
        zoneTexte.setBackground(Color.decode("#FFFFFF")); // Couleur de fond jaune

        JPanel tarifVoiture = new JPanel();
        tarifVoiture.setLayout(new BorderLayout());
        tarifVoiture.setBackground(Color.white);
        JTextArea descPrix = new JTextArea("Tarif de votre\nlocation de voiture");
        tarifVoiture.add(descPrix, BorderLayout.WEST);
        JTextArea prix = new JTextArea(String.valueOf(voiture.getPrix()));
        prix.setEditable(false); // Empêche l'edition du texte
        prix.setOpaque(false); // Rend le fond transparent
        tarifVoiture.add(prix, BorderLayout.EAST);

        JPanel remises = new JPanel();
        remises.setLayout(new BorderLayout());
        remises.setBackground(Color.white);
        JTextArea descRemises = new JTextArea("Remises");
        remises.add(descRemises, BorderLayout.WEST);

        float valRemise = 20;

        JTextArea ecritureRem = new JTextArea(String.valueOf(valRemise));
        ecritureRem.setEditable(false); // Empêche l'edition du texte
        ecritureRem.setOpaque(false); // Rend le fond transparent
        remises.add(ecritureRem, BorderLayout.EAST);

        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BorderLayout());
        panelTotal.setBackground(Color.white);
        JTextArea descTotal = new JTextArea("Total");
        panelTotal.add(descTotal, BorderLayout.WEST);
        float valTotale = voiture.getPrix() - valRemise;
        JTextArea valTotal = new JTextArea(String.valueOf(valTotale));
        valTotal.setEditable(false); // Empêche l'edition du texte
        valTotal.setOpaque(false); // Rend le fond transparent
        panelTotal.add(valTotal, BorderLayout.EAST);

        // Ajout d'une marge à la zone de texte
        zoneTexte.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        zoneTexte.add(tarifVoiture);
        zoneTexte.add(remises);
        zoneTexte.add(panelTotal);

        add(zoneTexte, BorderLayout.CENTER);
    }
}
