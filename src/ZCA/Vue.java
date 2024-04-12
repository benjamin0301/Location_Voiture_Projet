package ZCA;

import Controler.ClientController;
import Controler.VoitureController;
import ZCA.page_principale.ConteneurHaut;
import ZCA.page_principale.conteneurprincipal.ConteneurPrincipal;
import ZCA.page_principale.Footer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Vue extends JFrame implements EspacePersonnelListener {
    private JPanel contentPanel;

    private ConteneurHaut conteneurHaut;
    private ConteneurPrincipal conteneurPrincipal;

    public VoitureController voiturecontroller;

    public ClientController clientcontroller;

    public Vue() throws SQLException, ClassNotFoundException {
        //this.clientcontroller = new ClientController();
        //this.voiturecontroller = new VoitureController();
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        setTitle("Fenêtre Principale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un JPanel pour contenir l'ensemble du contenu
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Initialisation du conteneur principal
        conteneurPrincipal = new ConteneurPrincipal();
        conteneurPrincipal.initConteneurPrincipal();
        contentPanel.add(conteneurPrincipal, BorderLayout.CENTER);

        // Initialisation du conteneur haut
        conteneurHaut = new ConteneurHaut();
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        // Liaison du listener pour le bouton "Mon espace personnel" dans ConteneurHaut
        conteneurHaut.setEspacePersonnelListener(this);

        // Création du footer et ajout au contentPanel
        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        // Création du JScrollPane et ajout du JPanel contenant tout le contenu
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Ajout du JScrollPane à la fenêtre
        add(scrollPane);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Affiche la fenêtre en plein écran

        setVisible(true);
    }

    // Implémentation de la méthode de l'interface EspacePersonnelListener
    @Override
    public void onEspacePersonnelClicked() throws SQLException, ClassNotFoundException {
        // Mettre à jour le contenu de la page en conséquence
        conteneurPrincipal.removeAll(); // Retire le contenu actuel
        conteneurPrincipal.add(new EspacePersonnel()); // Ajoute le contenu de EspacePersonnel
        conteneurPrincipal.revalidate(); // Rafraîchit l'affichage
        conteneurPrincipal.repaint();
    }
}
