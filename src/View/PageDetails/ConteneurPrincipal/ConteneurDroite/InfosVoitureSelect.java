package View.PageDetails.ConteneurPrincipal.ConteneurDroite;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class InfosVoitureSelect extends JPanel
{
    public InfosVoitureSelect(VoitureModel voiture)
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.decode("#FFFFFF"));
        contenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel labelFiltrer = new JLabel("     Voiture sélectionée");
        labelFiltrer.setPreferredSize(new Dimension(220, 50));
        labelFiltrer.setOpaque(true);
        labelFiltrer.setHorizontalAlignment(SwingConstants.LEFT);
        labelFiltrer.setFont(new Font("Georgia", Font.BOLD, 13));
        labelFiltrer.setBackground(Color.decode("#E6E6E6"));
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        JTextArea typeVoitureSelect = new JTextArea(voiture.getType());
        typeVoitureSelect.setEditable(false);
        typeVoitureSelect.setFont(new Font("Georgia", Font.BOLD, 13));
        typeVoitureSelect.setPreferredSize(new Dimension(200, 16));
        contenuPanel.add(typeVoitureSelect);

        JTextArea nomVoiture = new JTextArea(voiture.getMarque() + " " + voiture.getnom_modele());
        nomVoiture.setPreferredSize(new Dimension(200, 16));
        nomVoiture.setEditable(false);
        nomVoiture.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(nomVoiture);

        ImageIcon AImage = new ImageIcon(voiture.getImage_voiture());
        JLabel imageLabel = new JLabel(AImage);
        contenuPanel.add(imageLabel);

        JLabel carac = new JLabel("Caractéristiques du véhicule :");
        carac.setFont(new Font("Georgia", Font.BOLD, 13));
        carac.setPreferredSize(new Dimension(200, 22));
        contenuPanel.add(carac);

        JLabel nbPass = new JLabel(String.valueOf(voiture.getNbPlace()) + " passagers            " + voiture.getMoteur());
        nbPass.setPreferredSize(new Dimension(200, 30));
        nbPass.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(nbPass);

        JLabel nbBag = new JLabel(String.valueOf(voiture.getCapaciteValise()) + " bagage(s)            " + voiture.getTransmission());
        nbBag.setPreferredSize(new Dimension(200, 30));
        nbBag.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(nbBag);

        JLabel nbPor = new JLabel(String.valueOf(voiture.getNbPorte()) + " portes");
        nbPor.setPreferredSize(new Dimension(200, 30));
        nbPor.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(nbPor);

        JPanel panelBlanc = new JPanel();
        panelBlanc.setPreferredSize(new Dimension(200, 12));
        panelBlanc.setBackground(Color.white);
        contenuPanel.add(panelBlanc);

        JTextArea PMC = new JTextArea("Kilométrage actuel :");
        PMC.setEditable(false);
        PMC.setPreferredSize(new Dimension(200, 18));
        PMC.setFont(new Font("Georgia", Font.BOLD, 13));
        contenuPanel.add(PMC);

        JTextArea KA2 = new JTextArea(String.valueOf(voiture.getkilometrage_actuel()) + " km");
        KA2.setPreferredSize(new Dimension(200, 22));
        KA2.setEditable(false);
        KA2.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(KA2);

        JTextArea kil = new JTextArea("Limite de kilométrage :");
        kil.setEditable(false);
        kil.setPreferredSize(new Dimension(200, 18));
        kil.setFont(new Font("Georgia", Font.BOLD, 13));
        contenuPanel.add(kil);

        JTextArea kil2 = new JTextArea(String.valueOf(voiture.getLimite_km()) + " km");
        kil2.setPreferredSize(new Dimension(200, 30));
        kil2.setEditable(false);
        kil2.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(kil2);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(200, 10));
        separator.setForeground(Color.darkGray);
        contenuPanel.add(separator);


        JLabel depart = new JLabel("Départ");
        depart.setForeground(Color.decode("#7E3DFF"));
        depart.setPreferredSize(new Dimension(200, 16));
        depart.setFont(new Font("Georgia", Font.BOLD, 13));
        contenuPanel.add(depart);

        JLabel depart2 = new JLabel(voiture.getLieuPriseEnCharge());
        depart2.setPreferredSize(new Dimension(200, 16));
        depart2.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(depart2);

        JLabel depart3 = new JLabel(voiture.getDate_debut_loc());
        depart3.setPreferredSize(new Dimension(200, 16));
        depart3.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(depart3);


        JLabel arrivee = new JLabel("Arrivée");
        arrivee.setForeground(Color.decode("#7E3DFF"));
        arrivee.setPreferredSize(new Dimension(200, 16));
        arrivee.setFont(new Font("Georgia", Font.BOLD, 13));
        contenuPanel.add(arrivee);

        JLabel arrivee2 = new JLabel(voiture.getLieuPriseEnCharge());
        arrivee2.setPreferredSize(new Dimension(200, 16));
        arrivee2.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(arrivee2);

        JLabel arrivee3 = new JLabel(voiture.getDate_fin_loc());
        arrivee3.setPreferredSize(new Dimension(200, 16));
        arrivee3.setFont(new Font("Georgia", Font.PLAIN, 13));
        contenuPanel.add(arrivee3);


        add(contenuPanel, BorderLayout.CENTER);
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
