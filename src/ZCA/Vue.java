package ZCA;

import ZCA.page_principale.ConteneurHaut;
import ZCA.page_principale.conteneurprincipal.ConteneurPrincipal;
import ZCA.page_principale.Footer;

import javax.swing.*;
import java.awt.*;

public class Vue extends JFrame {
    private JPanel contentPanel;

    public Vue() {
        initialize();
    }

    private void initialize() {
        setTitle("Fenêtre Principale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un JPanel pour contenir l'ensemble du contenu
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Ajout du conteneur principal
        ConteneurPrincipal conteneurPrincipal = new ConteneurPrincipal();
        contentPanel.add(conteneurPrincipal, BorderLayout.CENTER);

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

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Affiche la fenêtre en plein écran
        setLocationRelativeTo(null); // Centre la fenêtre

        setVisible(true);
    }
}
