package ZCA.page_details;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class InfosVoitureSelect extends JPanel
{
    public InfosVoitureSelect(VoitureModel voiture)
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));

        // Panel pour le contenu à placer au centre
        JPanel contenuPanel = new JPanel();
        contenuPanel.setBackground(Color.decode("#FFFFFF")); // Couleur jaune
        contenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel labelFiltrer = new JLabel("Infos Voiture Sélectionnée");
        labelFiltrer.setPreferredSize(new Dimension(220, 50)); // Hauteur de 50px
        labelFiltrer.setOpaque(true); // Permet d'appliquer la couleur de fond
        labelFiltrer.setHorizontalAlignment(SwingConstants.CENTER); // Centre le texte horizontalement
        labelFiltrer.setBackground(Color.decode("#E6E6E6")); // Couleur jaune moutarde
        labelFiltrer.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        contenuPanel.add(labelFiltrer);

        JTextArea typeVoitureSelect = new JTextArea(voiture.getType());
        typeVoitureSelect.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(typeVoitureSelect);

        JTextArea nomVoiture = new JTextArea(voiture.getMarque() + voiture.getnom_modele());
        nomVoiture.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(nomVoiture);

        JLabel carac = new JLabel("Caractéristiques du véhicule :");
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


        //JTextArea LPC = new JTextArea("Lieu de prise en charge :\n" + voiture.getLieuPriseEnCharge());
        //LPC.setPreferredSize(new Dimension(200, 30));
        //contenuPanel.add(LPC);

        JTextArea PMC = new JTextArea("Kilométrage actuel :\n" + voiture.getkilometrage_actuel());
        PMC.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(PMC);

        JTextArea kil = new JTextArea("Limite de kilométrage :\n" + voiture.getLimite_km());
        kil.setPreferredSize(new Dimension(200, 30));
        contenuPanel.add(kil);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(200, 2));
        separator.setForeground(Color.darkGray);
        contenuPanel.add(separator);

        JTextArea depArr = new JTextArea("Départ\n" + voiture.getLieuPriseEnCharge() + "\n" + voiture.getDate_debut_loc() + "\n\nRetour\n" + voiture.getLieuPriseEnCharge() + "\n" + voiture.getDate_fin_loc());
        depArr.setPreferredSize(new Dimension(200, 120));
        contenuPanel.add(depArr);



        // Ajout du contenuPanel au centre du BorderLayout
        add(contenuPanel, BorderLayout.CENTER);

        // Ajout du label "Filtrer" au nord du BorderLayout
        add(labelFiltrer, BorderLayout.NORTH);
    }

    //getPrix
}
