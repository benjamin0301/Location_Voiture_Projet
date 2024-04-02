package zone_chantier_antoine.conteneurs;
import javax.swing.*;
import java.awt.*;

public class ConteneurVoitures extends JPanel {
    public ConteneurVoitures() {
        setLayout(new FlowLayout());

        Carousel carousel = new Carousel();
        carousel.createItems();
    }
}
