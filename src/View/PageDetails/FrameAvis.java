package View.PageDetails;

import Controler.ClientController;
import Controler.VoitureController;
import Model.ClientModel;
import Model.VoitureModel;
import View.PageConfirmation.FrameConfirmation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameAvis extends JFrame {

    public FrameAvis(VoitureModel voiture, int res, ClientModel clientModel) throws SQLException, ClassNotFoundException {
        VoitureController voitureController = new VoitureController();
        // Définir le titre de la fenêtre
        setTitle("Donnez-nous votre avis !");

        // Définir la taille de la fenêtre à 600x600 pixels
        setSize(450, 300);

        // Définir l'opération de fermeture par défaut lorsque vous cliquez sur le bouton de fermeture de la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1;


        JLabel label = new JLabel("Quel est votre avis sur RentMyRide ?");
        label.setBackground(Color.white);
        label.setFont(new Font("Georgia", Font.BOLD, 20));
        label.setPreferredSize(new Dimension(400, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, gbc);

        gbc.gridy++;
        JPanel panelBoutons = new JPanel();
        panelBoutons.setPreferredSize(new Dimension(400, 80));
        panelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER));


        JButton e1 = new JButton("⭐");
        e1.setFont(new Font("Aleo", Font.BOLD, 40));
        e1.setFocusPainted(false);
        e1.setBackground(Color.white);
        panelBoutons.add(e1);

        JButton e2 = new JButton("⭐");
        e2.setFont(new Font("Aleo", Font.BOLD, 40));
        e2.setFocusPainted(false);
        e2.setBackground(Color.white);
        panelBoutons.add(e2);

        JButton e3 = new JButton("⭐");
        e3.setFont(new Font("Aleo", Font.BOLD, 40));
        e3.setFocusPainted(false);
        e3.setBackground(Color.white);
        panelBoutons.add(e3);

        JButton e4 = new JButton("⭐");
        e4.setFont(new Font("Aleo", Font.BOLD, 40));
        e4.setFocusPainted(false);
        e4.setBackground(Color.white);
        panelBoutons.add(e4);

        JButton e5 = new JButton("⭐");
        e5.setFont(new Font("Aleo", Font.BOLD, 40));
        e5.setFocusPainted(false);
        e5.setBackground(Color.white);
        panelBoutons.add(e5);



        add(panelBoutons, gbc);


        gbc.gridy++;
        JButton button = new JButton("Envoyer");
        button.setBackground(Color.decode("#7E3DFF"));
        button.setFont(new Font("Georgia", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setForeground(Color.white);
        add(button, gbc);

        final int[] temp = {5};

        e1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                temp[0] = 1;
                e1.setForeground(Color.decode("#7E3DFF"));
                e2.setForeground(Color.black);
                e3.setForeground(Color.black);
                e4.setForeground(Color.black);
                e5.setForeground(Color.black);
            }
        });

        e2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
               temp[0] = 2;
               e1.setForeground(Color.decode("#7E3DFF"));
               e2.setForeground(Color.decode("#7E3DFF"));
               e3.setForeground(Color.black);
               e4.setForeground(Color.black);
               e5.setForeground(Color.black);
            }
        });

        e3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                temp[0] = 3;
                e1.setForeground(Color.decode("#7E3DFF"));
                e2.setForeground(Color.decode("#7E3DFF"));
                e3.setForeground(Color.decode("#7E3DFF"));
                e4.setForeground(Color.black);
                e5.setForeground(Color.black);
            }
        });

        e4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                temp[0] = 4;
                e1.setForeground(Color.decode("#7E3DFF"));
                e2.setForeground(Color.decode("#7E3DFF"));
                e3.setForeground(Color.decode("#7E3DFF"));
                e4.setForeground(Color.decode("#7E3DFF"));
                e5.setForeground(Color.black);
            }
        });

        e5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                temp[0] = 5;
                e1.setForeground(Color.decode("#7E3DFF"));
                e2.setForeground(Color.decode("#7E3DFF"));
                e3.setForeground(Color.decode("#7E3DFF"));
                e4.setForeground(Color.decode("#7E3DFF"));
                e5.setForeground(Color.decode("#7E3DFF"));
            }
        });



        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try { voitureController.ChangeAvis(voiture, temp[0]); }
                catch (SQLException | ClassNotFoundException ex) { throw new RuntimeException(ex); }


                dispose();
                FrameConfirmation frameConfirmation = new FrameConfirmation(voiture, res, clientModel);
                frameConfirmation.setVisible(true);
            }
        });

        // Centrer la fenêtre sur l'écran
        setLocationRelativeTo(null);

        // Rendre la fenêtre visible
        setVisible(true);
    }
}
