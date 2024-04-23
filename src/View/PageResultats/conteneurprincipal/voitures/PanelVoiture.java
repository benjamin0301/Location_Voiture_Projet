package View.PageResultats.conteneurprincipal.voitures;

import Model.ClientModel;
import Model.VoitureModel;
import View.ConnexionVue;
import View.PageDetails.FrameDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PanelVoiture extends JPanel
{
    VoitureModel voiture_select;
    public ClientModel client;

    public PanelVoiture(VoitureModel voiture, ClientModel clientModel, int res) throws SQLException, ClassNotFoundException
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(2, 300));
        setBackground(Color.white);
        initialize(voiture, res);
        this.client = clientModel;
    }

    public void initialize(VoitureModel voiture, int res)
    {
        voiture_select = voiture;
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;

        JPanel panelA = new JPanel();
        panelA.setLayout(new FlowLayout());
        panelA.setPreferredSize(new Dimension(205, 300));
        panelA.setBackground(Color.decode("#FFFFFF"));
        panelA.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.lightGray));
        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(200, 5));
        panelA.add(espaceVideA);
        JTextArea AType = new JTextArea("  " + voiture.getType());
        AType.setLayout(new BorderLayout());
        AType.setPreferredSize(new Dimension(200, 35));
        AType.setEditable(false);
        AType.setFocusable(false);
        AType.setFont(new Font("Georgia", Font.BOLD, 17));
        panelA.add(AType, BorderLayout.WEST);
        JTextArea AModele = new JTextArea("   " + voiture.getMarque() + " " + voiture.getnom_modele());
        AModele.setLayout(new BorderLayout());
        AModele.setEditable(false);
        AModele.setPreferredSize(new Dimension(200, 20));
        AModele.setFont(new Font("Georgia", Font.PLAIN, 15));
        panelA.add(AModele, BorderLayout.WEST);
        ImageIcon AImage = new ImageIcon(voiture.getImage_voiture());
        JLabel imageLabel = new JLabel(AImage);
        panelA.add(imageLabel);
        JTextArea ACapacite = new JTextArea("\n    • " + voiture.getNbPlace() + " passagers\n    • " + voiture.getCapaciteValise() + " bagage(s)\n    • " + voiture.getNbPorte() + " portes");
        ACapacite.setLayout(new BorderLayout());
        ACapacite.setEditable(false);
        ACapacite.setPreferredSize(new Dimension(200, 100));
        ACapacite.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelA.add(ACapacite, BorderLayout.EAST);
        add(panelA, gbc);


        gbc.gridx++;


        JPanel panelB = new JPanel();
        panelB.setLayout(new FlowLayout());
        panelB.setPreferredSize(new Dimension(205, 300));
        panelB.setBackground(Color.decode("#F6F6F6"));
        panelB.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));
        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.decode("#F6F6F6"));
        espaceVideB.setPreferredSize(new Dimension(200, 7));
        panelB.add(espaceVideB);

        JTextArea trans1 = new JTextArea("       Transmission :\n");
        trans1.setEditable(false);
        trans1.setBackground(Color.decode("#F6F6F6"));
        trans1.setPreferredSize(new Dimension(200, 19));
        trans1.setFont(new Font("Georgia", Font.BOLD, 15));
        panelB.add(trans1);
        JTextArea trans2 = new JTextArea("        " + voiture.getTransmission());
        trans2.setEditable(false);
        trans2.setBackground(Color.decode("#F6F6F6"));
        trans2.setPreferredSize(new Dimension(200, 30));
        trans2.setFont(new Font("Georgia", Font.PLAIN, 15));
        panelB.add(trans2);

        JTextArea moteur1 = new JTextArea("       Moteur :\n");
        moteur1.setEditable(false);
        moteur1.setBackground(Color.decode("#F6F6F6"));
        moteur1.setPreferredSize(new Dimension(200, 19));
        moteur1.setFont(new Font("Georgia", Font.BOLD, 15));
        panelB.add(moteur1);
        JTextArea moteur2 = new JTextArea("        " + voiture.getMoteur());
        moteur2.setEditable(false);
        moteur2.setBackground(Color.decode("#F6F6F6"));
        moteur2.setPreferredSize(new Dimension(200, 30));
        moteur2.setFont(new Font("Georgia", Font.PLAIN, 15));
        panelB.add(moteur2);


        JTextArea kilometrageActuel1 = new JTextArea("        Kilométrage actuel :");
        kilometrageActuel1.setEditable(false);
        kilometrageActuel1.setBackground(Color.decode("#F6F6F6"));
        kilometrageActuel1.setPreferredSize(new Dimension(200, 16));
        kilometrageActuel1.setFont(new Font("Georgia", Font.BOLD, 13));
        panelB.add(kilometrageActuel1);
        JTextArea kilometrageActuel2 = new JTextArea("         " + voiture.getkilometrage_actuel() + " km");
        kilometrageActuel2.setBackground(Color.decode("#F6F6F6"));
        kilometrageActuel2.setEditable(false);
        kilometrageActuel2.setPreferredSize(new Dimension(200, 25));
        kilometrageActuel2.setFont(new Font("Georgia", Font.PLAIN, 13));
        panelB.add(kilometrageActuel2);

        JTextArea kilometrageLimite1 = new JTextArea("        Kilométrage limite :");
        kilometrageLimite1.setBackground(Color.decode("#F6F6F6"));
        kilometrageLimite1.setEditable(false);
        kilometrageLimite1.setPreferredSize(new Dimension(200, 16));
        kilometrageLimite1.setFont(new Font("Georgia", Font.BOLD, 13));
        panelB.add(kilometrageLimite1);
        JTextArea kilometrageLimite2 = new JTextArea("         " + voiture.getLimite_km() + " km");
        kilometrageLimite2.setBackground(Color.decode("#F6F6F6"));
        kilometrageLimite2.setEditable(false);
        kilometrageLimite2.setPreferredSize(new Dimension(200, 30));
        kilometrageLimite2.setFont(new Font("Georgia", Font.PLAIN, 13));
        panelB.add(kilometrageLimite2);

        JTextArea avisClients1 = new JTextArea("       Avis des clients :");
        avisClients1.setBackground(Color.decode("#F6F6F6"));
        avisClients1.setEditable(false);
        avisClients1.setPreferredSize(new Dimension(200, 19));
        avisClients1.setFont(new Font("Georgia", Font.BOLD, 15));
        panelB.add(avisClients1);
        JTextArea avisClients2 = new JTextArea("        " + voiture.getAvis() + "/5 étoiles");
        avisClients2.setBackground(Color.decode("#F6F6F6"));
        avisClients2.setEditable(false);
        avisClients2.setPreferredSize(new Dimension(200, 30));
        avisClients2.setFont(new Font("Georgia", Font.PLAIN, 15));
        panelB.add(avisClients2);


        add(panelB, gbc);


        gbc.gridx++;


        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(205, 300));
        panelC.setBackground(Color.decode("#F6F6F6"));
        panelC.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));
        JPanel espaceVideC = new JPanel();
        espaceVideC.setBackground(Color.decode("#F6F6F6"));
        espaceVideC.setPreferredSize(new Dimension(200, 17));
        panelC.add(espaceVideC);
        JTextArea areaC1 = new JTextArea("  Inclus gratuitement :");
        areaC1.setEditable(false);
        areaC1.setBackground(Color.decode("#F6F6F6"));
        areaC1.setFont(new Font("Georgia", Font.BOLD, 15));
        areaC1.setForeground(Color.decode("#5500FF"));
        areaC1.setPreferredSize(new Dimension(200, 45));
        panelC.add(areaC1);
        JTextArea areaC = new JTextArea("   - Annulation\n\n   - Modifications\n\n   - Assurance dommage\n      en cas de collision\n\n   - Assurance vol\n\n   - Assurance\n      responsabilité civile");
        areaC.setBackground(Color.decode("#F6F6F6"));
        areaC.setEditable(false);
        areaC.setFont(new Font("Georgia", Font.PLAIN, 15));
        areaC.setForeground(Color.decode("#5500FF"));
        areaC.setPreferredSize(new Dimension(200, 200));
        panelC.add(areaC);
        add(panelC, gbc);


        gbc.gridx++;


        JPanel panelD = new JPanel();
        panelD.setLayout(new FlowLayout(FlowLayout.RIGHT));

        panelD.setPreferredSize(new Dimension(205, 300));
        panelD.setBackground(Color.decode("#F5EFFF"));
        panelD.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.lightGray));
        JPanel espaceVideD = new JPanel();
        espaceVideD.setBackground(Color.decode("#F5EFFF"));
        espaceVideD.setPreferredSize(new Dimension(200, 150));
        panelD.add(espaceVideD);
        JTextArea prixGras = new JTextArea(voiture.getPrix() + " €/jour");
        prixGras.setEditable(false);
        prixGras.setFont(new Font("Georgia", Font.BOLD, 25));
        prixGras.setBackground(Color.decode("#F5EFFF"));
        panelD.add(prixGras);
        JTextArea prixCumule = new JTextArea("                        " + "Total " + voiture.getPrix() + " €");
        prixCumule.setFont(new Font("Georgia", Font.PLAIN, 15));
        prixCumule.setEditable(false);
        prixCumule.setBackground(Color.decode("#F5EFFF"));
        panelD.add(prixCumule);
        JPanel espaceVide2D = new JPanel();
        espaceVide2D.setBackground(Color.decode("#F5EFFF"));
        espaceVide2D.setPreferredSize(new Dimension(200, 10));
        panelD.add(espaceVide2D);
        JButton selectionner = new JButton("Sélectionner");
        selectionner.setPreferredSize(new Dimension(192, 50));
        selectionner.setBackground(Color.decode("#7E3DFF"));
        selectionner.setForeground(Color.white);
        selectionner.setFont(new Font("Georgia", Font.BOLD, 21));
        panelD.add(selectionner);


        selectionner.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                System.out.println("test du client" + client);
                if (client == null) {

                    Window window = SwingUtilities.getWindowAncestor(selectionner);

                    // Vérifiez si la fenêtre actuelle est une instance de JFrame avant de la fermer
                    if (window instanceof JFrame) {
                        JFrame frame = (JFrame) window;
                        frame.dispose(); // Fermer la fenêtre actuelle
                    }

                    ConnexionVue connexion = null;
                    try {
                        connexion = new ConnexionVue();
                        connexion.setVisible(true);
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (window instanceof JFrame) {
                        JFrame frame = (JFrame) window;
                        frame.dispose();
                    }
                } else {
                    try {
                        FrameDetails frameDetails = new FrameDetails(voiture_select, res, client);

                        Window window = SwingUtilities.getWindowAncestor(selectionner);

                        // Vérifiez si la fenêtre actuelle est une instance de JFrame avant de la fermer
                        if (window instanceof JFrame) {
                            JFrame frame = (JFrame) window;
                            frame.dispose(); // Fermer la fenêtre actuelle
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        add(panelD, gbc);
    }
}
