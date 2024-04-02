package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class Filtrer extends JPanel {
    public Filtrer() {
        setLayout(new BorderLayout());

        // Panel pour le contenu à placer au centre
        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.decode("#FFD700")); // Couleur jaune
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelFiltrer = new JLabel("Filtrer");
        labelFiltrer.setPreferredSize(new Dimension(220, 50)); // Hauteur de 50px
        labelFiltrer.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelFiltrer.setBackground(Color.decode("#C8A100")); // Couleur jaune moutarde
        contenuPanel.add(labelFiltrer);

        JTextArea textAreaTransmission = new JTextArea("Transmission");
        textAreaTransmission.setPreferredSize(new Dimension(200, 20));
        textAreaTransmission.setEditable(false); // Empêche l'édition du texte
        textAreaTransmission.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(textAreaTransmission); // Ajout du texte

        JCheckBox checkBoxAutomatique = new JCheckBox("Automatique");
        checkBoxAutomatique.setPreferredSize(new Dimension(200, 20));
        checkBoxAutomatique.setBackground(Color.decode("#FFD700"));
        JCheckBox checkBoxManuelle = new JCheckBox("Manuelle");
        checkBoxManuelle.setPreferredSize(new Dimension(200, 20));
        checkBoxManuelle.setBackground(Color.decode("#FFD700"));
        contenuPanel.add(checkBoxAutomatique);
        contenuPanel.add(checkBoxManuelle);

        JTextArea barreHorizontale = new JTextArea("__________________________");
        barreHorizontale.setBackground(Color.decode("#FFD700"));
        contenuPanel.add(barreHorizontale);

        JTextArea textAreaKilometrage = new JTextArea("Kilométrage");
        textAreaKilometrage.setPreferredSize(new Dimension(200, 20));
        textAreaKilometrage.setEditable(false); // Empêche l'édition du texte
        textAreaKilometrage.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(textAreaKilometrage); // Ajout du texte

        JCheckBox checkBoxLimite = new JCheckBox("Limité");
        checkBoxLimite.setPreferredSize(new Dimension(200, 20));
        checkBoxLimite.setBackground(Color.decode("#FFD700"));
        JCheckBox checkBoxIllimite = new JCheckBox("Illimité");
        checkBoxIllimite.setPreferredSize(new Dimension(200, 20));
        checkBoxIllimite.setBackground(Color.decode("#FFD700"));
        contenuPanel.add(checkBoxLimite);
        contenuPanel.add(checkBoxIllimite);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Ajout du contenuPanel au centre du BorderLayout
        add(contenuPanel, BorderLayout.CENTER);

        // Ajout du label "Filtrer" au nord du BorderLayout
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
