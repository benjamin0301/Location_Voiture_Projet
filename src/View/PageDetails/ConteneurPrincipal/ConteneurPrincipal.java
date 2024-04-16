package View.PageDetails.ConteneurPrincipal;

import Model.VoitureModel;
import View.PageConfirmation.PageConfirmation;
import View.PageDetails.ConteneurPrincipal.ConteneurDroite.ConteneurDroite;
import View.PageDetails.ConteneurPrincipal.ConteneurFormulaires.ConteneurFormulaires;
import View.PageResultats.conteneurprincipal.Progression;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class ConteneurPrincipal extends JPanel
{
    private CardLayout cardLayout;
    private JPanel cardPanel;
    public ConteneurPrincipal(VoitureModel voiture) throws SQLException, ClassNotFoundException
    {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setBackground(Color.decode("#E4E4E4"));
        setBorder(BorderFactory.createMatteBorder(30, 0, 30, 0, Color.decode("#E4E4E4")));


        JPanel pagePrincipale = createPagePrincipale(voiture);
        JPanel nouvellePage = createNouvellePage(voiture);

        cardPanel.add(pagePrincipale, "PAGE_PRINCIPALE");
        cardPanel.add(nouvellePage, "NOUVELLE_PAGE");

        add(cardPanel);
    }
    private JPanel createNouvellePage(VoitureModel voiture)
    {
        PageConfirmation nouvellePage = new PageConfirmation(voiture);
        return nouvellePage;
    }
    private JPanel createPagePrincipale(VoitureModel voiture) throws SQLException, ClassNotFoundException
    {
        JPanel pagePrincipale = new JPanel(new BorderLayout());
        pagePrincipale.setBackground(Color.white);

        ProgressionDetails progressionDetails = new ProgressionDetails();
        ConteneurDroite conteneurDroite = new ConteneurDroite(voiture);

        ConteneurFormulaires conteneurFormulaires = new ConteneurFormulaires();
        JPanel englobeurCF = new JPanel();
        englobeurCF.setBackground(Color.white);
        englobeurCF.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.white));
        englobeurCF.add(conteneurFormulaires);

        JPanel panelConf = new JPanel();
        panelConf.setBackground(Color.white);
        panelConf.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc. weighty = 1;

        JButton confirmation = new JButton("Confirmer la réservation");
        confirmation.setPreferredSize(new Dimension(500, 45));
        confirmation.setFont(new Font("Georgia", Font.BOLD, 16));
        confirmation.setForeground(Color.white);
        confirmation.setBackground(Color.decode("#5E17EB"));

        panelConf.add(confirmation, gbc);

        gbc.gridy++;
        JPanel ebz = new JPanel();
        ebz.setBackground(Color.white);
        ebz.setPreferredSize(new Dimension(1000, 20));
        panelConf.add(ebz, gbc);

        pagePrincipale.add(progressionDetails, BorderLayout.NORTH);
        pagePrincipale.add(conteneurDroite, BorderLayout.EAST);
        pagePrincipale.add(englobeurCF, BorderLayout.CENTER);
        pagePrincipale.add(panelConf, BorderLayout.SOUTH);

        confirmation.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(cardPanel, "NOUVELLE_PAGE");
            }
        });
        return pagePrincipale;
    }
}
