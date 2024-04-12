package ZCA;

import ZCA.page_principale.ConteneurHaut;
import ZCA.page_principale.Footer;
import ZCA.page_principale.conteneurprincipal.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Vue extends JFrame implements EspacePersonnelListener {
    private ConteneurHaut conteneurHaut;
    private ConteneurPrincipal conteneurPrincipal;

    public Vue() throws SQLException, ClassNotFoundException {
        //this.clientcontroller = new ClientController();
        //this.voiturecontroller = new VoitureController();
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        setTitle("Fenêtre Principale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialisation du conteneur principal
        conteneurPrincipal = new ConteneurPrincipal();
        conteneurPrincipal.initConteneurPrincipal();

        // Initialisation du conteneur haut
        conteneurHaut = new ConteneurHaut();

        // Liaison du listener pour le bouton "Mon espace personnel" dans ConteneurHaut
        conteneurHaut.setEspacePersonnelListener(this);

        // Création du footer
        Footer footer = new Footer();

        // Création d'un nouveau JPanel pour contenir le ConteneurPrincipal et le footer
        JPanel contenuPanel = new JPanel();
        contenuPanel.setLayout(new BorderLayout());
        contenuPanel.add(conteneurPrincipal, BorderLayout.CENTER);
        contenuPanel.add(footer, BorderLayout.SOUTH);

        // Création du JScrollPane et ajout du JPanel contenant tout le contenu
        JScrollPane scrollPane = new JScrollPane(contenuPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Mise en page de la JFrame
        setLayout(new BorderLayout());
        add(conteneurHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Affiche la fenêtre en plein écran
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
