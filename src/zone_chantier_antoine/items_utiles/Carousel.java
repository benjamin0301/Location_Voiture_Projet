/*package zone_chantier_antoine.items_utiles;

import zone_chantier_antoine.conteneurs.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carousel {

    private static final int ITEM_COUNT = 15;
    private static final int VISIBLE_ITEMS = 5;
    private JPanel carouselPanel;
    private int currentOffset = 0;

    public void createItems() {
        carouselPanel = new JPanel();
        carouselPanel.setLayout(new BoxLayout(carouselPanel, BoxLayout.X_AXIS));

        for (int i = 1; i <= ITEM_COUNT; i++) {
            CarouselItem item = new CarouselItem(i, "Phrase de l'élément " + i);
            carouselPanel.add(item);
        }
    }

    public void addToFrame(ConteneurPrincipal frame) {
        JScrollPane scrollPane = new JScrollPane(carouselPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(
                scrollPane.getPreferredSize().width,
                carouselPanel.getPreferredSize().height
        ));

        JPanel buttonPanel = new JPanel();
        JButton previousButton = new JButton("<");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previous();
            }
        });
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void previous() {
        if (currentOffset > 0) {
            currentOffset--;
            int newX = currentOffset * carouselPanel.getComponent(0).getWidth();
            JViewport viewport = (JViewport) carouselPanel.getParent();
            Rectangle rectangle = new Rectangle(newX, 0, carouselPanel.getWidth(), carouselPanel.getHeight());
            viewport.setViewPosition(rectangle.getLocation());
        }
    }

    private void next() {
        if (currentOffset < ITEM_COUNT - VISIBLE_ITEMS) {
            currentOffset++;
            int newX = currentOffset * carouselPanel.getComponent(0).getWidth();
            JViewport viewport = (JViewport) carouselPanel.getParent();
            Rectangle rectangle = new Rectangle(newX, 0, carouselPanel.getWidth(), carouselPanel.getHeight());
            viewport.setViewPosition(rectangle.getLocation());
        }
    }
}


 */



