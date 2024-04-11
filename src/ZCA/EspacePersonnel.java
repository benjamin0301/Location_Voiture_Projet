package ZCA;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class EspacePersonnel extends JPanel
{
    public EspacePersonnel() throws SQLException, ClassNotFoundException {
        setLayout(new BorderLayout());

        JLabel titre = new JLabel("Mon espace personnel");
        titre.setBackground(Color.white);
        titre.setPreferredSize(new Dimension(900, 100));
        add(titre, BorderLayout.NORTH);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBackground(Color.white);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 10, 10, 10);

        MesInfosPerso mesInfosPerso = new MesInfosPerso();
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
