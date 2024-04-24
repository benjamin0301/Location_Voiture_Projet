package View.PageResultats.conteneurprincipal.voitures;

import Model.ClientModel;
import Model.EmployeModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListeVoitures extends JPanel
{
    private ClientModel client;
    private EmployeModel employe;
    private String dateDepart,dateRetour;

    public ListeVoitures() throws SQLException, ClassNotFoundException
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.client = null;
    }

    public ListeVoitures(ClientModel clientModel, String dateDepart, String dateRetour) throws SQLException, ClassNotFoundException
    {
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.client = clientModel;
    }

    public ListeVoitures(EmployeModel employeModel) throws SQLException, ClassNotFoundException
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.employe = employeModel;
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
                PanelVoiture panelVoiture = new PanelVoiture(voiture, client, res, dateDepart, dateRetour);
                        add(panelVoiture);
            }
            else if (type == 2)
            {
                PanelVoitureEmploye panelVoitureEmploye = new PanelVoitureEmploye(voiture, employe);
                add(panelVoitureEmploye);
            }
        }
    }
}
