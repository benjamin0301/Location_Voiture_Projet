package ZCA;

import Controler.ClientController;
import Controler.VoitureController;
import Model.VoitureModel;
import ZCA.page_details.ConteneurPrincipalDetails;
import ZCA.page_principale.ConteneurHaut;
import ZCA.page_principale.Footer;
import ZCA.page_principale.conteneurprincipal.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FrameDetails extends JFrame
{
    VoitureModel voiture;
    private JPanel contentPanel;
    public FrameDetails(VoitureModel voiture) throws SQLException, ClassNotFoundException {
        this.voiture = voiture;
        initialize();
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        setTitle("RentMyRide - Détails de la sélection");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        System.out.println("voiure id" + voiture.getId_plaque());

        setLocationRelativeTo(null); // Centrer la nouvelle fenêtre sur l'écran
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un JPanel pour contenir l'ensemble du contenu
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Ajout du conteneur principal
        ConteneurPrincipalDetails conteneurPrincipalDetails = new ConteneurPrincipalDetails();
        conteneurPrincipalDetails.initConteneurPrincipalDetails();
        contentPanel.add(conteneurPrincipalDetails, BorderLayout.CENTER);

        // Ajout du conteneur haut
        ConteneurHaut conteneurHaut = new ConteneurHaut();
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        // Création du JScrollPane et ajout du JPanel contenant tout le contenu
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Ajout du JScrollPane à la fenêtre
        add(scrollPane);
    }

}
