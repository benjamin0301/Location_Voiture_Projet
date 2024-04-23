package View.popup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class popUpDefault extends JDialog {
    public popUpDefault(JFrame parent, String message) {
        super(parent, "Information", true);

        // Création des composants
        JLabel departLabel = new JLabel(message);
        departLabel.setHorizontalAlignment(SwingConstants.CENTER);
        departLabel.setForeground(Color.black);
        departLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        departLabel.setPreferredSize(new Dimension(180, 25));

        // Création du conteneur pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.white);

        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        espaceBlanc.setPreferredSize(new Dimension(200, 12));
        panel.add(espaceBlanc);

        panel.add(departLabel);

        JPanel espaceBlanc2 = new JPanel();
        espaceBlanc2.setBackground(Color.white);
        espaceBlanc2.setPreferredSize(new Dimension(200, 12));
        panel.add(espaceBlanc2);

        // Ajout du conteneur à la fenêtre
        getContentPane().add(panel, BorderLayout.CENTER);

        // Taille et position de la fenêtre
        setSize(250, 130);
        setLocationRelativeTo(parent);

        // Création du timer pour fermer la fenêtre après 2 secondes
        Timer timer = new Timer(1300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermeture de la fenêtre
                dispose();
            }
        });

        // Démarrage du timer
        timer.setRepeats(false); // Ne répète pas l'action
        timer.start();
    }
}
