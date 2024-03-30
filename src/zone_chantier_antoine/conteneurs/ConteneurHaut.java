package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurHaut extends JPanel {
    public ConteneurHaut() {
        setBackground(Color.decode("#6010FF"));
        setPreferredSize(new Dimension(getWidth(), 80));


        // Ajout d'éléments dans le conteneur placé en haut
        JPanel barreNavigation = new JPanel();
        barreNavigation.setLayout(new FlowLayout());

        JButton boutonAccueil = new JButton("Accueil");
        JButton boutonContact = new JButton("Contact");
        JButton boutonQuiSommesNous = new JButton("Qui sommes-nous ?");
        JButton boutonConnexion = new JButton("Connexion");

        barreNavigation.add(boutonAccueil);
        barreNavigation.add(boutonContact);
        barreNavigation.add(boutonQuiSommesNous);
        barreNavigation.add(boutonConnexion);

        this.add(barreNavigation, BorderLayout.CENTER);

    }
}

