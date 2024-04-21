package View.PageResultats.conteneurprincipal.voitures;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeVoitures extends JPanel
{
    public ClientModel clientModel;

    public ListeVoitures() throws SQLException, ClassNotFoundException
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.clientModel = null;
    }

    public ListeVoitures(ClientModel clientModel) throws SQLException, ClassNotFoundException
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.clientModel = clientModel;
    }
    public void afficherListeVoitures(ArrayList<VoitureModel> voitures, int type, int res) throws SQLException, ClassNotFoundException
    {
        System.out.println(voitures.getFirst().getType());
        for (VoitureModel voiture : voitures)
        {
            JPanel miniEspaceBlanc = new JPanel();
            miniEspaceBlanc.setPreferredSize(new Dimension(2, 15));
            miniEspaceBlanc.setBackground(Color.WHITE);
            add(miniEspaceBlanc);
            if (type == 1)
            {
                PanelVoiture panelVoiture = new PanelVoiture(voiture, clientModel, res);
                add(panelVoiture);
            }
            else if (type == 2)
            {
                PanelVoitureEmploye panelVoitureEmploye = new PanelVoitureEmploye(voiture);
                add(panelVoitureEmploye);
            }
        }
    }
}
