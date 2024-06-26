package View;
import Model.ClientModel;
import Model.EmployeModel;
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

public class ConteneurEmploye extends JPanel
{
    private AccueilListener accueilListener;
    private ConnexionListener connexionListener;
    private EmployeModel employe;

    public ConteneurEmploye(EmployeModel employeModel, String lieuDepart, String dateDepart, String lieuRetour, String dateRetour, int res)
    {
        this.employe = employeModel;
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

        JButton boutonAccueil = new JButton("Voiture");
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

        JButton boutonConnecte = new JButton("Connecté");
        boutonConnecte.setBackground(Color.decode("#7E3DFF"));
        boutonConnecte.setForeground(Color.white);
        boutonConnecte.setFont(new Font("Georgia", Font.BOLD, 18));
        boutonConnecte.setFocusPainted(false);

        barreNavigation.add(boutonAccueil);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));
        barreNavigation.add(boutonEspacePerso);
        barreNavigation.add(Box.createRigidArea(new Dimension(40, 0)));


        add(barreNavigation);
        add(Box.createVerticalGlue());

        boutonEspacePerso.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    FrameEspacePerso frameEspacePerso = new FrameEspacePerso(res, employe);
                } catch (SQLException | ClassNotFoundException ex) {
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
                try {
                    InscriptionVoiture inscriptionVoiture = new InscriptionVoiture(employe,  lieuDepart,  dateDepart,  lieuRetour,  dateRetour, res);
                    inscriptionVoiture.setVisible(true);

                    Window window = SwingUtilities.getWindowAncestor(boutonAccueil);

                    if (window instanceof JFrame)
                    {
                        JFrame frame = (JFrame) window;
                        frame.dispose();
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });



        if(res == 1){
            barreNavigation.add(boutonConnexion);
            boutonConnexion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    ConnexionVue connexion = null;
                    try {
                        connexion = new ConnexionVue( lieuDepart,  dateDepart,  lieuRetour,  dateRetour);
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
        else {
            barreNavigation.add(boutonConnecte);
            boutonConnecte.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, "Voulez-vous vous déconnecter ?", "Déconnexion", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // fermer la fenêtre actuelle
                        Window window = SwingUtilities.getWindowAncestor(boutonConnecte);
                        if (window instanceof JFrame) {
                            JFrame frame = (JFrame) window;
                            frame.dispose();
                        }

                        // ouvrir la page de connexion
                        //ConnexionVue connexion = null;
                        Accueil accueil = new Accueil(1, null);
                        accueil.setVisible(true);
                    }
                }
            });







        }
    }
}