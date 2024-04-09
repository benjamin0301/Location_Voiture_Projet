package ZCA.page_principale.conteneurprincipal.voitures;

import Controler.ClientController;
import Controler.VoitureController;
import Model.Connexion;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeVoitures extends JPanel
{
    private ArrayList<VoitureModel> voitures;
    //private ClientController clientcontroller;
    //private VoitureController voiturecontroller;

    //private Connexion connexion;
    public ListeVoitures() throws SQLException, ClassNotFoundException {

        //ClientController clientcontroller = new ClientController();
        VoitureController voiturecontroller = new VoitureController();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ArrayList<VoitureModel> listeVoitures = voiturecontroller.recupListeVoitureNonLouee();


        for (int i = 0; i < 4; i++)
        {
            JPanel miniEspaceBlanc = new JPanel();
            miniEspaceBlanc.setPreferredSize(new Dimension(2, 15));
            miniEspaceBlanc.setBackground(Color.WHITE);
            add(miniEspaceBlanc);

            PanelVoiture panelVoiture = new PanelVoiture(listeVoitures.get(i));
            add(panelVoiture);
        }
    }
}
