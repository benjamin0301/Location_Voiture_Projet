package ZCA.page_principale.conteneurprincipal.voitures;

import javax.swing.*;
import java.awt.*;

public class NbVoituresDispo extends JPanel
{
    public NbVoituresDispo()
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(2, 50));
        setBackground(Color.white);

        JPanel panelOuest = new JPanel();
        panelOuest.setBackground(Color.white);

        JTextArea textAreaOuest = new JTextArea();
        textAreaOuest.setText("31 voitures disponibles\nLes commissions reçues affectent l'ordre 'Recommandé'.");
        textAreaOuest.setFont(new Font("Aleo",Font.PLAIN,15));
        panelOuest.add(textAreaOuest);
        add(panelOuest, BorderLayout.WEST);



        JPanel panelEst = new JPanel();
        panelEst.setBackground(Color.white);

        JLabel labelEst = new JLabel("Trier par :");
        labelEst.setFont(new Font("Aleo",Font.PLAIN,15));
        panelEst.add(labelEst);

        JButton bouton1 = new JButton("Recommandations");
        panelEst.add(bouton1);

        JButton bouton2 = new JButton("Prix (croissant)");
        panelEst.add(bouton2);

        JButton bouton3 = new JButton("Note");
        panelEst.add(bouton3);

        add(panelEst, BorderLayout.EAST);
    }
}
