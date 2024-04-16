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
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel labelFiltrer = new JLabel("Infos Voiture Selectionnée");
        labelFiltrer.setPreferredSize(new Dimension(220, 50));
        labelFiltrer.setOpaque(true);
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER);
        labelFiltrer.setBackground(Color.decode("#E6E6E6"));
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        JTextArea typeVoitureSelect = new JTextArea(voiture.getType());
        typeVoitureSelect.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(typeVoitureSelect);

        JTextArea nomVoiture = new JTextArea(voiture.getMarque() + voiture.getnom_modele());
        nomVoiture.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(nomVoiture);

        JLabel carac = new JLabel("Caractéristiques du vehicule :");
        carac.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(carac);

        JLabel nbPass = new JLabel(String.valueOf(voiture.getNbPlace()) + " passagers");
        nbPass.setPreferredSize(new Dimension(100, 30));
        contenuPanel.add(nbPass);

        JLabel carbu = new JLabel(voiture.getMoteur());
        carbu.setPreferredSize(new Dimension(100, 30));
        contenuPanel.add(carbu);

        JLabel nbBag = new JLabel(String.valueOf(voiture.getCapaciteValise()) + " bagage(s)");
        nbBag.setPreferredSize(new Dimension(100, 30));
        contenuPanel.add(nbBag);

        JLabel trans = new JLabel(voiture.getTransmission());
        trans.setPreferredSize(new Dimension(100, 30));
        contenuPanel.add(trans);

        JLabel nbPor = new JLabel(String.valueOf(voiture.getNbPorte()) + " portes");
        nbPor.setPreferredSize(new Dimension(100, 30));
        contenuPanel.add(nbPor);

        JTextArea PMC = new JTextArea("Kilometrage actuel :\n" + voiture.getkilometrage_actuel());
        PMC.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(PMC);

        JTextArea kil = new JTextArea("Limite de kilometrage :\n" + voiture.getLimite_km());
        kil.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(kil);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(200, 2));
        separator.setForeground(Color.darkGray);
        contenuPanel.add(separator);

        JTextArea depArr = new JTextArea("Depart\n" + voiture.getLieuPriseEnCharge() + "\n" + voiture.getDate_debut_loc() + "\n\nRetour\n" + voiture.getLieuPriseEnCharge() + "\n" + voiture.getDate_fin_loc());
        depArr.setPreferredSize(new Dimension(200, 120));
        contenuPanel.add(depArr);


        add(contenuPanel, BorderLayout.CENTER);
        add(labelFiltrer, BorderLayout.NORTH);
    }
}
