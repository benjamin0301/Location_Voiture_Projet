package View.PageResultats;

import View.PageEspacePersonnel.EspacePersonnelListener;
import View.AccueilListener;
import View.ConnexionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ConteneurHaut extends JPanel
{
    private EspacePersonnelListener listener;
    private AccueilListener accueilListener;
    private ConnexionListener connexionListener;
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
        barreNavigation.add(Box.createRigidArea(new Dimension(630, 0)));

        JButton boutonAccueil = new JButton("Accueil");
        boutonAccueil.setBackground(Color.decode("#5E17EB"));
        boutonAccueil.setForeground(Color.white);
        boutonAccueil.setFont(new Font("Georgia", Font.BOLD, 14));
        JButton boutonEspacePerso = new JButton("Mon espace personnel");
        JButton boutonConnexion = new JButton("Connexion");

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
                if (listener != null)
                {
                    try
                    {
                        listener.onEspacePersonnelClicked();
                    }
                    catch (SQLException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                    catch (ClassNotFoundException ex)
                    {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        boutonAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (accueilListener != null) {
                    try {
                        accueilListener.onAccueilClicked();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        boutonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connexionListener != null) {
                    try {
                        connexionListener.onConnexionClicked();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    public void setEspacePersonnelListener(EspacePersonnelListener listener) {
        this.listener = listener;
    }
    public void setAccueilListener(AccueilListener listener) {
        this.accueilListener = listener;
    }

    public void setConnexionListener(ConnexionListener listener) {
        this.connexionListener = listener;
    }
}
