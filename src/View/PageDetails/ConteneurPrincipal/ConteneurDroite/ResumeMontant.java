package View.PageDetails.ConteneurPrincipal.ConteneurDroite;

import Model.ClientModel;
import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class ResumeMontant extends JPanel
{
    public float valTotale;
    public ResumeMontant(VoitureModel voiture, ClientModel client)
    {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(230, 300));
        setBackground(Color.decode("#FFFFFF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JLabel labelResume = new JLabel("     Résumé du montant");
        labelResume.setHorizontalAlignment(SwingConstants.LEFT);
        labelResume.setVerticalAlignment(SwingConstants.CENTER);
        labelResume.setFont(new Font("Georgia", Font.BOLD, 13));
        labelResume.setOpaque(true);
        labelResume.setBackground(Color.decode("#E6E6E6"));
        labelResume.setPreferredSize(new Dimension(getWidth(), 50));
        labelResume.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        add(labelResume, BorderLayout.NORTH);


        JPanel zoneTexte = new JPanel(new GridLayout(0, 1));
        zoneTexte.setBackground(Color.decode("#FFFFFF"));

        JPanel tarifVoiture = new JPanel();
        tarifVoiture.setLayout(new BorderLayout());
        tarifVoiture.setPreferredSize(new Dimension(200, 40));
        tarifVoiture.setBackground(Color.white);

        JTextArea descPrix = new JTextArea("Tarif de votre\nlocation de voiture");
        descPrix.setEditable(false);
        descPrix.setFont(new Font("Georgia", Font.PLAIN, 13));
        tarifVoiture.add(descPrix, BorderLayout.WEST);
        JTextArea prix = new JTextArea(String.valueOf(voiture.getPrix()) + "€");
        prix.setEditable(false);
        prix.setFont(new Font("Georgia", Font.BOLD, 13));
        prix.setEditable(false);
        prix.setOpaque(false);
        tarifVoiture.add(prix, BorderLayout.EAST);

        JPanel remises = new JPanel();
        remises.setLayout(new BorderLayout());
        remises.setPreferredSize(new Dimension(200, 40));
        remises.setBackground(Color.white);
        JTextArea descRemises = new JTextArea("Remises");
        descRemises.setEditable(false);
        descRemises.setFont(new Font("Georgia", Font.PLAIN, 13));
        remises.add(descRemises, BorderLayout.WEST);

        float valRemise = 0;

        if (client.isFidelite() >= 3)
        {
            valRemise = 50;
        }
        else
        {
            valRemise = 0;
        }

        JTextArea ecritureRem = new JTextArea("- " + String.valueOf(valRemise) + "€");
        ecritureRem.setFont(new Font("Georgia", Font.BOLD, 13));
        ecritureRem.setEditable(false);
        ecritureRem.setEditable(false);
        ecritureRem.setOpaque(false);
        remises.add(ecritureRem, BorderLayout.EAST);

        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BorderLayout());
        panelTotal.setBackground(Color.white);
        panelTotal.setPreferredSize(new Dimension(200, 40));
        JTextArea descTotal = new JTextArea("Total");
        descTotal.setEditable(false);
        descTotal.setFont(new Font("Georgia", Font.PLAIN, 13));
        panelTotal.add(descTotal, BorderLayout.WEST);

        valTotale = voiture.getPrix() - valRemise;

        JTextArea valTotal = new JTextArea(String.valueOf(valTotale) + "€");
        valTotal.setEditable(false);
        valTotal.setFont(new Font("Georgia", Font.BOLD, 14));
        valTotal.setForeground(Color.decode("#7E3DFF"));
        valTotal.setEditable(false);
        valTotal.setOpaque(false);
        panelTotal.add(valTotal, BorderLayout.EAST);


        zoneTexte.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        zoneTexte.add(tarifVoiture);

        zoneTexte.add(remises);
        zoneTexte.add(panelTotal);
        add(zoneTexte, BorderLayout.CENTER);
    }
}
