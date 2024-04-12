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
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel labelFiltrer = new JLabel("Filtrer");
        labelFiltrer.setPreferredSize(new Dimension(220, 50)); // Hauteur de 50px
        labelFiltrer.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelFiltrer.setBackground(Color.decode("#E6E6E6")); // Couleur jaune moutarde
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        ///////



        JTextArea taPrix = new JTextArea("Prix par jour");
        taPrix.setPreferredSize(new Dimension(200, 20));
        taPrix.setEditable(false); // Empêche l'édition du texte
        taPrix.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(taPrix); // Ajout du texte

        JCheckBox inf100 = new JCheckBox("< ou égal à 100€");
        inf100.setPreferredSize(new Dimension(200, 20));
        inf100.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf100);

        JCheckBox inf200 = new JCheckBox("< ou égal à 200€");
        inf200.setPreferredSize(new Dimension(200, 20));
        inf200.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf200);

        JCheckBox inf300 = new JCheckBox("< ou égal à 300€");
        inf300.setPreferredSize(new Dimension(200, 20));
        inf300.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf300);

        JCheckBox sup300 = new JCheckBox("> 300€");
        sup300.setPreferredSize(new Dimension(200, 20));
        sup300.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(sup300);

        /// FIN PANEL Prix


        JSeparator separatorO = new JSeparator(SwingConstants.HORIZONTAL);
        separatorO.setPreferredSize(new Dimension(190, 2));
        separatorO.setForeground(Color.darkGray);
        contenuPanel.add(separatorO);


        ///

        JTextArea taNote = new JTextArea("Notes des clients");
        taNote.setPreferredSize(new Dimension(200, 20));
        taNote.setEditable(false); // Empêche l'édition du texte
        taNote.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(taNote); // Ajout du texte

        JCheckBox e5 = new JCheckBox("5 étoiles");
        e5.setPreferredSize(new Dimension(200, 20));
        e5.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e5);

        JCheckBox e4 = new JCheckBox("4 étoiles");
        e4.setPreferredSize(new Dimension(200, 20));
        e4.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e4);

        JCheckBox e3 = new JCheckBox("3 étoiles");
        e3.setPreferredSize(new Dimension(200, 20));
        e3.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e3);

        ///

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setPreferredSize(new Dimension(190, 2));
        separator1.setForeground(Color.darkGray);
        contenuPanel.add(separator1);

        /// PANEL TRANSMISSION

        JTextArea textAreaTransmission = new JTextArea("Transmission");
        textAreaTransmission.setPreferredSize(new Dimension(200, 20));
        textAreaTransmission.setEditable(false); // Empêche l'edition du texte
        textAreaTransmission.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(textAreaTransmission); // Ajout du texte

        JCheckBox checkBoxAutomatique = new JCheckBox("Automatique");
        checkBoxAutomatique.setPreferredSize(new Dimension(200, 20));
        checkBoxAutomatique.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxAutomatique);

        JCheckBox checkBoxManuelle = new JCheckBox("Manuelle");
        checkBoxManuelle.setPreferredSize(new Dimension(200, 20));
        checkBoxManuelle.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxManuelle);

        /// FIN PANEL TRANSMISSION


        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(190, 2));
        separator.setForeground(Color.darkGray);
        contenuPanel.add(separator);

        /// PANEL KILOMETRAGE

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

        /// FIN PANEL KILOMETRAGE

        JSeparator separatorB = new JSeparator(SwingConstants.HORIZONTAL);
        separatorB.setPreferredSize(new Dimension(190, 2));
        separatorB.setForeground(Color.darkGray);
        contenuPanel.add(separatorB);

        /// PANEL VEHICULE ELECTRIQUE

        JTextArea taElectrique = new JTextArea("Véhicule électrique ?");
        taElectrique.setPreferredSize(new Dimension(200, 20));
        taElectrique.setEditable(false); // Empêche l'édition du texte
        taElectrique.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(taElectrique); // Ajout du texte

        JCheckBox oui = new JCheckBox("Oui");
        oui.setPreferredSize(new Dimension(200, 20));
        oui.setBackground(Color.decode("#FFFFFF"));
        JCheckBox non = new JCheckBox("Non");
        non.setPreferredSize(new Dimension(200, 20));
        non.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(oui);
        contenuPanel.add(non);

        /// FIN PANEL VEHICULE ELECTRIQUE

        JSeparator separatorC = new JSeparator(SwingConstants.HORIZONTAL);
        separatorC.setPreferredSize(new Dimension(190, 2));
        separatorC.setForeground(Color.darkGray);
        contenuPanel.add(separatorC);

        /// PANEL NOMBRE PLACES

        JTextArea nbP = new JTextArea("Nombre de passagers");
        nbP.setPreferredSize(new Dimension(200, 20));
        nbP.setEditable(false); // Empêche l'édition du texte
        nbP.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(nbP); // Ajout du texte

        JCheckBox inf4 = new JCheckBox("1-4");
        inf4.setPreferredSize(new Dimension(200, 20));
        inf4.setBackground(Color.decode("#FFFFFF"));
        JCheckBox sup5 = new JCheckBox("5+");
        sup5.setPreferredSize(new Dimension(200, 20));
        sup5.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf4);
        contenuPanel.add(sup5);

        /// FIN PANEL NOMBRE PLACES

        JSeparator separatorD = new JSeparator(SwingConstants.HORIZONTAL);
        separatorD.setPreferredSize(new Dimension(190, 2));
        separatorD.setForeground(Color.darkGray);
        contenuPanel.add(separatorD);

        /// PANEL NOMBRE PLACES

        JTextArea nbB = new JTextArea("Nombre de bagages");
        nbB.setPreferredSize(new Dimension(200, 20));
        nbB.setEditable(false); // Empêche l'édition du texte
        nbB.setOpaque(false); // Rend le fond transparent
        contenuPanel.add(nbB); // Ajout du texte

        JCheckBox inf3 = new JCheckBox("1-3");
        inf3.setPreferredSize(new Dimension(200, 20));
        inf3.setBackground(Color.decode("#FFFFFF"));
        JCheckBox sup4 = new JCheckBox("4+");
        sup4.setPreferredSize(new Dimension(200, 20));
        sup4.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf3);
        contenuPanel.add(sup4);

        // Ajout du contenuPanel au centre du BorderLayout
        add(contenuPanel, BorderLayout.CENTER);

        // Ajout du label "Filtrer" au nord du BorderLayout
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
