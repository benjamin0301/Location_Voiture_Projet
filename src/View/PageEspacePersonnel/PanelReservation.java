package View.PageEspacePersonnel;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class PanelReservation extends JPanel
{
    public PanelReservation(ClientModel client, VoitureModel voiture)
    {
        setPreferredSize(new Dimension(1000, 250));
        setBackground(Color.CYAN);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weightx = 0;

        JPanel panelA = new JPanel();
        panelA.setPreferredSize(new Dimension(350, 250));
        panelA.setBackground(Color.white);
        panelA.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelA.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.lightGray));


        JPanel ebs = new JPanel();
        ebs.setBackground(Color.white);
        ebs.setPreferredSize(new Dimension(350, 15));
        panelA.add(ebs);

        JLabel idR = new JLabel("Réservation #" + client.getId_facture());
        idR.setBackground(Color.white);
        idR.setFont(new Font("Georgia", Font.BOLD, 18));
        idR.setPreferredSize(new Dimension(310, 32));
        panelA.add(idR);
        idR.setForeground(Color.decode("#7E3DFF"));

        JLabel type = new JLabel("Type : " +voiture.getType());
        type.setBackground(Color.white);
        type.setFont(new Font("Georgia", Font.BOLD, 16));
        type.setPreferredSize(new Dimension(310, 25));
        panelA.add(type);

        JLabel mm = new JLabel("Marque : " +voiture.getMarque() + ", Modèle : " + voiture.getnom_modele());
        mm.setBackground(Color.white);
        mm.setFont(new Font("Georgia", Font.PLAIN, 16));
        mm.setPreferredSize(new Dimension(310, 50));
        panelA.add(mm);

        ImageIcon AImage = new ImageIcon("images/veyron-16.4.png");
        JLabel imageLabel = new JLabel(AImage);
        panelA.add(imageLabel);

        add(panelA, gbc);



        gbc.gridx++;
        JPanel panelB = new JPanel();
        panelB.setPreferredSize(new Dimension(350, 250));
        panelB.setBackground(Color.decode("#F6F6F6"));
        panelB.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        panelB.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.lightGray));

        JPanel ebs2 = new JPanel();
        ebs2.setBackground(Color.decode("#F6F6F6"));
        ebs2.setPreferredSize(new Dimension(350, 15));
        panelB.add(ebs2);

        JLabel numP = new JLabel("Numéro de plaque : " + voiture.getId_plaque());
        numP.setBackground(Color.white);
        numP.setFont(new Font("Georgia", Font.BOLD, 17));
        numP.setPreferredSize(new Dimension(310, 53));
        panelB.add(numP);

        JLabel trans = new JLabel("Transmission : " + voiture.getTransmission());
        trans.setBackground(Color.white);
        trans.setFont(new Font("Georgia", Font.PLAIN, 15));
        trans.setPreferredSize(new Dimension(310, 20));
        panelB.add(trans);

        JLabel moteur = new JLabel("Moteur : " + voiture.getMoteur());
        moteur.setBackground(Color.white);
        moteur.setFont(new Font("Georgia", Font.PLAIN, 15));
        moteur.setPreferredSize(new Dimension(310, 45));
        panelB.add(moteur);

        JTextArea ACapacite = new JTextArea("Nombre de passagers : " + voiture.getNbPlace() + "\nCapacité (bagages) : " + voiture.getCapaciteValise() + "\nNombre de portes : " + voiture.getNbPorte());
        ACapacite.setLayout(new BorderLayout());
        ACapacite.setEditable(false);
        ACapacite.setBackground(Color.decode("#F6F6F6"));
        ACapacite.setPreferredSize(new Dimension(310, 60));
        ACapacite.setFont(new Font("Georgia", Font.PLAIN, 15));
        panelB.add(ACapacite);

        JLabel KL = new JLabel("Kilométrage limite : " + voiture.getLimite_km() + " km");
        KL.setBackground(Color.white);
        KL.setForeground(Color.darkGray);
        KL.setFont(new Font("Georgia", Font.BOLD, 15));
        KL.setPreferredSize(new Dimension(310, 45));
        panelB.add(KL);

        add(panelB, gbc);

        gbc.gridx++;
        JPanel panelC = new JPanel();
        panelC.setPreferredSize(new Dimension(300, 250));
        panelC.setBackground(Color.white);
        panelC.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelC.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.lightGray));

        JPanel ebs3 = new JPanel();
        ebs3.setBackground(Color.white);
        ebs3.setPreferredSize(new Dimension(270, 15));
        panelC.add(ebs3);

        JLabel depart = new JLabel("Départ");
        depart.setForeground(Color.decode("#7E3DFF"));
        depart.setPreferredSize(new Dimension(270, 22));
        depart.setFont(new Font("Georgia", Font.BOLD, 19));
        panelC.add(depart);

        JLabel depart2 = new JLabel("Lieu : " + voiture.getLieuPriseEnCharge());
        depart2.setPreferredSize(new Dimension(270, 21));
        depart2.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelC.add(depart2);

        JLabel depart3 = new JLabel("Date : " + voiture.getDate_debut_loc());
        depart3.setPreferredSize(new Dimension(270, 21));
        depart3.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelC.add(depart3);

        JPanel ebs4 = new JPanel();
        ebs4.setBackground(Color.white);
        ebs4.setPreferredSize(new Dimension(270, 10));
        panelC.add(ebs4);


        JLabel arrivee = new JLabel("Arrivée");
        arrivee.setForeground(Color.decode("#7E3DFF"));
        arrivee.setPreferredSize(new Dimension(270, 22));
        arrivee.setFont(new Font("Georgia", Font.BOLD, 19));
        panelC.add(arrivee);

        JLabel arrivee2 = new JLabel("Lieu : " + voiture.getLieuPriseEnCharge());
        arrivee2.setPreferredSize(new Dimension(270, 21));
        arrivee2.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelC.add(arrivee2);

        JLabel arrivee3 = new JLabel("Date : " + voiture.getDate_fin_loc());
        arrivee3.setPreferredSize(new Dimension(270, 21));
        arrivee3.setFont(new Font("Georgia", Font.PLAIN, 17));
        panelC.add(arrivee3);

        JPanel ebs5 = new JPanel();
        ebs5.setBackground(Color.white);
        ebs5.setPreferredSize(new Dimension(270, 6));
        panelC.add(ebs5);


        JButton supp = new JButton("Supprimer cette réservation");
        supp.setBackground(Color.decode("#7E3DFF"));
        supp.setForeground(Color.white);
        supp.setFont(new Font("Georgia", Font.BOLD, 15));
        panelC.add(supp);


        add(panelC, gbc);
    }
}
