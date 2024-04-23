package View.PageEspacePersonnel;
import Model.ClientModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class EspacePersonnel extends JPanel
{
    ClientModel client = new ClientModel();
    public EspacePersonnel() throws SQLException, ClassNotFoundException
    {
        setLayout(new BorderLayout());

        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(Color.white);
        JTextArea titre = new JTextArea("\nMon espace personnel\n");
        titre.setEditable(false);
        titre.setFont(new Font("Georgia", Font.BOLD, 31));
        titre.setForeground(Color.decode("#7E3DFF"));
        panelTitre.add(titre);
        add(panelTitre, BorderLayout.NORTH);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        MesInfosPerso mesInfosPerso = new MesInfosPerso(client);
        panelPrincipal.add(mesInfosPerso, gbc);

        gbc.gridy++;
        MesReservations mesReservations = new MesReservations();
        panelPrincipal.add(mesReservations, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        panelPrincipal.add(espaceBlanc, gbc);

        add(panelPrincipal, BorderLayout.CENTER);
    }
}

