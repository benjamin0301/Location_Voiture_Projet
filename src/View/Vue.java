package View;
import View.PageEspacePersonnel.FrameEspacePerso;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;
import View.PageResultats.conteneurprincipal.ConteneurPrincipal;
import Model.ClientModel;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Vue extends JFrame
{
    private ConteneurHaut conteneurHaut;
    private ConteneurPrincipal conteneurPrincipal;
    private ClientModel client;

    public Vue(ClientModel clientModel) throws SQLException, ClassNotFoundException {
        this.client = clientModel;
    }

    public void initialize(String lieuDepart, String dateDepart, String lieuRetour, String dateRetour, int res) throws SQLException, ClassNotFoundException
    {
        setTitle("RentMyRide");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        conteneurPrincipal = new ConteneurPrincipal(client);
        conteneurPrincipal.initConteneurPrincipal(lieuDepart, dateDepart, lieuRetour, dateRetour, res); // Fournir les arguments ici

        conteneurHaut = new ConteneurHaut(res, client, lieuDepart, dateDepart, lieuRetour, dateRetour);
        Footer footer = new Footer();

        JPanel contenuPanel = new JPanel();
        contenuPanel.setLayout(new BorderLayout());
        contenuPanel.add(conteneurPrincipal, BorderLayout.CENTER);
        contenuPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contenuPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());


        add(conteneurHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Déplace la vue du JScrollPane vers le haut du contenuPanel
        SwingUtilities.invokeLater(() -> {
            JViewport viewport = scrollPane.getViewport();
            viewport.setViewPosition(new Point(0, 0));
        });

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}