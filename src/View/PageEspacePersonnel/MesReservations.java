package View.PageEspacePersonnel;

import Model.ClientModel;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MesReservations extends JPanel
{
    ClientModel clientModel = new ClientModel();
    public MesReservations() throws SQLException, ClassNotFoundException
    {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        setPreferredSize(new Dimension(40, 700));

        JPanel espaceVideA = new JPanel();
        espaceVideA.setBackground(Color.white);
        espaceVideA.setPreferredSize(new Dimension(700, 25));
        add(espaceVideA);

        JLabel titre = new JLabel("Mes réservations");
        titre.setPreferredSize(new Dimension(1000, 30));
        titre.setFont(new Font("Aleo", Font.BOLD, 18));
        titre.setBackground(Color.white);
        add(titre);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(1000, 2));
        separator.setForeground(Color.BLACK);
        add(separator);

        JPanel res1 = new JPanel();
        res1.setPreferredSize(new Dimension(1000, 250));
        res1.setBackground(Color.CYAN);

        JLabel id_res = new JLabel("ID de réservation : ");
        res1.add(id_res);

        JLabel id_vloue = new JLabel("ID de véhicule loué : " + clientModel.getId_vehicule_loue());
        res1.add(id_vloue);

        JLabel d_debut = new JLabel("Date de début : " + clientModel.getDate_debut_loc());
        res1.add(d_debut);

        JLabel d_fin = new JLabel("Date de fin : " + clientModel.getDate_fin_loc());
        res1.add(d_fin);

        add(res1);
    }
}
