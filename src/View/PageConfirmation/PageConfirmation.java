package View.PageConfirmation;

import Model.VoitureModel;
import View.PageEspacePersonnel.EspacePersonnel;
import View.PageResultats.conteneurprincipal.Progression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PageConfirmation extends JPanel
{
    public PageConfirmation(VoitureModel voiture)
    {
        setLayout(new BorderLayout());

        ProgConfirmation progConfirmation = new ProgConfirmation();
        add(progConfirmation, BorderLayout.NORTH);

        JPanel contPrin = new JPanel();
        contPrin.setLayout(new GridBagLayout());
        contPrin.setBackground(Color.white);

        JPanel panneauConfirmation = new JPanel();
        panneauConfirmation.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panneauConfirmation.setPreferredSize(new Dimension(1000, 500));
        panneauConfirmation.setBackground(Color.white);
        panneauConfirmation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JLabel messageConf = new JLabel("Votre reservation est confirmee !");
        messageConf.setFont(new Font("Aleo", Font.BOLD, 30));
        messageConf.setBackground(Color.white);
        panneauConfirmation.add(messageConf);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(950, 2));
        separator.setForeground(Color.darkGray);
        panneauConfirmation.add(separator);

        JLabel labelResume = new JLabel("Resume de votre reservation");
        labelResume.setFont(new Font("Aleo", Font.BOLD, 15));
        labelResume.setPreferredSize(new Dimension(900, 30));
        labelResume.setBackground(Color.white);
        panneauConfirmation.add(labelResume);

        JTextArea nomVoiture = new JTextArea(voiture.getMarque() + " " + voiture.getnom_modele());
        nomVoiture.setPreferredSize(new Dimension(900, 30));
        nomVoiture.setFont(new Font("Aleo", Font.PLAIN, 15));
        panneauConfirmation.add(nomVoiture);

        JTextArea ACapacites = new JTextArea(voiture.getNbPlace() + " 👤 | " + voiture.getCapaciteValise() + " 👜 | " + voiture.getNbPorte() + " 🚪");
        ACapacites.setPreferredSize(new Dimension(900, 30));
        ACapacites.setFont(new Font("Aleo", Font.PLAIN, 15));
        panneauConfirmation.add(ACapacites);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge entre les composants
        contPrin.add(panneauConfirmation, gbc);

        gbc.gridy++;
        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new BorderLayout());
        panelBoutons.setPreferredSize(new Dimension(600, 60));
        panelBoutons.setBackground(Color.white);

        JButton boutonFac = new JButton("Telecharger la facture");
        boutonFac.setBackground(Color.white);
        boutonFac.setPreferredSize(new Dimension(230, 50));
        panelBoutons.add(boutonFac, BorderLayout.WEST);

        JButton boutonEC = new JButton("J'accède à mon espace personnel");
        boutonEC.setBackground(Color.white);
        boutonEC.setPreferredSize(new Dimension(230, 50));
        panelBoutons.add(boutonEC, BorderLayout.EAST);

        contPrin.add(panelBoutons, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        contPrin.add(espaceBlanc, gbc);

        boutonEC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creation de la nouvelle page (JPanel bleu)
                EspacePersonnel espacePersonnel = null;
                try {
                    espacePersonnel = new EspacePersonnel();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // Retrait de la page actuelle et ajout de la nouvelle page
                removeAll();
                add(espacePersonnel, BorderLayout.CENTER);

                // Rafraîchissement de l'affichage
                revalidate();
                repaint();
            }
        });


        add(contPrin, BorderLayout.CENTER);
    }
}
