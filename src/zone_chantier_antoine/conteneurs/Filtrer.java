package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class Filtrer extends JPanel {
    public Filtrer() {
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
        setBackground(Color.decode("#FFD700")); // Couleur jaune
        setPreferredSize(new Dimension(230, 200)); // Largeur de 230px, hauteur de 300px

        // Création de la zone "Filtrer"
        JLabel labelFiltrer = new JLabel("Filtrer");
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelFiltrer.setVerticalAlignment(SwingConstants.CENTER); // Centre le texte verticalement
        labelFiltrer.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelFiltrer.setBackground(Color.decode("#C8A100")); // Couleur jaune moutarde
        labelFiltrer.setPreferredSize(new Dimension(getWidth(), 50)); // Hauteur de 50px
        add(labelFiltrer, BorderLayout.NORTH);

        // Création du panneau central pour les options
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(6, 1, 0, 5)); // Layout en grille pour aligner les éléments verticalement avec un espacement de 5 pixels entre chaque élément
        panelCentral.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Réduction des marges

        // Ajout du texte "Transmission"
        JTextArea textAreaTransmission = new JTextArea("Transmission");
        textAreaTransmission.setEditable(false); // Empêche l'édition du texte
        textAreaTransmission.setOpaque(false); // Rend le fond transparent
        panelCentral.add(textAreaTransmission); // Ajout du texte

        // Création d'un panneau pour contenir les checkboxes de "Transmission"
        JPanel panelCheckboxesTransmission = new JPanel();
        panelCheckboxesTransmission.setLayout(new GridLayout(2, 1)); // Layout en grille pour aligner les checkboxes verticalement

        // Création des checkboxes pour "Automatique" et "Manuelle"
        JCheckBox checkBoxAutomatique = new JCheckBox("Automatique");
        JCheckBox checkBoxManuelle = new JCheckBox("Manuelle");
        // Ajout des checkboxes au panneau des checkboxes
        panelCheckboxesTransmission.add(checkBoxAutomatique);
        panelCheckboxesTransmission.add(checkBoxManuelle);

        // Ajout du panneau des checkboxes de "Transmission" dans le panneau central
        panelCentral.add(panelCheckboxesTransmission); // Ajout des checkboxes

        // Ajout de l'espacement
        panelCentral.add(Box.createVerticalStrut(5)); // Espacement de 5 pixels

        // Ajout du texte "Kilométrage"
        JTextArea textAreaKilometrage = new JTextArea("Kilométrage");
        textAreaKilometrage.setEditable(false); // Empêche l'édition du texte
        textAreaKilometrage.setOpaque(false); // Rend le fond transparent
        panelCentral.add(textAreaKilometrage); // Ajout du texte

        // Création d'un panneau pour contenir les checkboxes de "Kilométrage"
        JPanel panelCheckboxesKilometrage = new JPanel();
        panelCheckboxesKilometrage.setLayout(new GridLayout(2, 1)); // Layout en grille pour aligner les checkboxes verticalement

        // Création des checkboxes pour "Limité" et "Illimité"
        JCheckBox checkBoxLimite = new JCheckBox("Limité");
        JCheckBox checkBoxIllimite = new JCheckBox("Illimité");
        // Ajout des checkboxes au panneau des checkboxes
        panelCheckboxesKilometrage.add(checkBoxLimite);
        panelCheckboxesKilometrage.add(checkBoxIllimite);

        // Ajout du panneau des checkboxes de "Kilométrage" dans le panneau central
        panelCentral.add(panelCheckboxesKilometrage); // Ajout des checkboxes

        // Ajout du panneau central au BorderLayout, juste après la zone "NORTH"
        add(panelCentral, BorderLayout.CENTER);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
