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

        JCheckBox checkBoxAutomatique = new JCheckBox("Automatique");
        checkBoxAutomatique.setPreferredSize(new Dimension(200, 20));
        checkBoxAutomatique.setFont(new Font("Georgia", Font.PLAIN, 12));
        checkBoxAutomatique.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxAutomatique);

        JCheckBox checkBoxManuelle = new JCheckBox("Manuelle");
        checkBoxManuelle.setPreferredSize(new Dimension(200, 20));
        checkBoxManuelle.setFont(new Font("Georgia", Font.PLAIN, 12));
        checkBoxManuelle.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxManuelle);

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

        JCheckBox checkBoxLimite = new JCheckBox("Limité");
        checkBoxLimite.setPreferredSize(new Dimension(200, 20));
        checkBoxLimite.setFont(new Font("Georgia", Font.PLAIN, 12));
        checkBoxLimite.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxLimite);

        JCheckBox checkBoxIllimite = new JCheckBox("Illimité");
        checkBoxIllimite.setPreferredSize(new Dimension(200, 20));
        checkBoxIllimite.setFont(new Font("Georgia", Font.PLAIN, 12));
        checkBoxIllimite.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(checkBoxIllimite);

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

        JCheckBox oui = new JCheckBox("Oui");
        oui.setPreferredSize(new Dimension(200, 20));
        oui.setFont(new Font("Georgia", Font.PLAIN, 12));
        oui.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(oui);

        JCheckBox non = new JCheckBox("Non");
        non.setPreferredSize(new Dimension(200, 20));
        non.setFont(new Font("Georgia", Font.PLAIN, 12));
        non.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(non);

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

        JCheckBox inf4 = new JCheckBox("1-4");
        inf4.setPreferredSize(new Dimension(200, 20));
        inf4.setFont(new Font("Georgia", Font.PLAIN, 12));
        inf4.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf4);

        JCheckBox sup5 = new JCheckBox("5+");
        sup5.setPreferredSize(new Dimension(200, 20));
        sup5.setFont(new Font("Georgia", Font.PLAIN, 12));
        sup5.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(sup5);

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

        JCheckBox inf3 = new JCheckBox("1-3");
        inf3.setPreferredSize(new Dimension(200, 20));
        inf3.setFont(new Font("Georgia", Font.PLAIN, 12));
        inf3.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(inf3);

        JCheckBox sup4 = new JCheckBox("4+");
        sup4.setPreferredSize(new Dimension(200, 20));
        sup4.setFont(new Font("Georgia", Font.PLAIN, 12));
        sup4.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.add(sup4);




        add(contenuPanel, BorderLayout.CENTER);
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
