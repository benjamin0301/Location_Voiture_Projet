package ZCA.page_principale.conteneurprincipal.voitures;

import Controler.VoitureController;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeVoitures extends JPanel {
    private ArrayList<VoitureModel> voitures;

    public ListeVoitures() throws SQLException, ClassNotFoundException {
        VoitureController voitureController = new VoitureController();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void afficherListeVoitures(ArrayList<VoitureModel> voitures) throws SQLException, ClassNotFoundException {
        System.out.println(voitures.getFirst().getType());
        for (VoitureModel voiture : voitures) {
            JPanel miniEspaceBlanc = new JPanel();
            miniEspaceBlanc.setPreferredSize(new Dimension(2, 15));
            miniEspaceBlanc.setBackground(Color.WHITE);
            add(miniEspaceBlanc);

            PanelVoiture panelVoiture = new PanelVoiture(voiture);
            add(panelVoiture);
        }
    }
}
