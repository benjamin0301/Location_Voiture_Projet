package ZCA;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class EspacePersonnel extends JPanel {
    public EspacePersonnel() throws SQLException, ClassNotFoundException {
        setLayout(new BorderLayout());

        // Création du contenu du titre
        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(Color.white);


        JTextArea titre = new JTextArea("\nMon espace personnel\n");
        titre.setFont(new Font("Aleo", Font.BOLD, 25));
        //titre.setPreferredSize(new Dimension(280, 80));
        panelTitre.add(titre);

        add(panelTitre, BorderLayout.NORTH);

        // Création du panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ajout de MesInfosPerso
        MesInfosPerso mesInfosPerso = new MesInfosPerso();
        panelPrincipal.add(mesInfosPerso, gbc);

        gbc.gridy++;
        // Ajout de MesReservations
        MesReservations mesReservations = new MesReservations();
        panelPrincipal.add(mesReservations, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        // Ajout d'un espace blanc pour remplir l'espace restant
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        panelPrincipal.add(espaceBlanc, gbc);

        // Ajout du panel principal au centre avec une bordure
        add(panelPrincipal, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85)); // Ajout d'une marge de 40px sur chaque côté
    }
}

