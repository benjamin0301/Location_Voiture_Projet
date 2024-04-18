package View.PageResultats;

import View.PageEspacePersonnel.FrameEspacePerso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConteneurHaut extends JPanel
{
    public ConteneurHaut()
    {
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(800, 80));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel labelTitre = new JLabel("RentMyRide");
        labelTitre.setForeground(Color.decode("#5E17EB"));
        labelTitre.setFont(new Font("Georgia", Font.BOLD, 23));

        add(Box.createVerticalGlue());

        JPanel barreNavigation = new JPanel();
        barreNavigation.setBackground(Color.decode("#FFFFFF"));
        barreNavigation.setLayout(new BoxLayout(barreNavigation, BoxLayout.X_AXIS));
        barreNavigation.add(labelTitre);
        barreNavigation.add(Box.createRigidArea(new Dimension(472, 0)));

        JButton boutonAccueil = new JButton("Accueil");
        boutonAccueil.setBackground(Color.decode("#5E17EB"));
        boutonAccueil.setForeground(Color.white);
        boutonAccueil.setFont(new Font("Georgia", Font.BOLD, 17));
        boutonAccueil.setFocusPainted(false);


        barreNavigation.add(boutonAccueil);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));


        JButton boutonEP = new JButton("Mon espace personnel");
        boutonEP.setBackground(Color.decode("#5E17EB"));
        boutonEP.setForeground(Color.white);
        boutonEP.setFont(new Font("Georgia", Font.BOLD, 17));
        boutonEP.setFocusPainted(false);


        barreNavigation.add(boutonEP);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));

        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.setBackground(Color.decode("#5E17EB"));
        boutonConnexion.setForeground(Color.white);
        boutonConnexion.setFont(new Font("Georgia", Font.BOLD, 17));
        boutonConnexion.setFocusPainted(false);

        barreNavigation.add(boutonConnexion);

        add(barreNavigation);
        add(Box.createVerticalGlue());

        boutonEP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FrameEspacePerso frameEspacePerso = null;
                try
                {
                    frameEspacePerso = new FrameEspacePerso();
                    Window window = SwingUtilities.getWindowAncestor(boutonEP);

                    // Vérifiez si la fenêtre actuelle est une instance de JFrame avant de la fermer
                    if (window instanceof JFrame) {
                        JFrame frame = (JFrame) window;
                        frame.dispose(); // Fermer la fenêtre actuelle
                    }
                }
                catch (SQLException ex) { throw new RuntimeException(ex); }
                catch (ClassNotFoundException ex) { throw new RuntimeException(ex); }
            }
        });
    }
}
