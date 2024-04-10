package ZCA.page_principale.conteneurprincipal.voitures;

import Controler.VoitureController;
import Model.VoitureModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConteneurVoitures extends JPanel {

    public ConteneurVoitures() throws SQLException, ClassNotFoundException {
        setLayout(new GridBagLayout());
        VoitureController voitureController = new VoitureController();
        VoitureModel voitureModel = new VoitureModel();

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JPanel messageIndicatif = new JPanel();
        messageIndicatif.setPreferredSize(new Dimension(2, 50));
        messageIndicatif.setBackground(Color.decode("#02A858"));
        messageIndicatif.setBorder(new LineBorder(Color.white, 3));
        add(messageIndicatif, gbc);

        gbc.gridy++;
        JPanel messageAlerte = new JPanel();
        messageAlerte.setPreferredSize(new Dimension(2, 50));
        messageAlerte.setBackground(Color.decode("#FF7520"));
        messageAlerte.setBorder(new LineBorder(Color.white, 3));
        add(messageAlerte, gbc);


        gbc.gridy++;
        CarouselVoitures carouselVoitures = new CarouselVoitures();
        add(carouselVoitures, gbc);


        gbc.gridy++;
        NbVoituresDispo nbVoituresDispo = new NbVoituresDispo();
        add(nbVoituresDispo, gbc);

        gbc.gridy++;
        JPanel miniEspaceBlanc = new JPanel();
        miniEspaceBlanc.setPreferredSize(new Dimension(2, 15));
        miniEspaceBlanc.setBackground(Color.WHITE);
        add(miniEspaceBlanc, gbc);


        gbc.gridy++;
        ListeVoitures listeVoitures = new ListeVoitures();
        String typeClicked = carouselVoitures.returnTypeClicked();

        ArrayList<VoitureModel> listeVoituresPourAffichage = new ArrayList<>();

        System.out.println("typeClicked = " + typeClicked);
        if (typeClicked != null){
            switch (typeClicked) {
                case "Mini":
                    try {
                        listeVoituresPourAffichage = voitureModel.recupListeVoitureFiltrage("type","=", "Mini",
                                null,null,null,null,null,null,null,
                                null,null,null,null,null);
                        System.out.println("si ca rentre dans mini" + listeVoituresPourAffichage.getFirst().getType());
                    } catch (ClassNotFoundException | SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "SUV":
                    // Action pour le type de voiture "SUV"
                    break;
                case "Sportive":
                    // Action pour le type de voiture "Sportive"
                    break;
                case "Supersportive":
                    // Action pour le type de voiture "Supersportive"
                    break;
                case "Berline":
                    // Action pour le type de voiture "Berline"
                    break;
                case "Minivan":
                    // Action pour le type de voiture "Minivan"
                    break;
                case "Spécial":
                    // Action pour le type de voiture "Spécial"
                    break;
                case "TypeXYZ":
                    // Action pour le type de voiture "TypeXYZ"
                    break;
            }
        } else{
            listeVoituresPourAffichage = voitureController.recupListeVoitureNonLouee();
            System.out.println("si ca rentre dans default" + listeVoituresPourAffichage.getFirst().getType());
        }



        // liste finale a afficher
        listeVoitures.afficherListeVoitures(listeVoituresPourAffichage);
        add(listeVoitures, gbc);


        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }
}
