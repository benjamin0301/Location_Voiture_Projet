package View.PageResultats.conteneurprincipal;

import Model.ClientModel;
import View.PageEspacePersonnel.EspacePersonnel;
import View.PageResultats.conteneurprincipal.gauche.ConteneurGauche;
import View.PageResultats.conteneurprincipal.voitures.ConteneurVoitures;
import com.mysql.cj.xdevapi.Client;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ConteneurPrincipal extends JPanel
{
    private String lieuDepart;
    private String dateDepart;
    private String lieuRetour;
    private String dateRetour;
    public ClientModel client;

    public ConteneurPrincipal(ClientModel clientModel) throws SQLException, ClassNotFoundException {
        this.client = clientModel;
    }

    public void initConteneurPrincipal(String lieuDepart, String dateDepart, String lieuRetour, String dateRetour, int res) throws SQLException, ClassNotFoundException
    {
        setLayout(new BorderLayout());

        JPanel conteneurGris = new JPanel(new BorderLayout());
        conteneurGris.setBackground(Color.decode("#E4E4E4"));
        conteneurGris.setBorder(BorderFactory.createEmptyBorder(35, 85, 35, 85));


        Progression progression = new Progression();
        conteneurGris.add(progression, BorderLayout.NORTH);

        ConteneurGauche conteneurGauche = new ConteneurGauche(lieuDepart, dateDepart, lieuRetour, dateRetour, res, client);
        conteneurGris.add(conteneurGauche, BorderLayout.WEST);

        ConteneurVoitures conteneurVoitures = new ConteneurVoitures(client,res);
        conteneurGris.add(conteneurVoitures, BorderLayout.CENTER);

        add(conteneurGris, BorderLayout.CENTER);
        
    }
    public void afficherEspacePersonnel()
    {
        removeAll();
        EspacePersonnel espacePersonnel = null;

        try { espacePersonnel = new EspacePersonnel(client); }
        catch (SQLException | ClassNotFoundException ex) { throw new RuntimeException(ex); }
        add(espacePersonnel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}

