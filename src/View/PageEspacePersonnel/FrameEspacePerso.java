package View.PageEspacePersonnel;

import Model.ClientModel;
import Model.EmployeModel;
import View.ConnexionVue;
import View.ConteneurEmploye;
import View.CustomScrollBarUI;
import View.PageConfirmation.PageConfirmation;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;
import View.VueEmploye;
import View.popup.popUpDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FrameEspacePerso extends JFrame
{
    private JPanel contentPanel;
    private ClientModel client;
    private EmployeModel employe;

    public FrameEspacePerso(int res, ClientModel clientModel) throws SQLException, ClassNotFoundException
    {
        this.client = clientModel;
        setTitle("Mon espace personnel");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurHaut conteneurHaut = new ConteneurHaut(res, client, "","","","");
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        EspacePersonnel espacePersonnel = new EspacePersonnel(client);

        JPanel englobeurPC = new JPanel(new BorderLayout());
        englobeurPC.setBackground(Color.decode("#E4E4E4"));
        englobeurPC.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));
        englobeurPC.add(espacePersonnel, BorderLayout.CENTER);

        contentPanel.add(englobeurPC, BorderLayout.CENTER);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());

        add(scrollPane);

        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setVisible(true);
    }

    public FrameEspacePerso(int res, EmployeModel employeModel) throws SQLException, ClassNotFoundException
    {
        this.employe = employeModel;
        setTitle("Mon espace personnel");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurEmploye conteneurEmploye = new ConteneurEmploye( employe,"","","","", res);
        contentPanel.add(conteneurEmploye, BorderLayout.NORTH);

        EspacePersonnel espacePersonnel = new EspacePersonnel(employe);

        JPanel englobeurPC = new JPanel(new BorderLayout());
        englobeurPC.setBackground(Color.decode("#E4E4E4"));
        englobeurPC.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));
        englobeurPC.add(espacePersonnel, BorderLayout.CENTER);

        contentPanel.add(englobeurPC, BorderLayout.CENTER);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());

        add(scrollPane);

        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setVisible(true);



        JButton boutonRetour = new JButton("Retour");
        add(boutonRetour, BorderLayout.SOUTH);
        //conteneurEmploye.add(boutonRetour, BorderLayout.SOUTH);

        boutonRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String lieuDepart = ""; // Fournir la valeur appropriée
                    String dateDepart = ""; // Fournir la valeur appropriée
                    String lieuRetour = ""; // Fournir la valeur appropriée
                    String dateRetour = ""; // Fournir la valeur appropriée

                    VueEmploye vp = new VueEmploye(employe);


                    vp.initialize(lieuDepart, dateDepart, lieuRetour, dateRetour, 10);
                    dispose(); // fermer la fenêtre actuelle
                } catch (SQLException ex)
                {
                    //popUpDefault erreur1emp = new popUpDefault(ConnexionVue.this, "Erreur de base de données : " + ex.getMessage());
                    //erreur1emp.setVisible(true);
                }
                catch (ClassNotFoundException ex)
                {
                    //popUpDefault erreur2 = new popUpDefault(ConnexionVue.this, "Classe introuvable : " + ex.getMessage());
                    //erreur2.setVisible(true);
                    }
            }
        });


    }
}
