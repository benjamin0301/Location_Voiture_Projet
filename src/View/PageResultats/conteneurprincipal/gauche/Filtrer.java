package View.PageResultats.conteneurprincipal.gauche;

import javax.swing.*;
import java.awt.*;

public class Filtrer extends JPanel
{
    public Filtrer()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel labelFiltrer = new JLabel("     Filtrer");
        labelFiltrer.setPreferredSize(new Dimension(220, 50));
        labelFiltrer.setOpaque(true);
        labelFiltrer.setFont(new Font("Georgia", Font.BOLD, 13));
        labelFiltrer.setHorizontalAlignment(SwingConstants.LEFT);
        labelFiltrer.setBackground(Color.decode("#E6E6E6"));
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        JPanel eBlanc = new JPanel();
        eBlanc.setPreferredSize(new Dimension(200, 2));
        eBlanc.setBackground(Color.white);
        contenuPanel.add(eBlanc);


        // Zone des Filtres :

        // Zone des Filtres :

        JTextArea taPrix = new JTextArea("Prix par jour");
        taPrix.setPreferredSize(new Dimension(200, 20));
        taPrix.setFont(new Font("Georgia", Font.BOLD, 12));
        taPrix.setEditable(false);
        taPrix.setOpaque(false);
        contenuPanel.add(taPrix);

        JCheckBox inf100 = new JCheckBox("< ou égal à 100€");
        inf100.setFont(new Font("Georgia", Font.PLAIN, 12));
        inf100.setPreferredSize(new Dimension(200, 20));
        inf100.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf100);

        JCheckBox inf200 = new JCheckBox("< ou égal à 200€");
        inf200.setPreferredSize(new Dimension(200, 20));
        inf200.setFont(new Font("Georgia", Font.PLAIN, 12));
        inf200.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf200);

        JCheckBox inf300 = new JCheckBox("< ou égal à 300€");
        inf300.setPreferredSize(new Dimension(200, 20));
        inf300.setFont(new Font("Georgia", Font.PLAIN, 12));
        inf300.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf300);

        JCheckBox sup300 = new JCheckBox("> 300€");
        sup300.setFont(new Font("Georgia", Font.PLAIN, 12));
        sup300.setPreferredSize(new Dimension(200, 20));
        sup300.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(sup300);

        JSeparator separatorO = new JSeparator(SwingConstants.HORIZONTAL);
        separatorO.setPreferredSize(new Dimension(190, 2));
        separatorO.setForeground(Color.darkGray);
        contenuPanel.add(separatorO);

        JTextArea taNote = new JTextArea("Notes des clients");
        taNote.setPreferredSize(new Dimension(200, 20));
        taNote.setFont(new Font("Georgia", Font.BOLD, 12));
        taNote.setEditable(false);
        taNote.setOpaque(false);
        contenuPanel.add(taNote);

        JCheckBox e5 = new JCheckBox("5 étoiles");
        e5.setPreferredSize(new Dimension(200, 20));
        e5.setFont(new Font("Georgia", Font.PLAIN, 12));
        e5.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e5);

        JCheckBox e4 = new JCheckBox("4 étoiles");
        e4.setPreferredSize(new Dimension(200, 20));
        e4.setFont(new Font("Georgia", Font.PLAIN, 12));
        e4.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e4);

        JCheckBox e3 = new JCheckBox("3 étoiles");
        e3.setPreferredSize(new Dimension(200, 20));
        e3.setFont(new Font("Georgia", Font.PLAIN, 12));
        e3.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(e3);

        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setPreferredSize(new Dimension(190, 2));
        separator1.setForeground(Color.darkGray);
        contenuPanel.add(separator1);

        JTextArea textAreaTransmission = new JTextArea("Transmission");
        textAreaTransmission.setPreferredSize(new Dimension(200, 20));
        textAreaTransmission.setFont(new Font("Georgia", Font.BOLD, 12));
        textAreaTransmission.setEditable(false);
        textAreaTransmission.setOpaque(false);
        contenuPanel.add(textAreaTransmission);

        // Création d'un groupe de boutons
        ButtonGroup buttonGroup = new ButtonGroup();

// Création du bouton radio "Automatique"
        JRadioButton radioButtonAutomatique = new JRadioButton("Automatique");
        radioButtonAutomatique.setPreferredSize(new Dimension(200, 20));
        radioButtonAutomatique.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonAutomatique.setBackground(Color.decode("#FFFFFF"));
        buttonGroup.add(radioButtonAutomatique); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonAutomatique);

// Création du bouton radio "Manuelle"
        JRadioButton radioButtonManuelle = new JRadioButton("Manuelle");
        radioButtonManuelle.setPreferredSize(new Dimension(200, 20));
        radioButtonManuelle.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonManuelle.setBackground(Color.decode("#FFFFFF"));
        buttonGroup.add(radioButtonManuelle); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonManuelle);




        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(190, 2));
        separator.setForeground(Color.darkGray);
        contenuPanel.add(separator);

        JTextArea textAreaKilometrage = new JTextArea("Kilométrage");
        textAreaKilometrage.setPreferredSize(new Dimension(200, 20));
        textAreaKilometrage.setFont(new Font("Georgia", Font.BOLD, 12));
        textAreaKilometrage.setEditable(false);
        textAreaKilometrage.setOpaque(false);
        contenuPanel.add(textAreaKilometrage);

        // Création d'un groupe de boutons
        ButtonGroup buttonGroupLimite = new ButtonGroup();

