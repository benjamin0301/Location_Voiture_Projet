package ZCA.page_principale.conteneurprincipal;
import javax.swing.*;
import java.awt.*;

public class Progression extends JPanel {

    public Progression() {
        // Définition du gestionnaire de disposition
        setLayout(new BorderLayout());
        setBackground(Color.white);

        // Ajout d'un composant à l'intérieur du conteneur
        add(new JLabel("Progression"), BorderLayout.CENTER);

        // Définition de la taille préférée
        setPreferredSize(new Dimension(200, 80));

        ImageIcon imageIcon = new ImageIcon("images\\pro-1.png");

        // Création d'un JLabel avec l'image
        JLabel imageLabel = new JLabel(imageIcon);

        // Ajout du JLabel au conteneur
        add(imageLabel, BorderLayout.CENTER);

        // Activation de la visibilité du conteneur
        setVisible(true);
    }
}
