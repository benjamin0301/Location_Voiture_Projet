package View.PageDetails.ConteneurPrincipal.ConteneurDroite;

import Model.VoitureModel;

import javax.swing.*;
import java.awt.*;

public class ResumeMontant extends JPanel
{
    public ResumeMontant(VoitureModel voiture)
    {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(230, 300));
        setBackground(Color.decode("#FFFFFF"));
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));


        JLabel labelResume = new JLabel("Resume du montant");
        labelResume.setHorizontalAlignment(SwingConstants.CENTER);
        labelResume.setVerticalAlignment(SwingConstants.CENTER);
        labelResume.setOpaque(true);
        labelResume.setBackground(Color.decode("#E6E6E6"));
        labelResume.setPreferredSize(new Dimension(getWidth(), 50));
        labelResume.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        add(labelResume, BorderLayout.NORTH);


        JPanel zoneTexte = new JPanel(new GridLayout(0, 1));
        zoneTexte.setBackground(Color.decode("#FFFFFF"));

        JPanel tarifVoiture = new JPanel();
        tarifVoiture.setLayout(new BorderLayout());
        tarifVoiture.setBackground(Color.white);
        JTextArea descPrix = new JTextArea("Tarif de votre\nlocation de voiture");
        tarifVoiture.add(descPrix, BorderLayout.WEST);
        JTextArea prix = new JTextArea(String.valueOf(voiture.getPrix()));
        prix.setEditable(false);
        prix.setOpaque(false);
        tarifVoiture.add(prix, BorderLayout.EAST);

        JPanel remises = new JPanel();
        remises.setLayout(new BorderLayout());
        remises.setBackground(Color.white);
        JTextArea descRemises = new JTextArea("Remises");
        remises.add(descRemises, BorderLayout.WEST);

        float valRemise = 20;
        JTextArea ecritureRem = new JTextArea(String.valueOf(valRemise));
        ecritureRem.setEditable(false);
        ecritureRem.setOpaque(false);
        remises.add(ecritureRem, BorderLayout.EAST);

        JPanel panelTotal = new JPanel();
        panelTotal.setLayout(new BorderLayout());
        panelTotal.setBackground(Color.white);
        JTextArea descTotal = new JTextArea("Total");
        panelTotal.add(descTotal, BorderLayout.WEST);
        float valTotale = voiture.getPrix() - valRemise;
        JTextArea valTotal = new JTextArea(String.valueOf(valTotale));
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
