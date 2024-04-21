package View.PageConfirmation;

import Model.VoitureModel;
import View.PageEspacePersonnel.EspacePersonnel;
import View.PageEspacePersonnel.FrameEspacePerso;
import View.PageResultats.conteneurprincipal.Progression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PageConfirmation extends JPanel
{
    public PageConfirmation(VoitureModel voiture)
    {
        setLayout(new BorderLayout());

        ProgConfirmation progConfirmation = new ProgConfirmation();
        add(progConfirmation, BorderLayout.NORTH);

        JPanel contPrin = new JPanel();
        contPrin.setLayout(new GridBagLayout());
        contPrin.setBackground(Color.white);

        JPanel panneauConfirmation = new JPanel();
        panneauConfirmation.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panneauConfirmation.setPreferredSize(new Dimension(1000, 500));
        panneauConfirmation.setBackground(Color.white);
        panneauConfirmation.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JLabel messageConf = new JLabel("Votre réservation est confirmée !");
        messageConf.setFont(new Font("Georgia", Font.BOLD, 30));
        messageConf.setBackground(Color.white);
        panneauConfirmation.add(messageConf);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(950, 2));
        separator.setForeground(Color.darkGray);
        panneauConfirmation.add(separator);

        JPanel engloBeurre = new JPanel();
        engloBeurre.setLayout(new GridBagLayout());
        engloBeurre.setPreferredSize(new Dimension(955, 390));
        engloBeurre.setBackground(Color.white);
        GridBagConstraints gdc = new GridBagConstraints();

        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.weightx = 1;
        gdc.fill = GridBagConstraints.VERTICAL;


        JPanel panelA = new JPanel();
        panelA.setPreferredSize(new Dimension(210, 380));
        panelA.setBackground(Color.white);

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(200, 25));
        panelA.add(espaceVideA);
        JTextArea AType = new JTextArea("  " + voiture.getType());
        AType.setLayout(new BorderLayout());
        AType.setPreferredSize(new Dimension(200, 25));
        AType.setEditable(false);
        AType.setFocusable(false);
        AType.setFont(new Font("Georgia", Font.BOLD, 18));
        panelA.add(AType, BorderLayout.WEST);
        JTextArea AModele = new JTextArea("  " + voiture.getMarque() + " " + voiture.getnom_modele());
        AModele.setLayout(new BorderLayout());
        AModele.setPreferredSize(new Dimension(200, 40));
        AModele.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelA.add(AModele, BorderLayout.WEST);
        ImageIcon AImage = new ImageIcon(voiture.getImage_voiture());
        JLabel imageLabel = new JLabel(AImage);
        panelA.add(imageLabel);
        JTextArea ACapacite = new JTextArea("\n\n    • " + voiture.getNbPlace() + " passagers\n    • " + voiture.getCapaciteValise() + " bagage(s)\n    • " + voiture.getNbPorte() + " portes");
        ACapacite.setLayout(new BorderLayout());
        ACapacite.setPreferredSize(new Dimension(200, 140));
        ACapacite.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelA.add(ACapacite, BorderLayout.EAST);

        engloBeurre.add(panelA, gdc);




        gdc.gridx++;
        JPanel panelB = new JPanel();
        panelB.setPreferredSize(new Dimension(210, 380));
        panelB.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
        panelB.setBackground(Color.decode("#F6F6F6"));

        JLabel depart = new JLabel("Départ");
        depart.setForeground(Color.decode("#7E3DFF"));
        depart.setPreferredSize(new Dimension(200, 22));
        depart.setFont(new Font("Georgia", Font.BOLD, 19));
        panelB.add(depart);

        JLabel depart2 = new JLabel(voiture.getLieuPriseEnCharge());
        depart2.setPreferredSize(new Dimension(200, 21));
        depart2.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelB.add(depart2);

        JLabel depart3 = new JLabel(voiture.getDate_debut_loc());
        depart3.setPreferredSize(new Dimension(200, 21));
        depart3.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelB.add(depart3);


        JLabel arrivee = new JLabel("Arrivée");
        arrivee.setForeground(Color.decode("#7E3DFF"));
        arrivee.setPreferredSize(new Dimension(200, 22));
        arrivee.setFont(new Font("Georgia", Font.BOLD, 19));
        panelB.add(arrivee);

        JLabel arrivee2 = new JLabel(voiture.getLieuPriseEnCharge());
        arrivee2.setPreferredSize(new Dimension(200, 21));
        arrivee2.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelB.add(arrivee2);

        JLabel arrivee3 = new JLabel(voiture.getDate_fin_loc());
        arrivee3.setPreferredSize(new Dimension(200, 50));
        arrivee3.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelB.add(arrivee3);

        JLabel prix1 = new JLabel("Prix total :");
        prix1.setForeground(Color.decode("#7E3DFF"));
        prix1.setPreferredSize(new Dimension(200, 22));
        prix1.setFont(new Font("Georgia", Font.BOLD, 19));
        panelB.add(prix1);

        JLabel prix2 = new JLabel(String.valueOf(voiture.getPrix()) + "€ TTC");
        prix2.setPreferredSize(new Dimension(200, 21));
        prix2.setFont(new Font("Georgia", Font.PLAIN, 18));
        panelB.add(prix2);

        engloBeurre.add(panelB, gdc);





        gdc.gridx++;
        gdc.weightx = 2;
        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(515, 380));
        panelC.setBackground(Color.white);

        ImageIcon AImage2 = new ImageIcon("images/image-finale.png");
        JLabel imageLabel2 = new JLabel(AImage2);
        panelC.add(imageLabel2);

        engloBeurre.add(panelC, gdc);

        panneauConfirmation.add(engloBeurre);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge entre les composants
        contPrin.add(panneauConfirmation, gbc);

        gbc.gridy++;
        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new BorderLayout());
        panelBoutons.setPreferredSize(new Dimension(850, 60));
        panelBoutons.setBackground(Color.white);

        JButton boutonFac = new JButton("Télécharger la facture");
        boutonFac.setFont(new Font("Georgia", Font.BOLD, 19));
        boutonFac.setBackground(Color.decode("#7E3DFF"));
        boutonFac.setForeground(Color.white);
        boutonFac.setPreferredSize(new Dimension(360, 50));
        panelBoutons.add(boutonFac, BorderLayout.WEST);

        JButton boutonEC = new JButton("J'accède à mon espace personnel");
        boutonEC.setFont(new Font("Georgia", Font.BOLD, 19));
        boutonEC.setBackground(Color.decode("#7E3DFF"));
        boutonEC.setForeground(Color.white);
        boutonEC.setPreferredSize(new Dimension(360, 50));
        panelBoutons.add(boutonEC, BorderLayout.EAST);

        contPrin.add(panelBoutons, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        contPrin.add(espaceBlanc, gbc);

        boutonEC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FrameEspacePerso frameEspacePerso = null;
                try
                {
                    frameEspacePerso = new FrameEspacePerso();
                    Window window = SwingUtilities.getWindowAncestor(boutonEC);

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


        add(contPrin, BorderLayout.CENTER);
    }
}
