package View.PageResultats.conteneurprincipal.voitures;

import Controler.VoitureController;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class NbVoituresDispo extends JPanel
{
    public NbVoituresDispo() throws SQLException, ClassNotFoundException
    {
        VoitureController voiturecontroller = new VoitureController();
        ArrayList<VoitureModel> listeVoitures = voiturecontroller.recupListeVoitureNonLouee();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(2, 30));
        setBackground(Color.white);

        JPanel panelOuest = new JPanel();
        panelOuest.setBackground(Color.white);

        JTextArea textAreaOuest = new JTextArea();
        textAreaOuest.setEditable(false);
        textAreaOuest.setText("     " + listeVoitures.size() + " voitures disponibles !");
        textAreaOuest.setFont(new Font("Georgia",Font.BOLD,16));
        panelOuest.add(textAreaOuest);
        add(panelOuest, BorderLayout.WEST);
    }
}
