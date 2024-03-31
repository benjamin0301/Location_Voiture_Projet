package zone_chantier_antoine.conteneurs;

import javax.swing.*;

public class ConteneurVoitures extends JPanel {

    public ConteneurVoitures() {
        // Création d'un carousel de voitures
        CarouselVoitures carousel = new CarouselVoitures();
        add(carousel);
    }
}
