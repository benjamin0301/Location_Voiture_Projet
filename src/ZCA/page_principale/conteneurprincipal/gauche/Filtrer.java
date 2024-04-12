package ZCA.page_principale.conteneurprincipal.gauche;

import javax.swing.*;
import java.awt.*;

public class Filtrer extends JPanel {
    public Filtrer() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

        // Panel pour le contenu à placer au centre
        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.decode("#FFFFFF")); // Couleur jaune
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelFiltrer = new JLabel("Filtrer");
        labelFiltrer.setPreferredSize(new Dimension(220, 50)); // Hauteur de 50px
        labelFiltrer.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelFiltrer.setBackground(Color.decode("#E6E6E6")); // Couleur jaune moutarde
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        JTextArea textAreaTransmission = new JTextArea("Transmission");
        textAreaTransmission.setPreferredSize(new Dimension(200, 20));
        textAreaTransmission.setEditable(false); // Empêche l'edition du texte
        textAreaTransmission.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(textAreaTransmission); // Ajout du texte

        JCheckBox checkBoxAutomatique = new JCheckBox("Automatique");
        checkBoxAutomatique.setPreferredSize(new Dimension(200, 20));
        checkBoxAutomatique.setBackground(Color.decode("#FFFFFF"));
        JCheckBox checkBoxManuelle = new JCheckBox("Manuelle");
        checkBoxManuelle.setPreferredSize(new Dimension(200, 20));
        checkBoxManuelle.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxAutomatique);
        contenuPanel.add(checkBoxManuelle);

        JTextArea barreHorizontale = new JTextArea("__________________________");
        barreHorizontale.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(barreHorizontale);

        JTextArea textAreaKilometrage = new JTextArea("Kilometrage");
        textAreaKilometrage.setPreferredSize(new Dimension(200, 20));
        textAreaKilometrage.setEditable(false); // Empêche l'édition du texte
        textAreaKilometrage.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(textAreaKilometrage); // Ajout du texte

        JCheckBox checkBoxLimite = new JCheckBox("Limité");
        checkBoxLimite.setPreferredSize(new Dimension(200, 20));
        checkBoxLimite.setBackground(Color.decode("#FFFFFF"));
        JCheckBox checkBoxIllimite = new JCheckBox("Illimité");
        checkBoxIllimite.setPreferredSize(new Dimension(200, 20));
        checkBoxIllimite.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxLimite);
        contenuPanel.add(checkBoxIllimite);

        // Ajout du contenuPanel au centre du BorderLayout
        add(contenuPanel, BorderLayout.CENTER);

        // Ajout du label "Filtrer" au nord du BorderLayout
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
