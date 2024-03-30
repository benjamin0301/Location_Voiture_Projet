package zone_chantier_antoine;

import zone_chantier_antoine.conteneurs.ConteneurHaut;
import zone_chantier_antoine.conteneurs.ConteneurPrincipal;

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

        // Création du JScrollPane et ajout du JPanel contenant tout le contenu
        JScrollPane scrollPane = new JScrollPane(contentPanel) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600); // Taille préférée arbitraire
            }
        };
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Ajout du JScrollPane à la fenêtre
        add(scrollPane);

        pack(); // Redimensionne la fenêtre pour qu'elle s'adapte à son contenu
        setLocationRelativeTo(null); // Centre la fenêtre
        setVisible(true);
    }
}
