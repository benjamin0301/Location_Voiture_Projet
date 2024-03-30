package zone_chantier_antoine.items_utiles;

import javax.swing.*;
import java.awt.*;

public class CarouselItem extends JPanel {

    public CarouselItem(int number, String text) {
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new BorderLayout());

        JLabel numberLabel = new JLabel("Numéro: " + number);
        JLabel textLabel = new JLabel(text);

        add(numberLabel, BorderLayout.NORTH);
        add(textLabel, BorderLayout.CENTER);
    }
}



