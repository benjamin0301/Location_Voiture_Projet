package ZCA.page_principale.conteneurprincipal.voitures;

import Controler.VoitureController;
import Model.VoitureModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        JPanel messageContainer = new JPanel(new BorderLayout());
        messageContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));

        JPanel messageIndicatif = new JPanel();
        messageIndicatif.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 12));
        messageIndicatif.setPreferredSize(new Dimension(2, 50));
        messageIndicatif.setBackground(Color.decode("#F5FFF4"));
        messageIndicatif.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#25991B")));

        JTextArea areaMI = new JTextArea("✅   Annulation flexible pour chaque réservation.");
        areaMI.setBackground(Color.decode("#F5FFF4"));
        areaMI.setFont(new Font("Aleo", Font.BOLD, 14));
        areaMI.setForeground(Color.decode("#25991B"));
        messageIndicatif.add(areaMI);

        messageContainer.add(messageIndicatif, BorderLayout.CENTER);

        add(messageContainer, gbc);

        gbc.gridy++;
        JPanel messageAlerteContainer = new JPanel(new BorderLayout());
        messageAlerteContainer.setBorder(BorderFactory.createMatteBorder(5, 10, 5, 12, Color.decode("#FFFFFF")));

        JPanel messageAlerte = new JPanel();
        messageAlerte.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 12));
        messageAlerte.setPreferredSize(new Dimension(2, 50));
        messageAlerte.setBackground(Color.decode("#FFF7F2"));
        messageAlerte.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#FF6100")));

        JTextArea areaMA = new JTextArea("⚠️   Il y a une forte demande à Paris en avril. Les prix risquent d'augmenter.");
        areaMA.setBackground(Color.decode("#FFF7F2"));
        areaMA.setFont(new Font("Aleo", Font.BOLD, 14));
        areaMA.setForeground(Color.decode("#FF6100"));
        messageAlerte.add(areaMA);

        messageAlerteContainer.add(messageAlerte, BorderLayout.CENTER);
        add(messageAlerteContainer, gbc);


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
