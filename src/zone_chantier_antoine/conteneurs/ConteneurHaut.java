package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurHaut extends JPanel {
    public ConteneurHaut() {
        setBackground(Color.decode("#6010FF"));
        setPreferredSize(new Dimension(getWidth(), 100));

        // Ajout d'éléments dans le conteneur placé en haut
        JLabel labelHaut = new JLabel("Conteneur Haut");
        labelHaut.setForeground(Color.WHITE);
        add(labelHaut);
    }
}