// Création du bouton radio "Limité"
        JRadioButton radioButtonLimite = new JRadioButton("Limité");
        radioButtonLimite.setPreferredSize(new Dimension(200, 20));
        radioButtonLimite.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonLimite.setBackground(Color.decode("#FFFFFF"));
        buttonGroupLimite.add(radioButtonLimite); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonLimite);

// Création du bouton radio "Illimité"
        JRadioButton radioButtonIllimite = new JRadioButton("Illimité");
        radioButtonIllimite.setPreferredSize(new Dimension(200, 20));
        radioButtonIllimite.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonIllimite.setBackground(Color.decode("#FFFFFF"));
        buttonGroupLimite.add(radioButtonIllimite); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonIllimite);


        JSeparator separatorB = new JSeparator(SwingConstants.HORIZONTAL);
        separatorB.setPreferredSize(new Dimension(190, 2));
        separatorB.setForeground(Color.darkGray);
        contenuPanel.add(separatorB);

        JTextArea taElectrique = new JTextArea("Véhicule électrique ?");
        taElectrique.setPreferredSize(new Dimension(200, 20));
        taElectrique.setFont(new Font("Georgia", Font.BOLD, 12));
        taElectrique.setEditable(false);
        taElectrique.setOpaque(false);
        contenuPanel.add(taElectrique);

        // Création d'un groupe de boutons
        ButtonGroup buttonGroupOuiNon = new ButtonGroup();

// Création du bouton radio "Oui"
        JRadioButton radioButtonOui = new JRadioButton("Oui");
        radioButtonOui.setPreferredSize(new Dimension(200, 20));
        radioButtonOui.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonOui.setBackground(Color.decode("#FFFFFF"));
        buttonGroupOuiNon.add(radioButtonOui); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonOui);

// Création du bouton radio "Non"
        JRadioButton radioButtonNon = new JRadioButton("Non");
        radioButtonNon.setPreferredSize(new Dimension(200, 20));
        radioButtonNon.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonNon.setBackground(Color.decode("#FFFFFF"));
        buttonGroupOuiNon.add(radioButtonNon); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonNon);

        JSeparator separatorC = new JSeparator(SwingConstants.HORIZONTAL);
        separatorC.setPreferredSize(new Dimension(190, 2));
        separatorC.setForeground(Color.darkGray);
        contenuPanel.add(separatorC);

        JTextArea nbP = new JTextArea("Nombre de passagers");
        nbP.setPreferredSize(new Dimension(200, 20));
        nbP.setFont(new Font("Georgia", Font.BOLD, 12));
        nbP.setEditable(false);
        nbP.setOpaque(false);
        contenuPanel.add(nbP);

        // Création d'un groupe de boutons
        ButtonGroup buttonGroupInfSup = new ButtonGroup();

// Création du bouton radio "1-4"
        JRadioButton radioButtonInf4 = new JRadioButton("1-4");
        radioButtonInf4.setPreferredSize(new Dimension(200, 20));
        radioButtonInf4.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonInf4.setBackground(Color.decode("#FFFFFF"));
        buttonGroupInfSup.add(radioButtonInf4); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonInf4);

// Création du bouton radio "5+"
        JRadioButton radioButtonSup5 = new JRadioButton("5+");
        radioButtonSup5.setPreferredSize(new Dimension(200, 20));
        radioButtonSup5.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonSup5.setBackground(Color.decode("#FFFFFF"));
        buttonGroupInfSup.add(radioButtonSup5); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonSup5);


        JSeparator separatorD = new JSeparator(SwingConstants.HORIZONTAL);
        separatorD.setPreferredSize(new Dimension(190, 2));
        separatorD.setForeground(Color.darkGray);
        contenuPanel.add(separatorD);

        JTextArea nbB = new JTextArea("Nombre de bagages");
        nbB.setPreferredSize(new Dimension(200, 20));
        nbB.setFont(new Font("Georgia", Font.BOLD, 12));
        nbB.setEditable(false);
        nbB.setOpaque(false);
        contenuPanel.add(nbB);

        // Création d'un groupe de boutons
        ButtonGroup buttonGroupInf3Sup4 = new ButtonGroup();

// Création du bouton radio "1-3"
        JRadioButton radioButtonInf3 = new JRadioButton("1-3");
        radioButtonInf3.setPreferredSize(new Dimension(200, 20));
        radioButtonInf3.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonInf3.setBackground(Color.decode("#FFFFFF"));
        buttonGroupInf3Sup4.add(radioButtonInf3); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonInf3);

// Création du bouton radio "4+"
        JRadioButton radioButtonSup4 = new JRadioButton("4+");
        radioButtonSup4.setPreferredSize(new Dimension(200, 20));
        radioButtonSup4.setFont(new Font("Georgia", Font.PLAIN, 12));
        radioButtonSup4.setBackground(Color.decode("#FFFFFF"));
        buttonGroupInf3Sup4.add(radioButtonSup4); // Ajout au groupe de boutons
        contenuPanel.add(radioButtonSup4);





        add(contenuPanel, BorderLayout.CENTER);
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
