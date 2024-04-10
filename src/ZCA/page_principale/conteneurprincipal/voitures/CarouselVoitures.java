package ZCA.page_principale.conteneurprincipal.voitures;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarouselVoitures extends JPanel {

    private List<String> elements;
    private int currentIndex;
    private JButton previousButton;
    private JButton nextButton;

    public CarouselVoitures() {
        elements = new ArrayList<>();
        setLayout(new BorderLayout());

        ArrayList<String> listeTypes = new ArrayList<>(Arrays.asList("Mini", "SUV", "Sportive", "Supersportive", "Berline", "Minivan", "Spécial", "TypeXYZ"));

        for (int i = 0; i < listeTypes.size(); i++) {
            addElement(listeTypes.get(i));
        }

        previousButton = createArrowButton('<');
        nextButton = createArrowButton('>');

        previousButton.addActionListener(e -> showPreviousElements());
        nextButton.addActionListener(e -> showNextElements());


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.white);

        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(createCarouselPanel(), BorderLayout.CENTER);

        showElements(0, 4);
    }

    private JPanel createCarouselPanel() {
        JPanel carouselPanel = new JPanel();
        carouselPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        carouselPanel.setBackground(Color.white);


        for (int i = 0; i < elements.size(); i++) {
            String element = elements.get(i);
            JButton caseCarrousel = new JButton();
            caseCarrousel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            caseCarrousel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
            caseCarrousel.setAlignmentX(SwingConstants.CENTER);
            caseCarrousel.setAlignmentY(SwingConstants.CENTER);
            caseCarrousel.setPreferredSize(new Dimension(160, 180));
            caseCarrousel.setBackground(Color.WHITE);
            caseCarrousel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

            caseCarrousel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Afficher la boîte de dialogue
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Ceci est une pop-up !");
                }
            });

            JTextArea typeVoiture = new JTextArea(element);
            typeVoiture.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            typeVoiture.setFont(new Font("Aleo", Font.BOLD, 15));
            caseCarrousel.add(typeVoiture);

            carouselPanel.add(caseCarrousel);
        }

        return carouselPanel;
    }

    private JButton createArrowButton(char direction) {
        JButton button = new JButton(Character.toString(direction));
        button.setPreferredSize(new Dimension(140, 25));
        button.setBackground(Color.white);
        button.setForeground(Color.darkGray);
        button.setFocusPainted(false);
        button.setFont(new Font("Aleo", Font.BOLD, 20));
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