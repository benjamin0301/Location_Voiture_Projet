package View.PageEspacePersonnel;
import Model.ClientModel;
import Model.EmployeModel;
import com.mysql.cj.xdevapi.Client;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class EspacePersonnel extends JPanel
{
    private ClientModel client;
    private EmployeModel employe;

    public EspacePersonnel(ClientModel clientModel) throws SQLException, ClassNotFoundException
    {
        this.client = clientModel;
        setLayout(new BorderLayout());

        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(Color.white);
        JTextArea titre = new JTextArea("\nMon espace personnel\n");
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
        MesReservations mesReservations = new MesReservations(client);
        panelPrincipal.add(mesReservations, gbc);

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        panelPrincipal.add(espaceBlanc, gbc);

        add(panelPrincipal, BorderLayout.CENTER);
    }

    public EspacePersonnel(EmployeModel employeModel) throws SQLException, ClassNotFoundException
    {
        this.employe = employeModel;
        setLayout(new BorderLayout());

        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(Color.white);
        JTextArea titre = new JTextArea("\nMon espace personnel\n");
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

        MesInfosPerso mesInfosPerso = new MesInfosPerso(employe);
        panelPrincipal.add(mesInfosPerso, gbc);

        gbc.gridy++;

        gbc.gridy++;
        gbc.weighty = 10;
        gbc.fill = GridBagConstraints.BOTH;
        JPanel espaceBlanc = new JPanel();
        espaceBlanc.setBackground(Color.white);
        panelPrincipal.add(espaceBlanc, gbc);

        add(panelPrincipal, BorderLayout.CENTER);
    }
}

