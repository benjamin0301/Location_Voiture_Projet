package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;

public class ConteneurPrincipal extends JPanel {
    public ConteneurPrincipal() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Ajoutez du contenu au conteneur principal
        for (int i = 0; i < 10; i++) {
            JPanel petitPanel = new JPanel();
            if (i % 2 == 0) { // Si l'indice est pair, la couleur est bleue
                petitPanel.setBackground(Color.decode("#2B51FF")); // Bleu
            } else { // Sinon, la couleur est verte
                petitPanel.setBackground(Color.decode("#6B85FF")); // Vert
            }
            petitPanel.setPreferredSize(new Dimension(100, 50)); // Définissez la taille préférée du petit panneau
            add(petitPanel);
        }
    }
}
