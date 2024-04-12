package ZCA.page_principale.conteneurprincipal.voitures;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class NbVoituresDispo extends JPanel
{
    public NbVoituresDispo() throws SQLException, ClassNotFoundException
    {
        VoitureModel voitureModel = new VoitureModel();
        ArrayList<VoitureModel> listeVoitures = new ArrayList<>();

        listeVoitures = voitureModel.recupListeVoitureNonLouee();

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(2, 50));
        setBackground(Color.white);

        JPanel panelOuest = new JPanel();
        panelOuest.setBackground(Color.white);

        JTextArea textAreaOuest = new JTextArea();
        textAreaOuest.setText(listeVoitures.size() + " voitures disponibles.");
        textAreaOuest.setFont(new Font("Aleo",Font.PLAIN,15));
        panelOuest.add(textAreaOuest);
        add(panelOuest, BorderLayout.WEST);

    }
}
