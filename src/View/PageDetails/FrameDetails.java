package View.PageDetails;

import Model.ClientModel;
import Model.VoitureModel;
import View.CustomScrollBarUI;
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
    private ClientModel client;
    private String dateDepart, dateRetour;
    public FrameDetails(VoitureModel voiture, int res, ClientModel clientModel, String dateDepart, String dateRetour) throws SQLException, ClassNotFoundException
    {
        this.voiture = voiture;
        this.client = clientModel;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        initialize(res);
    }

    public void initialize(int res) throws SQLException, ClassNotFoundException
    {
        setTitle("RentMyRide");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        ConteneurHaut conteneurHaut = new ConteneurHaut(res, client,"","","","");

        ConteneurPrincipal conteneurPrincipal = new ConteneurPrincipal(voiture, res, client, dateDepart, dateRetour);
        contentPanel.add(conteneurPrincipal);

        Footer footer = new Footer();
        contentPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());

        add(scrollPane);

        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setVisible(true);
    }
}
