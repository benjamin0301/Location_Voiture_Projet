package View.PageResultats;
import View.Accueil;
import View.AccueilListener;
import View.ConnexionListener;
import View.ConnexionVue;
import View.PageEspacePersonnel.FrameEspacePerso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConteneurHaut extends JPanel
{
    private AccueilListener accueilListener;
    private ConnexionListener connexionListener;
    public ConteneurHaut()
    {
        setBackground(Color.decode("#FFFFFF"));
        setPreferredSize(new Dimension(800, 80));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ImageIcon AImage = new ImageIcon("images/RentMyRide.png");
        JLabel imageLabel = new JLabel(AImage);;

        JPanel imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(100, 20));
        imagePanel.add(imageLabel);

        JLabel labelTitre = new JLabel("RentMyRide");
        labelTitre.setForeground(Color.decode("#5E17EB"));
        labelTitre.setFont(new Font("Georgia", Font.BOLD, 23));

        add(Box.createVerticalGlue());

        JPanel barreNavigation = new JPanel();
        barreNavigation.setBackground(Color.decode("#FFFFFF"));
        barreNavigation.setLayout(new BoxLayout(barreNavigation, BoxLayout.X_AXIS));
        barreNavigation.add(labelTitre);
        barreNavigation.add(Box.createRigidArea(new Dimension(500, 0)));

        JButton boutonAccueil = new JButton("Accueil");
        boutonAccueil.setBackground(Color.decode("#5E17EB"));
        boutonAccueil.setForeground(Color.white);
        boutonAccueil.setFont(new Font("Georgia", Font.BOLD, 18));
        boutonAccueil.setFocusPainted(false);

        JButton boutonEspacePerso = new JButton("Mon espace personnel");
        boutonEspacePerso.setBackground(Color.decode("#5E17EB"));
        boutonEspacePerso.setForeground(Color.white);
        boutonEspacePerso.setFont(new Font("Georgia", Font.BOLD, 18));
        boutonEspacePerso.setFocusPainted(false);

        JButton boutonConnexion = new JButton("Connexion");
        boutonConnexion.setBackground(Color.decode("#5E17EB"));
        boutonConnexion.setForeground(Color.white);
        boutonConnexion.setFont(new Font("Georgia", Font.BOLD, 18));
        boutonConnexion.setFocusPainted(false);

        barreNavigation.add(boutonAccueil);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));
        barreNavigation.add(boutonEspacePerso);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));
        barreNavigation.add(boutonConnexion);

        add(barreNavigation);
        add(Box.createVerticalGlue());

        boutonEspacePerso.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FrameEspacePerso frameEspacePerso = null;
                try {
                    frameEspacePerso = new FrameEspacePerso();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Window window = SwingUtilities.getWindowAncestor(boutonEspacePerso);

                if (window instanceof JFrame) {
                    JFrame frame = (JFrame) window;
                    frame.dispose();
                }
            }
        });
        boutonAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Accueil accueil = null;
                accueil = new Accueil();
                accueil.setVisible(true);

                Window window = SwingUtilities.getWindowAncestor(boutonAccueil);

                if (window instanceof JFrame)
                {
                    JFrame frame = (JFrame) window;
                    frame.dispose();
                }
            }
        });

        boutonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ConnexionVue connexion = null;
                try {
                    connexion = new ConnexionVue();
                    connexion.setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                Window window = SwingUtilities.getWindowAncestor(boutonConnexion);

                if (window instanceof JFrame) {
                    JFrame frame = (JFrame) window;
                    frame.dispose();
                }
            }
        });
    }
}