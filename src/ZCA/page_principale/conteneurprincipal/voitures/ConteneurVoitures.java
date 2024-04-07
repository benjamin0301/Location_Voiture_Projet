package ZCA.page_principale.conteneurprincipal.voitures;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ConteneurVoitures extends JPanel {

    public ConteneurVoitures() {
        setLayout(new GridBagLayout());

        // Création des contraintes pour le placement des composants
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
        ListeVoitures listeVoitures = new ListeVoitures();
        add(listeVoitures, gbc);


        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        add(espaceBlanc, gbc);
    }
}
