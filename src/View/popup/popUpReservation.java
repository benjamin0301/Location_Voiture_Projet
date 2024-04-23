package View.popup;

import javax.swing.*;
import java.awt.*;

public class popUpReservation extends JDialog {
    public popUpReservation(JFrame parent, String departDate, String arriveeDate, String lieu)
    {
        super(parent, "Résumé de votre réservation", true);

        // Création des composants
        JLabel departLabel = new JLabel("Date de départ : ");
        departLabel.setForeground(Color.black);
        departLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        departLabel.setPreferredSize(new Dimension(120, 25));

        JLabel departLabel2 = new JLabel(departDate);
        departLabel2.setForeground(Color.decode("#7E3DFF"));
        departLabel2.setFont(new Font("Georgia", Font.BOLD, 15));
        departLabel2.setPreferredSize(new Dimension(100, 25));




        JLabel arriveeLabel = new JLabel("Date d'arrivée : ");
        arriveeLabel.setForeground(Color.black);
        arriveeLabel.setPreferredSize(new Dimension(120, 25));
        arriveeLabel.setFont(new Font("Georgia", Font.PLAIN, 15));

        JLabel arriveeLabel2 = new JLabel(arriveeDate);
        arriveeLabel2.setForeground(Color.decode("#7E3DFF"));
        arriveeLabel2.setFont(new Font("Georgia", Font.BOLD, 15));
        arriveeLabel2.setPreferredSize(new Dimension(100, 25));



        JLabel lieuLabel = new JLabel("Lieu de prise en charge :");
        lieuLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lieuLabel.setFont(new Font("Georgia", Font.PLAIN, 15));
        lieuLabel.setPreferredSize(new Dimension(170, 18));
        lieuLabel.setForeground(Color.black);

        JLabel lieuLabel2 = new JLabel(lieu);
        lieuLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        lieuLabel2.setForeground(Color.decode("#7E3DFF"));
        lieuLabel2.setFont(new Font("Georgia", Font.BOLD, 15));
        lieuLabel2.setPreferredSize(new Dimension(280, 25));


        // Création du conteneur pour les composants
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(Color.white);

        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        espaceBlanc.setPreferredSize(new Dimension(200, 12));
        panel.add(espaceBlanc);

        panel.add(departLabel);
        panel.add(departLabel2);

        panel.add(arriveeLabel);
        panel.add(arriveeLabel2);

        JPanel espaceBlanc2 = new JPanel();
        espaceBlanc2.setBackground(Color.white);
        espaceBlanc2.setPreferredSize(new Dimension(200, 12));
        panel.add(espaceBlanc2);

        panel.add(lieuLabel);
        panel.add(lieuLabel2);

        // Ajout du conteneur à la fenêtre
        getContentPane().add(panel, BorderLayout.CENTER);

        // Taille et position de la fenêtre
        setSize(300, 245);
        setLocationRelativeTo(parent);
    }
}

