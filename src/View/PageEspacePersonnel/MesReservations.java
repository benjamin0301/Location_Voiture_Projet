package View.PageEspacePersonnel;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class MesReservations extends JPanel
{
    private ClientModel client;

    public MesReservations(ClientModel clientModel) throws SQLException, ClassNotFoundException
    {
        this.client = clientModel;
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setPreferredSize(new Dimension(40, 400));

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        JLabel titre = new JLabel("Mes réservations");
        titre.setPreferredSize(new Dimension(1000, 30));
        titre.setFont(new Font("Georgia", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1000, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JPanel espaceVideB = new JPanel();
        espaceVideB.setBackground(Color.white);
        espaceVideB.setPreferredSize(new Dimension(700, 25));
        add(espaceVideB);

        //ArrayList<VoitureModel> liste_voiture = new ArrayList<>();
        // plus tard si j'ai le temps
        VoitureModel voiture = new VoitureModel();
        voiture = voiture.RecupVoitureByIdPlaque(client.getId_vehicule_loue());
        PanelReservation panelReservation = new PanelReservation(client, voiture);
        add(panelReservation);
    }
}
