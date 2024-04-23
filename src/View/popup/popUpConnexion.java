package View.popup;

import javax.swing.*;
import java.awt.*;

public class popUpConnexion extends JDialog
{
    public popUpConnexion(JFrame parent)
    {
        super(parent, "Information", true);

        // Création des composants
        JLabel departLabel = new JLabel("Connexion réussie !");
        departLabel.setHorizontalAlignment(SwingConstants.CENTER);
        departLabel.setForeground(Color.black);
        departLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
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
    }
}

