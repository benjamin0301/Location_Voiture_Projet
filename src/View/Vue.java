package View;

import View.PageEspacePersonnel.EspacePersonnel;
import View.PageEspacePersonnel.EspacePersonnelListener;
import View.PageResultats.ConteneurHaut;
import View.PageResultats.Footer;
import View.PageResultats.conteneurprincipal.ConteneurPrincipal;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Vue extends JFrame implements EspacePersonnelListener
{
    private ConteneurHaut conteneurHaut;
    private ConteneurPrincipal conteneurPrincipal;

    public Vue() throws SQLException, ClassNotFoundException {}

    public void initialize() throws SQLException, ClassNotFoundException
    {
        setTitle("RentMyRide");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        conteneurPrincipal = new ConteneurPrincipal();
        conteneurPrincipal.initConteneurPrincipal();

        conteneurHaut = new ConteneurHaut();
        conteneurHaut.setEspacePersonnelListener(this);

        Footer footer = new Footer();

        JPanel contenuPanel = new JPanel();
        contenuPanel.setLayout(new BorderLayout());
        contenuPanel.add(conteneurPrincipal, BorderLayout.CENTER);
        contenuPanel.add(footer, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(contenuPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        add(conteneurHaut, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    @Override
    public void onEspacePersonnelClicked() throws SQLException, ClassNotFoundException
    {
        conteneurPrincipal.removeAll();
        conteneurPrincipal.add(new EspacePersonnel());
        conteneurPrincipal.revalidate();
        conteneurPrincipal.repaint();
    }
}
