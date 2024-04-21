package View;
import Model.EmployeModel;
import View.PageEspacePersonnel.FrameEspacePerso;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;
import View.PageResultats.conteneurprincipal.ConteneurPrincipal;
import Model.ClientModel;
import View.PageResultats.conteneurprincipal.voitures.ConteneurVoituresEmploye;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class VueEmploye extends JFrame
{
    private ConteneurEmploye conteneurEmploye;
    private ConteneurPrincipal conteneurPrincipal;
    private ConteneurVoituresEmploye conteneurvoituresemployes;


    public VueEmploye(EmployeModel employeModel) throws SQLException, ClassNotFoundException {}

    public void initialize(String lieuDepart, String dateDepart, String lieuRetour, String dateRetour) throws SQLException, ClassNotFoundException
    {
        setTitle("RentMyRide");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        //conteneurPrincipal = new ConteneurPrincipal();
        //conteneurPrincipal.initConteneurPrincipal(lieuDepart, dateDepart, lieuRetour, dateRetour); // Fournir les arguments ici
        conteneurvoituresemployes = new ConteneurVoituresEmploye();
        conteneurEmploye = new ConteneurEmploye();

        Footer footer = new Footer();

        JPanel contenuPanel = new JPanel();
        contenuPanel.setLayout(new BorderLayout());
        contenuPanel.add(conteneurvoituresemployes, BorderLayout.CENTER);
        contenuPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contenuPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setUI(new CustomScrollBarUI());


        add(conteneurEmploye, BorderLayout.NORTH);
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