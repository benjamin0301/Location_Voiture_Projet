package View.PageDetails.ConteneurPrincipal.ConteneurFormulaires;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ConteneurFormulaires extends JPanel
{
    public ConteneurFormulaires() throws SQLException, ClassNotFoundException
    {
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;

        JPanel espaceB = new JPanel();
        espaceB.setBackground(Color.white);
        espaceB.setPreferredSize(new Dimension(600, 10));
        add(espaceB, gbc);

        gbc.gridy++;
        FormulaireConducteur formulaireConducteur = new FormulaireConducteur();
        add(formulaireConducteur, gbc);

        gbc.gridy++;
        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA, gbc);

        gbc.gridy++;
        FormulairePaiement formulairePaiement = new FormulairePaiement();
        add(formulairePaiement, gbc);

        gbc.gridy++;
        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.white);
        espaceVideB.setPreferredSize(new Dimension(700, 25));
        add(espaceVideB, gbc);

        gbc.gridy++;
        JPanel annulation = new JPanel();
        annulation.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        annulation.setBackground(Color.white);
        annulation.setPreferredSize(new Dimension(810, 70));
        annulation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        JPanel espaceVideAnnulation = new JPanel();
        espaceVideAnnulation.setBackground(Color.white);
        espaceVideAnnulation.setPreferredSize(new Dimension(700, 17));
        annulation.add(espaceVideAnnulation);

        JTextArea infoAnnulation = new JTextArea("Bonne nouvelle ! Vous pouvez modifier votre programme grâce à l’annulation gratuite\njusqu’à 48 heures avant le retrait du véhicule.");
        infoAnnulation.setForeground(Color.black);
        infoAnnulation.setFont(new Font("Georgia", Font.BOLD, 15));
        infoAnnulation.setAlignmentX(SwingConstants.LEFT);
        infoAnnulation.setAlignmentY(SwingConstants.CENTER);
        annulation.add(infoAnnulation);

        add(annulation, gbc);

        gbc.gridy++;
        gbc.weighty = 5;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }
}

