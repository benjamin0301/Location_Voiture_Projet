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

    private Connexion connexion;
    public ListeVoitures() throws SQLException, ClassNotFoundException {

        ClientController clientcontroller = new ClientController();
        VoitureController voiturecontroller = new VoitureController();

        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ArrayList<VoitureModel> listeVoitures = voiturecontroller.recupListeVoiture();

        JPanel panelToyota = new JPanel();
        panelToyota.setPreferredSize(new Dimension(2, 300));
        panelToyota.setBackground(Color.CYAN);
        JLabel labelPlaque = new JLabel(listeVoitures.get(0).getId_plaque());
        panelToyota.add(labelPlaque);
        add(panelToyota);

        JPanel panelTesla = new JPanel();
        panelTesla.setPreferredSize(new Dimension(2, 300));
        panelTesla.setBackground(Color.orange);
        add(panelTesla);

        JPanel panelBugatti = new JPanel();
        panelBugatti.setPreferredSize(new Dimension(2, 300));
        panelBugatti.setBackground(Color.darkGray);
        add(panelBugatti);

        JPanel panelLotus = new JPanel();
        panelLotus.setPreferredSize(new Dimension(2, 300));
        panelLotus.setBackground(Color.decode("#0097B2"));
        add(panelLotus);

        JPanel panelAlpine = new JPanel();
        panelAlpine.setPreferredSize(new Dimension(2, 300));
        panelAlpine.setBackground(Color.decode("#FF66C4"));
        add(panelAlpine);
    }
}
