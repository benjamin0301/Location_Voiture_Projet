package zone_chantier_antoine.conteneurs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarouselVoitures extends JPanel {

    private List<String> elements;
    private int currentIndex;
    private JButton previousButton;
    private JButton nextButton;

    public CarouselVoitures() {
        elements = new ArrayList<>();
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        // Ajout de 15 éléments initialement
        for (int i = 0; i < 15; i++) {
            addElement("Catégorie " + (i + 1));
        }

        // Création des boutons fléchés
        previousButton = createArrowButton('<');
        nextButton = createArrowButton('>');

        // Ajout des écouteurs d'événements aux boutons
        previousButton.addActionListener(e -> showPreviousElements());
        nextButton.addActionListener(e -> showNextElements());

        // Création du conteneur pour les boutons fléchés avec BoxLayout horizontal
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Ajout du bouton précédent à l'extrême gauche du conteneur
        buttonPanel.add(previousButton);
        // Ajout d'un espace élastique pour pousser le bouton suivant à l'extrême droite
        // Ajout du bouton suivant à l'extrême droite du conteneur
        buttonPanel.add(nextButton);

        // Ajout du conteneur des boutons fléchés au nord du conteneur principal
        add(buttonPanel, BorderLayout.SOUTH);
        add(createCarouselPanel(), BorderLayout.CENTER);

        // Afficher les 5 premiers éléments par défaut
        showElements(0, 4);
    }

    private JPanel createCarouselPanel() {
        JPanel carouselPanel = new JPanel();
        carouselPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Utilisation d'un FlowLayout

        // Ajout des éléments du carousel
        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            JLabel label = new JLabel(element);
            label.setPreferredSize(new Dimension(160, 180));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setOpaque(true); // Permet de définir un fond coloré
            label.setBackground(Color.GREEN); // Couleur de fond verte
            carouselPanel.add(label);
        }

        return carouselPanel;
    }

    private JButton createArrowButton(char direction) {
        JButton button = new JButton(Character.toString(direction));
        button.setPreferredSize(new Dimension(200, 25));
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        return button;
    }

    public void addElement(String element) {
        elements.add(element);
    }

    public void showElements(int startIndex, int endIndex) {
        Component[] components = ((JPanel) ((BorderLayout) getLayout()).getLayoutComponent(BorderLayout.CENTER)).getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setVisible(i >= startIndex && i <= endIndex);
        }
    }

    public void showNextElements() {
        int nextIndex = currentIndex + 5;
        if (nextIndex < elements.size()) {
            showElements(nextIndex, nextIndex + 4);
            currentIndex = nextIndex;
        }
    }

    public void showPreviousElements() {
        int previousIndex = currentIndex - 5;
        if (previousIndex >= 0) {
            showElements(previousIndex, previousIndex + 4);
            currentIndex = previousIndex;
        }
    }
}