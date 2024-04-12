package ZCA.page_details;

import Model.VoitureModel;
import ZCA.page_principale.conteneurprincipal.Progression;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class ConteneurPrincipalDetails extends JPanel {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public ConteneurPrincipalDetails(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.decode("#E4E4E4"));
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));

        // Creation des differentes pages
        JPanel pagePrincipale = createPagePrincipale(voiture);
        JPanel nouvellePage = createNouvellePage(voiture);

        // Ajout des pages au cardPanel avec des noms associes
        cardPanel.add(pagePrincipale, "PAGE_PRINCIPALE");
        cardPanel.add(nouvellePage, "NOUVELLE_PAGE");

        // Ajout du cardPanel au conteneurGris
        conteneurGris.add(cardPanel, BorderLayout.CENTER);

        // Ajout du conteneur gris à ConteneurPrincipal
        add(conteneurGris);
    }

    // Cree une nouvelle page avec un conteneur bleu
    private JPanel createNouvellePage(VoitureModel voiture) {
        PageConfirmation nouvellePage = new PageConfirmation(voiture);
        return nouvellePage;
    }

    // Methode pour creer la page principale avec les composants existants
    private JPanel createPagePrincipale(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        JPanel pagePrincipale = new JPanel(new BorderLayout());

        // Creation des composants existants
        Progression progression = new Progression();
        ConteneurDroite conteneurDroite = new ConteneurDroite(voiture);
        ConteneurFormulaires conteneurFormulaires = new ConteneurFormulaires();
        JButton confirmation = new JButton("Confirmer la reservation");


        // Ajout des composants à la page principale
        pagePrincipale.add(progression, BorderLayout.NORTH);
        pagePrincipale.add(conteneurDroite, BorderLayout.EAST);
        pagePrincipale.add(conteneurFormulaires, BorderLayout.CENTER);
        pagePrincipale.add(confirmation, BorderLayout.SOUTH);

        confirmation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Basculer vers la nouvelle page lorsque le bouton est clique
                cardLayout.show(cardPanel, "NOUVELLE_PAGE");
            }
        });

        return pagePrincipale;
    }
}
