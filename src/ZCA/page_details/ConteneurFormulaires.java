package ZCA.page_details;

import ZCA.page_principale.conteneurprincipal.voitures.CarouselVoitures;
import ZCA.page_principale.conteneurprincipal.voitures.ListeVoitures;
import ZCA.page_principale.conteneurprincipal.voitures.NbVoituresDispo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;

public class ConteneurFormulaires extends JPanel {

    private CardLayout cardLayout; // CardLayout pour gérer les différentes pages
    private JPanel cardPanel; // Conteneur des pages

    public ConteneurFormulaires() throws SQLException, ClassNotFoundException
    {
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;

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

        JLabel infoAnnulation = new JLabel("<html>Bonne nouvelle ! Vous pouvez modifier votre programme grâce à <b>l’annulation gratuite</b> jusqu’à 48 heures avant le<br>retrait du véhicule.</html>");
        infoAnnulation.setForeground(Color.GRAY); // Couleur grise pour le texte
        infoAnnulation.setAlignmentX(SwingConstants.CENTER);
        infoAnnulation.setAlignmentY(SwingConstants.CENTER);
        annulation.add(infoAnnulation);

        add(annulation, gbc);

        gbc.gridy++;
        JPanel espaceVideC = new JPanel();
        espaceVideC.setBackground(Color.white);
        espaceVideC.setPreferredSize(new Dimension(700, 25));
        add(espaceVideC, gbc);


        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }
}

