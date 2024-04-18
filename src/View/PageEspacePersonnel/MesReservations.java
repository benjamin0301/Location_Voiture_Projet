package View.PageEspacePersonnel;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MesReservations extends JPanel
{
    ClientModel clientModel = new ClientModel();
    VoitureModel voiture = new VoitureModel();
    public MesReservations() throws SQLException, ClassNotFoundException
    {
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

        PanelReservation panelReservation = new PanelReservation(clientModel, voiture);
        add(panelReservation);
    }
}
