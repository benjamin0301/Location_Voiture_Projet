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

        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.decode("#E4E4E4"));
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));

        JPanel pagePrincipale = createPagePrincipale(voiture);
        JPanel nouvellePage = createNouvellePage(voiture);

        cardPanel.add(pagePrincipale, "PAGE_PRINCIPALE");
        cardPanel.add(nouvellePage, "NOUVELLE_PAGE");

        conteneurGris.add(cardPanel, BorderLayout.CENTER);
        add(conteneurGris);
    }
    private JPanel createNouvellePage(VoitureModel voiture)
    {
        PageConfirmation nouvellePage = new PageConfirmation(voiture);
        return nouvellePage;
    }
    private JPanel createPagePrincipale(VoitureModel voiture) throws SQLException, ClassNotFoundException
    {
        JPanel pagePrincipale = new JPanel(new BorderLayout());

        Progression progression = new Progression();
        ConteneurDroite conteneurDroite = new ConteneurDroite(voiture);
        ConteneurFormulaires conteneurFormulaires = new ConteneurFormulaires();
        JButton confirmation = new JButton("Confirmer la reservation");

        pagePrincipale.add(progression, BorderLayout.NORTH);
        pagePrincipale.add(conteneurDroite, BorderLayout.EAST);
        pagePrincipale.add(conteneurFormulaires, BorderLayout.CENTER);
        pagePrincipale.add(confirmation, BorderLayout.SOUTH);

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
