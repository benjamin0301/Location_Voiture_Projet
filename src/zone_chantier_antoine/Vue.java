package zone_chantier_antoine;

import zone_chantier_antoine.conteneurs.ConteneurGauche;
import zone_chantier_antoine.conteneurs.ConteneurHaut;
import zone_chantier_antoine.conteneurs.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;

public class Vue {
    private JFrame frame;

    public Vue() {
        initialize();
    }

    private void initialize()
    {
        frame = new JFrame();
        frame.setTitle("Fenêtre Principale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);


        ConteneurPrincipal conteneurPrincipal = new ConteneurPrincipal();
        ConteneurGauche conteneurGauche = new ConteneurGauche();
        ConteneurHaut conteneurHaut = new ConteneurHaut();

        frame.add(conteneurGauche, BorderLayout.WEST);
        frame.add(conteneurHaut, BorderLayout.NORTH);
        frame.add(conteneurPrincipal, BorderLayout.CENTER);

        // Rend la fenêtre visible
        frame.setVisible(true);
    }
}

