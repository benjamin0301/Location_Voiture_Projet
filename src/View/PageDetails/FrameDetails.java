package View.PageDetails;

import Model.VoitureModel;
import View.PageDetails.ConteneurPrincipal.ConteneurPrincipal;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class FrameDetails extends JFrame
{
    VoitureModel voiture;
    private JPanel contentPanel;
    public FrameDetails(VoitureModel voiture) throws SQLException, ClassNotFoundException
    {
        this.voiture = voiture;
        initialize();
    }

    public void initialize() throws SQLException, ClassNotFoundException
    {
        setTitle("RentMyRide");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurPrincipal conteneurPrincipalDetails = new ConteneurPrincipal(voiture);
        contentPanel.add(conteneurPrincipalDetails, BorderLayout.CENTER);

        ConteneurHaut conteneurHaut = new ConteneurHaut();
        contentPanel.add(conteneurHaut, BorderLayout.NORTH);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }
}